package org.finos.waltz.data.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.RowSetMetaDataImpl;
import org.finos.waltz.model.tally.Tally;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.SQLDialect;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.tools.jdbc.DefaultResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ConnectionComplexityDaoDiffblueTest {
  @InjectMocks private ConnectionComplexityDao connectionComplexityDao;

  @Mock private DSLContext dSLContext;

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline(Long)} with {@code appIds}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline(Long)}
   */
  @Test
  @DisplayName("Test calculateBaseline(Long) with 'appIds'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline(Long)"})
  void testCalculateBaselineWithAppIds_thenReturnMinusOne() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline(1L);

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where app_id in (?)");
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(7, 1L);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenDefaultDSLContextWithConnectionAndDialectIsCubrid()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar) and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar)) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar) and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar)) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DERBY}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DERBY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenDefaultDSLContextWithConnectionAndDialectIsDerby()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DERBY);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) as \"total_connections\" from (select \"app_id\", \"connection_count\" from (select \"logical_flow\".\"source_entity_id\" as \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") as \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar(32672)) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar(32672)) and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar(32672))) group by \"logical_flow\".\"source_entity_id\") x union all select \"app_id\", \"connection_count\" from (select \"logical_flow\".\"target_entity_id\" as \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") as \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar(32672)) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar(32672)) and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar(32672))) group by \"logical_flow\".\"target_entity_id\") x) as \"alias_18910030\" group by app_id) as \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code FIREBIRD}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'FIREBIRD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenDefaultDSLContextWithConnectionAndDialectIsFirebird()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.FIREBIRD);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar(11)) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar(11)) and \"logical_flow\".\"is_removed\" = 0 and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar(7))) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = cast(? as varchar(11)) and \"logical_flow\".\"target_entity_kind\" = cast(? as varchar(11)) and \"logical_flow\".\"is_removed\" = 0 and \"logical_flow\".\"entity_lifecycle_status\" <> cast(? as varchar(7))) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); given PreparedStatement getUpdateCount() return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenPreparedStatementGetUpdateCountReturnZero() throws SQLException {
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
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName(
      "Test calculateBaseline(); given PreparedStatement getWarnings() return 'null'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenPreparedStatementGetWarningsReturnNull_thenCallsClose()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); given 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
  void testCalculateBaseline_givenTrue_thenCallsClose() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    // Act
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
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
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#calculateBaseline()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConnectionComplexityDao#calculateBaseline()}
   */
  @Test
  @DisplayName("Test calculateBaseline(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConnectionComplexityDao.calculateBaseline()"})
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
    int actualCalculateBaselineResult = new ConnectionComplexityDao(dsl).calculateBaseline();

    // Assert
    verify(connection)
        .prepareStatement(
            "select max(total_connections) from (select app_id, sum(connection_count) \"total_connections\" from (select \"logical_flow\".\"source_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"target_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"source_entity_id\" union all select \"logical_flow\".\"target_entity_id\" \"app_id\", count(distinct \"logical_flow\".\"source_entity_id\") \"connection_count\" from \"logical_flow\" where (\"logical_flow\".\"source_entity_kind\" = ? and \"logical_flow\".\"target_entity_kind\" = ? and \"logical_flow\".\"is_removed\" = false and \"logical_flow\".\"entity_lifecycle_status\" <> ?) group by \"logical_flow\".\"target_entity_id\") \"alias_18910030\" group by app_id) \"alias_60083616\" where 1 = 1");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCalculateBaselineResult);
  }

  /**
   * Test {@link ConnectionComplexityDao#findCounts()}.
   *
   * <p>Method under test: {@link ConnectionComplexityDao#findCounts()}
   */
  @Test
  @DisplayName("Test findCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConnectionComplexityDao.findCounts()"})
  void testFindCounts() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<Long>> actualFindCountsResult = connectionComplexityDao.findCounts();

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindCountsResult.isEmpty());
  }

  /**
   * Test {@link ConnectionComplexityDao#findCounts(Long[])} with {@code appIds}.
   *
   * <p>Method under test: {@link ConnectionComplexityDao#findCounts(Long[])}
   */
  @Test
  @DisplayName("Test findCounts(Long[]) with 'appIds'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List ConnectionComplexityDao.findCounts(Long[])"})
  void testFindCountsWithAppIds() throws DataAccessException {
    // Arrange
    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.fetch(Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new ArrayList<>());

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    List<Tally<Long>> actualFindCountsResult = connectionComplexityDao.findCounts(1L);

    // Assert
    verify(dSLContext).select(isA(SelectField.class), isA(SelectField.class));
    verify(selectConditionStep).fetch(isA(RecordMapper.class));
    verify(selectSelectStep).from(isA(TableLike.class));
    verify(selectJoinStep).where(isA(Condition.class));
    assertTrue(actualFindCountsResult.isEmpty());
  }
}
