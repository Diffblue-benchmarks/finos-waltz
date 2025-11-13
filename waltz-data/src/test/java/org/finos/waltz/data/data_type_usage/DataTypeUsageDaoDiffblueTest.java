package org.finos.waltz.data.data_type_usage;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.data_type_usage.DataTypeUsage;
import org.finos.waltz.model.usage_info.ImmutableUsageInfo;
import org.finos.waltz.model.usage_info.UsageInfo;
import org.finos.waltz.model.usage_info.UsageKind;
import org.finos.waltz.schema.tables.records.DataTypeUsageRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.TransactionalRunnable;
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
class DataTypeUsageDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private DataTypeUsageDao dataTypeUsageDao;

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#select(SelectFieldOrAsterisk[])} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given DSLContext select(SelectFieldOrAsterisk[]) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenDSLContextSelectThrowUnsupportedOperationException() {
    // Arrange
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeUsageDao.findForEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenDefaultDSLContextWithDialectIsSql99() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.findForEntity(ref));
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<DataTypeUsage> actualFindForEntityResult = dataTypeUsageDao.findForEntity(ref);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#where(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given SelectJoinStep where(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenSelectJoinStepWhereThrowUnsupportedOperationException() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectSelectStep} {@link SelectSelectStep#from(TableLike)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); given SelectSelectStep from(TableLike) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_givenSelectSelectStepFromThrowUnsupportedOperationException() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntity(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findForEntity(EntityReference); when EntityReference id() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntity(EntityReference)"})
  void testFindForEntity_whenEntityReferenceIdThrowUnsupportedOperationException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeUsageDao.findForEntity(ref));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.findForEntityAndDataType(ref, 1L));
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType2() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.findForEntityAndDataType(ref, 1L));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType3() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new DataTypeUsageDao(dsl).findForEntityAndDataType(mock(EntityReference.class), 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType4() {
    // Arrange
    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new DataTypeUsageDao(dsl).findForEntityAndDataType(mock(EntityReference.class), 1L));
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType5() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.findForEntityAndDataType(ref, 1L));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType6() {
    // Arrange
    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeUsageDao.findForEntityAndDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType7() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenThrow(new UnsupportedOperationException());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeUsageDao.findForEntityAndDataType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L));
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#findForEntityAndDataType(EntityReference, Long)}
   */
  @Test
  @DisplayName("Test findForEntityAndDataType(EntityReference, Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeUsageDao.findForEntityAndDataType(EntityReference, Long)"})
  void testFindForEntityAndDataType_thenReturnEmpty() throws DataAccessException {
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    List<DataTypeUsage> actualFindForEntityAndDataTypeResult =
        dataTypeUsageDao.findForEntityAndDataType(ref, 1L);

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForEntityAndDataTypeResult.isEmpty());
  }

  /**
   * Test {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test insertUsageInfo(EntityReference, Long, List); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.insertUsageInfo(EntityReference, Long, List)"})
  void testInsertUsageInfo_thenReturnEmptyArrayOfInt() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertArrayEquals(new int[] {}, dataTypeUsageDao.insertUsageInfo(ref, 1L, new ArrayList<>()));
  }

  /**
   * Test {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test insertUsageInfo(EntityReference, Long, List); when EntityReference id() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.insertUsageInfo(EntityReference, Long, List)"})
  void testInsertUsageInfo_whenEntityReferenceIdThrowUnsupportedOperationException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    LinkedList<UsageInfo> inserts = new LinkedList<>();
    inserts.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.insertUsageInfo(ref, 1L, inserts));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#kind()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#insertUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test insertUsageInfo(EntityReference, Long, List); when EntityReference kind() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.insertUsageInfo(EntityReference, Long, List)"})
  void testInsertUsageInfo_whenEntityReferenceKindThrowUnsupportedOperationException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new UnsupportedOperationException());

    LinkedList<UsageInfo> inserts = new LinkedList<>();
    inserts.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.insertUsageInfo(ref, 1L, inserts));
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test deleteUsageInfo(EntityReference, Long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo() {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test deleteUsageInfo(EntityReference, Long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo2() {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test deleteUsageInfo(EntityReference, Long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo3() {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.and(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteConditionStep).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test deleteUsageInfo(EntityReference, Long, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo4() throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenThrow(new UnsupportedOperationException());

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);
    when(dSLContext.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any()))
        .thenReturn(deleteUsingStep);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#deleteFrom(Table)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DSLContext deleteFrom(Table) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDSLContextDeleteFromThrowUnsupportedOperationException() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    EntityReference ref = mock(EntityReference.class);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(dsl).deleteFrom(isA(Table.class));
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = cast(? as varchar) and \"data_type_usage\".\"entity_id\" = cast(? as bigint) and \"data_type_usage\".\"data_type_id\" = cast(? as bigint) and 1 = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertEquals(0, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = cast(? as varchar(3)) and \"data_type_usage\".\"entity_id\" = cast(? as bigint) and \"data_type_usage\".\"data_type_id\" = cast(? as bigint) and 1 = 0)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertEquals(0, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDefaultDSLContextWithConnectionAndDialectIsSql99()
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = ? and \"data_type_usage\".\"entity_id\" = ? and \"data_type_usage\".\"data_type_id\" = ? and \"data_type_usage\".\"usage_kind\" in ())");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(ref).id();
    verify(ref).kind();
    assertEquals(0, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDefaultDSLContextWithConnectionAndDialectIsSql992()
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
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"data_type_usage\" where (\"data_type_usage\".\"entity_kind\" = ? and \"data_type_usage\".\"entity_id\" = ? and \"data_type_usage\".\"data_type_id\" = ? and \"data_type_usage\".\"usage_kind\" in ())");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement).setString(1, "ALL");
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DeleteConditionStep execute() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDeleteConditionStepExecuteReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenReturn(1L);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>());

    // Assert
    verify(ref).id();
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@link DeleteUsingStep} {@link DeleteUsingStep#where(Condition)} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given DeleteUsingStep where(Condition) throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDeleteUsingStepWhereThrowUnsupportedOperationException() {
    // Arrange
    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any()))
        .thenThrow(new UnsupportedOperationException());

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).kind();
    verify(dsl).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Given {@code DISTRIBUTOR}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DISTRIBUTOR}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); given 'DISTRIBUTOR'; when ArrayList() add 'DISTRIBUTOR'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_givenDistributor_whenArrayListAddDistributor()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageKind> deletes = new ArrayList<>();
    deletes.add(UsageKind.DISTRIBUTOR);
    deletes.add(UsageKind.CONSUMER);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, deletes);

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultDSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test deleteUsageInfo(EntityReference, Long, List); then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_thenCallsDeleteFrom() throws DataAccessException {
    // Arrange
    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep = mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep2 = mock(DeleteConditionStep.class);
    when(deleteConditionStep2.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep3 = mock(DeleteConditionStep.class);
    when(deleteConditionStep3.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep2);

    DeleteConditionStep<DataTypeUsageRecord> deleteConditionStep4 = mock(DeleteConditionStep.class);
    when(deleteConditionStep4.and(Mockito.<Condition>any())).thenReturn(deleteConditionStep3);

    DeleteUsingStep<DataTypeUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep4);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.deleteFrom(Mockito.<Table<DataTypeUsageRecord>>any())).thenReturn(deleteUsingStep);
    DataTypeUsageDao dataTypeUsageDao = new DataTypeUsageDao(dsl);
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    ArrayList<UsageKind> deletes = new ArrayList<>();
    deletes.add(UsageKind.CONSUMER);

    // Act
    int actualDeleteUsageInfoResult = dataTypeUsageDao.deleteUsageInfo(ref, 1L, deletes);

    // Assert
    verify(deleteConditionStep4).and(isA(Condition.class));
    verify(deleteConditionStep3).and(isA(Condition.class));
    verify(deleteConditionStep2).and(isA(Condition.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    verify(dsl).deleteFrom(isA(Table.class));
    assertEquals(1, actualDeleteUsageInfoResult);
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); when EntityReference id() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_whenEntityReferenceIdThrowUnsupportedOperationException() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#kind()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#deleteUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test deleteUsageInfo(EntityReference, Long, List); when EntityReference kind() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataTypeUsageDao.deleteUsageInfo(EntityReference, Long, List)"})
  void testDeleteUsageInfo_whenEntityReferenceKindThrowUnsupportedOperationException() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));

    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.deleteUsageInfo(ref, 1L, new ArrayList<>()));
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>Then return empty array of {@code int}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName("Test updateUsageInfo(EntityReference, Long, List); then return empty array of int")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.updateUsageInfo(EntityReference, Long, List)"})
  void testUpdateUsageInfo_thenReturnEmptyArrayOfInt() {
    // Arrange
    DataTypeUsageDao dataTypeUsageDao =
        new DataTypeUsageDao(new DefaultDSLContext(SQLDialect.SQL99));
    ImmutableEntityReference ref =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act and Assert
    assertArrayEquals(new int[] {}, dataTypeUsageDao.updateUsageInfo(ref, 1L, new ArrayList<>()));
  }

  /**
   * Test {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#id()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test updateUsageInfo(EntityReference, Long, List); when EntityReference id() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.updateUsageInfo(EntityReference, Long, List)"})
  void testUpdateUsageInfo_whenEntityReferenceIdThrowUnsupportedOperationException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.id()).thenThrow(new UnsupportedOperationException());
    when(ref.kind()).thenReturn(EntityKind.ALL);

    LinkedList<UsageInfo> updates = new LinkedList<>();
    updates.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.updateUsageInfo(ref, 1L, updates));
    verify(ref).id();
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}.
   *
   * <ul>
   *   <li>When {@link EntityReference} {@link EntityReference#kind()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#updateUsageInfo(EntityReference, Long, List)}
   */
  @Test
  @DisplayName(
      "Test updateUsageInfo(EntityReference, Long, List); when EntityReference kind() throw UnsupportedOperationException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] DataTypeUsageDao.updateUsageInfo(EntityReference, Long, List)"})
  void testUpdateUsageInfo_whenEntityReferenceKindThrowUnsupportedOperationException() {
    // Arrange
    EntityReference ref = mock(EntityReference.class);
    when(ref.kind()).thenThrow(new UnsupportedOperationException());

    LinkedList<UsageInfo> updates = new LinkedList<>();
    updates.add(
        ImmutableUsageInfo.builder()
            .description("The characteristics of someone or something")
            .isSelected(true)
            .kind(UsageKind.CONSUMER)
            .build());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.updateUsageInfo(ref, 1L, updates));
    verify(ref).kind();
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForAllApplications()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForAllApplications()}
   */
  @Test
  @DisplayName("Test recalculateForAllApplications(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForAllApplications()"})
  void testRecalculateForAllApplications_thenReturnTrue() {
    // Arrange
    DSLContext dsl = mock(DSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    boolean actualRecalculateForAllApplicationsResult =
        new DataTypeUsageDao(dsl).recalculateForAllApplications();

    // Assert
    verify(dsl, atLeast(1)).transaction(Mockito.<TransactionalRunnable>any());
    assertTrue(actualRecalculateForAllApplicationsResult);
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForAllApplications()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForAllApplications()}
   */
  @Test
  @DisplayName("Test recalculateForAllApplications(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForAllApplications()"})
  void testRecalculateForAllApplications_thenThrowUnsupportedOperationException() {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(dSLContext)
        .transaction(Mockito.<TransactionalRunnable>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.recalculateForAllApplications());
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForAppIdSelector(Select)}
   */
  @Test
  @DisplayName("Test recalculateForAppIdSelector(Select); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForAppIdSelector(Select)"})
  void testRecalculateForAppIdSelector_thenReturnTrue() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    boolean actualRecalculateForAppIdSelectorResult =
        new DataTypeUsageDao(dsl).recalculateForAppIdSelector(mock(Select.class));

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualRecalculateForAppIdSelectorResult);
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForAppIdSelector(Select)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForAppIdSelector(Select)}
   */
  @Test
  @DisplayName("Test recalculateForAppIdSelector(Select); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForAppIdSelector(Select)"})
  void testRecalculateForAppIdSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(dSLContext)
        .transaction(Mockito.<TransactionalRunnable>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.recalculateForAppIdSelector(mock(Select.class)));
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForIdSelector(EntityKind, Select)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForIdSelector(EntityKind, Select)}
   */
  @Test
  @DisplayName("Test recalculateForIdSelector(EntityKind, Select); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForIdSelector(EntityKind, Select)"})
  void testRecalculateForIdSelector_thenReturnTrue() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    doNothing().when(dsl).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    boolean actualRecalculateForIdSelectorResult =
        new DataTypeUsageDao(dsl).recalculateForIdSelector(EntityKind.ALL, mock(Select.class));

    // Assert
    verify(dsl).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualRecalculateForIdSelectorResult);
  }

  /**
   * Test {@link DataTypeUsageDao#recalculateForIdSelector(EntityKind, Select)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeUsageDao#recalculateForIdSelector(EntityKind, Select)}
   */
  @Test
  @DisplayName(
      "Test recalculateForIdSelector(EntityKind, Select); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataTypeUsageDao.recalculateForIdSelector(EntityKind, Select)"})
  void testRecalculateForIdSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(dSLContext)
        .transaction(Mockito.<TransactionalRunnable>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeUsageDao.recalculateForIdSelector(EntityKind.ALL, mock(Select.class)));
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
  }
}
