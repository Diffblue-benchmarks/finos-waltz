package org.finos.waltz.service.entity_named_note;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
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
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.EntityWithOperations;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_named_note.EntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.EntityNamedNoteTypeChangeCommand;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNodeType;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNoteTypeChangeCommand.Builder;
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
class EntityNamedNoteTypeServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private EntityNamedNoteTypeDao entityNamedNoteTypeDao;

  @InjectMocks private EntityNamedNoteTypeService entityNamedNoteTypeService;

  /**
   * Test {@link EntityNamedNoteTypeService#findAll()}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityNamedNoteTypeService.findAll()"})
  void testFindAll() {
    // Arrange
    when(entityNamedNoteTypeDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<EntityNamedNodeType> actualFindAllResult = entityNamedNoteTypeService.findAll();

    // Assert
    verify(entityNamedNoteTypeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link EntityNamedNoteTypeService#removeById(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeService.removeById(Long, String)"})
  void testRemoveById_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(true);

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

    EntityNamedNoteTypeService entityNamedNoteTypeService =
        new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService);

    // Act
    boolean actualRemoveByIdResult = entityNamedNoteTypeService.removeById(1L, "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).removeById(1L);
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#removeById(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeService.removeById(Long, String)"})
  void testRemoveById_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualRemoveByIdResult = entityNamedNoteTypeService.removeById(1L, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).removeById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#removeById(Long, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityNamedNoteTypeDao} {@link EntityNamedNoteTypeDao#removeById(Long)}
   *       return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#removeById(Long, String)}
   */
  @Test
  @DisplayName(
      "Test removeById(Long, String); given EntityNamedNoteTypeDao removeById(Long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityNamedNoteTypeService.removeById(Long, String)"})
  void testRemoveById_givenEntityNamedNoteTypeDaoRemoveByIdReturnFalse_thenReturnFalse() {
    // Arrange
    when(entityNamedNoteTypeDao.removeById(Mockito.<Long>any())).thenReturn(false);

    // Act
    boolean actualRemoveByIdResult = entityNamedNoteTypeService.removeById(1L, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).removeById(1L);
    assertFalse(actualRemoveByIdResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(EntityNamedNoteTypeChangeCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long EntityNamedNoteTypeService.create(EntityNamedNoteTypeChangeCommand, String)"
  })
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.create(Mockito.<EntityNamedNoteTypeChangeCommand>any()))
        .thenReturn(1L);

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

    EntityNamedNoteTypeService entityNamedNoteTypeService =
        new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    long actualCreateResult =
        entityNamedNoteTypeService.create(
            externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(), "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).create(isA(EntityNamedNoteTypeChangeCommand.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EntityNamedNoteTypeService#create(EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test create(EntityNamedNoteTypeChangeCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long EntityNamedNoteTypeService.create(EntityNamedNoteTypeChangeCommand, String)"
  })
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(entityNamedNoteTypeDao.create(Mockito.<EntityNamedNoteTypeChangeCommand>any()))
        .thenReturn(1L);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    long actualCreateResult =
        entityNamedNoteTypeService.create(
            externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(), "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).create(isA(EntityNamedNoteTypeChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#update(long,
   * EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeService.update(long, EntityNamedNoteTypeChangeCommand, String)"
  })
  void testUpdate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityNamedNoteTypeDao entityNamedNoteTypeDao = mock(EntityNamedNoteTypeDao.class);
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any()))
        .thenReturn(true);

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

    EntityNamedNoteTypeService entityNamedNoteTypeService =
        new EntityNamedNoteTypeService(entityNamedNoteTypeDao, changeLogService);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeService.update(
            1L,
            externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(),
            "janedoe");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#update(long,
   * EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeService.update(long, EntityNamedNoteTypeChangeCommand, String)"
  })
  void testUpdate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any()))
        .thenReturn(true);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeService.update(
            1L,
            externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(),
            "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#update(long, EntityNamedNoteTypeChangeCommand, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityNamedNoteTypeDao} {@link EntityNamedNoteTypeDao#update(long,
   *       EntityNamedNoteTypeChangeCommand)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#update(long,
   * EntityNamedNoteTypeChangeCommand, String)}
   */
  @Test
  @DisplayName(
      "Test update(long, EntityNamedNoteTypeChangeCommand, String); given EntityNamedNoteTypeDao update(long, EntityNamedNoteTypeChangeCommand) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityNamedNoteTypeService.update(long, EntityNamedNoteTypeChangeCommand, String)"
  })
  void testUpdate_givenEntityNamedNoteTypeDaoUpdateReturnFalse_thenReturnFalse() {
    // Arrange
    when(entityNamedNoteTypeDao.update(anyLong(), Mockito.<EntityNamedNoteTypeChangeCommand>any()))
        .thenReturn(false);

    Builder builderResult = ImmutableEntityNamedNoteTypeChangeCommand.builder();
    Optional<? extends Set<EntityKind>> applicableEntityKinds = Optional.of(new HashSet<>());

    Builder externalIdResult =
        builderResult
            .applicableEntityKinds(applicableEntityKinds)
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<Boolean> isReadOnly = Optional.of(true);

    // Act
    boolean actualUpdateResult =
        entityNamedNoteTypeService.update(
            1L,
            externalIdResult.isReadOnly(isReadOnly).name("Name").position(1).build(),
            "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).update(eq(1L), isA(EntityNamedNoteTypeChangeCommand.class));
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link EntityNamedNoteTypeService#getByExternalId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableEntityNamedNodeType}.
   * </ul>
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String); then return ImmutableEntityNamedNodeType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityNamedNodeType EntityNamedNoteTypeService.getByExternalId(String)"})
  void testGetByExternalId_thenReturnImmutableEntityNamedNodeType() {
    // Arrange
    when(entityNamedNoteTypeDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableEntityNamedNodeType.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isReadOnly(true)
                .name("Name")
                .position(1)
                .build());

    // Act
    EntityNamedNodeType actualByExternalId = entityNamedNoteTypeService.getByExternalId("42");

    // Assert
    verify(entityNamedNoteTypeDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableEntityNamedNodeType);
    assertEquals("Name", actualByExternalId.name());
    assertEquals("The characteristics of someone or something", actualByExternalId.description());
    assertEquals(1, actualByExternalId.position());
    assertTrue(actualByExternalId.applicableEntityKinds().isEmpty());
    assertTrue(actualByExternalId.isReadOnly());
  }

  /**
   * Test {@link EntityNamedNoteTypeService#findForRefAndUser(EntityReference, String)}.
   *
   * <p>Method under test: {@link EntityNamedNoteTypeService#findForRefAndUser(EntityReference,
   * String)}
   */
  @Test
  @DisplayName("Test findForRefAndUser(EntityReference, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityNamedNoteTypeService.findForRefAndUser(EntityReference, String)"})
  void testFindForRefAndUser() {
    // Arrange
    when(entityNamedNoteTypeDao.findForRefAndUser(
            Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<EntityWithOperations<EntityNamedNodeType>> actualFindForRefAndUserResult =
        entityNamedNoteTypeService.findForRefAndUser(null, "janedoe");

    // Assert
    verify(entityNamedNoteTypeDao).findForRefAndUser(isNull(), eq("janedoe"));
    assertTrue(actualFindForRefAndUserResult.isEmpty());
  }
}
