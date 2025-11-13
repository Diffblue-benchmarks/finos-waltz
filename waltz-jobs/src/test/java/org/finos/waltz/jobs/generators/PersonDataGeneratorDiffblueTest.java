package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class PersonDataGeneratorDiffblueTest {
  /**
   * Test {@link PersonDataGenerator#create(ApplicationContext)}.
   *
   * <p>Method under test: {@link PersonDataGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDataGenerator.create(ApplicationContext)"})
  void testCreate() throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("̀")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());

    PersonDao personDao2 = mock(PersonDao.class);
    when(personDao2.all()).thenReturn(personList);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DEFAULT);

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao2, dsl);

    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.getResultSet()).thenReturn(null);
    when(preparedStatement2.execute()).thenReturn(true);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();

    Connection connection2 = mock(Connection.class);
    when(connection2.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement2);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection2, SQLDialect.SQL99);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(PersonService.class)).thenReturn(personService);
    when(ctx.getBean(PersonHierarchyService.class)).thenReturn(personHierarchyService);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = personDataGenerator.create(ctx);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection2, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement2, atLeast(1)).execute();
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement2, atLeast(1)).close();
    verify(preparedStatement2).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement2, atLeast(1)).getWarnings();
    verify(personDao2).all();
    verify(personDao).bulkSave(isA(List.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertEquals(1, actualCreateResult.size());
    assertTrue(actualCreateResult.containsKey("created"));
  }

  /**
   * Test {@link PersonDataGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#commit()} does nothing.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PersonDataGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given Connection commit() does nothing; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDataGenerator.create(ApplicationContext)"})
  void testCreate_givenConnectionCommitDoesNothing_thenReturnSizeIsOne()
      throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    PersonDao personDao2 = mock(PersonDao.class);
    when(personDao2.all()).thenReturn(new ArrayList<>());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.SQL99);

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao2, dsl);

    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.getResultSet()).thenReturn(null);
    when(preparedStatement2.execute()).thenReturn(true);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();

    Connection connection2 = mock(Connection.class);
    when(connection2.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement2);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection2, SQLDialect.SQL99);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(PersonService.class)).thenReturn(personService);
    when(ctx.getBean(PersonHierarchyService.class)).thenReturn(personHierarchyService);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = personDataGenerator.create(ctx);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection2, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement2, atLeast(1)).execute();
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement2, atLeast(1)).close();
    verify(preparedStatement2).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement2, atLeast(1)).getWarnings();
    verify(personDao2).all();
    verify(personDao).bulkSave(isA(List.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertEquals(1, actualCreateResult.size());
    assertTrue(actualCreateResult.containsKey("created"));
  }

  /**
   * Test {@link PersonDataGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDataGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DEFAULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDataGenerator.create(ApplicationContext)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsDefault()
      throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());

    PersonDao personDao2 = mock(PersonDao.class);
    when(personDao2.all()).thenReturn(personList);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DEFAULT);

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao2, dsl);

    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.getResultSet()).thenReturn(null);
    when(preparedStatement2.execute()).thenReturn(true);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();

    Connection connection2 = mock(Connection.class);
    when(connection2.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement2);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection2, SQLDialect.SQL99);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(PersonService.class)).thenReturn(personService);
    when(ctx.getBean(PersonHierarchyService.class)).thenReturn(personHierarchyService);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = personDataGenerator.create(ctx);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection2, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement2, atLeast(1)).execute();
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement2, atLeast(1)).close();
    verify(preparedStatement2).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement2, atLeast(1)).getWarnings();
    verify(personDao2).all();
    verify(personDao).bulkSave(isA(List.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertEquals(1, actualCreateResult.size());
    assertTrue(actualCreateResult.containsKey("created"));
  }

  /**
   * Test {@link PersonDataGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(Connection, SQLDialect)} with {@link
   *       Connection} and dialect is {@code DEFAULT}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDataGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given DefaultDSLContext(Connection, SQLDialect) with Connection and dialect is 'DEFAULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDataGenerator.create(ApplicationContext)"})
  void testCreate_givenDefaultDSLContextWithConnectionAndDialectIsDefault2()
      throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());

    PersonDao personDao2 = mock(PersonDao.class);
    when(personDao2.all()).thenReturn(personList);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DEFAULT);

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao2, dsl);

    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.getResultSet()).thenReturn(null);
    when(preparedStatement2.execute()).thenReturn(true);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();

    Connection connection2 = mock(Connection.class);
    when(connection2.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement2);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection2, SQLDialect.SQL99);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(PersonService.class)).thenReturn(personService);
    when(ctx.getBean(PersonHierarchyService.class)).thenReturn(personHierarchyService);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = personDataGenerator.create(ctx);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection2, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement2, atLeast(1)).execute();
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement).close();
    verify(preparedStatement2, atLeast(1)).close();
    verify(preparedStatement2).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement2, atLeast(1)).getWarnings();
    verify(personDao2).all();
    verify(personDao).bulkSave(isA(List.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertEquals(1, actualCreateResult.size());
    assertTrue(actualCreateResult.containsKey("created"));
  }

  /**
   * Test {@link PersonDataGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#addBatch()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDataGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName("Test create(ApplicationContext); then calls addBatch()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonDataGenerator.create(ApplicationContext)"})
  void testCreate_thenCallsAddBatch() throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());
    personList.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("̀")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());

    PersonDao personDao2 = mock(PersonDao.class);
    when(personDao2.all()).thenReturn(personList);

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.executeBatch()).thenReturn(new int[] {1, -1, 1, -1});
    doNothing().when(preparedStatement).addBatch();
    doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
    doNothing().when(preparedStatement).setString(anyInt(), Mockito.<String>any());
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    doNothing().when(connection).commit();
    doNothing().when(connection).setAutoCommit(anyBoolean());
    when(connection.getAutoCommit()).thenReturn(true);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    DefaultDSLContext dsl = new DefaultDSLContext(connection, SQLDialect.DEFAULT);

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao2, dsl);

    PreparedStatement preparedStatement2 = mock(PreparedStatement.class);
    when(preparedStatement2.getResultSet()).thenReturn(null);
    when(preparedStatement2.execute()).thenReturn(true);
    when(preparedStatement2.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement2).setString(anyInt(), Mockito.<String>any());
    doNothing().when(preparedStatement2).close();

    Connection connection2 = mock(Connection.class);
    when(connection2.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement2);
    DefaultDSLContext defaultDSLContext = new DefaultDSLContext(connection2, SQLDialect.SQL99);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(PersonService.class)).thenReturn(personService);
    when(ctx.getBean(PersonHierarchyService.class)).thenReturn(personHierarchyService);
    when(ctx.getBean(DSLContext.class)).thenReturn(defaultDSLContext);

    // Act
    Map<String, Integer> actualCreateResult = personDataGenerator.create(ctx);

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection2, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).addBatch();
    verify(preparedStatement).execute();
    verify(preparedStatement2, atLeast(1)).execute();
    verify(preparedStatement).setInt(3, 1);
    verify(preparedStatement, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement2, atLeast(1)).setString(anyInt(), Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement2, atLeast(1)).close();
    verify(preparedStatement).executeBatch();
    verify(preparedStatement2).getResultSet();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(preparedStatement2, atLeast(1)).getWarnings();
    verify(personDao2).all();
    verify(personDao).bulkSave(isA(List.class));
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertEquals(1, actualCreateResult.size());
    assertTrue(actualCreateResult.containsKey("created"));
  }

  /**
   * Test {@link PersonDataGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PersonDataGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PersonDataGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    PersonDataGenerator personDataGenerator = new PersonDataGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = personDataGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx, atLeast(1)).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
