package org.finos.waltz.service.person_hierarchy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.data.person.PersonDao;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonHierarchyServiceDiffblueTest {
  /**
   * Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  void testCount() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCountResult = (new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99))).count();

    // Assert
    verify(connection).prepareStatement(eq("select count(*) from \"person_hierarchy\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(0, actualCountResult);
  }

  /**
   * Method under test: {@link PersonHierarchyService#count()}
   */
  @Test
  void testCount2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    int actualCountResult = (new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99))).count();

    // Assert
    verify(connection).prepareStatement(eq("select count(*) from \"person_hierarchy\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3, actualCountResult);
  }

  /**
   * Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  void testCountRoots() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getInt(anyInt())).thenReturn(1);
    when(resultSet.next()).thenReturn(true).thenReturn(false).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    double actualCountRootsResult = (new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countRoots();

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(resultSet).close();
    verify(resultSet).getInt(eq(1));
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(1.0d, actualCountRootsResult);
  }

  /**
   * Method under test: {@link PersonHierarchyService#countRoots()}
   */
  @Test
  void testCountRoots2() throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(false);
    when(preparedStatement.getUpdateCount()).thenReturn(3);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    double actualCountRootsResult = (new PersonHierarchyService(mock(PersonDao.class),
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countRoots();

    // Assert
    verify(connection).prepareStatement(eq(
        "select count(*) \"c\" from (select distinct \"person_hierarchy\".\"manager_id\" from \"person_hierarchy\" where \"person_hierarchy\".\"level\" = ?) \"q\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setInt(eq(1), eq(1));
    verify(preparedStatement).close();
    verify(preparedStatement).getUpdateCount();
    verify(preparedStatement).getWarnings();
    assertEquals(3.0d, actualCountRootsResult);
  }
}
