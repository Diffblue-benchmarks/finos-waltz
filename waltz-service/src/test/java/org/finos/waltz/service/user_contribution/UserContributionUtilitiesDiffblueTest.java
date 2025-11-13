package org.finos.waltz.service.user_contribution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.ImmutableOrderedTally.Builder;
import org.finos.waltz.model.tally.OrderedTally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserContributionUtilitiesDiffblueTest {
  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code 42} index {@link Integer#MIN_VALUE} build.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName(
      "Test getOrderedListOf10(List, String); given builder count ten id '42' index MIN_VALUE build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenBuilderCountTenId42IndexMin_valueBuild() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("42").index(Integer.MIN_VALUE).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertTrue(actualOrderedListOf10.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code 42} index one build.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName(
      "Test getOrderedListOf10(List, String); given builder count ten id '42' index one build; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenBuilderCountTenId42IndexOneBuild_thenReturnArrayList() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("42").index(1).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertEquals(list, actualOrderedListOf10);
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Given builder count ten id {@code Id} index one build.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName(
      "Test getOrderedListOf10(List, String); given builder count ten id 'Id' index one build; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenBuilderCountTenIdIdIndexOneBuild_thenReturnArrayList() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("Id").index(1).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertEquals(list, actualOrderedListOf10);
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Then return first id is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); then return first id is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_thenReturnFirstIdIs42() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("42").index(1).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    list.add(builderResult2.count(10.0d).id("Id").index(1).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertEquals(2, actualOrderedListOf10.size());
    OrderedTally<String> getResult = actualOrderedListOf10.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualOrderedListOf10.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("42", getResult.id());
    assertEquals("Id", getResult2.id());
    assertEquals(1, getResult2.index());
    assertEquals(10.0d, getResult2.count());
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Then return first id is {@code Id}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); then return first id is 'Id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_thenReturnFirstIdIsId() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("Id").index(1).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    list.add(builderResult2.count(10.0d).id("Id").index(1).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertEquals(2, actualOrderedListOf10.size());
    OrderedTally<String> getResult = actualOrderedListOf10.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualOrderedListOf10.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("Id", getResult.id());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>Then return first index is six.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); then return first index is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_thenReturnFirstIndexIsSix() {
    // Arrange
    ArrayList<OrderedTally<String>> list = new ArrayList<>();

    Builder<String> builderResult = ImmutableOrderedTally.builder();
    list.add(builderResult.count(10.0d).id("42").index(6).build());

    Builder<String> builderResult2 = ImmutableOrderedTally.builder();
    list.add(builderResult2.count(10.0d).id("Id").index(1).build());

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    assertEquals(2, actualOrderedListOf10.size());
    OrderedTally<String> getResult = actualOrderedListOf10.get(0);
    assertTrue(getResult instanceof ImmutableOrderedTally);
    OrderedTally<String> getResult2 = actualOrderedListOf10.get(1);
    assertTrue(getResult2 instanceof ImmutableOrderedTally);
    assertEquals("Id", getResult2.id());
    assertEquals(1, getResult2.index());
    assertEquals(10.0d, getResult2.count());
    assertEquals(6, getResult.index());
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<OrderedTally<String>> actualOrderedListOf10 =
        UserContributionUtilities.getOrderedListOf10(new ArrayList<>(), "42");

    // Assert
    assertTrue(actualOrderedListOf10.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@code -2147483647}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); given '42'; when '-2147483647'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_when2147483647_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, -2147483647);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test findWindow(List, int, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test findWindow(List, int, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>Given {@code List}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code List}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test findWindow(List, int, int); given 'List'; when ArrayList() add 'List'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_givenList_whenArrayListAddList_thenReturnArrayList() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("List");

    // Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(list, 1, 3);

    // Assert
    assertEquals(list, actualFindWindowResult);
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(new ArrayList<>(), 1, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenArrayList_thenReturnEmpty2() {
    // Arrange and Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(new ArrayList<>(), Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenTwo_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(new ArrayList<>(), 1, 2);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when zero; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenZero_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult =
        UserContributionUtilities.findWindow(new ArrayList<>(), 1, 0);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }
}
