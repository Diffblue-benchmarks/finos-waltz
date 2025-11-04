package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecHelperDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}
   */
  @Test
  void testCreatePhysicalSpec() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any())).thenReturn(1L);

    // Act
    Long actualCreatePhysicalSpecResult = (new PhysicalSpecHelper(new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class)))).createPhysicalSpec(mock(EntityReference.class),
            "Name");

    // Assert
    verify(specificationDao).create(isA(PhysicalSpecification.class));
    assertEquals(1L, actualCreatePhysicalSpecResult.longValue());
  }

  /**
   * Method under test:
   * {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}
   */
  @Test
  void testCreatePhysicalSpec2() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.create(Mockito.<ImmutablePhysicalSpecification>any())).thenReturn(1L);

    // Act
    Long actualCreatePhysicalSpecResult = (new PhysicalSpecHelper(physicalSpecificationService))
        .createPhysicalSpec(mock(EntityReference.class), "Name");

    // Assert
    verify(physicalSpecificationService).create(isA(ImmutablePhysicalSpecification.class));
    assertEquals(1L, actualCreatePhysicalSpecResult.longValue());
  }

  /**
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  void testRemoveSpec() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.getById(anyLong())).thenReturn(null);

    // Act
    (new PhysicalSpecHelper(new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class)))).removeSpec(1L);

    // Assert
    verify(specificationDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  void testRemoveSpec2() {
    // Arrange
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.markRemovedIfUnused(Mockito.<PhysicalSpecificationDeleteCommand>any(),
        Mockito.<String>any())).thenReturn(null);

    // Act
    (new PhysicalSpecHelper(physicalSpecificationService)).removeSpec(1L);

    // Assert
    verify(physicalSpecificationService).markRemovedIfUnused(isA(PhysicalSpecificationDeleteCommand.class),
        eq("deletingSpec_4a993ec3-6b4d-42d8-9b70-1a00ac42dbc1"));
  }

  /**
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  void testRemoveSpec3() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(0);
    when(specificationDao.getById(anyLong())).thenReturn(mock(PhysicalSpecification.class));

    // Act
    (new PhysicalSpecHelper(new PhysicalSpecificationService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        specificationDao, mock(PhysicalSpecificationSearchDao.class)))).removeSpec(1L);

    // Assert
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
  }

  /**
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  void testRemoveSpec4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    when(physicalSpecification.owningEntity()).thenReturn(mock(EntityReference.class));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);

    // Act
    (new PhysicalSpecHelper(new PhysicalSpecificationService(changeLogService, specificationDao,
        mock(PhysicalSpecificationSearchDao.class)))).removeSpec(1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).name();
    verify(physicalSpecification).owningEntity();
  }

  /**
   * Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  void testRemoveSpec5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    when(physicalSpecification.owningEntity()).thenReturn(mock(EntityReference.class));
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);
    when(specificationDao.getById(anyLong())).thenReturn(physicalSpecification);

    // Act
    (new PhysicalSpecHelper(new PhysicalSpecificationService(changeLogService, specificationDao,
        mock(PhysicalSpecificationSearchDao.class)))).removeSpec(1L);

    // Assert
    verify(specificationDao).getById(eq(1L));
    verify(specificationDao).markRemovedIfUnused(eq(1L));
    verify(physicalSpecification).name();
    verify(physicalSpecification).owningEntity();
    verify(changeLogService).write(isA(ChangeLog.class));
  }
}
