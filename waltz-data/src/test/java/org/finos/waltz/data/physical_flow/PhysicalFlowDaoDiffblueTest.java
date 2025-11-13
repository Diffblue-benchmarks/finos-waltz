package org.finos.waltz.data.physical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FreshnessIndicator;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.finos.waltz.model.physical_flow.FrequencyKindValue;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlow.Builder;
import org.finos.waltz.model.physical_flow.ImmutablePhysicalFlowParsed;
import org.finos.waltz.model.physical_flow.PhysicalFlow;
import org.finos.waltz.model.physical_flow.PhysicalFlowInfo;
import org.finos.waltz.model.physical_flow.PhysicalFlowParsed;
import org.finos.waltz.model.physical_flow.TransportKindValue;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.schema.tables.records.PhysicalFlowRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
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
class PhysicalFlowDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PhysicalFlowDao physicalFlowDao;

  /**
   * Test {@link PhysicalFlowDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenCallsId() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);
    when(selectOnConditionStep2.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<PhysicalFlow> actualFindByEntityReferenceResult =
        physicalFlowDao.findByEntityReference(ref);

    // Assert
    verify(ref, atLeast(1)).id();
    verify(ref, atLeast(1)).kind();
    verify(dsl, atLeast(1)).renderInlined(Mockito.<QueryPart>any());
    verify(dsl, atLeast(1)).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnStep2, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep2).where("Render Inlined");
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#renderInlined(QueryPart)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then calls renderInlined(QueryPart)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenCallsRenderInlined() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);
    when(selectOnConditionStep2.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    List<PhysicalFlow> actualFindByEntityReferenceResult =
        physicalFlowDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(selectOrderByStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnStep2, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep2).where("Render Inlined");
    verify(selectOnConditionStep).where("Render Inlined");
    verify(dsl, atLeast(1)).renderInlined(Mockito.<QueryPart>any());
    verify(dsl, atLeast(1)).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByProducer(EntityReference)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByProducer(EntityReference)}
   */
  @Test
  @DisplayName("Test findByProducer(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByProducer(EntityReference)"})
  void testFindByProducer() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act
    List<PhysicalFlow> actualFindByProducerResult =
        physicalFlowDao.findByProducer(
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
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByProducerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByProducer(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao#PhysicalFlowDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByProducer(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByProducer(EntityReference); given PhysicalFlowDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByProducer(EntityReference)"})
  void testFindByProducer_givenPhysicalFlowDaoWithDslIsDSLContext() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    List<PhysicalFlow> actualFindByProducerResult =
        physicalFlowDao.findByProducer(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByProducerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByExternalId(String)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByExternalId(String)}
   */
  @Test
  @DisplayName("Test findByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByExternalId(String)"})
  void testFindByExternalId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<PhysicalFlow> actualFindByExternalIdResult =
        new PhysicalFlowDao(dsl).findByExternalId("42");

    // Assert
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByExternalIdResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByConsumer(EntityReference)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByConsumer(EntityReference)}
   */
  @Test
  @DisplayName("Test findByConsumer(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByConsumer(EntityReference)"})
  void testFindByConsumer() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    // Act
    List<PhysicalFlow> actualFindByConsumerResult =
        physicalFlowDao.findByConsumer(
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
    verify(dSLContext).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByConsumerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByConsumer(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao#PhysicalFlowDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByConsumer(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByConsumer(EntityReference); given PhysicalFlowDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByConsumer(EntityReference)"})
  void testFindByConsumer_givenPhysicalFlowDaoWithDslIsDSLContext() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.selectDistinct((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    List<PhysicalFlow> actualFindByConsumerResult =
        physicalFlowDao.findByConsumer(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).selectDistinct((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByConsumerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByProducerAndConsumer(EntityReference, EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalFlowDao#PhysicalFlowDao(DSLContext)} with dsl is {@link DSLContext}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByProducerAndConsumer(EntityReference,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByProducerAndConsumer(EntityReference, EntityReference); given PhysicalFlowDao(DSLContext) with dsl is DSLContext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalFlowDao.findByProducerAndConsumer(EntityReference, EntityReference)"
  })
  void testFindByProducerAndConsumer_givenPhysicalFlowDaoWithDslIsDSLContext()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);
    ImmutableEntityReference producer =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<PhysicalFlow> actualFindByProducerAndConsumerResult =
        physicalFlowDao.findByProducerAndConsumer(
            producer,
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dsl).renderInlined(isA(QueryPart.class));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByProducerAndConsumerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByProducerAndConsumer(EntityReference, EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByProducerAndConsumer(EntityReference,
   * EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByProducerAndConsumer(EntityReference, EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PhysicalFlowDao.findByProducerAndConsumer(EntityReference, EntityReference)"
  })
  void testFindByProducerAndConsumer_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference producer =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    List<PhysicalFlow> actualFindByProducerAndConsumerResult =
        physicalFlowDao.findByProducerAndConsumer(
            producer,
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
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where("Render Inlined");
    assertTrue(actualFindByProducerAndConsumerResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#getById(long)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    PhysicalFlow actualById = new PhysicalFlowDao(dsl).getById(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertNull(actualById);
  }

  /**
   * Test {@link PhysicalFlowDao#getByIdAndIsRemoved(long, boolean)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#getByIdAndIsRemoved(long, boolean)}
   */
  @Test
  @DisplayName("Test getByIdAndIsRemoved(long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowDao.getByIdAndIsRemoved(long, boolean)"})
  void testGetByIdAndIsRemoved() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    PhysicalFlow actualByIdAndIsRemoved = new PhysicalFlowDao(dsl).getByIdAndIsRemoved(1L, true);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertNull(actualByIdAndIsRemoved);
  }

  /**
   * Test {@link PhysicalFlowDao#findBySpecificationId(long)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findBySpecificationId(long)}
   */
  @Test
  @DisplayName("Test findBySpecificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findBySpecificationId(long)"})
  void testFindBySpecificationId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<PhysicalFlow> actualFindBySpecificationIdResult =
        new PhysicalFlowDao(dsl).findBySpecificationId(1L);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindBySpecificationIdResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test findByAttributesAndSpecification(PhysicalFlow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByAttributesAndSpecification(PhysicalFlow)"})
  void testFindByAttributesAndSpecification() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    List<PhysicalFlow> actualFindByAttributesAndSpecificationResult =
        physicalFlowDao.findByAttributesAndSpecification(
            specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByAttributesAndSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test findByAttributesAndSpecification(PhysicalFlow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByAttributesAndSpecification(PhysicalFlow)"})
  void testFindByAttributesAndSpecification2() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name(null)
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);

    // Act
    List<PhysicalFlow> actualFindByAttributesAndSpecificationResult =
        physicalFlowDao.findByAttributesAndSpecification(
            specificationIdResult.transport(TransportKindValue.of("42")).build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByAttributesAndSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}.
   *
   * <ul>
   *   <li>Then calls {@link PhysicalFlow#basisOffset()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#findByAttributesAndSpecification(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test findByAttributesAndSpecification(PhysicalFlow); then calls basisOffset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalFlowDao.findByAttributesAndSpecification(PhysicalFlow)"})
  void testFindByAttributesAndSpecification_thenCallsBasisOffset() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    PhysicalFlow flow = mock(PhysicalFlow.class);
    when(flow.logicalFlowId()).thenReturn(1L);
    when(flow.transport()).thenReturn(TransportKindValue.of("42"));
    when(flow.basisOffset()).thenReturn(1);
    when(flow.name()).thenReturn("Name");
    when(flow.specificationId()).thenReturn(1L);
    when(flow.frequency()).thenReturn(FrequencyKindValue.of("42"));

    // Act
    List<PhysicalFlow> actualFindByAttributesAndSpecificationResult =
        physicalFlowDao.findByAttributesAndSpecification(flow);

    // Assert
    verify(flow).basisOffset();
    verify(flow).frequency();
    verify(flow).logicalFlowId();
    verify(flow, atLeast(1)).name();
    verify(flow).specificationId();
    verify(flow).transport();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByAttributesAndSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalFlowDao#getByParsedFlow(PhysicalFlowParsed)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePhysicalFlow}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#getByParsedFlow(PhysicalFlowParsed)}
   */
  @Test
  @DisplayName("Test getByParsedFlow(PhysicalFlowParsed); then return ImmutablePhysicalFlow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowDao.getByParsedFlow(PhysicalFlowParsed)"})
  void testGetByParsedFlow_thenReturnImmutablePhysicalFlow() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);
    CriticalityValue criticality = CriticalityValue.of("42");

    Builder externalIdResult =
        createdResult
            .criticality(criticality)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");
    FrequencyKindValue frequency = FrequencyKindValue.of("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(frequency)
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    TransportKindValue transport = TransportKindValue.of("42");
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(specificationIdResult.transport(transport).build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.join(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    ImmutablePhysicalFlowParsed.Builder basisOffsetResult2 =
        ImmutablePhysicalFlowParsed.builder().basisOffset(1);

    ImmutablePhysicalFlowParsed.Builder criticalityResult =
        basisOffsetResult2.criticality(CriticalityValue.of("42"));

    ImmutablePhysicalFlowParsed.Builder externalIdResult2 =
        criticalityResult
            .dataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .description("The characteristics of someone or something")
            .externalId("42");

    ImmutablePhysicalFlowParsed.Builder formatResult =
        externalIdResult2.format(DataFormatKindValue.of("42"));

    ImmutablePhysicalFlowParsed.Builder nameResult =
        formatResult.frequency(FrequencyKindValue.of("42")).name("Name");

    ImmutablePhysicalFlowParsed.Builder ownerResult =
        nameResult.owner(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    ImmutablePhysicalFlowParsed.Builder specExternalIdResult =
        ownerResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .specDescription("Spec Description")
            .specExternalId("42");

    ImmutablePhysicalFlowParsed.Builder targetResult =
        specExternalIdResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    PhysicalFlow actualByParsedFlow =
        physicalFlowDao.getByParsedFlow(
            targetResult.transport(TransportKindValue.of("42")).build());

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).join(isA(TableLike.class));
    verify(selectOnConditionStep3).join(isA(TableLike.class));
    verify(selectOnConditionStep2).join(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualByParsedFlow instanceof ImmutablePhysicalFlow);
    assertEquals("2020-03-01", actualByParsedFlow.lastUpdatedBy());
    assertEquals("Name", actualByParsedFlow.name());
    assertEquals("Provenance", actualByParsedFlow.provenance());
    assertEquals("The characteristics of someone or something", actualByParsedFlow.description());
    assertEquals(1, actualByParsedFlow.basisOffset());
    assertEquals(1L, actualByParsedFlow.logicalFlowId());
    assertEquals(1L, actualByParsedFlow.specificationId());
    assertEquals(EntityKind.ALL, actualByParsedFlow.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualByParsedFlow.entityLifecycleStatus());
    assertEquals(FreshnessIndicator.NEVER_OBSERVED, actualByParsedFlow.freshnessIndicator());
    assertFalse(actualByParsedFlow.isRemoved());
    assertFalse(actualByParsedFlow.isReadOnly());
    assertSame(criticality, actualByParsedFlow.criticality());
    assertSame(frequency, actualByParsedFlow.frequency());
    assertSame(transport, actualByParsedFlow.transport());
  }

  /**
   * Test {@link PhysicalFlowDao#matchPhysicalFlow(PhysicalFlow)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetchOne(RecordMapper)}
   *       return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#matchPhysicalFlow(PhysicalFlow)}
   */
  @Test
  @DisplayName(
      "Test matchPhysicalFlow(PhysicalFlow); given SelectConditionStep fetchOne(RecordMapper) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowDao.matchPhysicalFlow(PhysicalFlow)"})
  void testMatchPhysicalFlow_givenSelectConditionStepFetchOneReturnNull_thenReturnNull()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(null);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectConditionStep<Record> selectConditionStep5 = mock(SelectConditionStep.class);
    when(selectConditionStep5.and(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectConditionStep<Record> selectConditionStep6 = mock(SelectConditionStep.class);
    when(selectConditionStep6.and(Mockito.<Condition>any())).thenReturn(selectConditionStep5);

    SelectConditionStep<Record> selectConditionStep7 = mock(SelectConditionStep.class);
    when(selectConditionStep7.and(Mockito.<Condition>any())).thenReturn(selectConditionStep6);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep7);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    PhysicalFlow flow = mock(PhysicalFlow.class);
    when(flow.criticality()).thenReturn(CriticalityValue.of("42"));
    when(flow.transport()).thenReturn(TransportKindValue.of("42"));
    when(flow.basisOffset()).thenReturn(1);
    when(flow.logicalFlowId()).thenReturn(1L);
    when(flow.specificationId()).thenReturn(1L);
    when(flow.frequency()).thenReturn(FrequencyKindValue.of("42"));
    Optional<Long> ofResult = Optional.of(42L);
    when(flow.id()).thenReturn(ofResult);

    // Act
    PhysicalFlow actualMatchPhysicalFlowResult = physicalFlowDao.matchPhysicalFlow(flow);

    // Assert
    verify(flow, atLeast(1)).id();
    verify(flow).basisOffset();
    verify(flow).criticality();
    verify(flow).frequency();
    verify(flow).logicalFlowId();
    verify(flow).specificationId();
    verify(flow).transport();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep7).and(isA(Condition.class));
    verify(selectConditionStep6).and(isA(Condition.class));
    verify(selectConditionStep5).and(isA(Condition.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertNull(actualMatchPhysicalFlowResult);
  }

  /**
   * Test {@link PhysicalFlowDao#matchPhysicalFlow(PhysicalFlow)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePhysicalFlow}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#matchPhysicalFlow(PhysicalFlow)}
   */
  @Test
  @DisplayName("Test matchPhysicalFlow(PhysicalFlow); then return ImmutablePhysicalFlow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhysicalFlow PhysicalFlowDao.matchPhysicalFlow(PhysicalFlow)"})
  void testMatchPhysicalFlow_thenReturnImmutablePhysicalFlow() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);

    Builder basisOffsetResult = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder createdResult = basisOffsetResult.created(created);

    Builder externalIdResult =
        createdResult
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult =
        externalIdResult
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    when(selectConditionStep.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(specificationIdResult.transport(TransportKindValue.of("42")).build());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectConditionStep<Record> selectConditionStep5 = mock(SelectConditionStep.class);
    when(selectConditionStep5.and(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectConditionStep<Record> selectConditionStep6 = mock(SelectConditionStep.class);
    when(selectConditionStep6.and(Mockito.<Condition>any())).thenReturn(selectConditionStep5);

    SelectConditionStep<Record> selectConditionStep7 = mock(SelectConditionStep.class);
    when(selectConditionStep7.and(Mockito.<Condition>any())).thenReturn(selectConditionStep6);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep7);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    Builder basisOffsetResult2 = ImmutablePhysicalFlow.builder().basisOffset(1);
    ImmutableUserTimestamp immutableUserTimestamp2 =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created2 = Optional.of(immutableUserTimestamp2);

    Builder createdResult2 = basisOffsetResult2.created(created2);

    Builder externalIdResult2 =
        createdResult2
            .criticality(CriticalityValue.of("42"))
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42");

    Builder specificationIdResult2 =
        externalIdResult2
            .frequency(FrequencyKindValue.of("42"))
            .freshnessIndicator(FreshnessIndicator.NEVER_OBSERVED)
            .id(1L)
            .kind(EntityKind.ALL)
            .lastAttestedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastAttestedBy("Last Attested By")
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .logicalFlowId(1L)
            .name("Name")
            .provenance("Provenance")
            .specificationDefinitionId(1L)
            .specificationId(1L);
    ImmutablePhysicalFlow flow =
        specificationIdResult2.transport(TransportKindValue.of("42")).build();

    // Act
    PhysicalFlow actualMatchPhysicalFlowResult = physicalFlowDao.matchPhysicalFlow(flow);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep7).and(isA(Condition.class));
    verify(selectConditionStep6).and(isA(Condition.class));
    verify(selectConditionStep5).and(isA(Condition.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualMatchPhysicalFlowResult instanceof ImmutablePhysicalFlow);
    assertEquals(flow, actualMatchPhysicalFlowResult);
  }

  /**
   * Test {@link PhysicalFlowDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualDeleteResult = new PhysicalFlowDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"is_removed\" = cast(? as bit(1)), \"physical_flow\".\"entity_lifecycle_status\" = cast(? as varchar) where (\"physical_flow\".\"id\" = cast(? as bigint) and \"physical_flow\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement).setString(2, "REMOVED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalFlowDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.delete(long)"})
  void testDelete_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualDeleteResult = new PhysicalFlowDao(dsl).delete(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"is_removed\" = ?, \"physical_flow\".\"entity_lifecycle_status\" = ? where (\"physical_flow\".\"id\" = ? and \"physical_flow\".\"is_readonly\" = false)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(1, true);
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement).setString(2, "REMOVED");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalFlowDao#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.delete(long)"})
  void testDelete_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualDeleteResult = new PhysicalFlowDao(dsl).delete(1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinition(String, long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateSpecDefinition(String, long, long)"})
  void testUpdateSpecDefinition_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateSpecDefinitionResult =
        new PhysicalFlowDao(dsl).updateSpecDefinition("janedoe", 1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"specification_definition_id\" = cast(? as bigint), \"physical_flow\".\"last_updated_by\" = cast(? as varchar), \"physical_flow\".\"last_updated_at\" = cast(? as datetime) where (\"physical_flow\".\"id\" = cast(? as bigint) and (\"physical_flow\".\"specification_definition_id\" is null or \"physical_flow\".\"specification_definition_id\" <> cast(? as bigint)))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "janedoe");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinition(String, long, long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateSpecDefinition(String, long, long)"})
  void testUpdateSpecDefinition_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateSpecDefinitionResult =
        new PhysicalFlowDao(dsl).updateSpecDefinition("janedoe", 1L, 1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"specification_definition_id\" = ?, \"physical_flow\".\"last_updated_by\" = ?, \"physical_flow\".\"last_updated_at\" = ? where (\"physical_flow\".\"id\" = ? and (\"physical_flow\".\"specification_definition_id\" is null or \"physical_flow\".\"specification_definition_id\" <> ?))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(2, "janedoe");
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateSpecDefinition(String, long, long)}
   */
  @Test
  @DisplayName(
      "Test updateSpecDefinition(String, long, long); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateSpecDefinition(String, long, long)"})
  void testUpdateSpecDefinition_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep3 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateSpecDefinitionResult =
        new PhysicalFlowDao(dsl).updateSpecDefinition("janedoe", 1L, 1L);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#cleanupOrphans()}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.cleanupOrphans()"})
  void testCleanupOrphans() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<Field<Object>>any())).thenReturn(new ArrayList<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);
    when(dSLContext.update(Mockito.<Table<PhysicalFlowRecord>>any()))
        .thenReturn(updateSetFirstStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    int actualCleanupOrphansResult = physicalFlowDao.cleanupOrphans();

    // Assert
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(selectConditionStep).fetch(isA(Field.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualCleanupOrphansResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}
   */
  @Test
  @DisplayName(
      "Test updateCriticality(long, CriticalityValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateCriticality(long, CriticalityValue)"})
  void testUpdateCriticality_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateCriticalityResult =
        physicalFlowDao.updateCriticality(1L, CriticalityValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"criticality\" = cast(? as varchar) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateCriticalityResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}
   */
  @Test
  @DisplayName(
      "Test updateCriticality(long, CriticalityValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateCriticality(long, CriticalityValue)"})
  void testUpdateCriticality_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateCriticalityResult =
        physicalFlowDao.updateCriticality(1L, CriticalityValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"criticality\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateCriticalityResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateCriticality(long, CriticalityValue)}
   */
  @Test
  @DisplayName("Test updateCriticality(long, CriticalityValue); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateCriticality(long, CriticalityValue)"})
  void testUpdateCriticality_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateCriticalityResult =
        physicalFlowDao.updateCriticality(1L, CriticalityValue.of("42"));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateCriticalityResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}
   */
  @Test
  @DisplayName(
      "Test updateFrequency(long, FrequencyKindValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateFrequency(long, FrequencyKindValue)"})
  void testUpdateFrequency_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateFrequencyResult =
        physicalFlowDao.updateFrequency(1L, FrequencyKindValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"frequency\" = cast(? as varchar) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFrequencyResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}
   */
  @Test
  @DisplayName(
      "Test updateFrequency(long, FrequencyKindValue); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateFrequency(long, FrequencyKindValue)"})
  void testUpdateFrequency_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateFrequencyResult =
        physicalFlowDao.updateFrequency(1L, FrequencyKindValue.of("42"));

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"frequency\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateFrequencyResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateFrequency(long, FrequencyKindValue)}
   */
  @Test
  @DisplayName("Test updateFrequency(long, FrequencyKindValue); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateFrequency(long, FrequencyKindValue)"})
  void testUpdateFrequency_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);
    PhysicalFlowDao physicalFlowDao = new PhysicalFlowDao(dsl);

    // Act
    int actualUpdateFrequencyResult =
        physicalFlowDao.updateFrequency(1L, FrequencyKindValue.of("42"));

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateFrequencyResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateExternalIdResult = new PhysicalFlowDao(dsl).updateExternalId(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"external_id\" = cast(? as varchar) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateExternalIdResult = new PhysicalFlowDao(dsl).updateExternalId(1L, "42");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"external_id\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "42");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateExternalId(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateExternalId(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateExternalId(long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateExternalId(long, String)"})
  void testUpdateExternalId_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateExternalIdResult = new PhysicalFlowDao(dsl).updateExternalId(1L, "42");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateExternalIdResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateTransport(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateTransport(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateTransport(long, String)"})
  void testUpdateTransport_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateTransportResult = new PhysicalFlowDao(dsl).updateTransport(1L, "Transport");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"transport\" = cast(? as varchar) where (\"physical_flow\".\"id\" = cast(? as bigint) and exists (select \"enum_value\".\"type\", \"enum_value\".\"key\", \"enum_value\".\"display_name\", \"enum_value\".\"description\", \"enum_value\".\"icon_name\", \"enum_value\".\"position\", \"enum_value\".\"icon_color\" from \"enum_value\" where (\"enum_value\".\"type\" = cast(? as varchar) and \"enum_value\".\"key\" = cast(? as varchar))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateTransportResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateTransport(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateTransport(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateTransport(long, String)"})
  void testUpdateTransport_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualUpdateTransportResult = new PhysicalFlowDao(dsl).updateTransport(1L, "Transport");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"transport\" = cast(? as varchar(9)) where (\"physical_flow\".\"id\" = cast(? as bigint) and exists (select \"enum_value\".\"type\", \"enum_value\".\"key\", \"enum_value\".\"display_name\", \"enum_value\".\"description\", \"enum_value\".\"icon_name\", \"enum_value\".\"position\", \"enum_value\".\"icon_color\" from \"enum_value\" where (\"enum_value\".\"type\" = cast(? as varchar(13)) and \"enum_value\".\"key\" = cast(? as varchar(9)))))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateTransportResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateTransport(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateTransport(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateTransport(long, String)"})
  void testUpdateTransport_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateTransportResult = new PhysicalFlowDao(dsl).updateTransport(1L, "Transport");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"transport\" = ? where (\"physical_flow\".\"id\" = ? and exists (select \"enum_value\".\"type\", \"enum_value\".\"key\", \"enum_value\".\"display_name\", \"enum_value\".\"description\", \"enum_value\".\"icon_name\", \"enum_value\".\"position\", \"enum_value\".\"icon_color\" from \"enum_value\" where (\"enum_value\".\"type\" = ? and \"enum_value\".\"key\" = ?)))");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateTransportResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateTransport(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateTransport(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateTransport(long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateTransport(long, String)"})
  void testUpdateTransport_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep2 = mock(UpdateConditionStep.class);
    when(updateConditionStep2.and(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep2);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateTransportResult = new PhysicalFlowDao(dsl).updateTransport(1L, "Transport");

    // Assert
    verify(dsl).update(isA(Table.class));
    verify(updateConditionStep).execute();
    verify(updateConditionStep2).and(isA(Condition.class));
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    assertEquals(1, actualUpdateTransportResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName(
      "Test updateBasisOffset(long, int); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(1L, 3);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"basis_offset\" = cast(? as int) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 3);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName(
      "Test updateBasisOffset(long, int); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(1L, 3);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"basis_offset\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 3);
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName(
      "Test updateBasisOffset(long, int); given UpdateConditionStep execute() return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_givenUpdateConditionStepExecuteReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(3L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName("Test updateBasisOffset(long, int); when four; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_whenFour_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(4L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName("Test updateBasisOffset(long, int); when one; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_whenOne_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(1L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateBasisOffset(long, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateBasisOffset(long, int)}
   */
  @Test
  @DisplayName("Test updateBasisOffset(long, int); when two; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateBasisOffset(long, int)"})
  void testUpdateBasisOffset_whenTwo_thenReturnThree() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(3);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateBasisOffsetResult = new PhysicalFlowDao(dsl).updateBasisOffset(2L, 3);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(3, actualUpdateBasisOffsetResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateDescription(long, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateDescriptionResult =
        new PhysicalFlowDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"description\" = cast(? as varchar) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateDescription(long, String)"})
  void testUpdateDescription_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateDescriptionResult =
        new PhysicalFlowDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"description\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(2, 1L);
    verify(preparedStatement).setString(1, "The characteristics of someone or something");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateDescription(long, String)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep} {@link UpdateConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateDescription(long, String)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(long, String); given UpdateConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalFlowDao.updateDescription(long, String)"})
  void testUpdateDescription_givenUpdateConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateDescriptionResult =
        new PhysicalFlowDao(dsl)
            .updateDescription(1L, "The characteristics of someone or something");

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test updateEntityLifecycleStatus(long, EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus)"
  })
  void testUpdateEntityLifecycleStatus() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualUpdateEntityLifecycleStatusResult =
        new PhysicalFlowDao(dsl).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"entity_lifecycle_status\" = ?, \"physical_flow\".\"is_removed\" = ? where \"physical_flow\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement).setString(1, "ACTIVE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test updateEntityLifecycleStatus(long, EntityLifecycleStatus)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus)"
  })
  void testUpdateEntityLifecycleStatus2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualUpdateEntityLifecycleStatusResult =
        new PhysicalFlowDao(dsl).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"physical_flow\" set \"physical_flow\".\"entity_lifecycle_status\" = cast(? as varchar), \"physical_flow\".\"is_removed\" = cast(? as bit(1)) where \"physical_flow\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(3, 1L);
    verify(preparedStatement).setString(1, "ACTIVE");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus)}
   */
  @Test
  @DisplayName("Test updateEntityLifecycleStatus(long, EntityLifecycleStatus); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus)"
  })
  void testUpdateEntityLifecycleStatus_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateEntityLifecycleStatusResult =
        new PhysicalFlowDao(dsl).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.ACTIVE);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link PhysicalFlowDao#updateEntityLifecycleStatus(long, EntityLifecycleStatus)}.
   *
   * <ul>
   *   <li>When {@link EntityLifecycleStatus#REMOVED}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#updateEntityLifecycleStatus(long,
   * EntityLifecycleStatus)}
   */
  @Test
  @DisplayName(
      "Test updateEntityLifecycleStatus(long, EntityLifecycleStatus); when REMOVED; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalFlowDao.updateEntityLifecycleStatus(long, EntityLifecycleStatus)"
  })
  void testUpdateEntityLifecycleStatus_whenRemoved_thenReturnOne() throws DataAccessException {
    // Arrange
    UpdateConditionStep<PhysicalFlowRecord> updateConditionStep = mock(UpdateConditionStep.class);
    when(updateConditionStep.execute()).thenReturn(1);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep.where(Mockito.<Condition>any())).thenReturn(updateConditionStep);

    UpdateSetMoreStep<PhysicalFlowRecord> updateSetMoreStep2 = mock(UpdateSetMoreStep.class);
    when(updateSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep);

    UpdateSetFirstStep<PhysicalFlowRecord> updateSetFirstStep = mock(UpdateSetFirstStep.class);
    when(updateSetFirstStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(updateSetMoreStep2);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.update(Mockito.<Table<PhysicalFlowRecord>>any())).thenReturn(updateSetFirstStep);

    // Act
    int actualUpdateEntityLifecycleStatusResult =
        new PhysicalFlowDao(dsl).updateEntityLifecycleStatus(1L, EntityLifecycleStatus.REMOVED);

    // Assert
    verify(updateConditionStep).execute();
    verify(updateSetFirstStep).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(updateSetMoreStep).where(isA(Condition.class));
    verify(dsl).update(isA(Table.class));
    assertEquals(1, actualUpdateEntityLifecycleStatusResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName(
      "Test hasPhysicalFlows(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = cast(? as bigint) and \"physical_flow\".\"is_removed\" = cast(? as bit(1)))) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName("Test hasPhysicalFlows(long); given PreparedStatement getUpdateCount() return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_givenPreparedStatementGetUpdateCountReturnThree() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName("Test hasPhysicalFlows(long); given PreparedStatement getUpdateCount() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_givenPreparedStatementGetUpdateCountReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertFalse(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName(
      "Test hasPhysicalFlows(long); given PreparedStatement getWarnings() return 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_givenPreparedStatementGetWarningsReturnNull_thenReturnTrue()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#fetchCount(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName("Test hasPhysicalFlows(long); then calls fetchCount(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_thenCallsFetchCount() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(dsl).fetchCount(isA(Select.class));
    assertTrue(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#hasPhysicalFlows(long)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#getResultSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalFlowDao#hasPhysicalFlows(long)}
   */
  @Test
  @DisplayName("Test hasPhysicalFlows(long); then calls getResultSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PhysicalFlowDao.hasPhysicalFlows(long)"})
  void testHasPhysicalFlows_thenCallsGetResultSet() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    boolean actualHasPhysicalFlowsResult = new PhysicalFlowDao(dsl).hasPhysicalFlows(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select \"physical_flow\".\"id\" from \"physical_flow\" where (\"physical_flow\".\"logical_flow_id\" = ? and \"physical_flow\".\"is_removed\" = ?)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(2, false);
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertFalse(actualHasPhysicalFlowsResult);
  }

  /**
   * Test {@link PhysicalFlowDao#findUnderlyingPhysicalFlows(Long)}.
   *
   * <p>Method under test: {@link PhysicalFlowDao#findUnderlyingPhysicalFlows(Long)}
   */
  @Test
  @DisplayName("Test findUnderlyingPhysicalFlows(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PhysicalFlowDao.findUnderlyingPhysicalFlows(Long)"})
  void testFindUnderlyingPhysicalFlows() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetchGroups(
            Mockito.<Field<Object>>any(),
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record3<Object, Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record3<Object, Object, Object>> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(
            Mockito
                .<RecordMapper<
                        Record14<
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object,
                            Object>,
                        Object>>
                    any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep5 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinPartitionByStep2 = mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep5);

    SelectOnConditionStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep6 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep6.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep6);

    SelectOnConditionStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnConditionStep7 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep7.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectOnStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectOnStep5 = mock(SelectOnStep.class);
    when(selectOnStep5.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep7);

    SelectJoinStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep5);

    SelectSelectStep<
            Record14<
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object,
                Object>>
        selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<PhysicalFlowInfo> actualFindUnderlyingPhysicalFlowsResult =
        physicalFlowDao.findUnderlyingPhysicalFlows(1L);

    // Assert
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(dSLContext)
        .select(
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class),
            isA(SelectField.class));
    verify(selectOnConditionStep).fetchGroups(isA(Field.class), isA(RecordMapper.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep7).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep6).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep5).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep5).on(isA(Condition.class));
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep4).where(isA(Condition.class));
    assertTrue(actualFindUnderlyingPhysicalFlowsResult.isEmpty());
  }
}
