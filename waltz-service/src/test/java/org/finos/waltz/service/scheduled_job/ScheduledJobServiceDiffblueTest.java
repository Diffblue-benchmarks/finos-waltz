package org.finos.waltz.service.scheduled_job;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.scheduled_job.ScheduledJobDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.scheduled_job.JobKey;
import org.finos.waltz.model.scheduled_job.JobLifecycleStatus;
import org.finos.waltz.service.attestation.AttestationRunService;
import org.finos.waltz.service.complexity.ComplexityService;
import org.finos.waltz.service.cost.CostService;
import org.finos.waltz.service.entity_hierarchy.EntityHierarchyService;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_specification_data_type.PhysicalSpecDataTypeService;
import org.finos.waltz.service.report_grid.ReportGridFilterViewService;
import org.finos.waltz.service.survey.SurveyInstanceActionQueueService;
import org.finos.waltz.service.survey.SurveyInstanceService;
import org.finos.waltz.service.usage_info.DataTypeUsageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScheduledJobServiceDiffblueTest {
  /**
   * Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  void testRun() {
    // Arrange
    ScheduledJobDao scheduledJobDao = mock(ScheduledJobDao.class);
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(true);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    SurveyInstanceActionQueueService surveyInstanceActionQueueService = mock(SurveyInstanceActionQueueService.class);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    (new ScheduledJobService(mock(AttestationRunService.class), mock(ComplexityService.class), mock(CostService.class),
        mock(DataTypeUsageService.class), mock(EntityHierarchyService.class), mock(FlowClassificationRuleService.class),
        mock(LogicalFlowService.class), mock(PhysicalSpecDataTypeService.class),
        mock(ReportGridFilterViewService.class), scheduledJobDao, surveyInstanceActionQueueService,
        mock(SurveyInstanceService.class), mock(AssessmentRatingRippler.class))).run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }

  /**
   * Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  void testRun2() {
    // Arrange
    AttestationRunService attestationRunService = mock(AttestationRunService.class);
    when(attestationRunService.issueInstancesForPendingRuns()).thenReturn(3);
    ComplexityService complexityService = mock(ComplexityService.class);
    doNothing().when(complexityService).populateMeasurableComplexities();
    CostService costService = mock(CostService.class);
    doNothing().when(costService).populateAllocatedCosts();
    DataTypeUsageService dataTypeUsageService = mock(DataTypeUsageService.class);
    when(dataTypeUsageService.recalculateForAllApplications()).thenReturn(true);
    EntityHierarchyService entityHierarchyService = mock(EntityHierarchyService.class);
    when(entityHierarchyService.buildFor(Mockito.<EntityKind>any())).thenReturn(1);
    FlowClassificationRuleService flowClassificationRuleService = mock(FlowClassificationRuleService.class);
    when(flowClassificationRuleService.fastRecalculateAllFlowRatings()).thenReturn(1);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.cleanupOrphans()).thenReturn(1);
    PhysicalSpecDataTypeService physicalSpecDataTypeService = mock(PhysicalSpecDataTypeService.class);
    when(physicalSpecDataTypeService.rippleDataTypesToLogicalFlows()).thenReturn(1);
    ReportGridFilterViewService reportGridFilterViewService = mock(ReportGridFilterViewService.class);
    doNothing().when(reportGridFilterViewService).generateAppGroupsFromFilter();
    ScheduledJobDao scheduledJobDao = mock(ScheduledJobDao.class);
    doNothing().when(scheduledJobDao).updateJobStatus(Mockito.<JobKey>any(), Mockito.<JobLifecycleStatus>any());
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(false);
    when(scheduledJobDao.markJobAsRunning(Mockito.<JobKey>any())).thenReturn(true);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    SurveyInstanceActionQueueService surveyInstanceActionQueueService = mock(SurveyInstanceActionQueueService.class);
    doNothing().when(surveyInstanceActionQueueService).performActions();
    SurveyInstanceService surveyInstanceService = mock(SurveyInstanceService.class);
    when(surveyInstanceService.reassignOwners()).thenReturn(null);
    when(surveyInstanceService.reassignRecipients()).thenReturn(null);
    AssessmentRatingRippler assessmentRatingRippler = mock(AssessmentRatingRippler.class);
    when(assessmentRatingRippler.findRippleConfig()).thenReturn(new HashSet<>());

    // Act
    (new ScheduledJobService(attestationRunService, complexityService, costService, dataTypeUsageService,
        entityHierarchyService, flowClassificationRuleService, logicalFlowService, physicalSpecDataTypeService,
        reportGridFilterViewService, scheduledJobDao, surveyInstanceActionQueueService, surveyInstanceService,
        assessmentRatingRippler)).run();

    // Assert
    verify(assessmentRatingRippler).findRippleConfig();
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1)).markJobAsRunning(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1)).updateJobStatus(Mockito.<JobKey>any(), Mockito.<JobLifecycleStatus>any());
    verify(attestationRunService).issueInstancesForPendingRuns();
    verify(complexityService).populateMeasurableComplexities();
    verify(costService).populateAllocatedCosts();
    verify(entityHierarchyService, atLeast(1)).buildFor(Mockito.<EntityKind>any());
    verify(flowClassificationRuleService).fastRecalculateAllFlowRatings();
    verify(logicalFlowService).cleanupOrphans();
    verify(physicalSpecDataTypeService).rippleDataTypesToLogicalFlows();
    verify(reportGridFilterViewService).generateAppGroupsFromFilter();
    verify(surveyInstanceActionQueueService).performActions();
    verify(surveyInstanceService).reassignOwners();
    verify(surveyInstanceService).reassignRecipients();
    verify(dataTypeUsageService).recalculateForAllApplications();
  }

  /**
   * Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  void testRun3() {
    // Arrange
    ScheduledJobDao scheduledJobDao = mock(ScheduledJobDao.class);
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(false);
    when(scheduledJobDao.markJobAsRunning(Mockito.<JobKey>any())).thenReturn(false);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    SurveyInstanceActionQueueService surveyInstanceActionQueueService = mock(SurveyInstanceActionQueueService.class);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    (new ScheduledJobService(mock(AttestationRunService.class), mock(ComplexityService.class), mock(CostService.class),
        mock(DataTypeUsageService.class), mock(EntityHierarchyService.class), mock(FlowClassificationRuleService.class),
        mock(LogicalFlowService.class), mock(PhysicalSpecDataTypeService.class),
        mock(ReportGridFilterViewService.class), scheduledJobDao, surveyInstanceActionQueueService,
        mock(SurveyInstanceService.class), mock(AssessmentRatingRippler.class))).run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1)).markJobAsRunning(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }

  /**
   * Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  void testRun4() {
    // Arrange
    ScheduledJobDao scheduledJobDao = mock(ScheduledJobDao.class);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(false);
    SurveyInstanceActionQueueService surveyInstanceActionQueueService = mock(SurveyInstanceActionQueueService.class);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    (new ScheduledJobService(mock(AttestationRunService.class), mock(ComplexityService.class), mock(CostService.class),
        mock(DataTypeUsageService.class), mock(EntityHierarchyService.class), mock(FlowClassificationRuleService.class),
        mock(LogicalFlowService.class), mock(PhysicalSpecDataTypeService.class),
        mock(ReportGridFilterViewService.class), scheduledJobDao, surveyInstanceActionQueueService,
        mock(SurveyInstanceService.class), mock(AssessmentRatingRippler.class))).run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }
}
