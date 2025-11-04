package org.finos.waltz.service.taxonomy_management;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable.MeasurableDao;
import org.finos.waltz.data.measurable.search.MeasurableSearchDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.finos.waltz.service.taxonomy_management.processors.AddMeasurableCommandProcessor;
import org.junit.jupiter.api.Test;

class TaxonomyCommandProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link TaxonomyCommandProcessor#checkDomain(TaxonomyChangeCommand, EntityKind)}
   */
  @Test
  void testCheckDomain() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    AddMeasurableCommandProcessor addMeasurableCommandProcessor = new AddMeasurableCommandProcessor(
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    TaxonomyChangeCommand cmd = mock(TaxonomyChangeCommand.class);
    when(cmd.changeDomain()).thenReturn(entityReference);

    // Act
    addMeasurableCommandProcessor.checkDomain(cmd, EntityKind.ALL);

    // Assert
    verify(entityReference, atLeast(1)).kind();
    verify(cmd, atLeast(1)).changeDomain();
  }

  /**
   * Method under test:
   * {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}
   */
  @Test
  void testHasNoChange() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertFalse(
        (new AddMeasurableCommandProcessor(new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .hasNoChange("Current Value", "New Value", "Field Name"));
  }

  /**
   * Method under test:
   * {@link TaxonomyCommandProcessor#hasNoChange(Object, Object, String)}
   */
  @Test
  void testHasNoChange2() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertTrue(
        (new AddMeasurableCommandProcessor(new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .hasNoChange("New Value", "New Value", "Field Name"));
  }
}
