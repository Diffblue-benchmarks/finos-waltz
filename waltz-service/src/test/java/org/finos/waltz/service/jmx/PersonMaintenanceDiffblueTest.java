package org.finos.waltz.service.jmx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyBoolean;
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
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.service.person_hierarchy.PersonHierarchyService;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonMaintenanceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PersonMaintenance#PersonMaintenance(PersonHierarchyService)}
   *   <li>{@link PersonMaintenance#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PersonMaintenance.<init>(PersonHierarchyService)",
    "String PersonMaintenance.getName()"
  })
  void testGettersAndSetters() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    PersonHierarchyService personHierarchyService =
        new PersonHierarchyService(personDao, new DefaultDSLContext(SQLDialect.SQL99));

    // Act and Assert
    assertEquals("Person", new PersonMaintenance(personHierarchyService).getName());
  }

  /**
   * Test {@link PersonMaintenance#rebuildHierarchyTable()}.
   *
   * <p>Method under test: {@link PersonMaintenance#rebuildHierarchyTable()}
   */
  @Test
  @DisplayName("Test rebuildHierarchyTable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonMaintenance.rebuildHierarchyTable()"})
  void testRebuildHierarchyTable() throws SQLException {
    // Arrange
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.all()).thenReturn(personList);

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

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao, dsl);

    // Act
    int actualRebuildHierarchyTableResult =
        new PersonMaintenance(personHierarchyService).rebuildHierarchyTable();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(personDao).all();
    assertEquals(0, actualRebuildHierarchyTableResult);
  }

  /**
   * Test {@link PersonMaintenance#rebuildHierarchyTable()}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#all()} return {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonMaintenance#rebuildHierarchyTable()}
   */
  @Test
  @DisplayName(
      "Test rebuildHierarchyTable(); given PersonDao all() return ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonMaintenance.rebuildHierarchyTable()"})
  void testRebuildHierarchyTable_givenPersonDaoAllReturnArrayList_thenReturnZero()
      throws SQLException {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.all()).thenReturn(new ArrayList<>());

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

    PersonHierarchyService personHierarchyService = new PersonHierarchyService(personDao, dsl);

    // Act
    int actualRebuildHierarchyTableResult =
        new PersonMaintenance(personHierarchyService).rebuildHierarchyTable();

    // Assert
    verify(connection).commit();
    verify(connection).getAutoCommit();
    verify(connection).prepareStatement("delete from \"person_hierarchy\"");
    verify(connection, atLeast(1)).setAutoCommit(anyBoolean());
    verify(preparedStatement).execute();
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(personDao).all();
    assertEquals(0, actualRebuildHierarchyTableResult);
  }

  /**
   * Test {@link PersonMaintenance#rebuildHierarchyTable()}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link PersonMaintenance#rebuildHierarchyTable()}
   */
  @Test
  @DisplayName("Test rebuildHierarchyTable(); then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PersonMaintenance.rebuildHierarchyTable()"})
  void testRebuildHierarchyTable_thenReturnFour() {
    // Arrange
    PersonHierarchyService personHierarchyService = mock(PersonHierarchyService.class);
    when(personHierarchyService.build()).thenReturn(new int[] {1, 0, 1, 0});

    // Act
    int actualRebuildHierarchyTableResult =
        new PersonMaintenance(personHierarchyService).rebuildHierarchyTable();

    // Assert
    verify(personHierarchyService).build();
    assertEquals(4, actualRebuildHierarchyTableResult);
  }
}
