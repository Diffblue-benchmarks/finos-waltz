package org.finos.waltz.data.changelog;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.Severity;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog;
import org.finos.waltz.model.changelog.ImmutableChangeLog.Builder;
import org.finos.waltz.model.tally.OrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.finos.waltz.schema.tables.records.ChangeLogRecord;
import org.jooq.Batch;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Query;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
import org.jooq.SelectQuery;
import org.jooq.SelectSeekStep1;
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
class ChangeLogDaoDiffblueTest {
  @InjectMocks private ChangeLogDao changeLogDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link ChangeLogDao#findByParentReference(EntityReference, Optional, Optional)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findByParentReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName("Test findByParentReference(EntityReference, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByParentReference(EntityReference, Optional, Optional)"
  })
  void testFindByParentReference() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceResult =
        changeLogDao.findByParentReference(ref, date, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByParentReference(EntityReference, Optional, Optional)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link EntityReference} {@link EntityReference#id()} return one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByParentReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findByParentReference(EntityReference, Optional, Optional); given one; when EntityReference id() return one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByParentReference(EntityReference, Optional, Optional)"
  })
  void testFindByParentReference_givenOne_whenEntityReferenceIdReturnOne_thenCallsId()
      throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceResult =
        changeLogDao.findByParentReference(ref, date, limit);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByParentReference(EntityReference, Optional, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByParentReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findByParentReference(EntityReference, Optional, Optional); when empty; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByParentReference(EntityReference, Optional, Optional)"
  })
  void testFindByParentReference_whenEmpty_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date = Optional.empty();
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceResult =
        changeLogDao.findByParentReference(ref, date, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByPersonReference(EntityReference, Optional, Optional)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findByPersonReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName("Test findByPersonReference(EntityReference, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByPersonReference(EntityReference, Optional, Optional)"
  })
  void testFindByPersonReference() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceResult =
        changeLogDao.findByPersonReference(ref, date, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    assertTrue(actualFindByPersonReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByPersonReference(EntityReference, Optional, Optional)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findByPersonReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName("Test findByPersonReference(EntityReference, Optional, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByPersonReference(EntityReference, Optional, Optional)"
  })
  void testFindByPersonReference2() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    Optional<java.util.Date> date =
        Optional.of(
            java.util.Date.from(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceResult =
        changeLogDao.findByPersonReference(ref, date, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    assertTrue(actualFindByPersonReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByPersonReference(EntityReference, Optional, Optional)}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByPersonReference(EntityReference, Optional,
   * Optional)}
   */
  @Test
  @DisplayName(
      "Test findByPersonReference(EntityReference, Optional, Optional); when empty; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByPersonReference(EntityReference, Optional, Optional)"
  })
  void testFindByPersonReference_whenEmpty_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<java.util.Date> date = Optional.empty();
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceResult =
        changeLogDao.findByPersonReference(ref, date, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    assertTrue(actualFindByPersonReferenceResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByParentReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link EntityReference#id()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByParentReferenceForDateRange(EntityReference,
   * Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByParentReferenceForDateRange(EntityReference, Date, Date, Optional); given one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByParentReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByParentReferenceForDateRange_givenOne_thenCallsId() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceForDateRangeResult =
        changeLogDao.findByParentReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByParentReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByParentReferenceForDateRange(EntityReference,
   * Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByParentReferenceForDateRange(EntityReference, Date, Date, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByParentReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByParentReferenceForDateRange_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByParentReferenceForDateRangeResult =
        changeLogDao.findByParentReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByParentReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByPersonReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findByPersonReferenceForDateRange(EntityReference,
   * Date, Date, Optional)}
   */
  @Test
  @DisplayName("Test findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByPersonReferenceForDateRange() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableAppGroupEntry ref =
        ImmutableAppGroupEntry.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .provenance("Provenance")
            .build();
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceForDateRangeResult =
        changeLogDao.findByPersonReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    assertTrue(actualFindByPersonReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByPersonReferenceForDateRange(EntityReference, Date, Date,
   * Optional)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByPersonReferenceForDateRange(EntityReference,
   * Date, Date, Optional)}
   */
  @Test
  @DisplayName(
      "Test findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ChangeLogDao.findByPersonReferenceForDateRange(EntityReference, Date, Date, Optional)"
  })
  void testFindByPersonReferenceForDateRange_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Date startDate = new Date(1L);
    Date endDate = new Date(1L);
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByPersonReferenceForDateRangeResult =
        changeLogDao.findByPersonReferenceForDateRange(ref, startDate, endDate, limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectJoinStep).orderBy(isA(OrderField.class));
    assertTrue(actualFindByPersonReferenceForDateRangeResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findByUser(String, Optional)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#findByUser(String, Optional)}
   */
  @Test
  @DisplayName("Test findByUser(String, Optional); when 'janedoe'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.findByUser(String, Optional)"})
  void testFindByUser_whenJanedoe_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record> selectLimitPercentStep = mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(Mockito.<Number>any())).thenReturn(selectLimitPercentStep);

    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.orderBy(Mockito.<OrderField<Object>>any()))
        .thenReturn(selectSeekStep1);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    Optional<Integer> limit = Optional.of(1);

    // Act
    List<ChangeLog> actualFindByUserResult = changeLogDao.findByUser("janedoe", limit);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByUserResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getContributionLeaderBoard(int)}.
   *
   * <p>Method under test: {@link ChangeLogDao#getContributionLeaderBoard(int)}
   */
  @Test
  @DisplayName("Test getContributionLeaderBoard(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getContributionLeaderBoard(int)"})
  void testGetContributionLeaderBoard() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record3<Object, Object, Object>> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record3<Object, Object, Object>, Object> selectSeekStep1 =
        mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrderedTally<String>> actualContributionLeaderBoard =
        changeLogDao.getContributionLeaderBoard(1);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectSeekStep1).limit(1);
    verify(selectHavingStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualContributionLeaderBoard.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getContributionLeaderBoardLastMonth(int)}.
   *
   * <p>Method under test: {@link ChangeLogDao#getContributionLeaderBoardLastMonth(int)}
   */
  @Test
  @DisplayName("Test getContributionLeaderBoardLastMonth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getContributionLeaderBoardLastMonth(int)"})
  void testGetContributionLeaderBoardLastMonth() throws DataAccessException {
    // Arrange
    SelectLimitPercentStep<Record3<Object, Object, Object>> selectLimitPercentStep =
        mock(SelectLimitPercentStep.class);
    when(selectLimitPercentStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectSeekStep1<Record3<Object, Object, Object>, Object> selectSeekStep1 =
        mock(SelectSeekStep1.class);
    when(selectSeekStep1.limit(anyInt())).thenReturn(selectLimitPercentStep);

    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrderedTally<String>> actualContributionLeaderBoardLastMonth =
        changeLogDao.getContributionLeaderBoardLastMonth(1);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectSeekStep1).limit(1);
    verify(selectHavingStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualContributionLeaderBoardLastMonth.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getRankingOfContributors()}.
   *
   * <p>Method under test: {@link ChangeLogDao#getRankingOfContributors()}
   */
  @Test
  @DisplayName("Test getRankingOfContributors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getRankingOfContributors()"})
  void testGetRankingOfContributors() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record3<Object, Object, Object>> selectHavingStep =
        mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(
            Mockito.<RecordMapper<Record3<Object, Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record3<Object, Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record3<Object, Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record3<Object, Object, Object>> selectSelectStep =
        mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any(),
            Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<OrderedTally<String>> actualRankingOfContributors =
        changeLogDao.getRankingOfContributors();

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext)
        .select(isA(SelectField.class), isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualRankingOfContributors.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getContributionScoresForUsers(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#getContributionScoresForUsers(List)}
   */
  @Test
  @DisplayName("Test getContributionScoresForUsers(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getContributionScoresForUsers(List)"})
  void testGetContributionScoresForUsers_given42_whenArrayListAdd42() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    ArrayList<String> userIds = new ArrayList<>();
    userIds.add("42");
    userIds.add("foo");

    // Act
    List<Tally<String>> actualContributionScoresForUsers =
        changeLogDao.getContributionScoresForUsers(userIds);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualContributionScoresForUsers.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getContributionScoresForUsers(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#getContributionScoresForUsers(List)}
   */
  @Test
  @DisplayName("Test getContributionScoresForUsers(List); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getContributionScoresForUsers(List)"})
  void testGetContributionScoresForUsers_givenFoo_whenArrayListAddFoo() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    ArrayList<String> userIds = new ArrayList<>();
    userIds.add("foo");

    // Act
    List<Tally<String>> actualContributionScoresForUsers =
        changeLogDao.getContributionScoresForUsers(userIds);

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualContributionScoresForUsers.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#getContributionScoresForUsers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#getContributionScoresForUsers(List)}
   */
  @Test
  @DisplayName("Test getContributionScoresForUsers(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.getContributionScoresForUsers(List)"})
  void testGetContributionScoresForUsers_whenArrayList() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<String>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.renderInlined(Mockito.<QueryPart>any())).thenReturn("Render Inlined");
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<String>> actualContributionScoresForUsers =
        changeLogDao.getContributionScoresForUsers(new ArrayList<>());

    // Assert
    verify(dSLContext).renderInlined(isA(QueryPart.class));
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectHavingStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).where("Render Inlined");
    assertTrue(actualContributionScoresForUsers.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogDao.write(changeLogs);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs2() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    Builder childIdResult2 = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind2 = Optional.of(EntityKind.ALL);

    Builder operationResult2 =
        childIdResult2
            .childKind(childKind2)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogDao.write(changeLogs);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs3() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.empty();

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogDao.write(changeLogs);

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <ul>
   *   <li>Given {@link Statement} {@link Statement#addBatch(String)} does nothing.
   *   <li>Then calls {@link Statement#addBatch(String)}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName(
      "Test write(Collection) with 'changeLogs'; given Statement addBatch(String) does nothing; then calls addBatch(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs_givenStatementAddBatchDoesNothing_thenCallsAddBatch()
      throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    doNothing().when(statement).addBatch(Mockito.<String>any());
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ChangeLogDao changeLogDao = new ChangeLogDao(dsl);

    ArrayList<ChangeLog> changeLogs = new ArrayList<>();

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);
    changeLogs.add(
        operationResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(Severity.INFORMATION)
            .userId("42")
            .build());

    // Act
    int[] actualWriteResult = changeLogDao.write(changeLogs);

    // Assert
    verify(connection).createStatement();
    verify(statement)
        .addBatch(
            "insert into \"change_log\" (\"message\", \"parent_id\", \"parent_kind\", \"user_id\", \"severity\", \"child_kind\", \"child_id\", \"operation\", \"created_at\") values ('Not all who wander are lost', 1, 'ALL', '42', 'INFORMATION', 'ALL', 1, 'ADD', timestamp '1970-01-01 00:00:00.0')");
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#createStatement()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'; then calls createStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs_thenCallsCreateStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    ChangeLogDao changeLogDao = new ChangeLogDao(dsl);

    // Act
    int[] actualWriteResult = changeLogDao.write(new ArrayList<>());

    // Assert
    verify(connection).createStatement();
    verify(statement).close();
    verify(statement).executeBatch();
    verify(statement).getWarnings();
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Collection)} with {@code changeLogs}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Batch#execute()}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Collection)}
   */
  @Test
  @DisplayName("Test write(Collection) with 'changeLogs'; when ArrayList(); then calls execute()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] ChangeLogDao.write(Collection)"})
  void testWriteWithChangeLogs_whenArrayList_thenCallsExecute() throws DataAccessException {
    // Arrange
    Batch batch = mock(Batch.class);
    when(batch.execute()).thenReturn(new int[] {1, -1, 1, -1});
    when(dSLContext.batch((Query[]) Mockito.any())).thenReturn(batch);

    // Act
    int[] actualWriteResult = changeLogDao.write(new ArrayList<>());

    // Assert
    verify(batch).execute();
    verify(dSLContext).batch((Query[]) Mockito.any());
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Optional, ChangeLog)} with {@code tx}, {@code changeLog}.
   *
   * <p>Method under test: {@link ChangeLogDao#write(Optional, ChangeLog)}
   */
  @Test
  @DisplayName("Test write(Optional, ChangeLog) with 'tx', 'changeLog'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogDao.write(Optional, ChangeLog)"})
  void testWriteWithTxChangeLog() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetStep<ChangeLogRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);
    when(dSLContext.insertInto(Mockito.<Table<ChangeLogRecord>>any())).thenReturn(insertSetStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    Builder childIdResult = ImmutableChangeLog.builder().childId(1L);
    Optional<? extends EntityKind> childKind = Optional.of(EntityKind.ALL);

    Builder operationResult =
        childIdResult
            .childKind(childKind)
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .message("Not all who wander are lost")
            .operation(Operation.ADD);

    // Act
    int actualWriteResult =
        changeLogDao.write(
            tx,
            operationResult
                .parentReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .severity(Severity.INFORMATION)
                .userId("42")
                .build());

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Optional, ChangeLog)} with {@code tx}, {@code changeLog}.
   *
   * <ul>
   *   <li>Given {@link InsertSetMoreStep} {@link InsertSetMoreStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Optional, ChangeLog)}
   */
  @Test
  @DisplayName(
      "Test write(Optional, ChangeLog) with 'tx', 'changeLog'; given InsertSetMoreStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogDao.write(Optional, ChangeLog)"})
  void testWriteWithTxChangeLog_givenInsertSetMoreStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep5 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep6 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep7 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep7.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep8 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep8.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep7);

    InsertSetMoreStep<ChangeLogRecord> insertSetMoreStep9 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep9.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep8);

    InsertSetStep<ChangeLogRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep9);
    when(dSLContext.insertInto(Mockito.<Table<ChangeLogRecord>>any())).thenReturn(insertSetStep);
    Optional<DSLContext> tx = Optional.of(dSLContext);

    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<Long> ofResult = Optional.of(1L);
    when(changeLog.childId()).thenReturn(ofResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(changeLog.childKind()).thenReturn(ofResult2);
    when(changeLog.operation()).thenReturn(Operation.ADD);
    when(changeLog.userId()).thenReturn("42");
    when(changeLog.severity()).thenReturn(Severity.INFORMATION);
    when(changeLog.parentReference())
        .thenReturn(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    when(changeLog.message()).thenReturn("Not all who wander are lost");

    // Act
    int actualWriteResult = changeLogDao.write(tx, changeLog);

    // Assert
    verify(changeLog).childId();
    verify(changeLog).childKind();
    verify(changeLog).createdAt();
    verify(changeLog).message();
    verify(changeLog).operation();
    verify(changeLog, atLeast(1)).parentReference();
    verify(changeLog).severity();
    verify(changeLog).userId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep9).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep8).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep7).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Optional, ChangeLog)} with {@code tx}, {@code changeLog}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Optional, ChangeLog)}
   */
  @Test
  @DisplayName(
      "Test write(Optional, ChangeLog) with 'tx', 'changeLog'; when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogDao.write(Optional, ChangeLog)"})
  void testWriteWithTxChangeLog_whenOfDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.CUBRID));

    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<Long> ofResult = Optional.of(1L);
    when(changeLog.childId()).thenReturn(ofResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(changeLog.childKind()).thenReturn(ofResult2);
    when(changeLog.operation()).thenReturn(Operation.ADD);
    when(changeLog.userId()).thenReturn("42");
    when(changeLog.severity()).thenReturn(Severity.INFORMATION);
    when(changeLog.message()).thenReturn("Not all who wander are lost");
    when(changeLog.parentReference())
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
    int actualWriteResult = changeLogDao.write(tx, changeLog);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"change_log\" (\"message\", \"parent_id\", \"parent_kind\", \"user_id\", \"severity\", \"child_kind\", \"child_id\", \"operation\", \"created_at\") values (cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as bigint), cast(? as varchar), cast(? as datetime))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(9), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(changeLog).childId();
    verify(changeLog).childKind();
    verify(changeLog).createdAt();
    verify(changeLog).message();
    verify(changeLog).operation();
    verify(changeLog, atLeast(1)).parentReference();
    verify(changeLog).severity();
    verify(changeLog).userId();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#write(Optional, ChangeLog)} with {@code tx}, {@code changeLog}.
   *
   * <ul>
   *   <li>When of {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link ChangeLogDao#write(Optional, ChangeLog)}
   */
  @Test
  @DisplayName(
      "Test write(Optional, ChangeLog) with 'tx', 'changeLog'; when of DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ChangeLogDao.write(Optional, ChangeLog)"})
  void testWriteWithTxChangeLog_whenOfDefaultDSLContextWithConnectionAndDialectIsSql99()
      throws SQLException {
    // Arrange
    ChangeLogDao changeLogDao = new ChangeLogDao(new DefaultDSLContext(SQLDialect.SQL99));

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    Optional<DSLContext> tx = Optional.of(new DefaultDSLContext(connection, SQLDialect.SQL99));

    ChangeLog changeLog = mock(ChangeLog.class);
    when(changeLog.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<Long> ofResult = Optional.of(1L);
    when(changeLog.childId()).thenReturn(ofResult);
    Optional<EntityKind> ofResult2 = Optional.of(EntityKind.ALL);
    when(changeLog.childKind()).thenReturn(ofResult2);
    when(changeLog.operation()).thenReturn(Operation.ADD);
    when(changeLog.userId()).thenReturn("42");
    when(changeLog.severity()).thenReturn(Severity.INFORMATION);
    when(changeLog.message()).thenReturn("Not all who wander are lost");
    when(changeLog.parentReference())
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
    int actualWriteResult = changeLogDao.write(tx, changeLog);

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"change_log\" (\"message\", \"parent_id\", \"parent_kind\", \"user_id\", \"severity\", \"child_kind\", \"child_id\", \"operation\", \"created_at\") values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(9), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(changeLog).childId();
    verify(changeLog).childKind();
    verify(changeLog).createdAt();
    verify(changeLog).message();
    verify(changeLog).operation();
    verify(changeLog, atLeast(1)).parentReference();
    verify(changeLog).severity();
    verify(changeLog).userId();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link ChangeLogDao#findUnattestedChanges(EntityReference)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findUnattestedChanges(EntityReference)}
   */
  @Test
  @DisplayName("Test findUnattestedChanges(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.findUnattestedChanges(EntityReference)"})
  void testFindUnattestedChanges() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());
    when(dSLContext.selectQuery(Mockito.<TableLike<Record>>any())).thenReturn(selectQuery);

    // Act
    List<ChangeLog> actualFindUnattestedChangesResult =
        changeLogDao.findUnattestedChanges(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).selectQuery(isA(TableLike.class));
    verify(selectQuery).fetch(isA(RecordMapper.class));
    assertTrue(actualFindUnattestedChangesResult.isEmpty());
  }

  /**
   * Test {@link ChangeLogDao#findUnattestedChanges(EntityReference)}.
   *
   * <p>Method under test: {@link ChangeLogDao#findUnattestedChanges(EntityReference)}
   */
  @Test
  @DisplayName("Test findUnattestedChanges(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ChangeLogDao.findUnattestedChanges(EntityReference)"})
  void testFindUnattestedChanges2() throws DataAccessException {
    // Arrange
    SelectQuery<Record> selectQuery = mock(SelectQuery.class);
    when(selectQuery.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());
    when(dSLContext.selectQuery(Mockito.<TableLike<Record>>any())).thenReturn(selectQuery);

    // Act
    List<ChangeLog> actualFindUnattestedChangesResult =
        changeLogDao.findUnattestedChanges(
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
    verify(dSLContext).selectQuery(isA(TableLike.class));
    verify(selectQuery).fetch(isA(RecordMapper.class));
    assertTrue(actualFindUnattestedChangesResult.isEmpty());
  }
}
