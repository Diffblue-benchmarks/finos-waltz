package org.finos.waltz.service.user_contribution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.ImmutableOrderedTally.Builder;
import org.finos.waltz.model.tally.OrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserContributionServiceDiffblueTest {
  @Mock private ChangeLogDao changeLogDao;

  @Mock private PersonDao personDao;

  @InjectMocks private UserContributionService userContributionService;

  /**
   * Test {@link UserContributionService#getLeaderBoard(int)}.
   *
   * <p>Method under test: {@link UserContributionService#getLeaderBoard(int)}
   */
  @Test
  @DisplayName("Test getLeaderBoard(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getLeaderBoard(int)"})
  void testGetLeaderBoard() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionLeaderBoard(anyInt())).thenReturn(new ArrayList<>());
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualLeaderBoard = userContributionService.getLeaderBoard(1);

    // Assert
    verify(changeLogDao).getContributionLeaderBoard(1);
    assertTrue(actualLeaderBoard.isEmpty());
  }

  /**
   * Test {@link UserContributionService#getLeaderBoardLastMonth(int)}.
   *
   * <p>Method under test: {@link UserContributionService#getLeaderBoardLastMonth(int)}
   */
  @Test
  @DisplayName("Test getLeaderBoardLastMonth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getLeaderBoardLastMonth(int)"})
  void testGetLeaderBoardLastMonth() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionLeaderBoardLastMonth(anyInt())).thenReturn(new ArrayList<>());
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualLeaderBoardLastMonth =
        userContributionService.getLeaderBoardLastMonth(1);

    // Assert
    verify(changeLogDao).getContributionLeaderBoardLastMonth(1);
    assertTrue(actualLeaderBoardLastMonth.isEmpty());
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName(
      "Test getRankedLeaderBoard(String); given ArrayList() addAll ArrayList(); when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_givenArrayListAddAllArrayList_when42_thenReturnEmpty() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();
    orderedTallyList.addAll(new ArrayList<>());

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("42").index(Integer.MIN_VALUE).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertTrue(actualRankedLeaderBoard.isEmpty());
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_thenReturnArrayList() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertEquals(orderedTallyList, actualRankedLeaderBoard);
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_thenReturnArrayList2() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult2.count(10.0d).id("42").index(1).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertEquals(orderedTallyList, actualRankedLeaderBoard);
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("Id").index(1).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult2.count(10.0d).id("42").index(6).build());
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertEquals(2, actualRankedLeaderBoard.size());
    OrderedTally<String> getResult = actualRankedLeaderBoard.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualRankedLeaderBoard.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("42", getResult2.id());
    assertEquals("Id", getResult.id());
    assertEquals(10.0d, getResult2.count());
    assertEquals(6, getResult2.index());
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); when '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_when42_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(new ArrayList<>());
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("42");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertTrue(actualRankedLeaderBoard.isEmpty());
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>When {@code User Id}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); when 'User Id'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_whenUserId_thenReturnArrayList() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("User Id");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertEquals(orderedTallyList, actualRankedLeaderBoard);
  }

  /**
   * Test {@link UserContributionService#getRankedLeaderBoard(String)}.
   *
   * <ul>
   *   <li>When {@code User Id}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getRankedLeaderBoard(String)}
   */
  @Test
  @DisplayName("Test getRankedLeaderBoard(String); when 'User Id'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.getRankedLeaderBoard(String)"})
  void testGetRankedLeaderBoard_whenUserId_thenReturnArrayList2() {
    // Arrange
    ArrayList<OrderedTally<String>> orderedTallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    orderedTallyList.add(builderResult2.count(10.0d).id("42").index(1).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getRankingOfContributors()).thenReturn(orderedTallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    List<OrderedTally<String>> actualRankedLeaderBoard =
        userContributionService.getRankedLeaderBoard("User Id");

    // Assert
    verify(changeLogDao).getRankingOfContributors();
    assertEquals(orderedTallyList, actualRankedLeaderBoard);
  }

  /**
   * Test {@link UserContributionService#getScoreForUser(String)}.
   *
   * <ul>
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getScoreForUser(String)}
   */
  @Test
  @DisplayName("Test getScoreForUser(String); then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double UserContributionService.getScoreForUser(String)"})
  void testGetScoreForUser_thenReturnTen() {
    // Arrange
    ArrayList<Tally<String>> tallyList = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    tallyList.add(builderResult.count(10.0d).id("42").index(1).build());

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any()))
        .thenReturn(tallyList);
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    double actualScoreForUser = userContributionService.getScoreForUser("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    assertEquals(10.0d, actualScoreForUser);
  }

  /**
   * Test {@link UserContributionService#getScoreForUser(String)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#getScoreForUser(String)}
   */
  @Test
  @DisplayName("Test getScoreForUser(String); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double UserContributionService.getScoreForUser(String)"})
  void testGetScoreForUser_thenReturnZero() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());
    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, mock(PersonDao.class));

    // Act
    double actualScoreForUser = userContributionService.getScoreForUser("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    assertEquals(0.0d, actualScoreForUser);
  }

  /**
   * Test {@link UserContributionService#findScoresForDirectReports(String)}.
   *
   * <p>Method under test: {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  @DisplayName("Test findScoresForDirectReports(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.findScoresForDirectReports(String)"})
  void testFindScoresForDirectReports() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

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
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(personList);
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

    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, personDao);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult =
        userContributionService.findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId("42");
    verify(personDao).getByUserEmail("42");
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
  }

  /**
   * Test {@link UserContributionService#findScoresForDirectReports(String)}.
   *
   * <p>Method under test: {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  @DisplayName("Test findScoresForDirectReports(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.findScoresForDirectReports(String)"})
  void testFindScoresForDirectReports2() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(personList);
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

    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, personDao);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult =
        userContributionService.findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId("42");
    verify(personDao).getByUserEmail("42");
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
  }

  /**
   * Test {@link UserContributionService#findScoresForDirectReports(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionService#findScoresForDirectReports(String)}
   */
  @Test
  @DisplayName("Test findScoresForDirectReports(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionService.findScoresForDirectReports(String)"})
  void testFindScoresForDirectReports_thenReturnEmpty() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.getContributionScoresForUsers(Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findDirectsByEmployeeId(Mockito.<String>any())).thenReturn(new ArrayList<>());
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

    UserContributionService userContributionService =
        new UserContributionService(changeLogDao, personDao);

    // Act
    List<Tally<String>> actualFindScoresForDirectReportsResult =
        userContributionService.findScoresForDirectReports("42");

    // Assert
    verify(changeLogDao).getContributionScoresForUsers(isA(List.class));
    verify(personDao).findDirectsByEmployeeId("42");
    verify(personDao).getByUserEmail("42");
    assertTrue(actualFindScoresForDirectReportsResult.isEmpty());
  }
}
