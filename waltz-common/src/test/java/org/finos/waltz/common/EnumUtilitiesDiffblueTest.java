package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.lang.Character.UnicodeScript;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import javax.lang.model.SourceVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EnumUtilitiesDiffblueTest {
  /**
   * Test {@link EnumUtilities#names(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given latest.
   *   <li>When {@link ArrayList#ArrayList()} add latest.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#names(Collection)}
   */
  @Test
  @DisplayName(
      "Test names(Collection) with 'Collection'; given latest; when ArrayList() add latest; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EnumUtilities.names(Collection)"})
  void testNamesWithCollection_givenLatest_whenArrayListAddLatest_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Enum<?>> enums = new ArrayList<>();
    enums.add(SourceVersion.latest());
    enums.add(UnicodeScript.of(1));

    // Act
    Set<String> actualNamesResult = EnumUtilities.names(enums);

    // Assert
    assertEquals(2, actualNamesResult.size());
    assertTrue(actualNamesResult.contains("COMMON"));
    assertTrue(actualNamesResult.contains("RELEASE_8"));
  }

  /**
   * Test {@link EnumUtilities#names(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>Given {@link UnicodeScript} with one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#names(Collection)}
   */
  @Test
  @DisplayName(
      "Test names(Collection) with 'Collection'; given UnicodeScript with one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EnumUtilities.names(Collection)"})
  void testNamesWithCollection_givenUnicodeScriptWithOne_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<Enum<?>> enums = new ArrayList<>();
    enums.add(UnicodeScript.of(1));

    // Act
    Set<String> actualNamesResult = EnumUtilities.names(enums);

    // Assert
    assertEquals(1, actualNamesResult.size());
    assertTrue(actualNamesResult.contains("COMMON"));
  }

  /**
   * Test {@link EnumUtilities#names(Collection)} with {@code Collection}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#names(Collection)}
   */
  @Test
  @DisplayName("Test names(Collection) with 'Collection'; when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EnumUtilities.names(Collection)"})
  void testNamesWithCollection_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualNamesResult = EnumUtilities.names(new ArrayList<>());

    // Assert
    assertTrue(actualNamesResult.isEmpty());
  }

  /**
   * Test {@link EnumUtilities#names(Enum[])} with {@code Enum[]}.
   *
   * <ul>
   *   <li>When {@link UnicodeScript} with one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#names(Object[])}
   */
  @Test
  @DisplayName(
      "Test names(Enum[]) with 'Enum[]'; when UnicodeScript with one; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EnumUtilities.names(Enum[])"})
  void testNamesWithEnum_whenUnicodeScriptWithOne_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualNamesResult = EnumUtilities.names(UnicodeScript.of(1));

    // Assert
    assertEquals(1, actualNamesResult.size());
    assertTrue(actualNamesResult.contains("COMMON"));
  }
}
