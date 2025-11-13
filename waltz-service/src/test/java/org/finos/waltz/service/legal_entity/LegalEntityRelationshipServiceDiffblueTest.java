package org.finos.waltz.service.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.legal_entity.LegalEntityRelationshipDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationship;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipAssessmentInfo;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipView;
import org.finos.waltz.model.legal_entity.LegalEntityRelationship;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipAssessmentInfo;
import org.finos.waltz.model.legal_entity.LegalEntityRelationshipView;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LegalEntityRelationshipServiceDiffblueTest {
  /**
   * Test {@link LegalEntityRelationshipService#getById(long)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LegalEntityRelationship LegalEntityRelationshipService.getById(long)"})
  void testGetById() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    when(legalEntityRelationshipDao.getById(Mockito.<Long>any()))
        .thenReturn(
            relationshipKindIdResult
                .targetEntityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    // Act
    LegalEntityRelationship actualById =
        new LegalEntityRelationshipService(legalEntityRelationshipDao).getById(1L);

    // Assert
    verify(legalEntityRelationshipDao).getById(1L);
    EntityReference legalEntityReferenceResult = actualById.legalEntityReference();
    assertTrue(legalEntityReferenceResult instanceof ImmutableEntityReference);
    EntityReference targetEntityReferenceResult = actualById.targetEntityReference();
    assertTrue(targetEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualById instanceof ImmutableLegalEntityRelationship);
    assertEquals("2020-03-01", actualById.lastUpdatedBy());
    assertEquals("Provenance", actualById.provenance());
    assertEquals(
        "The characteristics of someone or something", legalEntityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.relationshipKindId().longValue());
    assertEquals(1L, legalEntityReferenceResult.id());
    assertEquals(EntityKind.ALL, legalEntityReferenceResult.kind());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, legalEntityReferenceResult.entityLifecycleStatus());
    assertFalse(actualById.isReadOnly());
    assertEquals(legalEntityReferenceResult, targetEntityReferenceResult);
    assertSame(ofResult, actualById.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link LegalEntityRelationshipService#findByLegalEntityId(long)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#findByLegalEntityId(long)}
   */
  @Test
  @DisplayName("Test findByLegalEntityId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipService.findByLegalEntityId(long)"})
  void testFindByLegalEntityId() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByLegalEntityId(Mockito.<Long>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<LegalEntityRelationship> actualFindByLegalEntityIdResult =
        new LegalEntityRelationshipService(legalEntityRelationshipDao).findByLegalEntityId(1L);

    // Assert
    verify(legalEntityRelationshipDao).findByLegalEntityId(1L);
    assertTrue(actualFindByLegalEntityIdResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipService#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipService#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipService.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByEntityReference(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());

    // Act
    Set<LegalEntityRelationship> actualFindByEntityReferenceResult =
        new LegalEntityRelationshipService(legalEntityRelationshipDao).findByEntityReference(null);

    // Assert
    verify(legalEntityRelationshipDao).findByEntityReference(isNull());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipService#findByRelationshipKindId(long)} with {@code
   * relationshipKindId}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#findByRelationshipKindId(long)}
   */
  @Test
  @DisplayName("Test findByRelationshipKindId(long) with 'relationshipKindId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipService.findByRelationshipKindId(long)"})
  void testFindByRelationshipKindIdWithRelationshipKindId() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKind(Mockito.<DSLContext>any(), anyLong()))
        .thenReturn(new HashSet<>());

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindIdResult =
        new LegalEntityRelationshipService(legalEntityRelationshipDao).findByRelationshipKindId(1L);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKind(isNull(), eq(1L));
    assertTrue(actualFindByRelationshipKindIdResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipService#findByRelationshipKindId(DSLContext, long)} with
   * {@code tx}, {@code relKindId}.
   *
   * <p>Method under test: {@link
   * LegalEntityRelationshipService#findByRelationshipKindId(DSLContext, long)}
   */
  @Test
  @DisplayName("Test findByRelationshipKindId(DSLContext, long) with 'tx', 'relKindId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set LegalEntityRelationshipService.findByRelationshipKindId(DSLContext, long)"
  })
  void testFindByRelationshipKindIdWithTxRelKindId() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKind(Mockito.<DSLContext>any(), anyLong()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindIdResult =
        legalEntityRelationshipService.findByRelationshipKindId(
            new DefaultDSLContext(SQLDialect.SQL99), 1L);

    // Assert
    verify(legalEntityRelationshipDao).findByRelationshipKind(isA(DSLContext.class), eq(1L));
    assertTrue(actualFindByRelationshipKindIdResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  @DisplayName("Test bulkAdd(DSLContext, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkAdd(DSLContext, Set, String)"})
  void testBulkAdd() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToAdd = new HashSet<>();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    relationshipsToAdd.add(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    int actualBulkAddResult =
        legalEntityRelationshipService.bulkAdd(tx, relationshipsToAdd, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  @DisplayName("Test bulkAdd(DSLContext, Set, String); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkAdd(DSLContext, Set, String)"})
  void testBulkAdd_whenHashSet() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkAddResult =
        legalEntityRelationshipService.bulkAdd(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkAdd(DSLContext, Set, String)}
   */
  @Test
  @DisplayName("Test bulkAdd(DSLContext, Set, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkAdd(DSLContext, Set, String)"})
  void testBulkAdd_whenNull() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkAdd(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    // Act
    int actualBulkAddResult =
        legalEntityRelationshipService.bulkAdd(
            new DefaultDSLContext(SQLDialect.SQL99), null, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkAdd(isA(DSLContext.class), isNull());
    assertEquals(1, actualBulkAddResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkUpdate(DSLContext, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkUpdate(DSLContext, Set, String)"})
  void testBulkUpdate() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationshipsToUpdate = new HashSet<>();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    relationshipsToUpdate.add(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    int actualBulkUpdateResult =
        legalEntityRelationshipService.bulkUpdate(tx, relationshipsToUpdate, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkUpdate(DSLContext, Set, String); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkUpdate(DSLContext, Set, String)"})
  void testBulkUpdate_whenHashSet() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkUpdateResult =
        legalEntityRelationshipService.bulkUpdate(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkUpdate(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkUpdate(DSLContext, Set, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkUpdate(DSLContext, Set, String)"})
  void testBulkUpdate_whenNull() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkUpdate(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    // Act
    int actualBulkUpdateResult =
        legalEntityRelationshipService.bulkUpdate(
            new DefaultDSLContext(SQLDialect.SQL99), null, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkUpdate(isA(DSLContext.class), isNull());
    assertEquals(1, actualBulkUpdateResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkRemove(DSLContext, Set, String)"})
  void testBulkRemove() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    relationships.add(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    // Act
    int actualBulkRemoveResult =
        legalEntityRelationshipService.bulkRemove(tx, relationships, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set, String); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkRemove(DSLContext, Set, String)"})
  void testBulkRemove_whenHashSet() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act
    int actualBulkRemoveResult =
        legalEntityRelationshipService.bulkRemove(tx, new HashSet<>(), "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isA(Set.class));
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#bulkRemove(DSLContext, Set,
   * String)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set, String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipService.bulkRemove(DSLContext, Set, String)"})
  void testBulkRemove_whenNull() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.bulkRemove(
            Mockito.<DSLContext>any(), Mockito.<Set<LegalEntityRelationship>>any()))
        .thenReturn(1);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    // Act
    int actualBulkRemoveResult =
        legalEntityRelationshipService.bulkRemove(
            new DefaultDSLContext(SQLDialect.SQL99), null, "janedoe");

    // Assert
    verify(legalEntityRelationshipDao).bulkRemove(isA(DSLContext.class), isNull());
    assertEquals(1, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector2() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APPLICATION)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector3() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.APP_GROUP)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code ACTIVE}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions); given 'ACTIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_givenActive() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code IN_HOUSE}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions); given 'IN_HOUSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_givenInHouse() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();
    builderResult.addOmitApplicationKinds(ApplicationKind.IN_HOUSE);
    ImmutableSelectionFilters filters = builderResult.build();

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(filters);
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Given {@code PENDING}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions); given 'PENDING'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_givenPending() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.PENDING);
    builderResult.addEntityLifecycleStatuses(EntityLifecycleStatus.ACTIVE);

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return assessmentHeaders size is one.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewByRelKindAndSelector(long, IdSelectionOptions); then return assessmentHeaders size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_thenReturnAssessmentHeadersSizeIsOne() {
    // Arrange
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    legalEntityRelationshipSet.add(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet =
        new HashSet<>();

    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult =
        ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    legalEntityRelationshipAssessmentInfoSet.add(
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build());

    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.assessmentHeaders().size());
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return rows Empty.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test getViewByRelKindAndSelector(long, IdSelectionOptions); then return rows Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_thenReturnRowsEmpty() {
    // Arrange
    HashSet<LegalEntityRelationshipAssessmentInfo> legalEntityRelationshipAssessmentInfoSet =
        new HashSet<>();

    ImmutableLegalEntityRelationshipAssessmentInfo.Builder builderResult =
        ImmutableLegalEntityRelationshipAssessmentInfo.builder();
    legalEntityRelationshipAssessmentInfoSet.add(
        builderResult
            .definitionRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .ratingId(1L)
            .relationshipId(1L)
            .build());

    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipAssessmentInfoSet);
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.assessmentHeaders().size());
    assertTrue(actualViewByRelKindAndSelector.rows().isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return rows is assessmentHeaders.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewByRelKindAndSelector(long, IdSelectionOptions); then return rows is assessmentHeaders")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_thenReturnRowsIsAssessmentHeaders() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    Set<EntityReference> assessmentHeadersResult =
        actualViewByRelKindAndSelector.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualViewByRelKindAndSelector.rows());
  }

  /**
   * Test {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}.
   *
   * <ul>
   *   <li>Then return rows size is one.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipService#getViewByRelKindAndSelector(long,
   * IdSelectionOptions)}
   */
  @Test
  @DisplayName(
      "Test getViewByRelKindAndSelector(long, IdSelectionOptions); then return rows size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "LegalEntityRelationshipView LegalEntityRelationshipService.getViewByRelKindAndSelector(long, IdSelectionOptions)"
  })
  void testGetViewByRelKindAndSelector_thenReturnRowsSizeIsOne() {
    // Arrange
    HashSet<LegalEntityRelationship> legalEntityRelationshipSet = new HashSet<>();

    ImmutableLegalEntityRelationship.Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    ImmutableLegalEntityRelationship.Builder relationshipKindIdResult =
        lastUpdatedByResult
            .legalEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .provenance("Provenance")
            .relationshipKindId(1L);
    legalEntityRelationshipSet.add(
        relationshipKindIdResult
            .targetEntityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());

    LegalEntityRelationshipDao legalEntityRelationshipDao = mock(LegalEntityRelationshipDao.class);
    when(legalEntityRelationshipDao.findByRelationshipKindAndTargetSelector(
            Mockito.<Long>any(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(legalEntityRelationshipSet);
    when(legalEntityRelationshipDao.getViewAssessmentsByRelKind(
            anyLong(), Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new HashSet<>());
    LegalEntityRelationshipService legalEntityRelationshipService =
        new LegalEntityRelationshipService(legalEntityRelationshipDao);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);

    // Act
    LegalEntityRelationshipView actualViewByRelKindAndSelector =
        legalEntityRelationshipService.getViewByRelKindAndSelector(
            1L,
            joiningEntityKindResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .scope(HierarchyQueryScope.EXACT)
                .build());

    // Assert
    verify(legalEntityRelationshipDao)
        .findByRelationshipKindAndTargetSelector(eq(1L), isA(Select.class));
    verify(legalEntityRelationshipDao).getViewAssessmentsByRelKind(eq(1L), isA(Select.class));
    assertTrue(actualViewByRelKindAndSelector instanceof ImmutableLegalEntityRelationshipView);
    assertEquals(1, actualViewByRelKindAndSelector.rows().size());
    assertTrue(actualViewByRelKindAndSelector.assessmentHeaders().isEmpty());
  }
}
