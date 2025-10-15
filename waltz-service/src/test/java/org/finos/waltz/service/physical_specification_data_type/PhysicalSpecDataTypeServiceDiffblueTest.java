package org.finos.waltz.service.physical_specification_data_type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.data.datatype_decorator.PhysicalSpecDecoratorDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PhysicalSpecDataTypeServiceDiffblueTest {
  @InjectMocks private PhysicalSpecDataTypeService physicalSpecDataTypeService;

  @Mock private PhysicalSpecDecoratorDao physicalSpecDecoratorDao;

  /**
   * Test {@link PhysicalSpecDataTypeService#rippleDataTypesToLogicalFlows()}.
   *
   * <p>Method under test: {@link PhysicalSpecDataTypeService#rippleDataTypesToLogicalFlows()}
   */
  @Test
  @DisplayName("Test rippleDataTypesToLogicalFlows()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDataTypeService.rippleDataTypesToLogicalFlows()"})
  void testRippleDataTypesToLogicalFlows() {
    // Arrange
    when(physicalSpecDecoratorDao.rippleDataTypesToLogicalFlows()).thenReturn(1);

    // Act
    int actualRippleDataTypesToLogicalFlowsResult =
        physicalSpecDataTypeService.rippleDataTypesToLogicalFlows();

    // Assert
    verify(physicalSpecDecoratorDao).rippleDataTypesToLogicalFlows();
    assertEquals(1, actualRippleDataTypesToLogicalFlowsResult);
  }
}
