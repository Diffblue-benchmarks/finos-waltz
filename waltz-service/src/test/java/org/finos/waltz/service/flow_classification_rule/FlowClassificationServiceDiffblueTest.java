package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.flow_classification_rule.FlowClassificationDao;
import org.finos.waltz.model.flow_classification.FlowClassification;
import org.junit.jupiter.api.Test;

class FlowClassificationServiceDiffblueTest {
  /**
   * Method under test: {@link FlowClassificationService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    when(flowClassificationDao.getById(anyLong())).thenReturn(null);

    // Act
    FlowClassification actualById = (new FlowClassificationService(flowClassificationDao)).getById(1L);

    // Assert
    verify(flowClassificationDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link FlowClassificationService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    FlowClassificationDao flowClassificationDao = mock(FlowClassificationDao.class);
    HashSet<FlowClassification> flowClassificationSet = new HashSet<>();
    when(flowClassificationDao.findAll()).thenReturn(flowClassificationSet);

    // Act
    Set<FlowClassification> actualFindAllResult = (new FlowClassificationService(flowClassificationDao)).findAll();

    // Assert
    verify(flowClassificationDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(flowClassificationSet, actualFindAllResult);
  }
}
