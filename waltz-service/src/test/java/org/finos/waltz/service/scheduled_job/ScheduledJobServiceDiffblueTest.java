package org.finos.waltz.service.scheduled_job;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.assessment_rating.AssessmentRatingRippler;
import org.finos.waltz.data.scheduled_job.ScheduledJobDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.attestation.ImmutableSyncRecipientsResponse;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScheduledJobServiceDiffblueTest {
  @Mock private AssessmentRatingRippler assessmentRatingRippler;

  @Mock private AttestationRunService attestationRunService;

  @Mock private ComplexityService complexityService;

  @Mock private CostService costService;

  @Mock private DataTypeUsageService dataTypeUsageService;

  @Mock private EntityHierarchyService entityHierarchyService;

  @Mock private FlowClassificationRuleService flowClassificationRuleService;

  @Mock private LogicalFlowService logicalFlowService;

  @Mock private PhysicalSpecDataTypeService physicalSpecDataTypeService;

  @Mock private ReportGridFilterViewService reportGridFilterViewService;

  @Mock private ScheduledJobDao scheduledJobDao;

  @InjectMocks private ScheduledJobService scheduledJobService;

  @Mock private SurveyInstanceActionQueueService surveyInstanceActionQueueService;

  @Mock private SurveyInstanceService surveyInstanceService;

  /**
   * Test {@link ScheduledJobService#run()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledJobDao} {@link ScheduledJobDao#anyJobsRunning(Set)} return {@code
   *       true}.
   *   <li>Then calls {@link ScheduledJobDao#anyJobsRunning(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  @DisplayName(
      "Test run(); given ScheduledJobDao anyJobsRunning(Set) return 'true'; then calls anyJobsRunning(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobService.run()"})
  void testRun_givenScheduledJobDaoAnyJobsRunningReturnTrue_thenCallsAnyJobsRunning() {
    // Arrange
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(true);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    scheduledJobService.run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }

  /**
   * Test {@link ScheduledJobService#run()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledJobDao} {@link ScheduledJobDao#isJobRunnable(JobKey)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  @DisplayName("Test run(); given ScheduledJobDao isJobRunnable(JobKey) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobService.run()"})
  void testRun_givenScheduledJobDaoIsJobRunnableReturnFalse() {
    // Arrange
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(false);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    scheduledJobService.run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }

  /**
   * Test {@link ScheduledJobService#run()}.
   *
   * <ul>
   *   <li>Given {@link ScheduledJobDao} {@link ScheduledJobDao#markJobAsRunning(JobKey)} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  @DisplayName("Test run(); given ScheduledJobDao markJobAsRunning(JobKey) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobService.run()"})
  void testRun_givenScheduledJobDaoMarkJobAsRunningReturnFalse() {
    // Arrange
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(false);
    when(scheduledJobDao.markJobAsRunning(Mockito.<JobKey>any())).thenReturn(false);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    doNothing().when(surveyInstanceActionQueueService).performActions();

    // Act
    scheduledJobService.run();

    // Assert
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1)).markJobAsRunning(Mockito.<JobKey>any());
    verify(surveyInstanceActionQueueService).performActions();
  }

  /**
   * Test {@link ScheduledJobService#run()}.
   *
   * <ul>
   *   <li>Then calls {@link AssessmentRatingRippler#findRippleConfig()}.
   * </ul>
   *
   * <p>Method under test: {@link ScheduledJobService#run()}
   */
  @Test
  @DisplayName("Test run(); then calls findRippleConfig()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledJobService.run()"})
  void testRun_thenCallsFindRippleConfig() {
    // Arrange
    when(attestationRunService.issueInstancesForPendingRuns()).thenReturn(3);
    doNothing().when(complexityService).populateMeasurableComplexities();
    doNothing().when(costService).populateAllocatedCosts();
    when(dataTypeUsageService.recalculateForAllApplications()).thenReturn(true);
    when(entityHierarchyService.buildFor(Mockito.<EntityKind>any())).thenReturn(1);
    when(flowClassificationRuleService.fastRecalculateAllFlowRatings()).thenReturn(1);
    when(logicalFlowService.cleanupOrphans()).thenReturn(1);
    when(physicalSpecDataTypeService.rippleDataTypesToLogicalFlows()).thenReturn(1);
    doNothing().when(reportGridFilterViewService).generateAppGroupsFromFilter();
    doNothing()
        .when(scheduledJobDao)
        .updateJobStatus(Mockito.<JobKey>any(), Mockito.<JobLifecycleStatus>any());
    when(scheduledJobDao.anyJobsRunning(Mockito.<Set<JobKey>>any())).thenReturn(false);
    when(scheduledJobDao.markJobAsRunning(Mockito.<JobKey>any())).thenReturn(true);
    when(scheduledJobDao.isJobRunnable(Mockito.<JobKey>any())).thenReturn(true);
    doNothing().when(surveyInstanceActionQueueService).performActions();
    when(surveyInstanceService.reassignOwners())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());
    when(surveyInstanceService.reassignRecipients())
        .thenReturn(
            ImmutableSyncRecipientsResponse.builder()
                .recipientsCreatedCount(3L)
                .recipientsRemovedCount(3L)
                .build());
    when(assessmentRatingRippler.findRippleConfig()).thenReturn(new HashSet<>());

    // Act
    scheduledJobService.run();

    // Assert
    verify(assessmentRatingRippler).findRippleConfig();
    verify(scheduledJobDao, atLeast(1)).anyJobsRunning(Mockito.<Set<JobKey>>any());
    verify(scheduledJobDao, atLeast(1)).isJobRunnable(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1)).markJobAsRunning(Mockito.<JobKey>any());
    verify(scheduledJobDao, atLeast(1))
        .updateJobStatus(Mockito.<JobKey>any(), Mockito.<JobLifecycleStatus>any());
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
}
