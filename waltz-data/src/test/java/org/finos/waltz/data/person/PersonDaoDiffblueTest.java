package org.finos.waltz.data.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonDaoDiffblueTest {
  /**
   * Method under test: {@link PersonDao#getByEmployeeId(String)}
   */
  @Test
  void testGetByEmployeeId() throws SQLException {
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
   * Method under test: {@link PersonDao#getById(long)}
   */
  @Test
  void testGetById() throws SQLException {
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
   * Method under test: {@link PersonDao#getByUserEmail(String)}
   */
  @Test
  void testGetByUserEmail() throws SQLException {
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
   * Method under test: {@link PersonDao#findAllEmails()}
   */
  @Test
  void testFindAllEmails() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.getString(anyInt())).thenReturn("String");
    when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
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
    List<String> actualFindAllEmailsResult = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99)))
        .findAllEmails();

    // Assert
    verify(connection).prepareStatement(eq("select \"person\".\"email\" from \"person\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet, atLeast(1)).getString(eq(1));
    verify(resultSet, atLeast(1)).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertEquals(2, actualFindAllEmailsResult.size());
    assertEquals("String", actualFindAllEmailsResult.get(0));
    assertEquals("String", actualFindAllEmailsResult.get(1));
  }

  /**
   * Method under test: {@link PersonDao#getActiveByUserEmail(String)}
   */
  @Test
  void testGetActiveByUserEmail() throws SQLException {
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

  /**
   * Method under test: {@link PersonDao#findDirectsByEmployeeId(String)}
   */
  @Test
  void testFindDirectsByEmployeeId() throws SQLException {
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
    List<Person> actualFindDirectsByEmployeeIdResult = (new PersonDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findDirectsByEmployeeId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where ((\"person\".\"manager_employee_id\" = '42') and not(\"person\".\"is_removed\")) order by \"person\".\"display_name\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindDirectsByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findAllManagersByEmployeeId(String)}
   */
  @Test
  void testFindAllManagersByEmployeeId() throws SQLException {
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
    List<Person> actualFindAllManagersByEmployeeIdResult = (new PersonDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findAllManagersByEmployeeId("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" join \"person_hierarchy\" on \"person\".\"employee_id\" = \"person_hierarchy\".\"manager_id\" where (\"person_hierarchy\".\"employee_id\" = ? and not(\"person\".\"is_removed\")) order by \"person_hierarchy\".\"level\" desc"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindAllManagersByEmployeeIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#all()}
   */
  @Test
  void testAll() throws SQLException {
    // Arrange
    ResultSet resultSet = mock(ResultSet.class);
    when(resultSet.next()).thenReturn(false).thenReturn(true).thenReturn(false);
    when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
    doNothing().when(resultSet).close();
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.getResultSet()).thenReturn(resultSet);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setBoolean(anyInt(), anyBoolean());
    doNothing().when(preparedStatement).close();
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    // Act
    List<Person> actualAllResult = (new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99))).all();

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where \"person\".\"is_removed\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setBoolean(eq(1), eq(false));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualAllResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#bulkSave(List)}
   */
  @Test
  void testBulkSave() {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, personDao.bulkSave(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link PersonDao#bulkSave(List)}
   */
  @Test
  void testBulkSave2() {
    // Arrange
    PersonDao personDao = new PersonDao(new DefaultDSLContext(mock(Connection.class), SQLDialect.SQL99));

    // Act and Assert
    assertEquals(0, personDao.bulkSave(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link PersonDao#findPersonsByAttestationInstanceId(long)}
   */
  @Test
  void testFindPersonsByAttestationInstanceId() throws SQLException {
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
    List<Person> actualFindPersonsByAttestationInstanceIdResult = (new PersonDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findPersonsByAttestationInstanceId(1L);

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"attestation_instance_recipient\" join \"person\" on \"attestation_instance_recipient\".\"user_id\" = \"person\".\"email\" where (\"attestation_instance_recipient\".\"attestation_instance_id\" = ? and not(\"person\".\"is_removed\"))"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setLong(eq(1), eq(1L));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindPersonsByAttestationInstanceIdResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#countAllUnderlingsByKind(String)}
   */
  @Test
  void testCountAllUnderlingsByKind() throws SQLException {
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
    Map<PersonKind, Integer> actualCountAllUnderlingsByKindResult = (new PersonDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).countAllUnderlingsByKind("42");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"kind\", count(*) \"count\" from \"person_hierarchy\" join \"person\" on \"person_hierarchy\".\"employee_id\" = \"person\".\"employee_id\" where (\"person_hierarchy\".\"manager_id\" = ? and not(\"person\".\"is_removed\")) group by \"person\".\"kind\""));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("42"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualCountAllUnderlingsByKindResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findByIds(Set)}
   */
  @Test
  void testFindByIds() throws SQLException {
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
    PersonDao personDao = new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Person> actualFindByIdsResult = personDao.findByIds(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where \"person\".\"id\" in ()"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findByEmployeeIds(Set)}
   */
  @Test
  void testFindByEmployeeIds() throws SQLException {
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
    PersonDao personDao = new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personDao.findByEmployeeIds(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where (\"person\".\"employee_id\" in () and \"person\".\"is_removed\" = false)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findActivePeopleByEmails(Set)}
   */
  @Test
  void testFindActivePeopleByEmails() throws SQLException {
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
    PersonDao personDao = new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personDao.findActivePeopleByEmails(new HashSet<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where (\"person\".\"email\" in () and \"person\".\"is_removed\" = false)"));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findActivePeopleByUserRole(String)}
   */
  @Test
  void testFindActivePeopleByUserRole() throws SQLException {
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
    Set<Person> actualFindActivePeopleByUserRoleResult = (new PersonDao(
        new DefaultDSLContext(connection, SQLDialect.SQL99))).findActivePeopleByUserRole("Role");

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"user_role\" join \"person\" on (\"person\".\"email\" = \"user_role\".\"user_name\" and \"person\".\"is_removed\" = false) where \"user_role\".\"role\" = ?"));
    verify(preparedStatement).execute();
    verify(preparedStatement).setString(eq(1), eq("Role"));
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindActivePeopleByUserRoleResult.isEmpty());
  }

  /**
   * Method under test: {@link PersonDao#findDirectsForPersonIds(List)}
   */
  @Test
  void testFindDirectsForPersonIds() throws SQLException {
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
    PersonDao personDao = new PersonDao(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personDao.findDirectsForPersonIds(new ArrayList<>());

    // Assert
    verify(connection).prepareStatement(eq(
        "select \"person\".\"id\", \"person\".\"employee_id\", \"person\".\"display_name\", \"person\".\"email\", \"person\".\"user_principal_name\", \"person\".\"department_name\", \"person\".\"kind\", \"person\".\"manager_employee_id\", \"person\".\"title\", \"person\".\"office_phone\", \"person\".\"mobile_phone\", \"person\".\"organisational_unit_id\", \"person\".\"is_removed\" from \"person\" where ((\"person\".\"manager_employee_id\" in (select \"person\".\"employee_id\" from \"person\" where \"person\".\"id\" in ()) and not(\"person\".\"is_removed\"))) order by \"person\".\"display_name\""));
    verify(preparedStatement).execute();
    verify(resultSet).close();
    verify(resultSet).getMetaData();
    verify(resultSet).next();
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }
}
