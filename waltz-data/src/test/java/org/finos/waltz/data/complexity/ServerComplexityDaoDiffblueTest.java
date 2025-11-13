package org.finos.waltz.data.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.GroupField;
import org.jooq.OrderField;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectSeekStep1;
import org.jooq.SelectSelectStep;
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
class ServerComplexityDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private ServerComplexityDao serverComplexityDao;

  /**
   * Test {@link ServerComplexityDao#findCountsByAssetCodes(String[])} with {@code assetCodes}.
   *
   * <p>Method under test: {@link ServerComplexityDao#findCountsByAssetCodes(String[])}
   */
  @Test
  @DisplayName("Test findCountsByAssetCodes(String[]) with 'assetCodes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerComplexityDao.findCountsByAssetCodes(String[])"})
  void testFindCountsByAssetCodesWithAssetCodes() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record2<Object, Object>, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<String>> actualFindCountsByAssetCodesResult =
        serverComplexityDao.findCountsByAssetCodes("Asset Codes");

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectHavingStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindCountsByAssetCodesResult.isEmpty());
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = cast(? as varchar)) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = cast(? as varchar(11))) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); given PreparedStatement getWarnings() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenPreparedStatementGetWarningsReturnNull() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link SelectJoinStep} {@link SelectJoinStep#fetchOne(RecordMapper)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given SelectJoinStep fetchOne(RecordMapper) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenSelectJoinStepFetchOneReturnOne_thenReturnOne()
      throws DataAccessException {
    // Arrange
    SelectJoinStep<Record1<Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchOne(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(1);

    SelectSelectStep<Record1<Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(selectJoinStep).fetchOne(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(dsl).select(isA(SelectField.class));
    assertEquals(1, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_thenReturnMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_thenReturnThree() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ServerComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ServerComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_thenReturnZero() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ServerComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(\"server_count\") from (select \"server_usage\".\"entity_id\", count(*) \"server_count\" from \"server_usage\" where (1 = 1 and \"server_usage\".\"entity_kind\" = ?) group by \"server_usage\".\"entity_id\") \"alias_51382369\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(1, "APPLICATION");
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ServerComplexityDao#findCounts()}.
   *
   * <p>Method under test: {@link ServerComplexityDao#findCounts()}
   */
  @Test
  @DisplayName("Test findCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ServerComplexityDao.findCounts()"})
  void testFindCounts() throws DataAccessException {
    // Arrange
    SelectSeekStep1<Record2<Object, Object>, Object> selectSeekStep1 = mock(SelectSeekStep1.class);
    when(selectSeekStep1.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.orderBy(Mockito.<OrderField<Object>>any())).thenReturn(selectSeekStep1);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep2 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record2<Object, Object>> selectOnConditionStep3 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record2<Object, Object>> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<String>> actualFindCountsResult = serverComplexityDao.findCounts();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectSeekStep1).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).and(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectHavingStep).orderBy(isA(OrderField.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindCountsResult.isEmpty());
  }
}
