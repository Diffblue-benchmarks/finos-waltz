package org.finos.waltz.service.person;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PersonServiceDiffblueTest {
  /**
   * Method under test: {@link PersonService#getByEmployeeId(String)}
   */
  @Test
  void testGetByEmployeeId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(null);

    // Act
    Person actualByEmployeeId = (new PersonService(personDao, mock(PersonSearchDao.class))).getByEmployeeId("42");

    // Assert
    verify(personDao).getByEmployeeId(eq("42"));
    assertNull(actualByEmployeeId);
  }

  /**
   * Method under test: {@link PersonService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getById(anyLong())).thenReturn(null);

    // Act
    Person actualById = (new PersonService(personDao, mock(PersonSearchDao.class))).getById(1L);

    // Assert
    verify(personDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link PersonService#findDirectsByEmployeeId(String)}
   */
  @Test
  void testFindDirectsByEmployeeId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(personList);

    // Act
    List<Person> actualFindDirectsByEmployeeIdResult = (new PersonService(personDao, mock(PersonSearchDao.class)))
        .findDirectsByEmployeeId("42");

    // Assert
    verify(personDao).findDirectsByEmployeeId(eq("42"));
    assertTrue(actualFindDirectsByEmployeeIdResult.isEmpty());
    assertSame(personList, actualFindDirectsByEmployeeIdResult);
  }

  /**
   * Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  void testFindDirectsForPersonIds() {
    // Arrange
    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    // Act and Assert
    assertTrue(personService.findDirectsForPersonIds(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  void testFindDirectsForPersonIds2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.findDirectsForPersonIds(Mockito.<List<Long>>any())).thenReturn(personList);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personService.findDirectsForPersonIds(personIds);

    // Assert
    verify(personDao).findDirectsForPersonIds(isA(List.class));
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
    assertSame(personList, actualFindDirectsForPersonIdsResult);
  }

  /**
   * Method under test: {@link PersonService#findDirectsForPersonIds(List)}
   */
  @Test
  void testFindDirectsForPersonIds3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.findDirectsForPersonIds(Mockito.<List<Long>>any())).thenReturn(personList);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    ArrayList<Long> personIds = new ArrayList<>();
    personIds.add(0L);
    personIds.add(1L);

    // Act
    List<Person> actualFindDirectsForPersonIdsResult = personService.findDirectsForPersonIds(personIds);

    // Assert
    verify(personDao).findDirectsForPersonIds(isA(List.class));
    assertTrue(actualFindDirectsForPersonIdsResult.isEmpty());
    assertSame(personList, actualFindDirectsForPersonIdsResult);
  }

  /**
   * Method under test: {@link PersonService#findAllManagersByEmployeeId(String)}
   */
  @Test
  void testFindAllManagersByEmployeeId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.findAllManagersByEmployeeId(Mockito.<String>any())).thenReturn(personList);

    // Act
    List<Person> actualFindAllManagersByEmployeeIdResult = (new PersonService(personDao, mock(PersonSearchDao.class)))
        .findAllManagersByEmployeeId("42");

    // Assert
    verify(personDao).findAllManagersByEmployeeId(eq("42"));
    assertTrue(actualFindAllManagersByEmployeeIdResult.isEmpty());
    assertSame(personList, actualFindAllManagersByEmployeeIdResult);
  }

  /**
   * Method under test: {@link PersonService#search(String)}
   */
  @Test
  void testSearch() {
    // Arrange
    PersonSearchDao personSearchDao = mock(PersonSearchDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(personList);

    // Act
    List<Person> actualSearchResult = (new PersonService(mock(PersonDao.class), personSearchDao)).search("Query");

    // Assert
    verify(personSearchDao).search(isA(EntitySearchOptions.class));
    assertTrue(actualSearchResult.isEmpty());
    assertSame(personList, actualSearchResult);
  }

  /**
   * Method under test: {@link PersonService#search(String)}
   */
  @Test
  void testSearch2() {
    // Arrange, Act and Assert
    assertTrue((new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class))).search("").isEmpty());
  }

  /**
   * Method under test: {@link PersonService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    PersonSearchDao personSearchDao = mock(PersonSearchDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personSearchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(personList);

    // Act
    List<Person> actualSearchResult = (new PersonService(mock(PersonDao.class), personSearchDao))
        .search((EntitySearchOptions) null);

    // Assert
    verify(personSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
    assertSame(personList, actualSearchResult);
  }

  /**
   * Method under test: {@link PersonService#all()}
   */
  @Test
  void testAll() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    ArrayList<Person> personList = new ArrayList<>();
    when(personDao.all()).thenReturn(personList);

    // Act
    List<Person> actualAllResult = (new PersonService(personDao, mock(PersonSearchDao.class))).all();

    // Assert
    verify(personDao).all();
    assertTrue(actualAllResult.isEmpty());
    assertSame(personList, actualAllResult);
  }

  /**
   * Method under test: {@link PersonService#bulkSave(List)}
   */
  @Test
  void testBulkSave() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.bulkSave(Mockito.<List<ImmutablePerson>>any())).thenReturn(new int[]{1, -1, 1, -1});
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    int[] actualBulkSaveResult = personService.bulkSave(new ArrayList<>());

    // Assert
    verify(personDao).bulkSave(isA(List.class));
    assertArrayEquals(new int[]{1, -1, 1, -1}, actualBulkSaveResult);
  }

  /**
   * Method under test: {@link PersonService#getPersonByUserId(String)}
   */
  @Test
  void testGetPersonByUserId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(null);

    // Act
    Person actualPersonByUserId = (new PersonService(personDao, mock(PersonSearchDao.class))).getPersonByUserId("42");

    // Assert
    verify(personDao).getByUserEmail(eq("42"));
    assertNull(actualPersonByUserId);
  }

  /**
   * Method under test: {@link PersonService#countAllUnderlingsByKind(String)}
   */
  @Test
  void testCountAllUnderlingsByKind() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashMap<PersonKind, Integer> personKindIntegerMap = new HashMap<>();
    when(personDao.countAllUnderlingsByKind(Mockito.<String>any())).thenReturn(personKindIntegerMap);

    // Act
    Map<PersonKind, Integer> actualCountAllUnderlingsByKindResult = (new PersonService(personDao,
        mock(PersonSearchDao.class))).countAllUnderlingsByKind("42");

    // Assert
    verify(personDao).countAllUnderlingsByKind(eq("42"));
    assertTrue(actualCountAllUnderlingsByKindResult.isEmpty());
    assertSame(personKindIntegerMap, actualCountAllUnderlingsByKindResult);
  }

  /**
   * Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  void testFindByEmployeeIds() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(new HashSet<>());

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
    assertSame(personSet, actualFindByEmployeeIdsResult);
  }

  /**
   * Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  void testFindByEmployeeIds2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> empIds = new HashSet<>();
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(empIds);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
    assertSame(personSet, actualFindByEmployeeIdsResult);
  }

  /**
   * Method under test: {@link PersonService#findByEmployeeIds(Set)}
   */
  @Test
  void testFindByEmployeeIds3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findByEmployeeIds(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> empIds = new HashSet<>();
    empIds.add("42");
    empIds.add("foo");

    // Act
    Set<Person> actualFindByEmployeeIdsResult = personService.findByEmployeeIds(empIds);

    // Assert
    verify(personDao).findByEmployeeIds(isA(Set.class));
    assertTrue(actualFindByEmployeeIdsResult.isEmpty());
    assertSame(personSet, actualFindByEmployeeIdsResult);
  }

  /**
   * Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  void testFindActivePeopleByEmails() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personService.findActivePeopleByEmails(new HashSet<>());

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
    assertSame(personSet, actualFindActivePeopleByEmailsResult);
  }

  /**
   * Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  void testFindActivePeopleByEmails2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> emails = new HashSet<>();
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personService.findActivePeopleByEmails(emails);

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
    assertSame(personSet, actualFindActivePeopleByEmailsResult);
  }

  /**
   * Method under test: {@link PersonService#findActivePeopleByEmails(Set)}
   */
  @Test
  void testFindActivePeopleByEmails3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    HashSet<Person> personSet = new HashSet<>();
    when(personDao.findActivePeopleByEmails(Mockito.<Set<String>>any())).thenReturn(personSet);
    PersonService personService = new PersonService(personDao, mock(PersonSearchDao.class));

    HashSet<String> emails = new HashSet<>();
    emails.add("42");
    emails.add("foo");

    // Act
    Set<Person> actualFindActivePeopleByEmailsResult = personService.findActivePeopleByEmails(emails);

    // Assert
    verify(personDao).findActivePeopleByEmails(isA(Set.class));
    assertTrue(actualFindActivePeopleByEmailsResult.isEmpty());
    assertSame(personSet, actualFindActivePeopleByEmailsResult);
  }
}
