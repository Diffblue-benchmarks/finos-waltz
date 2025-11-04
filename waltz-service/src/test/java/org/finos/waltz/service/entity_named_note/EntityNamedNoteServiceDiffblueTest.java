package org.finos.waltz.service.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.GenericSelector;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_named_note.EntityNamedNoteDao;
import org.finos.waltz.data.entity_named_note.EntityNamedNoteTypeDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EntityNamedNoteServiceDiffblueTest {
  /**
   * Method under test:
   * {@link EntityNamedNoteService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    ArrayList<EntityNamedNote> entityNamedNoteList = new ArrayList<>();
    when(entityNamedNoteDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(entityNamedNoteList);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);

    // Act
    List<EntityNamedNote> actualFindByEntityReferenceResult = (new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByEntityReference(null);

    // Assert
    verify(entityNamedNoteDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(entityNamedNoteList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test: {@link EntityNamedNoteService#findByNoteTypeExtId(String)}
   */
  @Test
  void testFindByNoteTypeExtId() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdResult = (new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByNoteTypeExtId("42");

    // Assert
    verify(entityNamedNoteDao).findByNoteTypeExtId(eq("42"));
    assertTrue(actualFindByNoteTypeExtIdResult.isEmpty());
    assertSame(entityNamedNoteSet, actualFindByNoteTypeExtIdResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#findByNoteTypeExtIdAndEntityReference(String, EntityReference)}
   */
  @Test
  void testFindByNoteTypeExtIdAndEntityReference() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    HashSet<EntityNamedNote> entityNamedNoteSet = new HashSet<>();
    when(
        entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(Mockito.<String>any(), Mockito.<EntityReference>any()))
            .thenReturn(entityNamedNoteSet);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdAndEntityReferenceResult = (new EntityNamedNoteService(
        entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findByNoteTypeExtIdAndEntityReference("42", mock(EntityReference.class));

    // Assert
    verify(entityNamedNoteDao).findByNoteTypeExtIdAndEntityReference(eq("42"), isA(EntityReference.class));
    assertTrue(actualFindByNoteTypeExtIdAndEntityReferenceResult.isEmpty());
    assertSame(entityNamedNoteSet, actualFindByNoteTypeExtIdAndEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#save(EntityReference, long, String, String)}
   */
  @Test
  void testSave() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.save(Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any(),
        Mockito.<UserTimestamp>any())).thenReturn(true);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    when(entityNamedNodeType.name()).thenReturn("Name");
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualSaveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .save(mock(EntityReference.class), 1L, "Note Text", "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteDao).save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).name();
    verify(entityNamedNodeType).isReadOnly();
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#save(EntityReference, long, String, String)}
   */
  @Test
  void testSave2() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.save(Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any(),
        Mockito.<UserTimestamp>any())).thenReturn(false);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);

    // Act
    boolean actualSaveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .save(mock(EntityReference.class), 1L, "Note Text", "janedoe");

    // Assert
    verify(entityNamedNoteDao).save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).isReadOnly();
    assertFalse(actualSaveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#save(EntityReference, long, String, String)}
   */
  @Test
  void testSave3() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.save(Mockito.<EntityReference>any(), anyLong(), Mockito.<String>any(),
        Mockito.<UserTimestamp>any())).thenReturn(true);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    when(entityNamedNodeType.name()).thenReturn("Name");
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualSaveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        changeLogService)).save(mock(EntityReference.class), 1L, "Note Text", "janedoe");

    // Assert
    verify(entityNamedNoteDao).save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).name();
    verify(entityNamedNodeType).isReadOnly();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, long, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(null);
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).remove(null,
                1L, "janedoe");

    // Assert
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, long, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any(), anyLong())).thenReturn(false);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).remove(null,
                1L, "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isNull(), eq(1L));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).isReadOnly();
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, long, String)}
   */
  @Test
  void testRemove3() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any(), anyLong())).thenReturn(true);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    when(entityNamedNodeType.name()).thenReturn("Name");
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .remove(mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteDao).remove(isA(EntityReference.class), eq(1L));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).name();
    verify(entityNamedNodeType).isReadOnly();
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, long, String)}
   */
  @Test
  void testRemove4() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any(), anyLong())).thenReturn(true);
    EntityNamedNodeType entityNamedNodeType = mock(EntityNamedNodeType.class);
    when(entityNamedNodeType.isReadOnly()).thenReturn(false);
    when(entityNamedNodeType.name()).thenReturn("Name");
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong())).thenReturn(entityNamedNodeType);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        changeLogService)).remove(mock(EntityReference.class), 1L, "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isA(EntityReference.class), eq(1L));
    verify(entityNamedNodeTypeDao).getById(eq(1L));
    verify(entityNamedNodeType).name();
    verify(entityNamedNodeType).isReadOnly();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  void testRemove5() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(false);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).remove(null,
                "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isNull());
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  void testRemove6() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, mock(EntityNamedNoteTypeDao.class),
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .remove(mock(EntityReference.class), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteDao).remove(isA(EntityReference.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  void testRemove7() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveResult = (new EntityNamedNoteService(entityNamedNoteDao, mock(EntityNamedNoteTypeDao.class),
        changeLogService)).remove(mock(EntityReference.class), "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link EntityNamedNoteService#deleteByNamedNoteParentSelector(IdSelectionOptions)}
   */
  @Test
  void testDeleteByNamedNoteParentSelector() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.deleteByParentSelector(Mockito.<GenericSelector>any())).thenReturn(1);
    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    EntityNamedNoteService entityNamedNoteService = new EntityNamedNoteService(entityNamedNoteDao,
        entityNamedNodeTypeDao,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    int actualDeleteByNamedNoteParentSelectorResult = entityNamedNoteService
        .deleteByNamedNoteParentSelector(selectionOptions);

    // Assert
    verify(entityNamedNoteDao).deleteByParentSelector(isA(GenericSelector.class));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByNamedNoteParentSelectorResult);
  }
}
