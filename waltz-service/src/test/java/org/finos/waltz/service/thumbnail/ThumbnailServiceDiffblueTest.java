package org.finos.waltz.service.thumbnail;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
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
import org.finos.waltz.data.thumbnail.ThumbnailDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.thumbnail.Thumbnail;
import org.finos.waltz.model.thumbnail.ThumbnailSaveCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ThumbnailServiceDiffblueTest {
  /**
   * Method under test: {@link ThumbnailService#getByReference(EntityReference)}
   */
  @Test
  void testGetByReference() {
    // Arrange
    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any())).thenReturn(null);

    // Act
    Thumbnail actualByReference = (new ThumbnailService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        thumbnailDao)).getByReference(null);

    // Assert
    verify(thumbnailDao).getByReference(isNull());
    assertNull(actualByReference);
  }

  /**
   * Method under test:
   * {@link ThumbnailService#save(ThumbnailSaveCommand, String)}
   */
  @Test
  void testSave() throws UnsupportedEncodingException {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.create(Mockito.<Thumbnail>any())).thenReturn(1);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any())).thenReturn(null);
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    ThumbnailSaveCommand cmd = mock(ThumbnailSaveCommand.class);
    when(cmd.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cmd.mimeType()).thenReturn("Mime Type");
    when(cmd.parentEntityReference()).thenReturn(entityReference);

    // Act
    thumbnailService.save(cmd, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(thumbnailDao).create(isA(Thumbnail.class));
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(thumbnailDao).getByReference(isA(EntityReference.class));
    verify(entityReference).kind();
    verify(cmd).blob();
    verify(cmd).mimeType();
    verify(cmd, atLeast(1)).parentEntityReference();
  }

  /**
   * Method under test:
   * {@link ThumbnailService#save(ThumbnailSaveCommand, String)}
   */
  @Test
  void testSave2() throws UnsupportedEncodingException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.create(Mockito.<Thumbnail>any())).thenReturn(1);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any())).thenReturn(null);
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    ThumbnailSaveCommand cmd = mock(ThumbnailSaveCommand.class);
    when(cmd.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cmd.mimeType()).thenReturn("Mime Type");
    when(cmd.parentEntityReference()).thenReturn(entityReference);

    // Act
    thumbnailService.save(cmd, "janedoe");

    // Assert
    verify(thumbnailDao).create(isA(Thumbnail.class));
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(thumbnailDao).getByReference(isA(EntityReference.class));
    verify(entityReference).kind();
    verify(cmd).blob();
    verify(cmd).mimeType();
    verify(cmd, atLeast(1)).parentEntityReference();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link ThumbnailService#save(ThumbnailSaveCommand, String)}
   */
  @Test
  void testSave3() throws UnsupportedEncodingException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.create(Mockito.<Thumbnail>any())).thenReturn(1);
    when(thumbnailDao.getByReference(Mockito.<EntityReference>any())).thenReturn(mock(Thumbnail.class));
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    ThumbnailSaveCommand cmd = mock(ThumbnailSaveCommand.class);
    when(cmd.blob()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(cmd.mimeType()).thenReturn("Mime Type");
    when(cmd.parentEntityReference()).thenReturn(entityReference);

    // Act
    thumbnailService.save(cmd, "janedoe");

    // Assert
    verify(thumbnailDao).create(isA(Thumbnail.class));
    verify(thumbnailDao).getByReference(isA(EntityReference.class));
    verify(entityReference).kind();
    verify(cmd).blob();
    verify(cmd).mimeType();
    verify(cmd, atLeast(1)).parentEntityReference();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  void testDeleteByReference() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDeleteByReferenceResult = thumbnailService.deleteByReference(ref, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(ref).kind();
    assertTrue(actualDeleteByReferenceResult);
  }

  /**
   * Method under test:
   * {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  void testDeleteByReference2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(1);
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDeleteByReferenceResult = thumbnailService.deleteByReference(ref, "janedoe");

    // Assert
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(ref).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualDeleteByReferenceResult);
  }

  /**
   * Method under test:
   * {@link ThumbnailService#deleteByReference(EntityReference, String)}
   */
  @Test
  void testDeleteByReference3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ThumbnailDao thumbnailDao = mock(ThumbnailDao.class);
    when(thumbnailDao.deleteByReference(Mockito.<EntityReference>any())).thenReturn(15);
    ThumbnailService thumbnailService = new ThumbnailService(changeLogService, thumbnailDao);
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    boolean actualDeleteByReferenceResult = thumbnailService.deleteByReference(ref, "janedoe");

    // Assert
    verify(thumbnailDao).deleteByReference(isA(EntityReference.class));
    verify(ref).kind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualDeleteByReferenceResult);
  }
}
