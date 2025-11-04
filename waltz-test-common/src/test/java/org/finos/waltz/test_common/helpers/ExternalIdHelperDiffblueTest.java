package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.external_identifier.ExternalIdentifierDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExternalIdHelperDiffblueTest {
  /**
   * Method under test:
   * {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  void testCreateExtId() {
    // Arrange
    ExternalIdentifierService externalIdentifierService = mock(ExternalIdentifierService.class);
    when(externalIdentifierService.create(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);

    // Act
    int actualCreateExtIdResult = (new ExternalIdHelper(externalIdentifierService)).createExtId(null, "42", "Name");

    // Assert
    verify(externalIdentifierService).create(isNull(), eq("42"), eq("Name"));
    assertEquals(1, actualCreateExtIdResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  void testCreateExtId2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ExternalIdHelper externalIdHelper = new ExternalIdHelper(new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))));
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);

    // Act
    int actualCreateExtIdResult = externalIdHelper.createExtId(ref, "42", "Name");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(ref).id();
    assertEquals(1, actualCreateExtIdResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  void testCreateExtId3() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(-5);

    // Act
    int actualCreateExtIdResult = (new ExternalIdHelper(new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))))
                .createExtId(mock(EntityReference.class), "42", "Name");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(-5, actualCreateExtIdResult);
  }
}
