package org.finos.waltz.service.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNote;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNodeType;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class EntityNamedNoteServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityNamedNoteDao entityNamedNoteDao;

  @InjectMocks private EntityNamedNoteService entityNamedNoteService;

  @Mock private EntityNamedNoteTypeDao entityNamedNoteTypeDao;

  /**
   * Test {@link EntityNamedNoteService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link EntityNamedNoteService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityNamedNoteService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    when(entityNamedNoteDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityNamedNote> actualFindByEntityReferenceResult =
        entityNamedNoteService.findByEntityReference(null);

    // Assert
    verify(entityNamedNoteDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteService#findByNoteTypeExtId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#findByNoteTypeExtId(String)}
   */
  @Test
  @DisplayName("Test findByNoteTypeExtId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityNamedNoteService.findByNoteTypeExtId(String)"})
  void testFindByNoteTypeExtId_thenReturnEmpty() {
    // Arrange
    when(entityNamedNoteDao.findByNoteTypeExtId(Mockito.<String>any())).thenReturn(new HashSet<>());

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdResult =
        entityNamedNoteService.findByNoteTypeExtId("42");

    // Assert
    verify(entityNamedNoteDao).findByNoteTypeExtId("42");
    assertTrue(actualFindByNoteTypeExtIdResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteService#findByNoteTypeExtIdAndEntityReference(String,
   * EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityNamedNoteService#findByNoteTypeExtIdAndEntityReference(String, EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByNoteTypeExtIdAndEntityReference(String, EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set EntityNamedNoteService.findByNoteTypeExtIdAndEntityReference(String, EntityReference)"
  })
  void testFindByNoteTypeExtIdAndEntityReference_thenReturnEmpty() {
    // Arrange
    when(entityNamedNoteDao.findByNoteTypeExtIdAndEntityReference(
            Mockito.<String>any(), Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<EntityNamedNote> actualFindByNoteTypeExtIdAndEntityReferenceResult =
        entityNamedNoteService.findByNoteTypeExtIdAndEntityReference(
            "42",
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(entityNamedNoteDao)
        .findByNoteTypeExtIdAndEntityReference(eq("42"), isA(EntityReference.class));
    assertTrue(actualFindByNoteTypeExtIdAndEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteService#save(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#save(EntityReference, long, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.save(EntityReference, long, String, String)"})
  void testSave_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.save(
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any(),
            Mockito.<UserTimestamp>any()))
        .thenReturn(true);

    EntityNamedNoteTypeDao entityNamedNodeTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNodeTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableEntityNamedNodeType.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isReadOnly(false)
                .name("Name")
                .position(1)
                .build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(entityNamedNoteDao, entityNamedNodeTypeDao, changeLogService);

    // Act
    boolean actualSaveResult =
        entityNamedNoteService.save(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "Note Text",
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteDao)
        .save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNodeTypeDao).getById(1L);
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#save(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#save(EntityReference, long, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.save(EntityReference, long, String, String)"})
  void testSave_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(entityNamedNoteDao.save(
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any(),
            Mockito.<UserTimestamp>any()))
        .thenReturn(true);
    when(entityNamedNoteTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableEntityNamedNodeType.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isReadOnly(false)
                .name("Name")
                .position(1)
                .build());
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualSaveResult =
        entityNamedNoteService.save(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "Note Text",
            "janedoe");

    // Assert
    verify(entityNamedNoteDao)
        .save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNoteTypeDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#save(EntityReference, long, String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityNamedNoteDao} {@link EntityNamedNoteDao#save(EntityReference, long,
   *       String, UserTimestamp)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#save(EntityReference, long, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test save(EntityReference, long, String, String); given EntityNamedNoteDao save(EntityReference, long, String, UserTimestamp) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.save(EntityReference, long, String, String)"})
  void testSave_givenEntityNamedNoteDaoSaveReturnFalse_thenReturnFalse() {
    // Arrange
    when(entityNamedNoteDao.save(
            Mockito.<EntityReference>any(),
            anyLong(),
            Mockito.<String>any(),
            Mockito.<UserTimestamp>any()))
        .thenReturn(false);
    when(entityNamedNoteTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableEntityNamedNodeType.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isReadOnly(false)
                .name("Name")
                .position(1)
                .build());

    // Act
    boolean actualSaveResult =
        entityNamedNoteService.save(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L,
            "Note Text",
            "janedoe");

    // Assert
    verify(entityNamedNoteDao)
        .save(isA(EntityReference.class), eq(1L), eq("Note Text"), isA(UserTimestamp.class));
    verify(entityNamedNoteTypeDao).getById(1L);
    assertFalse(actualSaveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#remove(EntityReference, long, String)} with {@code ref},
   * {@code namedNoteTypeId}, {@code username}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#remove(EntityReference, long, String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference, long, String) with 'ref', 'namedNoteTypeId', 'username'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.remove(EntityReference, long, String)"})
  void testRemoveWithRefNamedNoteTypeIdUsername_thenReturnFalse() {
    // Arrange
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any(), anyLong())).thenReturn(false);
    when(entityNamedNoteTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableEntityNamedNodeType.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isReadOnly(false)
                .name("Name")
                .position(1)
                .build());

    // Act
    boolean actualRemoveResult = entityNamedNoteService.remove(null, 1L, "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isNull(), eq(1L));
    verify(entityNamedNoteTypeDao).getById(1L);
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#remove(EntityReference, String)} with {@code ref}, {@code
   * username}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference, String) with 'ref', 'username'; given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.remove(EntityReference, String)"})
  void testRemoveWithRefUsername_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityNamedNoteDao entityNamedNoteDao = mock(EntityNamedNoteDao.class);
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(true);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    EntityNamedNoteService entityNamedNoteService =
        new EntityNamedNoteService(
            entityNamedNoteDao, mock(EntityNamedNoteTypeDao.class), changeLogService);

    // Act
    boolean actualRemoveResult =
        entityNamedNoteService.remove(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteDao).remove(isA(EntityReference.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#remove(EntityReference, String)} with {@code ref}, {@code
   * username}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityReference, String) with 'ref', 'username'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.remove(EntityReference, String)"})
  void testRemoveWithRefUsername_thenCallsWrite() {
    // Arrange
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveResult =
        entityNamedNoteService.remove(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isA(EntityReference.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#remove(EntityReference, String)} with {@code ref}, {@code
   * username}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteService#remove(EntityReference, String)}
   */
  @Test
  @DisplayName("Test remove(EntityReference, String) with 'ref', 'username'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteService.remove(EntityReference, String)"})
  void testRemoveWithRefUsername_thenReturnFalse() {
    // Arrange
    when(entityNamedNoteDao.remove(Mockito.<EntityReference>any())).thenReturn(false);

    // Act
    boolean actualRemoveResult =
        entityNamedNoteService.remove(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "janedoe");

    // Assert
    verify(entityNamedNoteDao).remove(isA(EntityReference.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link EntityNamedNoteService#deleteByNamedNoteParentSelector(IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@link HierarchyQueryScope#EXACT}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityNamedNoteService#deleteByNamedNoteParentSelector(IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test deleteByNamedNoteParentSelector(IdSelectionOptions); given EXACT; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int EntityNamedNoteService.deleteByNamedNoteParentSelector(IdSelectionOptions)"
  })
  void testDeleteByNamedNoteParentSelector_givenExact_thenReturnOne() {
    // Arrange
    when(entityNamedNoteDao.deleteByParentSelector(Mockito.<GenericSelector>any())).thenReturn(1);

    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    int actualDeleteByNamedNoteParentSelectorResult =
        entityNamedNoteService.deleteByNamedNoteParentSelector(selectionOptions);

    // Assert
    verify(entityNamedNoteDao).deleteByParentSelector(isA(GenericSelector.class));
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    assertEquals(1, actualDeleteByNamedNoteParentSelectorResult);
  }
}
