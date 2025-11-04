package org.finos.waltz.service.physical_specification_data_type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.data.datatype_decorator.PhysicalSpecDecoratorDao;
import org.junit.jupiter.api.Test;

class PhysicalSpecDataTypeServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecDataTypeService#rippleDataTypesToLogicalFlows()}
   */
  @Test
  void testRippleDataTypesToLogicalFlows() {
    // Arrange
    PhysicalSpecDecoratorDao physicalSpecDecoratorDao = mock(PhysicalSpecDecoratorDao.class);
    when(physicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()).thenReturn(1);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult = (new PhysicalSpecDataTypeService(physicalSpecDecoratorDao))
        .rippleDataTypesToLogicalFlows();

    // Assert
    verify(physicalSpecDecoratorDao).rippleDataTypesToLogicalFlows();
    assertEquals(1, actualRippleDataTypesToLogicalFlowsResult);
  }
}
