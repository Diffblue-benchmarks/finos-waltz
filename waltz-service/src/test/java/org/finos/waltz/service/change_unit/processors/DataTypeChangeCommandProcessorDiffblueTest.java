package org.finos.waltz.service.change_unit.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.finos.waltz.data.datatype_decorator.DataTypeDecoratorDaoSelectorFactory;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.service.assessment_definition.AssessmentDefinitionService;
import org.finos.waltz.service.assessment_rating.AssessmentRatingService;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorRatingsCalculator;
import org.finos.waltz.service.data_flow_decorator.LogicalFlowDecoratorService;
import org.finos.waltz.service.data_type.DataTypeDecoratorService;
import org.finos.waltz.service.data_type.DataTypeService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.permission.permission_checker.FlowPermissionChecker;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.finos.waltz.service.rating_scheme.RatingSchemeService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.junit.jupiter.api.Test;

class DataTypeChangeCommandProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link DataTypeChangeCommandProcessor#supportedAttribute()}
   */
  @Test
  void testSupportedAttribute() {
    // Arrange
    PhysicalFlowService physicalFlowService = new PhysicalFlowService(mock(ChangeLogService.class),
        mock(LogicalFlowService.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationService.class),
        mock(ExternalIdentifierService.class), mock(DataTypeDecoratorService.class), mock(FlowPermissionChecker.class));

    // Act and Assert
    assertEquals("DataType",
        (new DataTypeChangeCommandProcessor(physicalFlowService,
            new DataTypeDecoratorService(mock(ChangeLogService.class), mock(LogicalFlowDecoratorService.class),
                mock(DataTypeDecoratorDaoSelectorFactory.class), mock(LogicalFlowDao.class),
                mock(LogicalFlowService.class), mock(LogicalFlowDecoratorRatingsCalculator.class),
                mock(DataTypeUsageService.class), mock(DataTypeService.class), mock(PhysicalSpecificationDao.class),
                mock(PhysicalSpecificationService.class), mock(AssessmentRatingService.class),
                mock(AssessmentDefinitionService.class), mock(RatingSchemeService.class),
                mock(FlowClassificationService.class), mock(FlowClassificationRuleService.class))))
                    .supportedAttribute());
  }
}
