package org.finos.waltz.data.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationship;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationship.Builder;
import org.finos.waltz.model.legal_entity.LegalEntityRelationship;
import org.finos.waltz.schema.tables.records.LegalEntityRelationshipRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Query;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LegalEntityRelationshipDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private LegalEntityRelationshipDao legalEntityRelationshipDao;

  /**
   * Test {@link LegalEntityRelationshipDao#findByLegalEntityId(Long)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#findByLegalEntityId(Long)}
   */
  @Test
  @DisplayName("Test findByLegalEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipDao.findByLegalEntityId(Long)"})
  void testFindByLegalEntityId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Set<LegalEntityRelationship> actualFindByLegalEntityIdResult =
        legalEntityRelationshipDao.findByLegalEntityId(1L);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByLegalEntityIdResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Set<LegalEntityRelationship> actualFindByEntityReferenceResult =
        legalEntityRelationshipDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipDao#findByEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Set<LegalEntityRelationship> actualFindByEntityReferenceResult =
        legalEntityRelationshipDao.findByEntityReference(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipDao#findByRelationshipKind(DSLContext, long)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#renderInlined(QueryPart)}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#findByRelationshipKind(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test findByRelationshipKind(DSLContext, long); then calls renderInlined(QueryPart)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipDao.findByRelationshipKind(DSLContext, long)"})
  void testFindByRelationshipKind_thenCallsRenderInlined() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindResult =
        legalEntityRelationshipDao.findByRelationshipKind(dSLContext, 1L);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByRelationshipKindResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipDao#findByRelationshipKind(DSLContext, long)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#renderInlined(QueryPart)}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#findByRelationshipKind(DSLContext,
   * long)}
   */
  @Test
  @DisplayName("Test findByRelationshipKind(DSLContext, long); then calls renderInlined(QueryPart)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set LegalEntityRelationshipDao.findByRelationshipKind(DSLContext, long)"})
  void testFindByRelationshipKind_thenCallsRenderInlined2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");

    // Act
    Set<LegalEntityRelationship> actualFindByRelationshipKindResult =
        new LegalEntityRelationshipDao(dsl).findByRelationshipKind(null, 1L);

    // Assert
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where("Render Inlined");
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindByRelationshipKindResult.isEmpty());
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkAdd(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkAdd(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test bulkAdd(DSLContext, Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkAdd(DSLContext, Set)"})
  void testBulkAdd_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao =
        new LegalEntityRelationshipDao(new DefaultDSLContext(SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkAdd(tx, new HashSet<>()));
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkUpdate(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkUpdate(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test bulkUpdate(DSLContext, Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkUpdate(DSLContext, Set)"})
  void testBulkUpdate_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao =
        new LegalEntityRelationshipDao(new DefaultDSLContext(SQLDialect.SQL99));
    DefaultDSLContext tx = new DefaultDSLContext(SQLDialect.SQL99);

    // Act and Assert
    assertEquals(0, legalEntityRelationshipDao.bulkUpdate(tx, new HashSet<>()));
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}.
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkRemove(DSLContext, Set)"})
  void testBulkRemove() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DeleteUsingStep<LegalEntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));
    when(dSLContext.deleteFrom(Mockito.<Table<LegalEntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
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

    Builder lastUpdatedByResult2 =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult2 =
        lastUpdatedByResult2
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
        relationshipKindIdResult2
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
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(dSLContext, relationships);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext, atLeast(1)).deleteFrom(isA(Table.class));
    verify(deleteUsingStep, atLeast(1)).where(Mockito.<Condition>any());
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(DSLContext, Set); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkRemove(DSLContext, Set)"})
  void testBulkRemove_givenDefaultDSLContextWithDialectIsSql99_thenCallsCreateStatement()
      throws SQLException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao =
        new LegalEntityRelationshipDao(new DefaultDSLContext(SQLDialect.SQL99));

    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  @DisplayName(
      "Test bulkRemove(DSLContext, Set); given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkRemove(DSLContext, Set)"})
  void testBulkRemove_givenStatementAddBatchDoesNothing_thenCallsAddBatch() throws SQLException {
    // Arrange
    LegalEntityRelationshipDao legalEntityRelationshipDao =
        new LegalEntityRelationshipDao(new DefaultDSLContext(SQLDialect.SQL99));

    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext tx = new DefaultDSLContext(connection, SQLDialect.SQL99);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
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
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(tx, relationships);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "delete from \"legal_entity_relationship\" where \"legal_entity_relationship\".\"id\" = 1");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkRemove(DSLContext, Set)"})
  void testBulkRemove_thenCallsDeleteFrom() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DeleteUsingStep<LegalEntityRelationshipRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenReturn(mock(DeleteConditionStep.class));
    when(dSLContext.deleteFrom(Mockito.<Table<LegalEntityRelationshipRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    HashSet<LegalEntityRelationship> relationships = new HashSet<>();

    Builder lastUpdatedByResult =
        ImmutableLegalEntityRelationship.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01");

    Builder relationshipKindIdResult =
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
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(dSLContext, relationships);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    assertEquals(0, actualBulkRemoveResult);
  }

  /**
   * Test {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link LegalEntityRelationshipDao#bulkRemove(DSLContext, Set)}
   */
  @Test
  @DisplayName("Test bulkRemove(DSLContext, Set); when HashSet(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LegalEntityRelationshipDao.bulkRemove(DSLContext, Set)"})
  void testBulkRemove_whenHashSet_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);

    // Act
    int actualBulkRemoveResult = legalEntityRelationshipDao.bulkRemove(dSLContext, new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch(isA(Collection.class));
    assertEquals(0, actualBulkRemoveResult);
  }
}
