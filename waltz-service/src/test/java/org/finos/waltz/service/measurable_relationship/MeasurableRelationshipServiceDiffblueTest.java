package org.finos.waltz.service.measurable_relationship;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.entity_relationship.EntityRelationship;
import org.finos.waltz.model.entity_relationship.EntityRelationshipKey;
import org.finos.waltz.model.entity_relationship.UpdateEntityRelationshipParams;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MeasurableRelationshipServiceDiffblueTest {
  /**
   * Method under test:
   * {@link MeasurableRelationshipService#findForEntityReference(EntityReference)}
   */
  @Test
  void testFindForEntityReference() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    ArrayList<EntityRelationship> entityRelationshipList = new ArrayList<>();
    when(entityRelationshipDao.findRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityRelationshipList);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Collection<EntityRelationship> actualFindForEntityReferenceResult = (new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .findForEntityReference(mock(EntityReference.class));

    // Assert
    verify(entityRelationshipDao).findRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualFindForEntityReferenceResult instanceof List);
    assertTrue(actualFindForEntityReferenceResult.isEmpty());
    assertSame(entityRelationshipList, actualFindForEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#tallyForEntityReference(EntityReference)}
   */
  @Test
  void testTallyForEntityReference() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    HashMap<EntityKind, Integer> entityKindIntegerMap = new HashMap<>();
    when(entityRelationshipDao.tallyRelationshipsInvolving(Mockito.<EntityReference>any()))
        .thenReturn(entityKindIntegerMap);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    Map<EntityKind, Integer> actualTallyForEntityReferenceResult = (new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class))))
                .tallyForEntityReference(mock(EntityReference.class));

    // Assert
    verify(entityRelationshipDao).tallyRelationshipsInvolving(isA(EntityReference.class));
    assertTrue(actualTallyForEntityReferenceResult.isEmpty());
    assertSame(entityKindIntegerMap, actualTallyForEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(false);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    boolean actualRemoveResult = (new MeasurableRelationshipService(entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).remove(null,
                "janedoe");

    // Assert
    verify(entityRelationshipDao).remove(isNull());
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#remove(EntityRelationshipKey, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.remove(Mockito.<EntityRelationshipKey>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableRelationshipService measurableRelationshipService = new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    EntityRelationshipKey command = mock(EntityRelationshipKey.class);
    when(command.relationshipKind()).thenReturn("Relationship Kind");
    when(command.a()).thenReturn(mock(EntityReference.class));
    when(command.b()).thenReturn(mock(EntityReference.class));

    // Act
    boolean actualRemoveResult = measurableRelationshipService.remove(command, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).remove(isA(EntityRelationshipKey.class));
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(command, atLeast(1)).a();
    verify(command, atLeast(1)).b();
    verify(command).relationshipKind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference, String, String)}
   */
  @Test
  void testCreate() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(false);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    boolean actualCreateResult = (new MeasurableRelationshipService(entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).create(
                "janedoe", mock(EntityReference.class), mock(EntityReference.class), "Relationship Kind",
                "The characteristics of someone or something");

    // Assert
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    assertFalse(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference, String, String)}
   */
  @Test
  void testCreate2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualCreateResult = (new MeasurableRelationshipService(entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).create(
                "janedoe", mock(EntityReference.class), mock(EntityReference.class), "Relationship Kind",
                "The characteristics of someone or something");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(entityReference2).name();
    verify(entityReference).name();
    assertTrue(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#create(String, EntityReference, EntityReference, String, String)}
   */
  @Test
  void testCreate3() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.create(Mockito.<EntityRelationship>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    // Act
    boolean actualCreateResult = (new MeasurableRelationshipService(entityRelationshipDao, entityReferenceNameResolver,
        changeLogService)).create("janedoe", mock(EntityReference.class), mock(EntityReference.class),
            "Relationship Kind", "The characteristics of someone or something");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).create(isA(EntityRelationship.class));
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualCreateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(Mockito.<EntityRelationshipKey>any(),
        Mockito.<UpdateEntityRelationshipParams>any(), Mockito.<String>any())).thenReturn(false);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);

    // Act
    boolean actualUpdateResult = (new MeasurableRelationshipService(entityRelationshipDao, entityReferenceNameResolver,
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)))).update(null,
                null, "janedoe");

    // Assert
    verify(entityRelationshipDao).update(isNull(), isNull(), eq("janedoe"));
    assertFalse(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(Mockito.<EntityRelationshipKey>any(),
        Mockito.<UpdateEntityRelationshipParams>any(), Mockito.<String>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableRelationshipService measurableRelationshipService = new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.a()).thenReturn(mock(EntityReference.class));
    when(key.b()).thenReturn(mock(EntityReference.class));
    UpdateEntityRelationshipParams params = mock(UpdateEntityRelationshipParams.class);
    when(params.description()).thenReturn("The characteristics of someone or something");
    when(params.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    boolean actualUpdateResult = measurableRelationshipService.update(key, params, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).update(isA(EntityRelationshipKey.class), isA(UpdateEntityRelationshipParams.class),
        eq("janedoe"));
    verify(params).description();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(params, atLeast(1)).relationshipKind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(Mockito.<EntityRelationshipKey>any(),
        Mockito.<UpdateEntityRelationshipParams>any(), Mockito.<String>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableRelationshipService measurableRelationshipService = new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.a()).thenReturn(mock(EntityReference.class));
    when(key.b()).thenReturn(mock(EntityReference.class));
    UpdateEntityRelationshipParams params = mock(UpdateEntityRelationshipParams.class);
    when(params.description()).thenReturn(null);
    when(params.relationshipKind()).thenReturn("Relationship Kind");

    // Act
    boolean actualUpdateResult = measurableRelationshipService.update(key, params, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).update(isA(EntityRelationshipKey.class), isA(UpdateEntityRelationshipParams.class),
        eq("janedoe"));
    verify(params).description();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(params, atLeast(1)).relationshipKind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link MeasurableRelationshipService#update(EntityRelationshipKey, UpdateEntityRelationshipParams, String)}
   */
  @Test
  void testUpdate4() {
    // Arrange
    EntityRelationshipDao entityRelationshipDao = mock(EntityRelationshipDao.class);
    when(entityRelationshipDao.update(Mockito.<EntityRelationshipKey>any(),
        Mockito.<UpdateEntityRelationshipParams>any(), Mockito.<String>any())).thenReturn(true);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult2);

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(entityReference2);
    entityReferenceList.add(entityReference);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<List<EntityReference>>any())).thenReturn(entityReferenceList);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    MeasurableRelationshipService measurableRelationshipService = new MeasurableRelationshipService(
        entityRelationshipDao, entityReferenceNameResolver, changeLogService);
    EntityRelationshipKey key = mock(EntityRelationshipKey.class);
    when(key.a()).thenReturn(mock(EntityReference.class));
    when(key.b()).thenReturn(mock(EntityReference.class));
    UpdateEntityRelationshipParams params = mock(UpdateEntityRelationshipParams.class);
    when(params.description()).thenReturn("The characteristics of someone or something");
    when(params.relationshipKind()).thenReturn(null);

    // Act
    boolean actualUpdateResult = measurableRelationshipService.update(key, params, "janedoe");

    // Assert
    verify(entityReferenceNameResolver).resolve(isA(List.class));
    verify(entityRelationshipDao).update(isA(EntityRelationshipKey.class), isA(UpdateEntityRelationshipParams.class),
        eq("janedoe"));
    verify(params).description();
    verify(entityReference2).name();
    verify(entityReference).name();
    verify(key, atLeast(1)).a();
    verify(key, atLeast(1)).b();
    verify(params).relationshipKind();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualUpdateResult);
  }
}
