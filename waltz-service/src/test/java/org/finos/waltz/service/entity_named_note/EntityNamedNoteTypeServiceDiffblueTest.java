package org.finos.waltz.service.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_named_note.EntityNamedNoteTypeDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.EntityWithOperations;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.EntityNamedNoteTypeChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityNamedNoteTypeServiceDiffblueTest {
  /**
   * Method under test: {@link EntityNamedNoteTypeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    ArrayList<EntityNamedNodeType> entityNamedNodeTypeList = new ArrayList<>();
    when(entityNamedNoteTypeDao.findAll()).thenReturn(entityNamedNodeTypeList);

    // Act
    List<EntityNamedNodeType> actualFindAllResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).findAll();

    // Assert
    verify(entityNamedNoteTypeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(entityNamedNodeTypeList, actualFindAllResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  void testRemoveById() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeById(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).removeById(eq(1L));
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  void testRemoveById2() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .removeById(1L, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).removeById(eq(1L));
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  void testRemoveById3() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveByIdResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService))
        .removeById(1L, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).removeById(eq(1L));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.create(Mockito.<EntityNamedNoteTypeChangeCommand>any())).thenReturn(1L);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    long actualCreateResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .create(mock(EntityNamedNoteTypeChangeCommand.class), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).create(isA(EntityNamedNoteTypeChangeCommand.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.create(Mockito.<EntityNamedNoteTypeChangeCommand>any())).thenReturn(1L);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    long actualCreateResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService))
        .create(mock(EntityNamedNoteTypeChangeCommand.class), "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).create(isA(EntityNamedNoteTypeChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  void testUpdate() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).update(1L,
                mock(EntityNamedNoteTypeChangeCommand.class), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any())).thenReturn(false);

    // Act
    boolean actualUpdateResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).update(1L,
                mock(EntityNamedNoteTypeChangeCommand.class), "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualUpdateResult = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService)).update(1L,
        mock(EntityNamedNoteTypeChangeCommand.class), "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteTypeService#getByExternalId(String)}
   */
  @Test
  void testGetByExternalId() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.getByExternalId(Mockito.<String>any())).thenReturn(null);

    // Act
    EntityNamedNodeType actualByExternalId = (new EntityNamedNoteTypeService(entityNamedNoteTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .getByExternalId("42");

    // Assert
    verify(entityNamedNoteTypeDao).getByExternalId(eq("42"));
    assertNull(actualByExternalId);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteTypeService#findForRefAndUser(EntityReference, String)}
   */
  @Test
  void testFindForRefAndUser() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    HashSet<EntityWithOperations<EntityNamedNodeType>> entityWithOperationsSet = new HashSet<>();
    when(entityNamedNoteTypeDao.findForRefAndUser(Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(entityWithOperationsSet);

    // Act
    Set<EntityWithOperations<EntityNamedNodeType>> actualFindForRefAndUserResult = (new EntityNamedNoteTypeService(
        entityNamedNoteTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForRefAndUser(null, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).findForRefAndUser(isNull(), eq("janedoe"));
    assertTrue(actualFindForRefAndUserResult.isEmpty());
    assertSame(entityWithOperationsSet, actualFindForRefAndUserResult);
  }
}
