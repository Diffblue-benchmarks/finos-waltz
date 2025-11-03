package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import org.finos.waltz.model.person.Person;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonDaoDiffblueTest {
  /**
   * Test {@link PersonDao#getByEmployeeId(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonDao#getByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test getByEmployeeId(String); given ResultSet next() return 'false'; when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person PersonDao.getByEmployeeId(String)"})
  void testGetByEmployeeId_givenResultSetNextReturnFalse_when42_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Person actualByEmployeeId = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByEmployeeId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where \"person\".\"employee_id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByEmployeeId);
  }

  /**
   * Test {@link PersonDao#getById(long)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person PersonDao.getById(long)"})
  void testGetById_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Person actualById = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).getById(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where \"person\".\"id\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualById);
  }

  /**
   * Test {@link PersonDao#getByUserEmail(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonDao#getByUserEmail(String)}
   */
  @Test
  @DisplayName("Test getByUserEmail(String); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person PersonDao.getByUserEmail(String)"})
  void testGetByUserEmail_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Person actualByUserEmail = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getByUserEmail("jane.doe@example.org");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where \"person\".\"email\" = ? order by \"person\".\"is_removed\" limit ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(2), eq(1L));
    verify(preparedStatement).setString(eq(1), eq("jane.doe@example.org"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualByUserEmail);
  }

  /**
   * Test {@link PersonDao#getActiveByUserEmail(String)}.
   * <ul>
   *   <li>Given {@link ResultSet} {@link ResultSet#next()} return {@code false}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PersonDao#getActiveByUserEmail(String)}
   */
  @Test
  @DisplayName("Test getActiveByUserEmail(String); given ResultSet next() return 'false'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Person PersonDao.getActiveByUserEmail(String)"})
  void testGetActiveByUserEmail_givenResultSetNextReturnFalse_thenReturnNull() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    Person actualActiveByUserEmail = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .getActiveByUserEmail("jane.doe@example.org");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where (\"person\".\"email\" = ? and not(\"person\".\"is_removed\"))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("jane.doe@example.org"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertNull(actualActiveByUserEmail);
  }
}
