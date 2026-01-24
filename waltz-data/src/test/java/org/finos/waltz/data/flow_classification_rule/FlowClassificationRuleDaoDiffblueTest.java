package org.finos.waltz.data.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType.Builder;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchyItem;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRule;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleUpdateCommand;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.schema.tables.records.FlowClassificationRuleRecord;
import org.finos.waltz.schema.tables.records.LogicalFlowDecoratorRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.OrderField;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Record2;
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
import org.jooq.SelectSeekStep6;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UpdateConditionStep;
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
class FlowClassificationRuleDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private FlowClassificationRuleDao flowClassificationRuleDao;

  /**
   * Test {@link FlowClassificationRuleDao#findAll()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleDao.findAll()"})
  void testFindAll() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    List<FlowClassificationRule> actualFindAllResult = new FlowClassificationRuleDao(dsl).findAll();

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectOnConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findByEntityKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findByEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test findByEntityKind(EntityKind); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleDao.findByEntityKind(EntityKind)"})
  void testFindByEntityKind_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    List<FlowClassificationRule> actualFindByEntityKindResult =
        new FlowClassificationRuleDao(dsl).findByEntityKind(EntityKind.ALL);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityKindResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenCallsId() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<FlowClassificationRule> actualFindByEntityReferenceResult =
        flowClassificationRuleDao.findByEntityReference(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findByEntityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#select(SelectField)}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findByEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityReference(EntityReference); then calls select(SelectField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleDao.findByEntityReference(EntityReference)"})
  void testFindByEntityReference_thenCallsSelect() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    // Act
    List<FlowClassificationRule> actualFindByEntityReferenceResult =
        flowClassificationRuleDao.findByEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    verify(dsl).select(isA(SelectField.class));
    assertTrue(actualFindByEntityReferenceResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findByApplicationId(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findByApplicationId(long)}
   */
  @Test
  @DisplayName("Test findByApplicationId(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FlowClassificationRuleDao.findByApplicationId(long)"})
  void testFindByApplicationId_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    List<FlowClassificationRule> actualFindByApplicationIdResult =
        new FlowClassificationRuleDao(dsl).findByApplicationId(1L);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByApplicationIdResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test update(FlowClassificationRuleUpdateCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.update(FlowClassificationRuleUpdateCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
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
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    FlowClassificationRuleUpdateCommand command = mock(FlowClassificationRuleUpdateCommand.class);
    when(command.message()).thenReturn("Not all who wander are lost");
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.classificationId()).thenReturn(1L);
    when(command.severity()).thenReturn(MessageSeverity.NONE);
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = flowClassificationRuleDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_classification_rule\" set \"flow_classification_rule\".\"flow_classification_id\" = cast(? as bigint), \"flow_classification_rule\".\"description\" = cast(? as varchar), \"flow_classification_rule\".\"direction\" = (select \"flow_classification\".\"direction\" from \"flow_classification\" where \"flow_classification\".\"id\" = cast(? as bigint)), \"flow_classification_rule\".\"message_severity\" = cast(? as varchar), \"flow_classification_rule\".\"message\" = cast(? as varchar) where \"flow_classification_rule\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command, atLeast(1)).id();
    verify(command, atLeast(1)).classificationId();
    verify(command).message();
    verify(command, atLeast(1)).severity();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test update(FlowClassificationRuleUpdateCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.update(FlowClassificationRuleUpdateCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
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
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    FlowClassificationRuleUpdateCommand command = mock(FlowClassificationRuleUpdateCommand.class);
    when(command.message()).thenReturn("Not all who wander are lost");
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.classificationId()).thenReturn(1L);
    when(command.severity()).thenReturn(MessageSeverity.NONE);
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = flowClassificationRuleDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_classification_rule\" set \"flow_classification_rule\".\"flow_classification_id\" = cast(? as bigint), \"flow_classification_rule\".\"description\" = cast(? as varchar(43)), \"flow_classification_rule\".\"direction\" = (select \"flow_classification\".\"direction\" from \"flow_classification\" where \"flow_classification\".\"id\" = cast(? as bigint)), \"flow_classification_rule\".\"message_severity\" = cast(? as varchar(4)), \"flow_classification_rule\".\"message\" = cast(? as varchar(27)) where \"flow_classification_rule\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command, atLeast(1)).id();
    verify(command, atLeast(1)).classificationId();
    verify(command).message();
    verify(command, atLeast(1)).severity();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#update(FlowClassificationRuleUpdateCommand)}
   */
  @Test
  @DisplayName(
      "Test update(FlowClassificationRuleUpdateCommand); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.update(FlowClassificationRuleUpdateCommand)"})
  void testUpdate_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
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
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    FlowClassificationRuleUpdateCommand command = mock(FlowClassificationRuleUpdateCommand.class);
    when(command.message()).thenReturn("Not all who wander are lost");
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.classificationId()).thenReturn(1L);
    when(command.severity()).thenReturn(MessageSeverity.NONE);
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = flowClassificationRuleDao.update(command);

    // Assert
    verify(connection)
        .prepareStatement(
            "update \"flow_classification_rule\" set \"flow_classification_rule\".\"flow_classification_id\" = ?, \"flow_classification_rule\".\"description\" = ?, \"flow_classification_rule\".\"direction\" = (select \"flow_classification\".\"direction\" from \"flow_classification\" where \"flow_classification\".\"id\" = ?), \"flow_classification_rule\".\"message_severity\" = ?, \"flow_classification_rule\".\"message\" = ? where \"flow_classification_rule\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(command).description();
    verify(command, atLeast(1)).id();
    verify(command, atLeast(1)).classificationId();
    verify(command).message();
    verify(command, atLeast(1)).severity();
    assertEquals(0, actualUpdateResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualRemoveResult = new FlowClassificationRuleDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_classification_rule\" where \"flow_classification_rule\".\"id\" = cast(? as bigint)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#remove(long)}
   */
  @Test
  @DisplayName(
      "Test remove(long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.remove(long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualRemoveResult = new FlowClassificationRuleDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"flow_classification_rule\" where \"flow_classification_rule\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualRemoveResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#remove(long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.remove(long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<FlowClassificationRuleRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<FlowClassificationRuleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.delete(Mockito.<Table<FlowClassificationRuleRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    int actualRemoveResult = new FlowClassificationRuleDao(dsl).remove(1L);

    // Assert
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).delete(isA(Table.class));
    assertEquals(1, actualRemoveResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#cleanupOrphans()}.
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#cleanupOrphans()}
   */
  @Test
  @DisplayName("Test cleanupOrphans()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleDao.cleanupOrphans()"})
  void testCleanupOrphans() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record1<Object>> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.fetchSet(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    DeleteConditionStep<FlowClassificationRuleRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<FlowClassificationRuleRecord> deleteConditionStep2 =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep2.or(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<FlowClassificationRuleRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);
    when(dSLContext.deleteFrom(Mockito.<Table<FlowClassificationRuleRecord>>any()))
        .thenReturn(deleteUsingStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep2);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    Set<EntityReference> actualCleanupOrphansResult = flowClassificationRuleDao.cleanupOrphans();

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(deleteConditionStep2).or(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(selectConditionStep2).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep2).where(isA(Condition.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualCleanupOrphansResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenOne_whenHashSetAddOne()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> orgVantagePointIds = new HashSet<>();
    orgVantagePointIds.add(1L);
    HashSet<Long> appVantagePointIds = new HashSet<>();

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenOne_whenHashSetAddOne2()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Long> orgVantagePointIds = new HashSet<>();

    HashSet<Long> appVantagePointIds = new HashSet<>();
    appVantagePointIds.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashSet#HashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given one; when HashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenOne_whenHashSetAddOne3()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Long> orgVantagePointIds = new HashSet<>();
    HashSet<Long> appVantagePointIds = new HashSet<>();

    HashSet<Long> actorVantagePointIds = new HashSet<>();
    actorVantagePointIds.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND,
                orgVantagePointIds,
                appVantagePointIds,
                actorVantagePointIds);

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenZero_whenHashSetAddZero()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> orgVantagePointIds = new HashSet<>();
    orgVantagePointIds.add(0L);
    orgVantagePointIds.add(1L);
    HashSet<Long> appVantagePointIds = new HashSet<>();

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenZero_whenHashSetAddZero2()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Long> orgVantagePointIds = new HashSet<>();

    HashSet<Long> appVantagePointIds = new HashSet<>();
    appVantagePointIds.add(0L);
    appVantagePointIds.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); given zero; when HashSet() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_givenZero_whenHashSetAddZero3()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Long> orgVantagePointIds = new HashSet<>();
    HashSet<Long> appVantagePointIds = new HashSet<>();

    HashSet<Long> actorVantagePointIds = new HashSet<>();
    actorVantagePointIds.add(0L);
    actorVantagePointIds.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND,
                orgVantagePointIds,
                appVantagePointIds,
                actorVantagePointIds);

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set,
   * Set, Set)}
   */
  @Test
  @DisplayName(
      "Test findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(FlowDirection, Set, Set, Set)"
  })
  void testFindExpandedFlowClassificationRuleVantagePoints_whenHashSet()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);
    HashSet<Long> orgVantagePointIds = new HashSet<>();
    HashSet<Long> appVantagePointIds = new HashSet<>();

    // Act
    List<FlowClassificationRuleVantagePoint>
        actualFindExpandedFlowClassificationRuleVantagePointsResult =
            flowClassificationRuleDao.findExpandedFlowClassificationRuleVantagePoints(
                FlowDirection.INBOUND, orgVantagePointIds, appVantagePointIds, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindExpandedFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection)}
   * with {@code direction}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection)}
   */
  @Test
  @DisplayName("Test findFlowClassificationRuleVantagePoints(FlowDirection) with 'direction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirection() throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection.INBOUND);

    // Assert
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * Set)} with {@code direction}, {@code dataTypeIdsToConsider}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, Set) with 'direction', 'dataTypeIdsToConsider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDataTypeIdsToConsider()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, new HashSet<>());

    // Assert
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * Set)} with {@code direction}, {@code dataTypeIdsToConsider}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, Set) with 'direction', 'dataTypeIdsToConsider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDataTypeIdsToConsider2()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> dataTypeIdsToConsider = new HashSet<>();
    dataTypeIdsToConsider.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dataTypeIdsToConsider);

    // Assert
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * Set)} with {@code direction}, {@code dataTypeIdsToConsider}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, Set) with 'direction', 'dataTypeIdsToConsider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDataTypeIdsToConsider3()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
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
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    HashSet<Long> dataTypeIdsToConsider = new HashSet<>();
    dataTypeIdsToConsider.add(0L);
    dataTypeIdsToConsider.add(1L);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dataTypeIdsToConsider);

    // Assert
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, null, new HashSet<>());

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation2()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation3()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    ImmutableEntityHierarchy dtHierarchy = builderResult.build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation4()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    ImmutableEntityHierarchy dtHierarchy = builderResult.build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation5()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    ImmutableEntityHierarchy dtHierarchy = builderResult.build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation6()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(2L)
            .build());
    ImmutableEntityHierarchy dtHierarchy = builderResult.build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)} with {@code direction}, {@code dtHierarchy}, {@code population}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findFlowClassificationRuleVantagePoints(FlowDirection,
   * EntityHierarchy, Set)}
   */
  @Test
  @DisplayName(
      "Test findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set) with 'direction', 'dtHierarchy', 'population'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FlowClassificationRuleDao.findFlowClassificationRuleVantagePoints(FlowDirection, EntityHierarchy, Set)"
  })
  void testFindFlowClassificationRuleVantagePointsWithDirectionDtHierarchyPopulation7()
      throws DataAccessException {
    // Arrange
    SelectSeekStep6<
            Record11<
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
            Object,
            Object,
            Object,
            Object,
            Object,
            Object>
        selectSeekStep6 = mock(SelectSeekStep6.class);
    when(selectSeekStep6.fetch(
            Mockito
                .<RecordMapper<
                        Record11<
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
        .thenReturn(new ArrayList<>());

    SelectConditionStep<
            Record11<
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
    when(selectConditionStep.orderBy(
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any(),
            Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep6);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<
            Record11<
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
        selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<
            Record11<
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
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<
            Record11<
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
        selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<
            Record11<
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
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<
            Record11<
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
        selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectSelectStep<
            Record11<
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
        selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(
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
        .thenReturn(selectSelectStep);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    ImmutableEntityHierarchy.Builder builderResult = ImmutableEntityHierarchy.builder();
    builderResult.addHierarchyItems(
        ImmutableEntityHierarchyItem.builder()
            .ancestorLevel(1)
            .descendantLevel(3)
            .id(1L)
            .kind(EntityKind.ALL)
            .parentId(1L)
            .build());
    ImmutableEntityHierarchy dtHierarchy = builderResult.build();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult2 =
        sourceOuIdResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult2
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    // Act
    List<FlowClassificationRuleVantagePoint> actualFindFlowClassificationRuleVantagePointsResult =
        flowClassificationRuleDao.findFlowClassificationRuleVantagePoints(
            FlowDirection.INBOUND, dtHierarchy, population);

    // Assert
    verify(dsl)
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
            isA(SelectField.class));
    verify(selectSeekStep6).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectConditionStep)
        .orderBy(
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class),
            isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindFlowClassificationRuleVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findClassificationRules(Condition)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findClassificationRules(Condition)}
   */
  @Test
  @DisplayName("Test findClassificationRules(Condition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleDao.findClassificationRules(Condition)"})
  void testFindClassificationRules() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    Set<FlowClassificationRule> actualFindClassificationRulesResult =
        new FlowClassificationRuleDao(dsl).findClassificationRules(ApplicationDao.IS_ACTIVE);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindClassificationRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findCompanionEntityRules(long)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findCompanionEntityRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionEntityRules(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleDao.findCompanionEntityRules(long)"})
  void testFindCompanionEntityRules() throws DataAccessException {
    // Arrange
    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    Set<FlowClassificationRule> actualFindCompanionEntityRulesResult =
        new FlowClassificationRuleDao(dsl).findCompanionEntityRules(1L);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectOnConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    assertTrue(actualFindCompanionEntityRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findCompanionDataTypeRules(long)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleDao#findCompanionDataTypeRules(long)}
   */
  @Test
  @DisplayName("Test findCompanionDataTypeRules(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleDao.findCompanionDataTypeRules(long)"})
  void testFindCompanionDataTypeRules() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    Set<FlowClassificationRule> actualFindCompanionDataTypeRulesResult =
        new FlowClassificationRuleDao(dsl).findCompanionDataTypeRules(1L);

    // Assert
    verify(dsl).select(isA(SelectField.class));
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindCompanionDataTypeRulesResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#findAppliedClassificationRulesForFlow(Long)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#findAppliedClassificationRulesForFlow(Long)}
   */
  @Test
  @DisplayName("Test findAppliedClassificationRulesForFlow(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set FlowClassificationRuleDao.findAppliedClassificationRulesForFlow(Long)"})
  void testFindAppliedClassificationRulesForFlow() throws DataAccessException {
    // Arrange
    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep2 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep2.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep3);

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep2);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep3 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep3.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record1<Object>> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep4);

    // Act
    Set<FlowClassificationRule> actualFindAppliedClassificationRulesForFlowResult =
        new FlowClassificationRuleDao(dsl).findAppliedClassificationRulesForFlow(1L);

    // Assert
    verify(dsl, atLeast(1)).select(isA(SelectField.class));
    verify(selectOrderByStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep, atLeast(1)).from(isA(TableLike.class));
    verify(selectOnConditionStep2, atLeast(1)).innerJoin(isA(TableLike.class));
    verify(selectJoinStep, atLeast(1)).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep4, atLeast(1)).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3, atLeast(1)).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep3, atLeast(1)).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2, atLeast(1)).on(isA(Condition.class));
    verify(selectJoinPartitionByStep, atLeast(1)).on(isA(Condition.class));
    verify(selectOnStep, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectSelectStep4, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).union(isA(Select.class));
    verify(selectOnConditionStep, atLeast(1)).where(isA(Condition.class));
    assertTrue(actualFindAppliedClassificationRulesForFlowResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  @DisplayName("Test updateDecoratorsWithClassifications(Set); given UpdateConditionStep")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.updateDecoratorsWithClassifications(Set)"})
  void testUpdateDecoratorsWithClassifications_givenUpdateConditionStep()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    HashSet<UpdateConditionStep<LogicalFlowDecoratorRecord>> updateStmts = new HashSet<>();
    updateStmts.add(mock(UpdateConditionStep.class));

    // Act
    int actualUpdateDecoratorsWithClassificationsResult =
        flowClassificationRuleDao.updateDecoratorsWithClassifications(updateStmts);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}.
   *
   * <ul>
   *   <li>Given {@link UpdateConditionStep}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  @DisplayName("Test updateDecoratorsWithClassifications(Set); given UpdateConditionStep")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.updateDecoratorsWithClassifications(Set)"})
  void testUpdateDecoratorsWithClassifications_givenUpdateConditionStep2()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    HashSet<UpdateConditionStep<LogicalFlowDecoratorRecord>> updateStmts = new HashSet<>();
    updateStmts.add(mock(UpdateConditionStep.class));
    updateStmts.add(mock(UpdateConditionStep.class));

    // Act
    int actualUpdateDecoratorsWithClassificationsResult =
        flowClassificationRuleDao.updateDecoratorsWithClassifications(updateStmts);

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  @DisplayName("Test updateDecoratorsWithClassifications(Set); then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.updateDecoratorsWithClassifications(Set)"})
  void testUpdateDecoratorsWithClassifications_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    // Act
    int actualUpdateDecoratorsWithClassificationsResult =
        flowClassificationRuleDao.updateDecoratorsWithClassifications(new HashSet<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }

  /**
   * Test {@link FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleDao#updateDecoratorsWithClassifications(Set)}
   */
  @Test
  @DisplayName(
      "Test updateDecoratorsWithClassifications(Set); when HashSet(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int FlowClassificationRuleDao.updateDecoratorsWithClassifications(Set)"})
  void testUpdateDecoratorsWithClassifications_whenHashSet_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.batch(Mockito.<Collection<Query>>any())).thenReturn(batch);
    FlowClassificationRuleDao flowClassificationRuleDao = new FlowClassificationRuleDao(dsl);

    // Act
    int actualUpdateDecoratorsWithClassificationsResult =
        flowClassificationRuleDao.updateDecoratorsWithClassifications(new HashSet<>());

    // Assert
    verify(batch).execute();
    verify(dsl).batch(isA(Collection.class));
    assertEquals(0, actualUpdateDecoratorsWithClassificationsResult);
  }
}
