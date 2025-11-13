package org.finos.waltz.service.measurable_relationship;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.entity_relationship.EntityRelationshipDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.ImmutableEntityRelationshipKey.Builder;
import org.finos.waltz.model.entity_relationship.ImmutableUpdateEntityRelationshipParams;
import org.finos.waltz.model.entity_relationship.UpdateEntityRelationshipParams;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRelationshipServiceDiffblueTest {
  /**
   * Test {@link MeasurableRelationshipService#findForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRelationshipService#findForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findForEntityReference(EntityReference); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MeasurableRelationshipService.findForEntityReference(EntityReference)"
  })
  void testFindForEntityReference_thenReturnList() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    // Act
    Collection<EntityRelationship> actualFindForEntityReferenceResult =
        measurableRelationshipService.findForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityReferenceResult instanceof List);
    assertTrue(actualFindForEntityReferenceResult.isEmpty());
    assertSame(entityRelationshipList, actualFindForEntityReferenceResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#tallyForEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * MeasurableRelationshipService#tallyForEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test tallyForEntityReference(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map MeasurableRelationshipService.tallyForEntityReference(EntityReference)"})
  void testTallyForEntityReference_thenReturnEmpty() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.tallyRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(new HashMap<>());
    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    // Act
    Map<EntityKind, Integer> actualTallyForEntityReferenceResult =
        measurableRelationshipService.tallyForEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(entityRelationshipDao).tallyRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualTallyForEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#remove(EntityRelationshipKey,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRelationshipService.remove(EntityRelationshipKey, String)"})
  void testRemove_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

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

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRelationshipService.remove(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#remove(EntityRelationshipKey,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRelationshipService.remove(EntityRelationshipKey, String)"})
  void testRemove_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRelationshipService.remove(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationshipDao} {@link
   *       EntityRelationshipDao#remove(EntityRelationshipKey)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#remove(EntityRelationshipKey,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey, String); given EntityRelationshipDao remove(EntityRelationshipKey) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRelationshipService.remove(EntityRelationshipKey, String)"})
  void testRemove_givenEntityRelationshipDaoRemoveReturnFalse_thenReturnFalse() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);
    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao,
            mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class));

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    boolean actualRemoveResult =
        measurableRelationshipService.remove(
            aResult
                .b(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}.
   *
   * <ul>
   *   <li>Given {@code Relationship Kind}.
   *   <li>Then calls {@link EntityRelationshipKey#a()}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#remove(EntityRelationshipKey,
   * String)}
   */
  @Test
  @DisplayName(
      "Test remove(EntityRelationshipKey, String); given 'Relationship Kind'; then calls a()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MeasurableRelationshipService.remove(EntityRelationshipKey, String)"})
  void testRemove_givenRelationshipKind_thenCallsA() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

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

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    EntityRelationshipKey command = mock(EntityRelationshipKey.class);
    when(command.relationshipKind()).thenReturn("Relationship Kind");
    when(command.a())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(command.b())
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
    boolean actualRemoveResult = measurableRelationshipService.remove(command, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(command, atLeast(1)).a();
    verify(command, atLeast(1)).b();
    verify(command).relationshipKind();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#create(String, EntityReference,
   * EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(String, EntityReference, EntityReference, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.create(String, EntityReference, EntityReference, String, String)"
  })
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

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

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    ImmutableEntityReference entityRefA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualCreateResult =
        measurableRelationshipService.create(
            "janedoe",
            entityRefA,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Relationship Kind",
            "The characteristics of someone or something");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#create(String, EntityReference,
   * EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(String, EntityReference, EntityReference, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.create(String, EntityReference, EntityReference, String, String)"
  })
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    ImmutableEntityReference entityRefA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualCreateResult =
        measurableRelationshipService.create(
            "janedoe",
            entityRefA,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Relationship Kind",
            "The characteristics of someone or something");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualCreateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference,
   * String, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationshipDao} {@link
   *       EntityRelationshipDao#create(EntityRelationship)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#create(String, EntityReference,
   * EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test create(String, EntityReference, EntityReference, String, String); given EntityRelationshipDao create(EntityRelationship) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.create(String, EntityReference, EntityReference, String, String)"
  })
  void testCreate_givenEntityRelationshipDaoCreateReturnFalse_thenReturnFalse() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(false);
    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao,
            mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class));
    ImmutableEntityReference entityRefA =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    boolean actualCreateResult =
        measurableRelationshipService.create(
            "janedoe",
            entityRefA,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Relationship Kind",
            "The characteristics of someone or something");

    // Assert
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(
            Mockito.<EntityRelationshipKey>any(),
            Mockito.<UpdateEntityRelationshipParams>any(),
            Mockito.<String>any()))
        .thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

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

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        measurableRelationshipService.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(entityRelationshipDao)
        .update(
            isA(EntityRelationshipKey.class),
            isA(UpdateEntityRelationshipParams.class),
            eq("janedoe"));
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(
            Mockito.<EntityRelationshipKey>any(),
            Mockito.<UpdateEntityRelationshipParams>any(),
            Mockito.<String>any()))
        .thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        measurableRelationshipService.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao)
        .update(
            isA(EntityRelationshipKey.class),
            isA(UpdateEntityRelationshipParams.class),
            eq("janedoe"));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualUpdateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelationshipDao} {@link
   *       EntityRelationshipDao#update(EntityRelationshipKey, UpdateEntityRelationshipParams,
   *       String)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); given EntityRelationshipDao update(EntityRelationshipKey, UpdateEntityRelationshipParams, String) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_givenEntityRelationshipDaoUpdateReturnFalse_thenReturnFalse() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(
            Mockito.<EntityRelationshipKey>any(),
            Mockito.<UpdateEntityRelationshipParams>any(),
            Mockito.<String>any()))
        .thenReturn(false);
    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao,
            mock(EntityReferenceNameResolver.class),
            mock(ChangeLogService.class));

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        measurableRelationshipService.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description("The characteristics of someone or something")
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityRelationshipDao)
        .update(
            isA(EntityRelationshipKey.class),
            isA(UpdateEntityRelationshipParams.class),
            eq("janedoe"));
    assertFalse(actualUpdateResult);
  }

  /**
   * Test {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}.
   *
   * <ul>
   *   <li>When builder description {@code null} relationshipKind {@code Relationship Kind} build.
   * </ul>
   *
   * <p>Method under test: {@link MeasurableRelationshipService#update(EntityRelationshipKey,
   * UpdateEntityRelationshipParams, String)}
   */
  @Test
  @DisplayName(
      "Test update(EntityRelationshipKey, UpdateEntityRelationshipParams, String); when builder description 'null' relationshipKind 'Relationship Kind' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MeasurableRelationshipService.update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)"
  })
  void testUpdate_whenBuilderDescriptionNullRelationshipKindRelationshipKindBuild() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(
            Mockito.<EntityRelationshipKey>any(),
            Mockito.<UpdateEntityRelationshipParams>any(),
            Mockito.<String>any()))
        .thenReturn(true);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferenceList.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    EntityReferenceNameResolver entityReferenceNameResolver =
        mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any()))
        .thenReturn(entityReferenceList);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    MeasurableRelationshipService measurableRelationshipService =
        new MeasurableRelationshipService(
            entityRelationshipDao, entityReferenceNameResolver, changeLogService);

    Builder builderResult = ImmutableEntityRelationshipKey.builder();

    Builder aResult =
        builderResult.a(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityRelationshipKey key =
        aResult
            .b(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .relationshipKind("Relationship Kind")
            .build();

    // Act
    boolean actualUpdateResult =
        measurableRelationshipService.update(
            key,
            ImmutableUpdateEntityRelationshipParams.builder()
                .description(null)
                .relationshipKind("Relationship Kind")
                .build(),
            "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao)
        .update(
            isA(EntityRelationshipKey.class),
            isA(UpdateEntityRelationshipParams.class),
            eq("janedoe"));
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualUpdateResult);
  }
}
