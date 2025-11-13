package org.finos.waltz.service.person_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import javax.sql.rowset.RowSetMetaDataImpl;
import org.finos.waltz.data.person.PersonDao;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.tools.jdbc.DefaultResultSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonHierarchyServiceDiffblueTest {
  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#fetchCount(Table)} return three.
   *   <li>Then calls {@link DefaultDSLContext#fetchCount(Table)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultDSLContext fetchCount(Table) return three; then calls fetchCount(Table)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultDSLContextFetchCountReturnThree_thenCallsFetchCount() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchCount(Mockito.<Table<?>>any())).thenReturn(3);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(dsl).fetchCount(isA(Table.class));
    assertEquals(3, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultDSLContextWithConnectionAndDialectIsMariadb_thenCallsClose()
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
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from `person_hierarchy`");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultDSLContextWithConnectionAndDialectIsPostgres() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultDSLContextWithConnectionAndDialectIsSqlite_thenCallsClose()
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
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from person_hierarchy");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DefaultResultSet} {@link DefaultResultSet#wasNull()} return {@code true}.
   *   <li>Then calls {@link DefaultResultSet#getInt(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultResultSet wasNull() return 'true'; then calls getInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultResultSetWasNullReturnTrue_thenCallsGetInt() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.wasNull()).thenReturn(true);
    when(defaultResultSet.getInt(anyInt())).thenReturn(0);
    when(defaultResultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getInt(1);
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet, atLeast(1)).next();
    verify(defaultResultSet).wasNull();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given PreparedStatement getResultSet() return 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenPreparedStatementGetResultSetReturnNull_thenReturnMinusOne()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given PreparedStatement getUpdateCount() return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenPreparedStatementGetUpdateCountReturnThree_thenReturnThree()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   *   <li>Then calls {@link PreparedStatement#getUpdateCount()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given PreparedStatement getUpdateCount() return zero; then calls getUpdateCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenPreparedStatementGetUpdateCountReturnZero_thenCallsGetUpdateCount()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given PreparedStatement getWarnings() return 'null'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenPreparedStatementGetWarningsReturnNull_thenCallsClose() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link DefaultResultSet#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName("Test count(); given 'true'; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenTrue_thenCallsClose() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(connection).prepareStatement("select count(*) from \"person_hierarchy\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet).next();
    assertEquals(0, actualCountResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext} {@link DefaultDSLContext#fetchCount(Select)} return
   *       three.
   *   <li>Then calls {@link DefaultDSLContext#fetchCount(Select)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultDSLContext fetchCount(Select) return three; then calls fetchCount(Select)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultDSLContextFetchCountReturnThree_thenCallsFetchCount() {
    // Arrange
    DefaultDSLContext dsl = mock(DefaultDSLContext.class);
    when(dsl.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(dsl).fetchCount(isA(Select.class));
    assertEquals(3.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code CUBRID}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'CUBRID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultDSLContextWithConnectionAndDialectIsCubrid() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.CUBRID);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = cast(? as int)) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code MARIADB}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'MARIADB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultDSLContextWithConnectionAndDialectIsMariadb()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.getInt(anyInt())).thenReturn(1);
    when(defaultResultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.MARIADB);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) as `c` from (select distinct `person_hierarchy`.`manager_id` from `person_hierarchy` where `person_hierarchy`.`level` = ?) as `q`");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getInt(1);
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet, atLeast(1)).next();
    assertEquals(1.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code POSTGRES}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'POSTGRES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultDSLContextWithConnectionAndDialectIsPostgres()
      throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.getInt(anyInt())).thenReturn(1);
    when(defaultResultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(defaultResultSet.getMetaData()).thenReturn(new RowSetMetaDataImpl());
    doNothing().when(defaultResultSet).close();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(defaultResultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.POSTGRES);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) as \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) as \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(defaultResultSet).close();
    verify(defaultResultSet).getInt(1);
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet, atLeast(1)).next();
    assertEquals(1.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@code
   *       null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given PreparedStatement getResultSet() return 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenPreparedStatementGetResultSetReturnNull_thenReturnMinusOne()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(null);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(-1.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given PreparedStatement getUpdateCount() return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenPreparedStatementGetUpdateCountReturnThree_thenReturnThree()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getUpdateCount()} return zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given PreparedStatement getUpdateCount() return zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenPreparedStatementGetUpdateCountReturnZero_thenReturnZero()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(0);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(0.0d, actualCountRootsResult);
  }

  /**
   * Test {@link PersonHierarchyService#countRoots()}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getWarnings()} return {@code
   *       null}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given PreparedStatement getWarnings() return 'null'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenPreparedStatementGetWarningsReturnNull_thenReturnThree()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(null);
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\"");
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(1, 1);
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3.0d, actualCountRootsResult);
  }
}
