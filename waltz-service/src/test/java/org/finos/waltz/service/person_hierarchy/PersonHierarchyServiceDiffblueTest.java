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
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Select;
import org.jooq.Table;
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
class PersonHierarchyServiceDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private PersonHierarchyService personHierarchyService;

  /**
   * Test {@link PersonHierarchyService#count()}.
   *
   * <ul>
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Table)} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName("Test count(); given DSLContext fetchCount(Table) return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDSLContextFetchCountReturnThree_thenReturnThree() throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Table<?>>any())).thenReturn(3);

    // Act
    int actualCountResult = personHierarchyService.count();

    // Assert
    verify(dSLContext).fetchCount(isA(Table.class));
    assertEquals(3, actualCountResult);
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
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultDSLContextWithConnectionAndDialectIsSqlite_thenReturnZero()
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
   *   <li>Given {@link DefaultResultSet} {@link DefaultResultSet#wasNull()} return {@code false}.
   *   <li>Then calls {@link DefaultResultSet#getInt(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName(
      "Test count(); given DefaultResultSet wasNull() return 'false'; then calls getInt(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenDefaultResultSetWasNullReturnFalse_thenCallsGetInt() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.wasNull()).thenReturn(false);
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
   *   <li>Given {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  @DisplayName("Test count(); given 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonHierarchyService.count()"})
  void testCount_givenTrue_thenReturnZero() throws SQLException {
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
   *   <li>Given {@link DSLContext} {@link DSLContext#fetchCount(Select)} return three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DSLContext fetchCount(Select) return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDSLContextFetchCountReturnThree_thenReturnThree()
      throws DataAccessException {
    // Arrange
    when(dSLContext.fetchCount(Mockito.<Select<?>>any())).thenReturn(3);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(dSLContext).fetchCount(isA(Select.class));
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
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code SQLITE}.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'SQLITE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultDSLContextWithConnectionAndDialectIsSqlite() throws SQLException {
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
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQLITE);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(mock(PersonDao.class), dsl);

    // Act
    double actualCountRootsResult = personHierarchyService.countRoots();

    // Assert
    verify(connection)
        .prepareStatement(
            "select count(*) as c from (select distinct person_hierarchy.manager_id from person_hierarchy where person_hierarchy.level = ?) as q");
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
   *   <li>Given {@link DefaultResultSet} {@link DefaultResultSet#wasNull()} return {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  @DisplayName(
      "Test countRoots(); given DefaultResultSet wasNull() return 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double PersonHierarchyService.countRoots()"})
  void testCountRoots_givenDefaultResultSetWasNullReturnFalse_thenReturnZero() throws SQLException {
    // Arrange
    DefaultResultSet defaultResultSet = mock(DefaultResultSet.class);
    when(defaultResultSet.wasNull()).thenReturn(false);
    when(defaultResultSet.getInt(anyInt())).thenReturn(0);
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
    verify(defaultResultSet).close();
    verify(defaultResultSet).getInt(1);
    verify(defaultResultSet).getMetaData();
    verify(defaultResultSet, atLeast(1)).next();
    verify(defaultResultSet).wasNull();
    assertEquals(0.0d, actualCountRootsResult);
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
}
