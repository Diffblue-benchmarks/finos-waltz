package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.attestation.AttestationInstanceDao;
import org.finos.waltz.data.attestation.AttestationInstanceRecipientDao;
import org.finos.waltz.data.attestation.AttestationRunDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.attestation.AttestEntityCommand;
import org.finos.waltz.model.attestation.AttestationCreateSummary;
import org.finos.waltz.model.attestation.AttestationRun;
import org.finos.waltz.model.attestation.AttestationRunCreateCommand;
import org.finos.waltz.model.attestation.AttestationRunRecipient;
import org.finos.waltz.model.attestation.AttestationRunResponseSummary;
import org.finos.waltz.model.attestation.AttestationStatus;
import org.finos.waltz.model.attestation.ImmutableAttestationCreateSummary;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationRunServiceDiffblueTest {
  /**
   * Method under test: {@link AttestationRunService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getById(anyLong())).thenReturn(null);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    AttestationRun actualById = (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao,
        attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).getById(1L);

    // Assert
    verify(attestationRunDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link AttestationRunService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .getById(1L));
    verify(attestationRunDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link AttestationRunService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findAll()).thenReturn(attestationRunList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    List<AttestationRun> actualFindAllResult = (new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).findAll();

    // Assert
    verify(attestationRunDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(attestationRunList, actualFindAllResult);
  }

  /**
   * Method under test: {@link AttestationRunService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.findAll()).thenThrow(new IllegalArgumentException("foo"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .findAll());
    verify(attestationRunDao).findAll();
  }

  /**
   * Method under test: {@link AttestationRunService#findByRecipient(String)}
   */
  @Test
  void testFindByRecipient() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByRecipient(Mockito.<String>any())).thenReturn(attestationRunList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    List<AttestationRun> actualFindByRecipientResult = (new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).findByRecipient("42");

    // Assert
    verify(attestationRunDao).findByRecipient(eq("42"));
    assertTrue(actualFindByRecipientResult.isEmpty());
    assertSame(attestationRunList, actualFindByRecipientResult);
  }

  /**
   * Method under test: {@link AttestationRunService#findByRecipient(String)}
   */
  @Test
  void testFindByRecipient2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.findByRecipient(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("userId cannot be null"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .findByRecipient("42"));
    verify(attestationRunDao).findByRecipient(eq("42"));
  }

  /**
   * Method under test: {@link AttestationRunService#findResponseSummaries()}
   */
  @Test
  void testFindResponseSummaries() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRunResponseSummary> attestationRunResponseSummaryList = new ArrayList<>();
    when(attestationRunDao.findResponseSummaries()).thenReturn(attestationRunResponseSummaryList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    List<AttestationRunResponseSummary> actualFindResponseSummariesResult = (new AttestationRunService(
        attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver,
        involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)))).findResponseSummaries();

    // Assert
    verify(attestationRunDao).findResponseSummaries();
    assertTrue(actualFindResponseSummariesResult.isEmpty());
    assertSame(attestationRunResponseSummaryList, actualFindResponseSummariesResult);
  }

  /**
   * Method under test: {@link AttestationRunService#findResponseSummaries()}
   */
  @Test
  void testFindResponseSummaries2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.findResponseSummaries()).thenThrow(new IllegalArgumentException("foo"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .findResponseSummaries());
    verify(attestationRunDao).findResponseSummaries();
  }

  /**
   * Method under test:
   * {@link AttestationRunService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByEntityReference(Mockito.<EntityReference>any())).thenReturn(attestationRunList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    List<AttestationRun> actualFindByEntityReferenceResult = (new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByEntityReference(mock(EntityReference.class));

    // Assert
    verify(attestationRunDao).findByEntityReference(isA(EntityReference.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(attestationRunList, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenThrow(new IllegalArgumentException("ref cannot be null"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .findByEntityReference(mock(EntityReference.class)));
    verify(attestationRunDao).findByEntityReference(isA(EntityReference.class));
  }

  /**
   * Method under test:
   * {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  void testGetCreateSummary() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    when(command.selectionOptions()).thenReturn(idSelectionOptions);

    // Act
    AttestationCreateSummary actualCreateSummary = attestationRunService.getCreateSummary(command);

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(command).involvementKindIds();
    verify(command, atLeast(1)).selectionOptions();
    verify(command, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Method under test:
   * {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  void testGetCreateSummary2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.targetEntityKind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    when(command.selectionOptions()).thenReturn(idSelectionOptions);

    // Act
    AttestationCreateSummary actualCreateSummary = attestationRunService.getCreateSummary(command);

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class),
        isA(Set.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(command).involvementKindIds();
    verify(command, atLeast(1)).selectionOptions();
    verify(command, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Method under test:
   * {@link AttestationRunService#getCreateSummary(AttestationRunCreateCommand)}
   */
  @Test
  void testGetCreateSummary3() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getEntityCount(Mockito.<Select<Record1<Long>>>any())).thenReturn(3);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.targetEntityKind()).thenReturn(EntityKind.CHANGE_INITIATIVE);
    when(command.selectionOptions()).thenReturn(idSelectionOptions);

    // Act
    AttestationCreateSummary actualCreateSummary = attestationRunService.getCreateSummary(command);

    // Assert
    verify(attestationRunDao).getEntityCount(isA(Select.class));
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.CHANGE_INITIATIVE), isA(Select.class),
        isA(Set.class));
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(command).involvementKindIds();
    verify(command, atLeast(1)).selectionOptions();
    verify(command, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSummary instanceof ImmutableAttestationCreateSummary);
    assertEquals(0, actualCreateSummary.instanceCount());
    assertEquals(0L, actualCreateSummary.recipientCount());
    assertEquals(3, actualCreateSummary.entityCount());
  }

  /**
   * Method under test:
   * {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  void testCreate() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.create(Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .create("42", null));
    verify(attestationRunDao).create(eq("42"), isNull());
  }

  /**
   * Method under test:
   * {@link AttestationRunService#create(String, AttestationRunCreateCommand)}
   */
  @Test
  void testCreate2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.create(Mockito.<String>any(), Mockito.<AttestationRunCreateCommand>any())).thenReturn(1L);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException("Recipients for attestation run: %s"));
    AttestationRunService attestationRunService = new AttestationRunService(mock(AttestationInstanceDao.class),
        mock(AttestationInstanceRecipientDao.class), attestationRunDao, mock(EntityReferenceNameResolver.class),
        mock(InvolvementDao.class), involvementGroupService);
    AttestationRunCreateCommand command = mock(AttestationRunCreateCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> attestationRunService.create("42", command));
    verify(attestationRunDao).create(eq("42"), isA(AttestationRunCreateCommand.class));
    verify(command).name();
    verify(command).involvementKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("42"));
  }

  /**
   * Method under test:
   * {@link AttestationRunService#createRunForEntity(String, AttestEntityCommand)}
   */
  @Test
  void testCreateRunForEntity() {
    // Arrange
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    when(entityReferenceNameResolver.resolve(Mockito.<EntityReference>any())).thenThrow(
        new IllegalArgumentException("Attests that all %s mappings are present and correct for this entity"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    AttestEntityCommand entityRunCreateCommand = mock(AttestEntityCommand.class);
    when(entityRunCreateCommand.attestedEntityId()).thenReturn(1L);
    when(entityRunCreateCommand.attestedEntityKind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> attestationRunService.createRunForEntity("janedoe", entityRunCreateCommand));
    verify(entityReferenceNameResolver).resolve(isA(EntityReference.class));
    verify(entityRunCreateCommand, atLeast(1)).attestedEntityId();
    verify(entityRunCreateCommand).attestedEntityKind();
  }

  /**
   * Method under test:
   * {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByIdSelector() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(attestationRunList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult = attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options).filters();
    verify(options).scope();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunService#findByIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindByIdSelector2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    ArrayList<AttestationRun> attestationRunList = new ArrayList<>();
    when(attestationRunDao.findByIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(attestationRunList);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    AttestationRunService attestationRunService = new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions options = mock(IdSelectionOptions.class);
    when(options.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(options.filters()).thenReturn(selectionFilters);
    when(options.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(options.entityReference()).thenReturn(entityReference);

    // Act
    Collection<AttestationRun> actualFindByIdSelectorResult = attestationRunService.findByIdSelector(options);

    // Assert
    verify(attestationRunDao).findByIdSelector(isA(Select.class));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(options).entityLifecycleStatuses();
    verify(options, atLeast(1)).entityReference();
    verify(options, atLeast(1)).filters();
    verify(options).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    assertTrue(actualFindByIdSelectorResult instanceof List);
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(attestationRunList, actualFindByIdSelectorResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  void testIssueInstancesForPendingRuns() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateStatusForRunIds(Mockito.<Set<Long>>any(), Mockito.<AttestationStatus>any()))
        .thenReturn(1);
    when(attestationRunDao.findPendingRuns()).thenReturn(new HashSet<>());
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    int actualIssueInstancesForPendingRunsResult = (new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).issueInstancesForPendingRuns();

    // Assert
    verify(attestationRunDao).findPendingRuns();
    verify(attestationRunDao, atLeast(1)).updateStatusForRunIds(isA(Set.class), Mockito.<AttestationStatus>any());
    assertEquals(1, actualIssueInstancesForPendingRunsResult);
  }

  /**
   * Method under test:
   * {@link AttestationRunService#issueInstancesForPendingRuns()}
   */
  @Test
  void testIssueInstancesForPendingRuns2() {
    // Arrange
    AttestationRun attestationRun = mock(AttestationRun.class);
    when(attestationRun.attestedEntityKind()).thenReturn(EntityKind.ALL);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(attestationRun.id()).thenReturn(ofResult);

    HashSet<AttestationRun> attestationRunSet = new HashSet<>();
    attestationRunSet.add(attestationRun);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    AttestationRun attestationRun2 = mock(AttestationRun.class);
    when(attestationRun2.targetEntityKind()).thenThrow(new IllegalArgumentException("admin"));
    when(attestationRun2.involvementKindIds()).thenReturn(resultLongSet);
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.getById(anyLong())).thenReturn(attestationRun2);
    when(attestationRunDao.findPendingRuns()).thenReturn(attestationRunSet);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .issueInstancesForPendingRuns());
    verify(attestationRunDao).findPendingRuns();
    verify(attestationRunDao).getById(eq(1L));
    verify(attestationRun).id();
    verify(attestationRun).attestedEntityKind();
    verify(attestationRun2).involvementKindIds();
    verify(attestationRun2).targetEntityKind();
  }

  /**
   * Method under test:
   * {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    AttestationRunService attestationRunService = new AttestationRunService(mock(AttestationInstanceDao.class),
        mock(AttestationInstanceRecipientDao.class), attestationRunDao, mock(EntityReferenceNameResolver.class),
        mock(InvolvementDao.class), new InvolvementGroupService(involvementGroupDao));

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", new HashSet<>(), "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
  }

  /**
   * Method under test:
   * {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    AttestationRunService attestationRunService = new AttestationRunService(mock(AttestationInstanceDao.class),
        mock(AttestationInstanceRecipientDao.class), attestationRunDao, mock(EntityReferenceNameResolver.class),
        mock(InvolvementDao.class), involvementGroupService);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", new HashSet<>(), "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup3() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    AttestationRunService attestationRunService = new AttestationRunService(mock(AttestationInstanceDao.class),
        mock(AttestationInstanceRecipientDao.class), attestationRunDao, mock(EntityReferenceNameResolver.class),
        mock(InvolvementDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", involvementKindIds, "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link AttestationRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup4() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    AttestationRunService attestationRunService = new AttestationRunService(mock(AttestationInstanceDao.class),
        mock(AttestationInstanceRecipientDao.class), attestationRunDao, mock(EntityReferenceNameResolver.class),
        mock(InvolvementDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(1L);
    involvementKindIds.add(3L);

    // Act
    attestationRunService.createRecipientsGroup(1L, "Run Name", involvementKindIds, "janedoe");

    // Assert
    verify(attestationRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test: {@link AttestationRunService#findRunRecipients(long)}
   */
  @Test
  void testFindRunRecipients() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    HashSet<AttestationRunRecipient> attestationRunRecipientSet = new HashSet<>();
    when(attestationRunDao.findRunRecipients(anyLong())).thenReturn(attestationRunRecipientSet);
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act
    Set<AttestationRunRecipient> actualFindRunRecipientsResult = (new AttestationRunService(attestationInstanceDao,
        attestationInstanceRecipientDao, attestationRunDao, entityReferenceNameResolver, involvementDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).findRunRecipients(1L);

    // Assert
    verify(attestationRunDao).findRunRecipients(eq(1L));
    assertTrue(actualFindRunRecipientsResult.isEmpty());
    assertSame(attestationRunRecipientSet, actualFindRunRecipientsResult);
  }

  /**
   * Method under test: {@link AttestationRunService#findRunRecipients(long)}
   */
  @Test
  void testFindRunRecipients2() {
    // Arrange
    AttestationRunDao attestationRunDao = mock(AttestationRunDao.class);
    when(attestationRunDao.findRunRecipients(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    AttestationInstanceDao attestationInstanceDao = mock(AttestationInstanceDao.class);
    AttestationInstanceRecipientDao attestationInstanceRecipientDao = mock(AttestationInstanceRecipientDao.class);
    EntityReferenceNameResolver entityReferenceNameResolver = mock(EntityReferenceNameResolver.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new AttestationRunService(attestationInstanceDao, attestationInstanceRecipientDao, attestationRunDao,
            entityReferenceNameResolver, involvementDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
                .findRunRecipients(1L));
    verify(attestationRunDao).findRunRecipients(eq(1L));
  }
}
