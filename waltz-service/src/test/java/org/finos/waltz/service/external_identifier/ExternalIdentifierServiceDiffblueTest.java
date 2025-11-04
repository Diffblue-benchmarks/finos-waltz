package org.finos.waltz.service.external_identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExternalIdentifierServiceDiffblueTest {
  /**
   * Method under test:
   * {@link ExternalIdentifierService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(externalIdentifierSet);

    // Act
    Set<ExternalIdentifier> actualFindByEntityReferenceResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByEntityReference(null);

    // Assert
    verify(externalIdentifierDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(externalIdentifierSet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#findByKind(EntityKind, String)}
   */
  @Test
  void testFindByKind() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    HashSet<ExternalIdentifier> externalIdentifierSet = new HashSet<>();
    when(externalIdentifierDao.findByKind(Mockito.<EntityKind>any(), Mockito.<String>any()))
        .thenReturn(externalIdentifierSet);

    // Act
    Set<ExternalIdentifier> actualFindByKindResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByKind(EntityKind.ALL, "42");

    // Assert
    verify(externalIdentifierDao).findByKind(eq(EntityKind.ALL), eq("42"));
    assertTrue(actualFindByKindResult.isEmpty());
    assertSame(externalIdentifierSet, actualFindByKindResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#merge(EntityReference, EntityReference)}
   */
  @Test
  void testMerge() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<Set<ExternalIdentifier>>any())).thenReturn(new int[]{1, -1, 1, -1});
    when(externalIdentifierDao.delete(Mockito.<Collection<ExternalIdentifier>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(externalIdentifierDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(new HashSet<>());

    // Act
    int actualMergeResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).merge(null,
                null);

    // Assert
    verify(externalIdentifierDao).create(isA(Set.class));
    verify(externalIdentifierDao).delete(isA(Collection.class));
    verify(externalIdentifierDao, atLeast(1)).findByEntityReference(isNull());
    assertEquals(0, actualMergeResult);
  }

  /**
   * Method under test: {@link ExternalIdentifierService#delete(EntityReference)}
   */
  @Test
  void testDelete() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.delete(Mockito.<EntityReference>any())).thenReturn(1);

    // Act
    int actualDeleteResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).delete(null);

    // Assert
    verify(externalIdentifierDao).delete((EntityReference) isNull());
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#delete(EntityReference, String, String, String)}
   */
  @Test
  void testDelete2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ExternalIdentifierService externalIdentifierService = new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);

    // Act
    int actualDeleteResult = externalIdentifierService.delete(entityRef, "42", "Provenance", "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    verify(entityRef).id();
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#delete(EntityReference, String, String, String)}
   */
  @Test
  void testDelete3() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(-5);

    // Act
    int actualDeleteResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .delete(mock(EntityReference.class), "42", "Provenance", "janedoe");

    // Assert
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    assertEquals(-5, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#delete(EntityReference, String, String, String)}
   */
  @Test
  void testDelete4() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.delete(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ExternalIdentifierService externalIdentifierService = new ExternalIdentifierService(externalIdentifierDao,
        changeLogService);
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);

    // Act
    int actualDeleteResult = externalIdentifierService.delete(entityRef, "42", "Provenance", "janedoe");

    // Assert
    verify(externalIdentifierDao).delete(isA(ExternalIdentifier.class));
    verify(entityRef).id();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ExternalIdentifierService externalIdentifierService = new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);

    // Act
    int actualCreateResult = externalIdentifierService.create(entityRef, "42", "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(entityRef).id();
    assertEquals(1, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(-5);

    // Act
    int actualCreateResult = (new ExternalIdentifierService(externalIdentifierDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .create(mock(EntityReference.class), "42", "janedoe");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(-5, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link ExternalIdentifierService#create(EntityReference, String, String)}
   */
  @Test
  void testCreate3() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    ExternalIdentifierService externalIdentifierService = new ExternalIdentifierService(externalIdentifierDao,
        changeLogService);
    EntityReference entityRef = mock(EntityReference.class);
    when(entityRef.id()).thenReturn(1L);

    // Act
    int actualCreateResult = externalIdentifierService.create(entityRef, "42", "janedoe");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(entityRef).id();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCreateResult);
  }
}
