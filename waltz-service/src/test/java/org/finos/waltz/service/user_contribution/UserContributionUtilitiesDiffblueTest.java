package org.finos.waltz.service.user_contribution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.tally.OrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UserContributionUtilitiesDiffblueTest {
  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   * <ul>
   *   <li>Given {@link OrderedTally} {@link Tally#id()} return {@code foo}.</li>
   *   <li>Then return size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); given OrderedTally id() return 'foo'; then return size is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenOrderedTallyIdReturnFoo_thenReturnSizeIsTen() {
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
    OrderedTally<String> orderedTally12 = mock(OrderedTally.class);
    when(orderedTally12.id()).thenReturn("42");
    OrderedTally<String> orderedTally13 = mock(OrderedTally.class);
    when(orderedTally13.id()).thenReturn("42");
    OrderedTally<String> orderedTally14 = mock(OrderedTally.class);
    when(orderedTally14.id()).thenReturn("42");
    OrderedTally<String> orderedTally15 = mock(OrderedTally.class);
    when(orderedTally15.id()).thenReturn("42");
    OrderedTally<String> orderedTally16 = mock(OrderedTally.class);
    when(orderedTally16.id()).thenReturn("42");
    OrderedTally<String> orderedTally17 = mock(OrderedTally.class);
    when(orderedTally17.id()).thenReturn("42");
    OrderedTally<String> orderedTally18 = mock(OrderedTally.class);
    when(orderedTally18.id()).thenReturn("42");
    OrderedTally<String> orderedTally19 = mock(OrderedTally.class);
    when(orderedTally19.id()).thenReturn("42");
    OrderedTally<String> orderedTally20 = mock(OrderedTally.class);
    when(orderedTally20.id()).thenReturn("42");
    OrderedTally<String> orderedTally21 = mock(OrderedTally.class);
    when(orderedTally21.id()).thenReturn("42");
    OrderedTally<String> orderedTally22 = mock(OrderedTally.class);
    when(orderedTally22.id()).thenReturn("42");
    OrderedTally<String> orderedTally23 = mock(OrderedTally.class);
    when(orderedTally23.id()).thenReturn("42");
    OrderedTally<String> orderedTally24 = mock(OrderedTally.class);
    when(orderedTally24.id()).thenReturn("42");
    OrderedTally<String> orderedTally25 = mock(OrderedTally.class);
    when(orderedTally25.id()).thenReturn("42");
    OrderedTally<String> orderedTally26 = mock(OrderedTally.class);
    when(orderedTally26.id()).thenReturn("42");
    OrderedTally<String> orderedTally27 = mock(OrderedTally.class);
    when(orderedTally27.id()).thenReturn("42");
    OrderedTally<String> orderedTally28 = mock(OrderedTally.class);
    when(orderedTally28.id()).thenReturn("42");
    OrderedTally<String> orderedTally29 = mock(OrderedTally.class);
    when(orderedTally29.id()).thenReturn("42");
    OrderedTally<String> orderedTally30 = mock(OrderedTally.class);
    when(orderedTally30.id()).thenReturn("42");
    OrderedTally<String> orderedTally31 = mock(OrderedTally.class);
    when(orderedTally31.id()).thenReturn("42");
    OrderedTally<String> orderedTally32 = mock(OrderedTally.class);
    when(orderedTally32.id()).thenReturn("42");
    OrderedTally<String> orderedTally33 = mock(OrderedTally.class);
    when(orderedTally33.id()).thenReturn("42");
    OrderedTally<String> orderedTally34 = mock(OrderedTally.class);
    when(orderedTally34.id()).thenReturn("42");
    OrderedTally<String> orderedTally35 = mock(OrderedTally.class);
    when(orderedTally35.id()).thenReturn("42");
    OrderedTally<String> orderedTally36 = mock(OrderedTally.class);
    when(orderedTally36.id()).thenReturn("42");
    OrderedTally<String> orderedTally37 = mock(OrderedTally.class);
    when(orderedTally37.id()).thenReturn("42");
    OrderedTally<String> orderedTally38 = mock(OrderedTally.class);
    when(orderedTally38.id()).thenReturn("42");
    OrderedTally<String> orderedTally39 = mock(OrderedTally.class);
    when(orderedTally39.id()).thenReturn("42");
    OrderedTally<String> orderedTally40 = mock(OrderedTally.class);
    when(orderedTally40.id()).thenReturn("42");
    OrderedTally<String> orderedTally41 = mock(OrderedTally.class);
    when(orderedTally41.id()).thenReturn("42");
    OrderedTally<String> orderedTally42 = mock(OrderedTally.class);
    when(orderedTally42.id()).thenReturn("42");
    OrderedTally<String> orderedTally43 = mock(OrderedTally.class);
    when(orderedTally43.id()).thenReturn("42");
    OrderedTally<String> orderedTally44 = mock(OrderedTally.class);
    when(orderedTally44.id()).thenReturn("42");
    OrderedTally<String> orderedTally45 = mock(OrderedTally.class);
    when(orderedTally45.id()).thenReturn("42");
    OrderedTally<String> orderedTally46 = mock(OrderedTally.class);
    when(orderedTally46.id()).thenReturn("42");
    OrderedTally<String> orderedTally47 = mock(OrderedTally.class);
    when(orderedTally47.id()).thenReturn("42");
    OrderedTally<String> orderedTally48 = mock(OrderedTally.class);
    when(orderedTally48.id()).thenReturn("42");
    OrderedTally<String> orderedTally49 = mock(OrderedTally.class);
    when(orderedTally49.id()).thenReturn("42");
    OrderedTally<String> orderedTally50 = mock(OrderedTally.class);
    when(orderedTally50.id()).thenReturn("42");
    OrderedTally<String> orderedTally51 = mock(OrderedTally.class);
    when(orderedTally51.id()).thenReturn("42");
    OrderedTally<String> orderedTally52 = mock(OrderedTally.class);
    when(orderedTally52.id()).thenReturn("42");
    OrderedTally<String> orderedTally53 = mock(OrderedTally.class);
    when(orderedTally53.id()).thenReturn("42");
    OrderedTally<String> orderedTally54 = mock(OrderedTally.class);
    when(orderedTally54.id()).thenReturn("42");
    OrderedTally<String> orderedTally55 = mock(OrderedTally.class);
    when(orderedTally55.id()).thenReturn("42");
    OrderedTally<String> orderedTally56 = mock(OrderedTally.class);
    when(orderedTally56.id()).thenReturn("42");
    OrderedTally<String> orderedTally57 = mock(OrderedTally.class);
    when(orderedTally57.id()).thenReturn("42");
    OrderedTally<String> orderedTally58 = mock(OrderedTally.class);
    when(orderedTally58.id()).thenReturn("42");
    OrderedTally<String> orderedTally59 = mock(OrderedTally.class);
    when(orderedTally59.id()).thenReturn("42");
    OrderedTally<String> orderedTally60 = mock(OrderedTally.class);
    when(orderedTally60.id()).thenReturn("42");
    OrderedTally<String> orderedTally61 = mock(OrderedTally.class);
    when(orderedTally61.id()).thenReturn("42");
    OrderedTally<String> orderedTally62 = mock(OrderedTally.class);
    when(orderedTally62.id()).thenReturn("42");
    OrderedTally<String> orderedTally63 = mock(OrderedTally.class);
    when(orderedTally63.id()).thenReturn("42");
    OrderedTally<String> orderedTally64 = mock(OrderedTally.class);
    when(orderedTally64.id()).thenReturn("42");
    OrderedTally<String> orderedTally65 = mock(OrderedTally.class);
    when(orderedTally65.id()).thenReturn("42");
    OrderedTally<String> orderedTally66 = mock(OrderedTally.class);
    when(orderedTally66.id()).thenReturn("42");
    OrderedTally<String> orderedTally67 = mock(OrderedTally.class);
    when(orderedTally67.id()).thenReturn("42");
    OrderedTally<String> orderedTally68 = mock(OrderedTally.class);
    when(orderedTally68.id()).thenReturn("42");
    OrderedTally<String> orderedTally69 = mock(OrderedTally.class);
    when(orderedTally69.id()).thenReturn("42");
    OrderedTally<String> orderedTally70 = mock(OrderedTally.class);
    when(orderedTally70.id()).thenReturn("42");
    OrderedTally<String> orderedTally71 = mock(OrderedTally.class);
    when(orderedTally71.id()).thenReturn("42");
    OrderedTally<String> orderedTally72 = mock(OrderedTally.class);
    when(orderedTally72.id()).thenReturn("42");
    OrderedTally<String> orderedTally73 = mock(OrderedTally.class);
    when(orderedTally73.id()).thenReturn("42");
    OrderedTally<String> orderedTally74 = mock(OrderedTally.class);
    when(orderedTally74.id()).thenReturn("42");
    OrderedTally<String> orderedTally75 = mock(OrderedTally.class);
    when(orderedTally75.id()).thenReturn("42");
    OrderedTally<String> orderedTally76 = mock(OrderedTally.class);
    when(orderedTally76.id()).thenReturn("42");
    OrderedTally<String> orderedTally77 = mock(OrderedTally.class);
    when(orderedTally77.id()).thenReturn("42");
    OrderedTally<String> orderedTally78 = mock(OrderedTally.class);
    when(orderedTally78.id()).thenReturn("42");
    OrderedTally<String> orderedTally79 = mock(OrderedTally.class);
    when(orderedTally79.id()).thenReturn("42");
    OrderedTally<String> orderedTally80 = mock(OrderedTally.class);
    when(orderedTally80.id()).thenReturn("42");
    OrderedTally<String> orderedTally81 = mock(OrderedTally.class);
    when(orderedTally81.id()).thenReturn("42");
    OrderedTally<String> orderedTally82 = mock(OrderedTally.class);
    when(orderedTally82.id()).thenReturn("42");
    OrderedTally<String> orderedTally83 = mock(OrderedTally.class);
    when(orderedTally83.id()).thenReturn("42");
    OrderedTally<String> orderedTally84 = mock(OrderedTally.class);
    when(orderedTally84.id()).thenReturn("42");
    OrderedTally<String> orderedTally85 = mock(OrderedTally.class);
    when(orderedTally85.id()).thenReturn("42");
    OrderedTally<String> orderedTally86 = mock(OrderedTally.class);
    when(orderedTally86.id()).thenReturn("42");
    OrderedTally<String> orderedTally87 = mock(OrderedTally.class);
    when(orderedTally87.id()).thenReturn("42");
    OrderedTally<String> orderedTally88 = mock(OrderedTally.class);
    when(orderedTally88.id()).thenReturn("42");
    OrderedTally<String> orderedTally89 = mock(OrderedTally.class);
    when(orderedTally89.id()).thenReturn("42");
    OrderedTally<String> orderedTally90 = mock(OrderedTally.class);
    when(orderedTally90.id()).thenReturn("42");
    OrderedTally<String> orderedTally91 = mock(OrderedTally.class);
    when(orderedTally91.id()).thenReturn("42");
    OrderedTally<String> orderedTally92 = mock(OrderedTally.class);
    when(orderedTally92.id()).thenReturn("42");
    OrderedTally<String> orderedTally93 = mock(OrderedTally.class);
    when(orderedTally93.id()).thenReturn("42");
    OrderedTally<String> orderedTally94 = mock(OrderedTally.class);
    when(orderedTally94.id()).thenReturn("42");
    OrderedTally<String> orderedTally95 = mock(OrderedTally.class);
    when(orderedTally95.id()).thenReturn("42");
    OrderedTally<String> orderedTally96 = mock(OrderedTally.class);
    when(orderedTally96.index()).thenReturn(1);
    when(orderedTally96.id()).thenReturn("42");
    OrderedTally<String> orderedTally97 = mock(OrderedTally.class);
    when(orderedTally97.id()).thenReturn("foo");

    ArrayList<OrderedTally<String>> list = new ArrayList<>();
    list.add(orderedTally97);
    list.add(orderedTally96);
    list.add(orderedTally95);
    list.add(orderedTally94);
    list.add(orderedTally93);
    list.add(orderedTally92);
    list.add(orderedTally91);
    list.add(orderedTally90);
    list.add(orderedTally89);
    list.add(orderedTally88);
    list.add(orderedTally87);
    list.add(orderedTally86);
    list.add(orderedTally85);
    list.add(orderedTally84);
    list.add(orderedTally83);
    list.add(orderedTally82);
    list.add(orderedTally81);
    list.add(orderedTally80);
    list.add(orderedTally79);
    list.add(orderedTally78);
    list.add(orderedTally77);
    list.add(orderedTally76);
    list.add(orderedTally75);
    list.add(orderedTally74);
    list.add(orderedTally73);
    list.add(orderedTally72);
    list.add(orderedTally71);
    list.add(orderedTally70);
    list.add(orderedTally69);
    list.add(orderedTally68);
    list.add(orderedTally67);
    list.add(orderedTally66);
    list.add(orderedTally65);
    list.add(orderedTally64);
    list.add(orderedTally63);
    list.add(orderedTally62);
    list.add(orderedTally61);
    list.add(orderedTally60);
    list.add(orderedTally59);
    list.add(orderedTally58);
    list.add(orderedTally57);
    list.add(orderedTally56);
    list.add(orderedTally55);
    list.add(orderedTally54);
    list.add(orderedTally53);
    list.add(orderedTally52);
    list.add(orderedTally51);
    list.add(orderedTally50);
    list.add(orderedTally49);
    list.add(orderedTally48);
    list.add(orderedTally47);
    list.add(orderedTally46);
    list.add(orderedTally45);
    list.add(orderedTally44);
    list.add(orderedTally43);
    list.add(orderedTally42);
    list.add(orderedTally41);
    list.add(orderedTally40);
    list.add(orderedTally39);
    list.add(orderedTally38);
    list.add(orderedTally37);
    list.add(orderedTally36);
    list.add(orderedTally35);
    list.add(orderedTally34);
    list.add(orderedTally33);
    list.add(orderedTally32);
    list.add(orderedTally31);
    list.add(orderedTally30);
    list.add(orderedTally29);
    list.add(orderedTally28);
    list.add(orderedTally27);
    list.add(orderedTally26);
    list.add(orderedTally25);
    list.add(orderedTally24);
    list.add(orderedTally23);
    list.add(orderedTally22);
    list.add(orderedTally21);
    list.add(orderedTally20);
    list.add(orderedTally19);
    list.add(orderedTally18);
    list.add(orderedTally17);
    list.add(orderedTally16);
    list.add(orderedTally15);
    list.add(orderedTally14);
    list.add(orderedTally13);
    list.add(orderedTally12);
    list.add(orderedTally11);
    list.add(orderedTally10);
    list.add(orderedTally9);
    list.add(orderedTally8);
    list.add(orderedTally7);
    list.add(orderedTally6);
    list.add(orderedTally5);
    list.add(orderedTally4);
    list.add(orderedTally3);
    list.add(orderedTally2);
    list.add(orderedTally);

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 = UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    verify(orderedTally96).index();
    verify(orderedTally97).id();
    verify(orderedTally96).id();
    assertEquals(10, actualOrderedListOf10.size());
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   * <ul>
   *   <li>Given {@link OrderedTally} {@link OrderedTally#index()} return one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); given OrderedTally index() return one; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenOrderedTallyIndexReturnOne_thenReturnArrayList() {
    // Arrange
    OrderedTally<String> orderedTally = mock(OrderedTally.class);
    when(orderedTally.index()).thenReturn(1);
    when(orderedTally.id()).thenReturn("42");

    ArrayList<OrderedTally<String>> list = new ArrayList<>();
    list.add(orderedTally);

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 = UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    verify(orderedTally).index();
    verify(orderedTally).id();
    assertEquals(list, actualOrderedListOf10);
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   * <ul>
   *   <li>Given {@link OrderedTally} {@link OrderedTally#index()} return one.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); given OrderedTally index() return one; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenOrderedTallyIndexReturnOne_thenReturnArrayList2() {
    // Arrange
    OrderedTally<String> orderedTally = mock(OrderedTally.class);
    when(orderedTally.index()).thenReturn(1);
    when(orderedTally.id()).thenReturn("42");
    OrderedTally<String> orderedTally2 = mock(OrderedTally.class);
    when(orderedTally2.index()).thenReturn(1);
    when(orderedTally2.id()).thenReturn("42");

    ArrayList<OrderedTally<String>> list = new ArrayList<>();
    list.add(orderedTally2);
    list.add(orderedTally);

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 = UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    verify(orderedTally2).index();
    verify(orderedTally2).id();
    assertEquals(list, actualOrderedListOf10);
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   * <ul>
   *   <li>Given {@link OrderedTally} {@link OrderedTally#index()} return one.</li>
   *   <li>Then return size is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); given OrderedTally index() return one; then return size is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_givenOrderedTallyIndexReturnOne_thenReturnSizeIsTen() {
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

    ArrayList<OrderedTally<String>> list = new ArrayList<>();
    list.add(orderedTally11);
    list.add(orderedTally10);
    list.add(orderedTally9);
    list.add(orderedTally8);
    list.add(orderedTally7);
    list.add(orderedTally6);
    list.add(orderedTally5);
    list.add(orderedTally4);
    list.add(orderedTally3);
    list.add(orderedTally2);
    list.add(orderedTally);

    // Act
    List<OrderedTally<String>> actualOrderedListOf10 = UserContributionUtilities.getOrderedListOf10(list, "42");

    // Assert
    verify(orderedTally11).index();
    verify(orderedTally11).id();
    assertEquals(10, actualOrderedListOf10.size());
  }

  /**
   * Test {@link UserContributionUtilities#getOrderedListOf10(List, String)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#getOrderedListOf10(List, String)}
   */
  @Test
  @DisplayName("Test getOrderedListOf10(List, String); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.getOrderedListOf10(List, String)"})
  void testGetOrderedListOf10_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<OrderedTally<String>> actualOrderedListOf10 = UserContributionUtilities.getOrderedListOf10(new ArrayList<>(),
        "42");

    // Assert
    assertTrue(actualOrderedListOf10.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code -2147483647}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); given '42'; when '-2147483647'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_when2147483647_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, -2147483647);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_whenArrayListAdd42_thenReturnEmpty() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); given '42'; when ArrayList() add '42'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_given42_whenArrayListAdd42_thenReturnEmpty2() {
    // Arrange
    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(list, Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>Given {@code List}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code List}.</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); given 'List'; when ArrayList() add 'List'; then return ArrayList()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(new ArrayList<>(), 1, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenArrayList_thenReturnEmpty2() {
    // Arrange and Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(new ArrayList<>(), Integer.MIN_VALUE, 3);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when two; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenTwo_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(new ArrayList<>(), 1, 2);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }

  /**
   * Test {@link UserContributionUtilities#findWindow(List, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserContributionUtilities#findWindow(List, int, int)}
   */
  @Test
  @DisplayName("Test findWindow(List, int, int); when zero; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UserContributionUtilities.findWindow(List, int, int)"})
  void testFindWindow_whenZero_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFindWindowResult = UserContributionUtilities.findWindow(new ArrayList<>(), 1, 0);

    // Assert
    assertTrue(actualFindWindowResult.isEmpty());
  }
}
