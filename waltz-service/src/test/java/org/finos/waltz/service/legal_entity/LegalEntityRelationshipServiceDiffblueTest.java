package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipView;
import org.finos.waltz.model.legal_entity.LegalEntityRelationship;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipAssessmentInfo;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipView;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipServiceDiffblueTest {
  /**
   * Method under test: {@link LegalEntityRelationshipService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.getById(Mockito.<Long>any())).thenReturn(null);

    // Act
    LegalEntityRelationship actualById = (new LegalEntityRelationshipService(legalEntityRelationshipDao)).getById(1L);

    // Assert
    verify(legalEntityRelationshipDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#findByLegalEntityId(long)}
   */
  @Test
  void testFindByLegalEntityId() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    when(legalEntityRelationshipDao.findByLegalEntityId(Mockito.<Long>any())).thenReturn(legalEntityRelationshipSet);

    // Act
    Set<LegalEntityRelationship> actualFindByLegalEntityIdResult = (new LegalEntityRelationshipService(
        legalEntityRelationshipDao)).findByLegalEntityId(1L);

    // Assert
    verify(legalEntityRelationshipDao).findByLegalEntityId(eq(1L));
    assertTrue(actualFindByLegalEntityIdResult.isEmpty());
    assertSame(legalEntityRelationshipSet, actualFindByLegalEntityIdResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#findByEntityReference(EntityReference)}
   */
  @Test
  void testFindByEntityReference() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    when(legalEntityRelationshipDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(legalEntityRelationshipSet);

    // Act
    Set<LegalEntityRelationship> actualFindByEntityReferenceResult = (new LegalEntityRelationshipService(
        legalEntityRelationshipDao)).findByEntityReference(null);

    // Assert
    verify(legalEntityRelationshipDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
    assertSame(legalEntityRelationshipSet, actualFindByEntityReferenceResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#findByRelationshipKindId(long)}
   */
  @Test
  void testFindByRelationshipKindId() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    when(legalEntityRelationshipDao.findByRelationshipKind(Mockito.<DSLContext>any(), anyLong()))
        .thenReturn(legalEntityRelationshipSet);

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindIdResult = (new LegalEntityRelationshipService(
        legalEntityRelationshipDao)).findByRelationshipKindId(1L);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKind(isNull(), eq(1L));
    assertTrue(actualFindByRelationshipKindIdResult.isEmpty());
    assertSame(legalEntityRelationshipSet, actualFindByRelationshipKindIdResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#findByRelationshipKindId(DSLContext, long)}
   */
  @Test
  void testFindByRelationshipKindId2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    when(legalEntityRelationshipDao.findByRelationshipKind(Mockito.<DSLContext>any(), anyLong()))
        .thenReturn(legalEntityRelationshipSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindIdResult = legalEntityRelationshipService
        .findByRelationshipKindId(new DefaultDSLContext(SQLDialect.SQL99), 1L);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKind(isA(DSLContext.class), eq(1L));
    assertTrue(actualFindByRelationshipKindIdResult.isEmpty());
    assertSame(legalEntityRelationshipSet, actualFindByRelationshipKindIdResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  void testBulkAdd() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkAddResult = legalEntityRelationshipService.bulkAdd(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  void testBulkAdd2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToAdd = new HashSet<>();
    relationshipsToAdd.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkAddResult = legalEntityRelationshipService.bulkAdd(tx, relationshipsToAdd, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  void testBulkAdd3() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToAdd = new HashSet<>();
    relationshipsToAdd.add(mock(LegalEntityRelationship.class));
    relationshipsToAdd.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkAddResult = legalEntityRelationshipService.bulkAdd(tx, relationshipsToAdd, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}
   */
  @Test
  void testBulkUpdate() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkUpdateResult = legalEntityRelationshipService.bulkUpdate(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}
   */
  @Test
  void testBulkUpdate2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToUpdate = new HashSet<>();
    relationshipsToUpdate.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkUpdateResult = legalEntityRelationshipService.bulkUpdate(tx, relationshipsToUpdate, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}
   */
  @Test
  void testBulkUpdate3() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToUpdate = new HashSet<>();
    relationshipsToUpdate.add(mock(LegalEntityRelationship.class));
    relationshipsToUpdate.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkUpdateResult = legalEntityRelationshipService.bulkUpdate(tx, relationshipsToUpdate, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}
   */
  @Test
  void testBulkRemove() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipService.bulkRemove(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}
   */
  @Test
  void testBulkRemove2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();
    relationships.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipService.bulkRemove(tx, relationships, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}
   */
  @Test
  void testBulkRemove3() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();
    relationships.add(mock(LegalEntityRelationship.class));
    relationships.add(mock(LegalEntityRelationship.class));

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipService.bulkRemove(tx, relationships, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(selectionOptions.filters()).thenReturn(selectionFilters);
    when(selectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference, atLeast(1)).kind();
    verify(selectionOptions).entityLifecycleStatuses();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult = actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector2() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship.entityReference()).thenReturn(entityReference);

    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    legalEntityRelationshipSet.add(legalEntityRelationship);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.definitionRef()).thenReturn(entityReference2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo2 = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo2.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.definitionRef()).thenReturn(entityReference3);

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet = new HashSet<>();
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo2);
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo);
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.id()).thenReturn(1L);
    when(entityReference4.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference4);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference2).id();
    verify(entityReference4).id();
    verify(entityReference4).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    verify(legalEntityRelationship).entityReference();
    verify(legalEntityRelationshipAssessmentInfo2, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo2).ratingId();
    verify(legalEntityRelationshipAssessmentInfo).ratingId();
    verify(legalEntityRelationshipAssessmentInfo2).relationshipId();
    verify(legalEntityRelationshipAssessmentInfo).relationshipId();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
    assertEquals(2, actualViewByRelKindAndSelector.assessmentHeaders().size());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector3() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(2L);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship.entityReference()).thenReturn(entityReference);

    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    legalEntityRelationshipSet.add(legalEntityRelationship);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.definitionRef()).thenReturn(entityReference2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo2 = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo2.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.definitionRef()).thenReturn(entityReference3);

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet = new HashSet<>();
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo2);
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo);
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.id()).thenReturn(1L);
    when(entityReference4.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference4);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference2).id();
    verify(entityReference4).id();
    verify(entityReference4).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    verify(legalEntityRelationship).entityReference();
    verify(legalEntityRelationshipAssessmentInfo2, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo2).ratingId();
    verify(legalEntityRelationshipAssessmentInfo).ratingId();
    verify(legalEntityRelationshipAssessmentInfo2).relationshipId();
    verify(legalEntityRelationshipAssessmentInfo).relationshipId();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
    assertEquals(2, actualViewByRelKindAndSelector.assessmentHeaders().size());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector4() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship.entityReference()).thenReturn(entityReference);

    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    legalEntityRelationshipSet.add(legalEntityRelationship);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.definitionRef()).thenReturn(entityReference2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(2L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo2 = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo2.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.definitionRef()).thenReturn(entityReference3);

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet = new HashSet<>();
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo2);
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo);
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.id()).thenReturn(1L);
    when(entityReference4.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference4);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference2).id();
    verify(entityReference4).id();
    verify(entityReference4).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    verify(legalEntityRelationship).entityReference();
    verify(legalEntityRelationshipAssessmentInfo2, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo2).ratingId();
    verify(legalEntityRelationshipAssessmentInfo).ratingId();
    verify(legalEntityRelationshipAssessmentInfo2).relationshipId();
    verify(legalEntityRelationshipAssessmentInfo).relationshipId();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
    assertEquals(2, actualViewByRelKindAndSelector.assessmentHeaders().size());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector5() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship.entityReference()).thenReturn(entityReference);

    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    legalEntityRelationshipSet.add(legalEntityRelationship);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.definitionRef()).thenReturn(entityReference2);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo2 = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo2.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.definitionRef()).thenReturn(entityReference3);

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet = new HashSet<>();
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo2);
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo);
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.id()).thenReturn(1L);
    when(entityReference4.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference4);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference).id();
    verify(entityReference3).id();
    verify(entityReference2).id();
    verify(entityReference4).id();
    verify(entityReference4, atLeast(1)).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    verify(legalEntityRelationship).entityReference();
    verify(legalEntityRelationshipAssessmentInfo2, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo2).ratingId();
    verify(legalEntityRelationshipAssessmentInfo).ratingId();
    verify(legalEntityRelationshipAssessmentInfo2).relationshipId();
    verify(legalEntityRelationshipAssessmentInfo).relationshipId();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
    assertEquals(2, actualViewByRelKindAndSelector.assessmentHeaders().size());
  }

  /**
   * Method under test:
   * {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long, IdSelectionOptions)}
   */
  @Test
  void testGetViewByRelKindAndSelector6() {
    // Arrange
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(2L);
    LegalEntityRelationship legalEntityRelationship = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship.entityReference()).thenReturn(entityReference);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.id()).thenReturn(1L);
    LegalEntityRelationship legalEntityRelationship2 = mock(LegalEntityRelationship.class);
    when(legalEntityRelationship2.entityReference()).thenReturn(entityReference2);

    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();
    legalEntityRelationshipSet.add(legalEntityRelationship2);
    legalEntityRelationshipSet.add(legalEntityRelationship);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo.definitionRef()).thenReturn(entityReference3);
    EntityReference entityReference4 = mock(EntityReference.class);
    when(entityReference4.id()).thenReturn(1L);
    LegalEntityRelationshipAssessmentInfo legalEntityRelationshipAssessmentInfo2 = mock(
        LegalEntityRelationshipAssessmentInfo.class);
    when(legalEntityRelationshipAssessmentInfo2.ratingId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.relationshipId()).thenReturn(1L);
    when(legalEntityRelationshipAssessmentInfo2.definitionRef()).thenReturn(entityReference4);

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet = new HashSet<>();
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo2);
    legalEntityRelationshipAssessmentInfoSet.add(legalEntityRelationshipAssessmentInfo);
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(Mockito.<Long>any(),
        Mockito.<Select<Record1<Long>>>any())).thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService = new LegalEntityRelationshipService(
        legalEntityRelationshipDao);
    EntityReference entityReference5 = mock(EntityReference.class);
    when(entityReference5.id()).thenReturn(1L);
    when(entityReference5.kind()).thenReturn(EntityKind.ACTOR);
    IdSelectionOptions selectionOptions = mock(IdSelectionOptions.class);
    when(selectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(selectionOptions.entityReference()).thenReturn(entityReference5);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector = legalEntityRelationshipService
        .getViewByRelKindAndSelector(1L, selectionOptions);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    verify(entityReference2).id();
    verify(entityReference).id();
    verify(entityReference4).id();
    verify(entityReference3).id();
    verify(entityReference5).id();
    verify(entityReference5).kind();
    verify(selectionOptions, atLeast(1)).entityReference();
    verify(selectionOptions).scope();
    verify(legalEntityRelationship2).entityReference();
    verify(legalEntityRelationship).entityReference();
    verify(legalEntityRelationshipAssessmentInfo2, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo, atLeast(1)).definitionRef();
    verify(legalEntityRelationshipAssessmentInfo2).ratingId();
    verify(legalEntityRelationshipAssessmentInfo).ratingId();
    verify(legalEntityRelationshipAssessmentInfo2).relationshipId();
    verify(legalEntityRelationshipAssessmentInfo).relationshipId();
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(2, actualViewByRelKindAndSelector.assessmentHeaders().size());
    assertEquals(2, actualViewByRelKindAndSelector.rows().size());
  }
}
