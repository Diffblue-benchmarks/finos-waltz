package org.finos.waltz.service.person;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonServiceDiffblueTest {
  /**
   * Test {@link PersonService#getByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutablePerson}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#getByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test getByEmployeeId(String); then return ImmutablePerson")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonService.getByEmployeeId(String)"})
  void testGetByEmployeeId_thenReturnImmutablePerson() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
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
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Person actualByEmployeeId = personService.getByEmployeeId("42");

    // Assert
    verify(personDao).getByEmployeeId("42");
    assertTrue(actualByEmployeeId instanceof ImmutablePerson);
    assertEquals("42", actualByEmployeeId.employeeId());
    assertEquals("42", actualByEmployeeId.userId());
    assertEquals("Display Name", actualByEmployeeId.displayName());
    assertEquals("Display Name", actualByEmployeeId.name());
    assertEquals("jane.doe@example.org", actualByEmployeeId.email());
    assertEquals(EntityKind.ALL, actualByEmployeeId.kind());
    assertEquals(PersonKind.EMPLOYEE, actualByEmployeeId.personKind());
    assertTrue(actualByEmployeeId.isRemoved());
  }

  /**
   * Test {@link PersonService#getById(long)}.
   *
   * <p>Method under test: {@link PersonService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonService.getById(long)"})
  void testGetById() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong()))
        .thenReturn(
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
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Person actualById = personService.getById(1L);

    // Assert
    verify(personDao).getById(1L);
    assertTrue(actualById instanceof ImmutablePerson);
    assertEquals("42", actualById.employeeId());
    assertEquals("42", actualById.userId());
    assertEquals("Display Name", actualById.displayName());
    assertEquals("Display Name", actualById.name());
    assertEquals("jane.doe@example.org", actualById.email());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(PersonKind.EMPLOYEE, actualById.personKind());
    assertTrue(actualById.isRemoved());
  }

  /**
   * Test {@link PersonService#findDirectsByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findDirectsByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findDirectsByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findDirectsByEmployeeId(String)"})
  void testFindDirectsByEmployeeId_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    List<Person> actualFindDirectsByEmployeeIdResult = personService.findDirectsByEmployeeId("42");

    // Assert
    verify(personDao).findDirectsByEmployeeId("42");
    assertTrue(actualFindDirectsByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); given zero; when ArrayList() add zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_givenZero_whenArrayListAddZero() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsForPersonIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(0L);
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult =
        personService.findDirectsForPersonIds(personIds);

    // Assert
    verify(personDao).findDirectsForPersonIds(isA(List.class));
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>Then calls {@link PersonDao#findDirectsForPersonIds(List)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); then calls findDirectsForPersonIds(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_thenCallsFindDirectsForPersonIds() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsForPersonIds(Mockito.<List<Long>>any()))
        .thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult =
        personService.findDirectsForPersonIds(personIds);

    // Assert
    verify(personDao).findDirectsForPersonIds(isA(List.class));
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_whenArrayList() {
    // Arrange
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    // Act and Assert
    assertTrue(personService.findDirectsForPersonIds(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link PersonService#findDirectsForPersonIds(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  @DisplayName("Test findDirectsForPersonIds(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findDirectsForPersonIds(List)"})
  void testFindDirectsForPersonIds_whenNull() {
    // Arrange
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    // Act and Assert
    assertTrue(personService.findDirectsForPersonIds(null).isEmpty());
  }

  /**
   * Test {@link PersonService#findAllManagersByEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findAllManagersByEmployeeId(String)}
   */
  @Test
  @DisplayName("Test findAllManagersByEmployeeId(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.findAllManagersByEmployeeId(String)"})
  void testFindAllManagersByEmployeeId_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findAllManagersByEmployeeId(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    List<Person> actualFindAllManagersByEmployeeIdResult =
        personService.findAllManagersByEmployeeId("42");

    // Assert
    verify(personDao).findAllManagersByEmployeeId("42");
    assertTrue(actualFindAllManagersByEmployeeIdResult.isEmpty());
  }

  /**
   * Test {@link PersonService#search(EntitySearchOptions)} with {@code options}.
   *
   * <p>Method under test: {@link PersonService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions) with 'options'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.search(EntitySearchOptions)"})
  void testSearchWithOptions() {
    // Arrange
    PersonSearchDao personSearchDao = mock(PersonSearchDao.class);
    when(personSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(mock(PersonDao.class), personSearchDao);

    // Act
    List<Person> actualSearchResult = personService.search((EntitySearchOptions) null);

    // Assert
    verify(personSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link PersonService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>Given {@link PersonSearchDao} {@link PersonSearchDao#search(EntitySearchOptions)} return
   *       {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link PersonSearchDao#search(EntitySearchOptions)}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#search(String)}
   */
  @Test
  @DisplayName(
      "Test search(String) with 'query'; given PersonSearchDao search(EntitySearchOptions) return ArrayList(); then calls search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.search(String)"})
  void testSearchWithQuery_givenPersonSearchDaoSearchReturnArrayList_thenCallsSearch() {
    // Arrange
    PersonSearchDao personSearchDao = mock(PersonSearchDao.class);
    when(personSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(mock(PersonDao.class), personSearchDao);

    // Act
    List<Person> actualSearchResult = personService.search("Query");

    // Assert
    verify(personSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link PersonService#search(String)} with {@code query}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#search(String)}
   */
  @Test
  @DisplayName("Test search(String) with 'query'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.search(String)"})
  void testSearchWithQuery_whenEmptyString() {
    // Arrange
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    // Act and Assert
    assertTrue(personService.search("").isEmpty());
  }

  /**
   * Test {@link PersonService#all()}.
   *
   * <p>Method under test: {@link PersonService#all()}
   */
  @Test
  @DisplayName("Test all()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PersonService.all()"})
  void testAll() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.all()).thenReturn(new ArrayList<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    List<Person> actualAllResult = personService.all();

    // Assert
    verify(personDao).all();
    assertTrue(actualAllResult.isEmpty());
  }

  /**
   * Test {@link PersonService#bulkSave(List)}.
   *
   * <p>Method under test: {@link PersonService#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PersonService.bulkSave(List)"})
  void testBulkSave() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<ImmutablePerson> people = new ArrayList<>();
    people.add(
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

    // Act
    int[] actualBulkSaveResult = personService.bulkSave(people);

    // Assert
    verify(personDao).bulkSave(isA(List.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link PersonService#bulkSave(List)}.
   *
   * <p>Method under test: {@link PersonService#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PersonService.bulkSave(List)"})
  void testBulkSave2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<ImmutablePerson> people = new ArrayList<>();
    people.add(
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
    people.add(
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

    // Act
    int[] actualBulkSaveResult = personService.bulkSave(people);

    // Assert
    verify(personDao).bulkSave(isA(List.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link PersonService#bulkSave(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#bulkSave(List)}
   */
  @Test
  @DisplayName("Test bulkSave(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PersonService.bulkSave(List)"})
  void testBulkSave_whenArrayList() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any()))
        .thenReturn(new int[] {1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    int[] actualBulkSaveResult = personService.bulkSave(new ArrayList<>());

    // Assert
    verify(personDao).bulkSave(isA(List.class));
    assertArrayEquals(new int[] {1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Test {@link PersonService#getPersonByUserId(String)}.
   *
   * <p>Method under test: {@link PersonService#getPersonByUserId(String)}
   */
  @Test
  @DisplayName("Test getPersonByUserId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Person PersonService.getPersonByUserId(String)"})
  void testGetPersonByUserId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any()))
        .thenReturn(
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
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Person actualPersonByUserId = personService.getPersonByUserId("42");

    // Assert
    verify(personDao).getByUserEmail("42");
    assertTrue(actualPersonByUserId instanceof ImmutablePerson);
    assertEquals("42", actualPersonByUserId.employeeId());
    assertEquals("42", actualPersonByUserId.userId());
    assertEquals("Display Name", actualPersonByUserId.displayName());
    assertEquals("Display Name", actualPersonByUserId.name());
    assertEquals("jane.doe@example.org", actualPersonByUserId.email());
    assertEquals(EntityKind.ALL, actualPersonByUserId.kind());
    assertEquals(PersonKind.EMPLOYEE, actualPersonByUserId.personKind());
    assertTrue(actualPersonByUserId.isRemoved());
  }

  /**
   * Test {@link PersonService#countAllUnderlingsByKind(String)}.
   *
   * <p>Method under test: {@link PersonService#countAllUnderlingsByKind(String)}
   */
  @Test
  @DisplayName("Test countAllUnderlingsByKind(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PersonService.countAllUnderlingsByKind(String)"})
  void testCountAllUnderlingsByKind() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.countAllUnderlingsByKind(Mockito.<String>any())).thenReturn(new HashMap<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Map<PersonKind, Integer> actualCountAllUnderlingsByKindResult =
        personService.countAllUnderlingsByKind("42");

    // Assert
    verify(personDao).countAllUnderlingsByKind("42");
    assertTrue(actualCountAllUnderlingsByKindResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_given42_whenHashSetAdd42() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> empIds = new HashSet<>();
    empIds.add("42");
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(empIds);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_givenFoo_whenHashSetAddFoo() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> empIds = new HashSet<>();
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(empIds);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findByEmployeeIds(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  @DisplayName("Test findByEmployeeIds(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findByEmployeeIds(Set)"})
  void testFindByEmployeeIds_whenHashSet() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(new HashSet<>());

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); given '42'; when HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_given42_whenHashSetAdd42() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any()))
        .thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> emails = new HashSet<>();
    emails.add("42");
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult =
        personService.findActivePeopleByEmails(emails);

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link HashSet#HashSet()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); given 'foo'; when HashSet() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_givenFoo_whenHashSetAddFoo() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any()))
        .thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> emails = new HashSet<>();
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult =
        personService.findActivePeopleByEmails(emails);

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }

  /**
   * Test {@link PersonService#findActivePeopleByEmails(Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  @DisplayName("Test findActivePeopleByEmails(Set); when HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set PersonService.findActivePeopleByEmails(Set)"})
  void testFindActivePeopleByEmails_whenHashSet() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any()))
        .thenReturn(new HashSet<>());
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult =
        personService.findActivePeopleByEmails(new HashSet<>());

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
  }
}
