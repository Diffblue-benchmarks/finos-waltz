package org.finos.waltz.data.access_log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.accesslog.AccessLog;
import org.finos.waltz.model.accesslog.AccessTime;
import org.finos.waltz.model.accesslog.ImmutableAccessLog;
import org.finos.waltz.schema.tables.records.AccessLogRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.GroupField;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.jooq.OrderField;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectLimitPercentStep;
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
class AccessLogDaoDiffblueTest {
  @InjectMocks private AccessLogDao accessLogDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link AccessLogDao#AccessLogDao(DSLContext)} with dsl is {@link DSLContext}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given AccessLogDao(DSLContext) with dsl is DSLContext; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenAccessLogDaoWithDslIsDSLContext_thenReturnOne() throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetStep<AccessLogRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.insertInto(Mockito.<Table<AccessLogRecord>>any())).thenReturn(insertSetStep);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);

    // Act
    int actualWriteResult =
        accessLogDao.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(dsl).insertInto(isA(Table.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenDefaultDSLContextWithConnectionAndDialectIsCubrid_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);

    // Act
    int actualWriteResult =
        accessLogDao.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"access_log\" (\"params\", \"state\", \"user_id\", \"created_at\") values (cast(? as varchar), cast(? as varchar), cast(? as varchar), cast(? as datetime))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenDefaultDSLContextWithConnectionAndDialectIsFirebird() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);

    // Act
    int actualWriteResult =
        accessLogDao.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"access_log\" (\"params\", \"state\", \"user_id\", \"created_at\") values (cast(? as varchar(6)), cast(? as varchar(2)), cast(? as varchar(2)), cast(? as timestamp))");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQL99}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQL99'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenDefaultDSLContextWithConnectionAndDialectIsSql99_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);

    // Act
    int actualWriteResult =
        accessLogDao.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"access_log\" (\"params\", \"state\", \"user_id\", \"created_at\") values (?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@code Params}.
   *   <li>When {@link AccessLog} {@link AccessLog#params()} return {@code Params}.
   *   <li>Then calls {@link AccessLog#createdAt()}.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given 'Params'; when AccessLog params() return 'Params'; then calls createdAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenParams_whenAccessLogParamsReturnParams_thenCallsCreatedAt()
      throws DataAccessException {
    // Arrange
    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep.execute()).thenReturn(1);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep2 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep2.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep3 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep3.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep2);

    InsertSetMoreStep<AccessLogRecord> insertSetMoreStep4 = mock(InsertSetMoreStep.class);
    when(insertSetMoreStep4.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep3);

    InsertSetStep<AccessLogRecord> insertSetStep = mock(InsertSetStep.class);
    when(insertSetStep.set(Mockito.<Field<Object>>any(), Mockito.<Object>any()))
        .thenReturn(insertSetMoreStep4);
    when(dSLContext.insertInto(Mockito.<Table<AccessLogRecord>>any())).thenReturn(insertSetStep);

    AccessLog logEntry = mock(AccessLog.class);
    when(logEntry.params()).thenReturn("Params");
    when(logEntry.state()).thenReturn("MD");
    when(logEntry.userId()).thenReturn("42");
    when(logEntry.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Act
    int actualWriteResult = accessLogDao.write(logEntry);

    // Assert
    verify(logEntry).createdAt();
    verify(logEntry).params();
    verify(logEntry).state();
    verify(logEntry).userId();
    verify(dSLContext).insertInto(isA(Table.class));
    verify(insertSetMoreStep4).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep3).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep2).set(isA(Field.class), isA(Object.class));
    verify(insertSetStep).set(isA(Field.class), isA(Object.class));
    verify(insertSetMoreStep).execute();
    assertEquals(1, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#write(AccessLog)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AccessLogDao#write(AccessLog)}
   */
  @Test
  @DisplayName(
      "Test write(AccessLog); given PreparedStatement getWarnings() return 'null'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int AccessLogDao.write(AccessLog)"})
  void testWrite_givenPreparedStatementGetWarningsReturnNull_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).setTimestamp(anyInt(), Mockito.<Timestamp>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);

    // Act
    int actualWriteResult =
        accessLogDao.write(
            ImmutableAccessLog.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .params("Params")
                .state("MD")
                .userId("42")
                .build());

    // Assert
    verify(connection)
        .prepareStatement(
            "insert into \"access_log\" (\"params\", \"state\", \"user_id\", \"created_at\") values (?, ?, ?, ?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).setTimestamp(eq(4), isA(Timestamp.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualWriteResult);
  }

  /**
   * Test {@link AccessLogDao#findForUserId(String, Optional)}.
   *
   * <p>Method under test: {@link AccessLogDao#findForUserId(String, Optional)}
   */
  @Test
  @DisplayName("Test findForUserId(String, Optional)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AccessLogDao.findForUserId(String, Optional)"})
  void testFindForUserId() throws DataAccessException {
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

    DSLContext dsl = mock(DSLContext.class);
    when(dsl.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep);
    AccessLogDao accessLogDao = new AccessLogDao(dsl);
    Optional<Integer> limit = Optional.of(42);

    // Act
    List<AccessLog> actualFindForUserIdResult = accessLogDao.findForUserId("42", limit);

    // Assert
    verify(dsl).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectLimitPercentStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectSeekStep1).limit(isA(Number.class));
    verify(selectConditionStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindForUserIdResult.isEmpty());
  }

  /**
   * Test {@link AccessLogDao#findActiveUsersSince(LocalDateTime)}.
   *
   * <p>Method under test: {@link AccessLogDao#findActiveUsersSince(LocalDateTime)}
   */
  @Test
  @DisplayName("Test findActiveUsersSince(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List AccessLogDao.findActiveUsersSince(LocalDateTime)"})
  void testFindActiveUsersSince() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record2<Object, Object>, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<AccessTime> actualFindActiveUsersSinceResult =
        accessLogDao.findActiveUsersSince(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectHavingStep).orderBy(isA(OrderField.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindActiveUsersSinceResult.isEmpty());
  }
}
