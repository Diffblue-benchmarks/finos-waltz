package org.finos.waltz.data.allocation;

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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.allocation.Allocation;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange;
import org.finos.waltz.model.allocation.ImmutableMeasurablePercentageChange.Builder;
import org.finos.waltz.model.allocation.ImmutableMeasurableRatingPercentage;
import org.finos.waltz.model.allocation.MeasurablePercentageChange;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSelectStep;
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
class AllocationDaoDiffblueTest {
  @InjectMocks private AllocationDao allocationDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AllocationDao#findByEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Given {@link SelectConditionStep} {@link SelectConditionStep#fetch(RecordMapper)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#findByEntity(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test findByEntity(EntityReference); given SelectConditionStep fetch(RecordMapper) return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationDao.findByEntity(EntityReference)"})
  void testFindByEntity_givenSelectConditionStepFetchReturnArrayList_thenReturnEmpty()
      throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Allocation> actualFindByEntityResult =
        allocationDao.findByEntity(
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
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityResult.isEmpty());
  }

  /**
   * Test {@link AllocationDao#findByEntityAndScheme(EntityReference, long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#findByEntityAndScheme(EntityReference, long)}
   */
  @Test
  @DisplayName("Test findByEntityAndScheme(EntityReference, long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationDao.findByEntityAndScheme(EntityReference, long)"})
  void testFindByEntityAndScheme_thenReturnEmpty() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.and(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Allocation> actualFindByEntityAndSchemeResult =
        allocationDao.findByEntityAndScheme(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep3).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByEntityAndSchemeResult.isEmpty());
  }

  /**
   * Test {@link AllocationDao#findByMeasurableIdAndScheme(long, long)}.
   *
   * <p>Method under test: {@link AllocationDao#findByMeasurableIdAndScheme(long, long)}
   */
  @Test
  @DisplayName("Test findByMeasurableIdAndScheme(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AllocationDao.findByMeasurableIdAndScheme(long, long)"})
  void testFindByMeasurableIdAndScheme() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record> selectConditionStep = mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectConditionStep<Record> selectConditionStep2 = mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectJoinStep<Record> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectSelectStep<Record> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);

    // Act
    List<Allocation> actualFindByMeasurableIdAndSchemeResult =
        allocationDao.findByMeasurableIdAndScheme(1L, 1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindByMeasurableIdAndSchemeResult.isEmpty());
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transaction(TransactionalRunnable)} does
   *       nothing.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); given DSLContext transaction(TransactionalRunnable) does nothing; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_givenDSLContextTransactionDoesNothing_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#transaction(TransactionalRunnable)} does
   *       nothing.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); given DSLContext transaction(TransactionalRunnable) does nothing; then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_givenDSLContextTransactionDoesNothing_thenCallsTransaction2() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_thenCallsPrepareStatement() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AllocationDao allocationDao = new AllocationDao(dsl);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection, atLeast(1)).createStatement();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "insert into \"allocation\" (\"allocation_scheme_id\", \"allocation_percentage\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"measurable_rating_id\") values (?, ?, ?, ?, ?, ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).setInt(2, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(3), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(statement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(statement, atLeast(1)).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(statement, atLeast(1)).getWarnings();
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>Then calls {@link Connection#prepareStatement(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); then calls prepareStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_thenCallsPrepareStatement2() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AllocationDao allocationDao = new AllocationDao(dsl);

    ArrayList<MeasurablePercentageChange> changes = new ArrayList<>();

    Builder builderResult = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    Builder builderResult2 = ImmutableMeasurablePercentageChange.builder();
    changes.add(
        builderResult2
            .measurablePercentage(
                ImmutableMeasurableRatingPercentage.builder()
                    .measurableRatingId(1L)
                    .percentage(1)
                    .build())
            .operation(Operation.ADD)
            .previousPercentage(1)
            .build());

    // Act
    Boolean actualUpdateAllocationsResult = allocationDao.updateAllocations(1L, changes, "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection, atLeast(1)).createStatement();
    verify(connection).getAutoCommit();
    verify(connection)
        .prepareStatement(
            "insert into \"allocation\" (\"allocation_scheme_id\", \"allocation_percentage\", \"last_updated_at\", \"last_updated_by\", \"provenance\", \"measurable_rating_id\") values (?, ?, ?, ?, ?, ?)");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement, atLeast(1)).addBatch();
    verify(preparedStatement, atLeast(1)).setInt(2, 1);
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).setTimestamp(eq(3), Mockito.<Timestamp>any());
    verify(preparedStatement).close();
    verify(statement, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(statement, atLeast(1)).executeBatch();
    verify(preparedStatement).getWarnings();
    verify(statement, atLeast(1)).getWarnings();
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link Connection#commit()}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); when ArrayList(); then calls commit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_whenArrayList_thenCallsCommit() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    when(statement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(statement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.createStatement()).thenReturn(statement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AllocationDao allocationDao = new AllocationDao(dsl);

    // Act
    Boolean actualUpdateAllocationsResult =
        allocationDao.updateAllocations(1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(connection).commit();
    verify(connection, atLeast(1)).createStatement();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(statement, atLeast(1)).close();
    verify(statement, atLeast(1)).executeBatch();
    verify(statement, atLeast(1)).getWarnings();
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#updateAllocations(long, Collection, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link DSLContext#transaction(TransactionalRunnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AllocationDao#updateAllocations(long, Collection, String)}
   */
  @Test
  @DisplayName(
      "Test updateAllocations(long, Collection, String); when ArrayList(); then calls transaction(TransactionalRunnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean AllocationDao.updateAllocations(long, Collection, String)"})
  void testUpdateAllocations_whenArrayList_thenCallsTransaction() {
    // Arrange
    doNothing().when(dSLContext).transaction(Mockito.<TransactionalRunnable>any());

    // Act
    Boolean actualUpdateAllocationsResult =
        allocationDao.updateAllocations(1L, new ArrayList<>(), "janedoe");

    // Assert
    verify(dSLContext).transaction(isA(TransactionalRunnable.class));
    assertTrue(actualUpdateAllocationsResult);
  }

  /**
   * Test {@link AllocationDao#findByMeasurableRatingId(long)}.
   *
   * <p>Method under test: {@link AllocationDao#findByMeasurableRatingId(long)}
   */
  @Test
  @DisplayName("Test findByMeasurableRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set AllocationDao.findByMeasurableRatingId(long)"})
  void testFindByMeasurableRatingId() throws DataAccessException {
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
    Set<Allocation> actualFindByMeasurableRatingIdResult =
        allocationDao.findByMeasurableRatingId(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep).fetchSet(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindByMeasurableRatingIdResult.isEmpty());
  }
}
