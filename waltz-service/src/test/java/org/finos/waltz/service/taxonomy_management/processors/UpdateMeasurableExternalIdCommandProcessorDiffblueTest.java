package org.finos.waltz.service.taxonomy_management.processors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.Set;
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
import org.finos.waltz.model.taxonomy_management.TaxonomyChangeType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.measurable.MeasurableService;
import org.junit.jupiter.api.Test;

class UpdateMeasurableExternalIdCommandProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link UpdateMeasurableExternalIdCommandProcessor#supportedTypes()}
   */
  @Test
  void testSupportedTypes() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Set<TaxonomyChangeType> actualSupportedTypesResult = (new UpdateMeasurableExternalIdCommandProcessor(
        new MeasurableService(measurableDao, measurableSearchDao, nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .supportedTypes();

    // Assert
    assertEquals(1, actualSupportedTypesResult.size());
    assertTrue(actualSupportedTypesResult.contains(TaxonomyChangeType.UPDATE_EXTERNAL_ID));
  }

  /**
   * Method under test:
   * {@link UpdateMeasurableExternalIdCommandProcessor#domain()}
   */
  @Test
  void testDomain() {
    // Arrange
    MeasurableDao measurableDao = mock(MeasurableDao.class);
    MeasurableSearchDao measurableSearchDao = mock(MeasurableSearchDao.class);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);

    // Act and Assert
    assertEquals(EntityKind.MEASURABLE_CATEGORY,
        (new UpdateMeasurableExternalIdCommandProcessor(new MeasurableService(measurableDao, measurableSearchDao,
            nameResolver,
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                    .domain());
  }
}
