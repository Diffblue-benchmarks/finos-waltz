package org.finos.waltz.data.custom_environment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.custom_environment.CustomEnvironmentUsage;
import org.finos.waltz.model.custom_environment.CustomEnvironmentUsageInfo;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsage;
import org.finos.waltz.model.custom_environment.ImmutableCustomEnvironmentUsage.Builder;
import org.finos.waltz.schema.tables.records.CustomEnvironmentUsageRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.DeleteConditionStep;
import org.jooq.DeleteUsingStep;
import org.jooq.Field;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinPartitionByStep;
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
class CustomEnvironmentUsageDaoDiffblueTest {
  @InjectMocks private CustomEnvironmentUsageDao customEnvironmentUsageDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link CustomEnvironmentUsageDao#findByOwningEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#findByOwningEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByOwningEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentUsageDao.findByOwningEntityRef(EntityReference)"})
  void testFindByOwningEntityRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<CustomEnvironmentUsage> actualFindByOwningEntityRefResult =
        customEnvironmentUsageDao.findByOwningEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByOwningEntityRefResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentUsageDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);

    // Act
    boolean actualRemoveResult = new CustomEnvironmentUsageDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"custom_environment_usage\" where \"custom_environment_usage\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentUsageDao.remove(Long)"})
  void testRemove_givenDefaultDSLContextWithConnectionAndDialectIsSql99() throws SQLException {
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
    boolean actualRemoveResult = new CustomEnvironmentUsageDao(dsl).remove(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "delete from \"custom_environment_usage\" where \"custom_environment_usage\".\"id\" = ?");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(1, 1L);
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentUsageDao.remove(Long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnOne_thenReturnTrue()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<CustomEnvironmentUsageRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(1);

    DeleteUsingStep<CustomEnvironmentUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<CustomEnvironmentUsageRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = customEnvironmentUsageDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertTrue(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#remove(Long)}.
   *
   * <ul>
   *   <li>Given {@link DeleteConditionStep} {@link DeleteConditionStep#execute()} return zero.
   *   <li>Then calls {@link DSLContext#deleteFrom(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#remove(Long)}
   */
  @Test
  @DisplayName(
      "Test remove(Long); given DeleteConditionStep execute() return zero; then calls deleteFrom(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CustomEnvironmentUsageDao.remove(Long)"})
  void testRemove_givenDeleteConditionStepExecuteReturnZero_thenCallsDeleteFrom()
      throws DataAccessException {
    // Arrange
    DeleteConditionStep<CustomEnvironmentUsageRecord> deleteConditionStep =
        mock(DeleteConditionStep.class);
    when(deleteConditionStep.execute()).thenReturn(0);

    DeleteUsingStep<CustomEnvironmentUsageRecord> deleteUsingStep = mock(DeleteUsingStep.class);
    when(deleteUsingStep.where(Mockito.<Condition>any())).thenReturn(deleteConditionStep);
    when(dSLContext.deleteFrom(Mockito.<Table<CustomEnvironmentUsageRecord>>any()))
        .thenReturn(deleteUsingStep);

    // Act
    boolean actualRemoveResult = customEnvironmentUsageDao.remove(1L);

    // Assert
    verify(dSLContext).deleteFrom(isA(Table.class));
    verify(deleteUsingStep).where(isA(Condition.class));
    verify(deleteConditionStep).execute();
    assertFalse(actualRemoveResult);
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#addAsset(CustomEnvironmentUsage, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#addAsset(CustomEnvironmentUsage,
   * String)}
   */
  @Test
  @DisplayName("Test addAsset(CustomEnvironmentUsage, String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long CustomEnvironmentUsageDao.addAsset(CustomEnvironmentUsage, String)"})
  void testAddAsset_thenReturnNull() throws DataAccessException {
    // Arrange
    InsertResultStep<CustomEnvironmentUsageRecord> insertResultStep = mock(InsertResultStep.class);
    when(insertResultStep.fetchOne()).thenReturn(new CustomEnvironmentUsageRecord());

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.returning((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(insertResultStep);

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep2 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep3 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep4 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep5 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep5.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    InsertSetMoreStep<CustomEnvironmentUsageRecord> insertSetMoreStep6 =
        mock(InsertSetMoreStep.class);
    when(insertSetMoreStep6.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep5);

    InsertSetStep<CustomEnvironmentUsageRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep6);
    when(dSLContext.insertInto(Mockito.<Table<CustomEnvironmentUsageRecord>>any()))
        .thenReturn(insertSetStep);

    Builder customEnvironmentIdResult =
        ImmutableCustomEnvironmentUsage.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .createdBy("Jan 1, 2020 8:00am GMT+0100")
            .customEnvironmentId(1L);

    // Act
    Long actualAddAssetResult =
        customEnvironmentUsageDao.addAsset(
            customEnvironmentIdResult
                .entityReference(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .id(1L)
                .provenance("Provenance")
                .build(),
            "janedoe");

    // Assert
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertResultStep).fetchOne();
    verify(insertSetMoreStep).returning((SelectFieldOrAsterisk[]) Mockito.any());
    verify(insertSetMoreStep6).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep5).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    assertNull(actualAddAssetResult);
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#findByEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CustomEnvironmentUsageDao#findByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findByEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentUsageDao.findByEntityRef(EntityReference)"})
  void testFindByEntityRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    Set<CustomEnvironmentUsage> actualFindByEntityRefResult =
        customEnvironmentUsageDao.findByEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityRefResult.isEmpty());
  }

  /**
   * Test {@link CustomEnvironmentUsageDao#findUsageInfoByOwningRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * CustomEnvironmentUsageDao#findUsageInfoByOwningRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findUsageInfoByOwningRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set CustomEnvironmentUsageDao.findUsageInfoByOwningRef(EntityReference)"})
  void testFindUsageInfoByOwningRef_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

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

    SelectOnConditionStep<Record> selectOnConditionStep4 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep3);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep4 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep4.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep4);

    SelectOnConditionStep<Record> selectOnConditionStep5 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep5.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep4);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep5 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep5.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep5);

    SelectOnConditionStep<Record> selectOnConditionStep6 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep6.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep5);

    SelectJoinPartitionByStep<Record> selectJoinPartitionByStep6 =
        mock(SelectJoinPartitionByStep.class);
    when(selectJoinPartitionByStep6.on(Mockito.<Condition>any()))
        .thenReturn(selectOnConditionStep6);

    SelectOnConditionStep<Record> selectOnConditionStep7 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep7.leftJoin(Mockito.<TableLike<?>>any()))
        .thenReturn(selectJoinPartitionByStep6);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep7);

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
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep5);

    // Act
    Set<CustomEnvironmentUsageInfo> actualFindUsageInfoByOwningRefResult =
        customEnvironmentUsageDao.findUsageInfoByOwningRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep7).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep6).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep5).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep4).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).leftJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).leftJoin(isA(TableLike.class));
    verify(selectJoinPartitionByStep6).on(isA(Condition.class));
    verify(selectJoinPartitionByStep5).on(isA(Condition.class));
    verify(selectJoinPartitionByStep4).on(isA(Condition.class));
    verify(selectJoinPartitionByStep3).on(isA(Condition.class));
    verify(selectJoinPartitionByStep2).on(isA(Condition.class));
    verify(selectJoinPartitionByStep).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep2).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindUsageInfoByOwningRefResult.isEmpty());
  }
}
