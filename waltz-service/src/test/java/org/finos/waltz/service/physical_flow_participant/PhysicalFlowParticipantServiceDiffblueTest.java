package org.finos.waltz.service.physical_flow_participant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.physical_flow_participant.PhysicalFlowParticipantDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.logical_flow.LogicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow_participant.ParticipationKind;
import org.finos.waltz.model.physical_flow_participant.PhysicalFlowParticipant;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.logical_flow.LogicalFlowService;
import org.finos.waltz.service.physical_flow.PhysicalFlowService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalFlowParticipantServiceDiffblueTest {
  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#findByPhysicalFlowId(long)}
   */
  @Test
  void testFindByPhysicalFlowId() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    ArrayList<PhysicalFlowParticipant> physicalFlowParticipantList = new ArrayList<>();
    when(dao.findByPhysicalFlowId(anyLong())).thenReturn(physicalFlowParticipantList);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByPhysicalFlowIdResult = (new PhysicalFlowParticipantService(dao,
        mock(ChangeLogService.class), mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class),
        mock(PhysicalFlowService.class), mock(PhysicalSpecificationService.class))).findByPhysicalFlowId(1L);

    // Assert
    verify(dao).findByPhysicalFlowId(eq(1L));
    assertTrue(actualFindByPhysicalFlowIdResult instanceof List);
    assertTrue(actualFindByPhysicalFlowIdResult.isEmpty());
    assertSame(physicalFlowParticipantList, actualFindByPhysicalFlowIdResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#findByParticipant(EntityReference)}
   */
  @Test
  void testFindByParticipant() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    ArrayList<PhysicalFlowParticipant> physicalFlowParticipantList = new ArrayList<>();
    when(dao.findByParticipant(Mockito.<EntityReference>any())).thenReturn(physicalFlowParticipantList);

    // Act
    Collection<PhysicalFlowParticipant> actualFindByParticipantResult = (new PhysicalFlowParticipantService(dao,
        mock(ChangeLogService.class), mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class),
        mock(PhysicalFlowService.class), mock(PhysicalSpecificationService.class)))
            .findByParticipant(mock(EntityReference.class));

    // Assert
    verify(dao).findByParticipant(isA(EntityReference.class));
    assertTrue(actualFindByParticipantResult instanceof List);
    assertTrue(actualFindByParticipantResult.isEmpty());
    assertSame(physicalFlowParticipantList, actualFindByParticipantResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        mock(LogicalFlowService.class), physicalFlowService, mock(PhysicalSpecificationService.class))).remove(1L,
            ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isNull());
    verify(entityReference).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(physicalFlowService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove2() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(false);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, mock(ChangeLogService.class),
        mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class), mock(PhysicalFlowService.class),
        mock(PhysicalSpecificationService.class))).remove(1L, ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isNull());
    assertFalse(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove3() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(true);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, mock(ChangeLogService.class), nameResolver,
        mock(LogicalFlowService.class), physicalFlowService, mock(PhysicalSpecificationService.class))).remove(1L,
            ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isNull());
    verify(physicalFlowService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove4() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(null);
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).remove(1L, ParticipationKind.SOURCE,
            null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isNull());
    verify(entityReference).name();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove5() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(mock(LogicalFlow.class));
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).remove(1L, ParticipationKind.SOURCE,
            null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isNull());
    verify(entityReference).name();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#remove(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testRemove6() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.remove(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any())).thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult3);
    EntityReference entityReference3 = mock(EntityReference.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(entityReference3.name()).thenReturn(ofResult4);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.target()).thenReturn(entityReference3);
    when(logicalFlow.source()).thenReturn(entityReference2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(logicalFlow);
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(physicalSpecification);

    // Act
    Boolean actualRemoveResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).remove(1L, ParticipationKind.SOURCE,
            mock(EntityReference.class), "janedoe");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(dao).remove(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class));
    verify(entityReference).name();
    verify(entityReference3).name();
    verify(entityReference2).name();
    verify(physicalSpecification).name();
    verify(logicalFlow).source();
    verify(logicalFlow).target();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualRemoveResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        mock(LogicalFlowService.class), physicalFlowService, mock(PhysicalSpecificationService.class))).add(1L,
            ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isNull(), eq("janedoe"));
    verify(entityReference).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(physicalFlowService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd2() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(false);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, mock(ChangeLogService.class),
        mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class), mock(PhysicalFlowService.class),
        mock(PhysicalSpecificationService.class))).add(1L, ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isNull(), eq("janedoe"));
    assertFalse(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd3() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(true);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(emptyResult);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, mock(ChangeLogService.class), nameResolver,
        mock(LogicalFlowService.class), physicalFlowService, mock(PhysicalSpecificationService.class))).add(1L,
            ParticipationKind.SOURCE, null, "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isNull(), eq("janedoe"));
    verify(physicalFlowService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd4() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(null);
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).add(1L, ParticipationKind.SOURCE, null,
            "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isNull(), eq("janedoe"));
    verify(entityReference).name();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd5() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(mock(LogicalFlow.class));
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(null);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).add(1L, ParticipationKind.SOURCE, null,
            "janedoe");

    // Assert
    verify(nameResolver).resolve((EntityReference) isNull());
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isNull(), eq("janedoe"));
    verify(entityReference).name();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService).write(isA(ChangeLog.class));
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#add(long, ParticipationKind, EntityReference, String)}
   */
  @Test
  void testAdd6() {
    // Arrange
    PhysicalFlowParticipantDao dao = mock(PhysicalFlowParticipantDao.class);
    when(dao.add(anyLong(), Mockito.<ParticipationKind>any(), Mockito.<EntityReference>any(), Mockito.<String>any()))
        .thenReturn(true);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    EntityReference entityReference = mock(EntityReference.class);
    Optional<String> ofResult = Optional.of("foo");
    when(entityReference.name()).thenReturn(ofResult);
    Optional<EntityReference> ofResult2 = Optional.of(entityReference);
    EntityReferenceNameResolver nameResolver = mock(EntityReferenceNameResolver.class);
    when(nameResolver.resolve(Mockito.<EntityReference>any())).thenReturn(ofResult2);
    EntityReference entityReference2 = mock(EntityReference.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(entityReference2.name()).thenReturn(ofResult3);
    EntityReference entityReference3 = mock(EntityReference.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(entityReference3.name()).thenReturn(ofResult4);
    LogicalFlow logicalFlow = mock(LogicalFlow.class);
    when(logicalFlow.target()).thenReturn(entityReference3);
    when(logicalFlow.source()).thenReturn(entityReference2);
    LogicalFlowService logicalFlowService = mock(LogicalFlowService.class);
    when(logicalFlowService.getById(anyLong())).thenReturn(logicalFlow);
    PhysicalFlow physicalFlow = mock(PhysicalFlow.class);
    when(physicalFlow.logicalFlowId()).thenReturn(1L);
    when(physicalFlow.specificationId()).thenReturn(1L);
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    when(physicalFlowService.getById(anyLong())).thenReturn(physicalFlow);
    PhysicalSpecification physicalSpecification = mock(PhysicalSpecification.class);
    when(physicalSpecification.name()).thenReturn("Name");
    PhysicalSpecificationService physicalSpecificationService = mock(PhysicalSpecificationService.class);
    when(physicalSpecificationService.getById(anyLong())).thenReturn(physicalSpecification);

    // Act
    Boolean actualAddResult = (new PhysicalFlowParticipantService(dao, changeLogService, nameResolver,
        logicalFlowService, physicalFlowService, physicalSpecificationService)).add(1L, ParticipationKind.SOURCE,
            mock(EntityReference.class), "janedoe");

    // Assert
    verify(nameResolver).resolve(isA(EntityReference.class));
    verify(dao).add(eq(1L), eq(ParticipationKind.SOURCE), isA(EntityReference.class), eq("janedoe"));
    verify(entityReference).name();
    verify(entityReference3).name();
    verify(entityReference2).name();
    verify(physicalSpecification).name();
    verify(logicalFlow).source();
    verify(logicalFlow).target();
    verify(physicalFlow).logicalFlowId();
    verify(physicalFlow).specificationId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(logicalFlowService).getById(eq(1L));
    verify(physicalFlowService).getById(eq(1L));
    verify(physicalSpecificationService).getById(eq(1L));
    assertTrue(actualAddResult);
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}
   */
  @Test
  void testCheckHasPermission() throws InsufficientPrivelegeException {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    doNothing().when(physicalFlowService).checkHasPermission(anyLong(), Mockito.<String>any());

    // Act
    (new PhysicalFlowParticipantService(mock(PhysicalFlowParticipantDao.class), mock(ChangeLogService.class),
        mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class), physicalFlowService,
        mock(PhysicalSpecificationService.class))).checkHasPermission(1L, "janedoe");

    // Assert
    verify(physicalFlowService).checkHasPermission(eq(1L), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link PhysicalFlowParticipantService#checkHasPermission(long, String)}
   */
  @Test
  void testCheckHasPermission2() throws InsufficientPrivelegeException {
    // Arrange
    PhysicalFlowService physicalFlowService = mock(PhysicalFlowService.class);
    doThrow(new InsufficientPrivelegeException("An error occurred")).when(physicalFlowService)
        .checkHasPermission(anyLong(), Mockito.<String>any());

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class,
        () -> (new PhysicalFlowParticipantService(mock(PhysicalFlowParticipantDao.class), mock(ChangeLogService.class),
            mock(EntityReferenceNameResolver.class), mock(LogicalFlowService.class), physicalFlowService,
            mock(PhysicalSpecificationService.class))).checkHasPermission(1L, "janedoe"));
    verify(physicalFlowService).checkHasPermission(eq(1L), eq("janedoe"));
  }
}
