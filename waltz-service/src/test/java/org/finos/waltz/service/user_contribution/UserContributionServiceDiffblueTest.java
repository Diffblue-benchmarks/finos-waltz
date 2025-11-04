package org.finos.waltz.service.user_contribution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.tally.OrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserContributionServiceDiffblueTest {
  /**
   * Method under test: {@link UserContributionService#getLeaderBoard(int)}
   */
  @Test
  void testGetLeaderBoard() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    when(changeLogDao.getContributionLeaderBoard(anyInt())).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualLeaderBoard = (new UserContributionService(changeLogDao, mock(PersonDao.class)))
        .getLeaderBoard(1);

    // Assert
    verify(changeLogDao).getContributionLeaderBoard(eq(1));
    assertTrue(actualLeaderBoard.isEmpty());
    assertSame(orderedTallyList, actualLeaderBoard);
  }

  /**
   * Method under test:
   * {@link UserContributionService#getLeaderBoardLastMonth(int)}
   */
  @Test
  void testGetLeaderBoardLastMonth() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    when(changeLogDao.getContributionLeaderBoardLastMonth(anyInt())).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualLeaderBoardLastMonth = (new UserContributionService(changeLogDao,
        mock(PersonDao.class))).getLeaderBoardLastMonth(1);

    // Assert
    verify(changeLogDao).getContributionLeaderBoardLastMonth(eq(1));
    assertTrue(actualLeaderBoardLastMonth.isEmpty());
    assertSame(orderedTallyList, actualLeaderBoardLastMonth);
  }

  /**
   * Method under test:
   * {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  void testGetRankedLeaderBoard() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(new ArrayList<>());

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard = (new UserContributionService(changeLogDao,
        mock(PersonDao.class))).getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertTrue(actualRankedLeaderBoard.isEmpty());
  }

  /**
   * Method under test:
   * {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  void testGetRankedLeaderBoard2() {
    // Arrange
    OrderedTally<String> orderedTally = mock(OrderedTally.class);
    when(orderedTally.index()).thenReturn(1);
    when(orderedTally.id()).thenReturn("42");

    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    orderedTallyList.add(orderedTally);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard = (new UserContributionService(changeLogDao,
        mock(PersonDao.class))).getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    verify(orderedTally).index();
    verify(orderedTally).id();
    assertEquals(1, actualRankedLeaderBoard.size());
  }

  /**
   * Method under test:
   * {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  void testGetRankedLeaderBoard3() {
    // Arrange
    OrderedTally<String> orderedTally = mock(OrderedTally.class);
    when(orderedTally.index()).thenReturn(1);
    when(orderedTally.id()).thenReturn("42");
    OrderedTally<String> orderedTally2 = mock(OrderedTally.class);
    when(orderedTally2.index()).thenReturn(1);
    when(orderedTally2.id()).thenReturn("42");

    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    orderedTallyList.add(orderedTally2);
    orderedTallyList.add(orderedTally);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard = (new UserContributionService(changeLogDao,
        mock(PersonDao.class))).getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    verify(orderedTally2).index();
    verify(orderedTally2).id();
    assertEquals(orderedTallyList, actualRankedLeaderBoard);
  }

  /**
   * Method under test:
   * {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  void testGetRankedLeaderBoard4() {
    // Arrange
    OrderedTally<String> orderedTally = mock(OrderedTally.class);
    when(orderedTally.index()).thenReturn(1);
    when(orderedTally.id()).thenReturn("42");
    OrderedTally<String> orderedTally2 = mock(OrderedTally.class);
    when(orderedTally2.index()).thenReturn(1);
    when(orderedTally2.id()).thenReturn("42");
    OrderedTally<String> orderedTally3 = mock(OrderedTally.class);
    when(orderedTally3.id()).thenReturn("42");
    OrderedTally<String> orderedTally4 = mock(OrderedTally.class);
    when(orderedTally4.id()).thenReturn("42");
    OrderedTally<String> orderedTally5 = mock(OrderedTally.class);
    when(orderedTally5.id()).thenReturn("42");
    OrderedTally<String> orderedTally6 = mock(OrderedTally.class);
    when(orderedTally6.id()).thenReturn("42");
    OrderedTally<String> orderedTally7 = mock(OrderedTally.class);
    when(orderedTally7.id()).thenReturn("42");
    OrderedTally<String> orderedTally8 = mock(OrderedTally.class);
    when(orderedTally8.id()).thenReturn("42");
    OrderedTally<String> orderedTally9 = mock(OrderedTally.class);
    when(orderedTally9.id()).thenReturn("42");
    OrderedTally<String> orderedTally10 = mock(OrderedTally.class);
    when(orderedTally10.id()).thenReturn("42");
    OrderedTally<String> orderedTally11 = mock(OrderedTally.class);
    when(orderedTally11.index()).thenReturn(1);
    when(orderedTally11.id()).thenReturn("42");

    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    orderedTallyList.add(orderedTally11);
    orderedTallyList.add(orderedTally10);
    orderedTallyList.add(orderedTally9);
    orderedTallyList.add(orderedTally8);
    orderedTallyList.add(orderedTally7);
    orderedTallyList.add(orderedTally6);
    orderedTallyList.add(orderedTally5);
    orderedTallyList.add(orderedTally4);
    orderedTallyList.add(orderedTally3);
    orderedTallyList.add(orderedTally2);
    orderedTallyList.add(orderedTally);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard = (new UserContributionService(changeLogDao,
        mock(PersonDao.class))).getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    verify(orderedTally11).index();
    verify(orderedTally11).id();
    assertEquals(10, actualRankedLeaderBoard.size());
  }

  /**
   * Method under test: {@link UserContributionService#getScoreForUser(String)}
   */
  @Test
  void testGetScoreForUser() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any())).thenReturn(new ArrayList<>());

    // Act
    double actualScoreForUser = (new UserContributionService(changeLogDao, mock(PersonDao.class)))
        .getScoreForUser("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    assertEquals(0.0d, actualScoreForUser);
  }

  /**
   * Method under test: {@link UserContributionService#getScoreForUser(String)}
   */
  @Test
  void testGetScoreForUser2() {
    // Arrange
    Tally<String> tally = mock(Tally.class);
    when(tally.count()).thenReturn(10.0d);

    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    tallyList.add(tally);
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any())).thenReturn(tallyList);

    // Act
    double actualScoreForUser = (new UserContributionService(changeLogDao, mock(PersonDao.class)))
        .getScoreForUser("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(tally).count();
    assertEquals(10.0d, actualScoreForUser);
  }

  /**
   * Method under test:
   * {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  void testFindScoresForDirectReports() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(null);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult = (new UserContributionService(mock(ChangeLogDao.class),
        personDao)).findScoresForDirectReports("42");

    // Assert
    verify(personDao).getByUserEmail(eq("42"));
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  void testFindScoresForDirectReports2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any())).thenReturn(tallyList);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult = (new UserContributionService(changeLogDao, personDao))
        .findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId(eq("42"));
    verify(personDao).getByUserEmail(eq("42"));
    verify(person).employeeId();
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
    assertSame(tallyList, actualFindScoresForDirectReportsResult);
  }

  /**
   * Method under test:
   * {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  void testFindScoresForDirectReports3() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any())).thenReturn(tallyList);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    Person person2 = mock(Person.class);
    when(person2.userId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person2);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(personList);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult = (new UserContributionService(changeLogDao, personDao))
        .findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId(eq("42"));
    verify(personDao).getByUserEmail(eq("42"));
    verify(person).employeeId();
    verify(person2).userId();
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
    assertSame(tallyList, actualFindScoresForDirectReportsResult);
  }

  /**
   * Method under test:
   * {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  void testFindScoresForDirectReports4() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    ArrayList<Tally<String>> tallyList = new ArrayList<>();
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any())).thenReturn(tallyList);
    Person person = mock(Person.class);
    when(person.employeeId()).thenReturn("42");
    Person person2 = mock(Person.class);
    when(person2.userId()).thenReturn("42");
    Person person3 = mock(Person.class);
    when(person3.userId()).thenReturn("42");

    ArrayList<Person> personList = new ArrayList<>();
    personList.add(person3);
    personList.add(person2);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(personList);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult = (new UserContributionService(changeLogDao, personDao))
        .findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId(eq("42"));
    verify(personDao).getByUserEmail(eq("42"));
    verify(person).employeeId();
    verify(person3).userId();
    verify(person2).userId();
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
    assertSame(tallyList, actualFindScoresForDirectReportsResult);
  }
}
