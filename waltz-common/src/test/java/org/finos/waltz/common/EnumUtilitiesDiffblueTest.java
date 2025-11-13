package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.lang.Character.UnicodeScript;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import javax.lang.model.SourceVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumUtilitiesDiffblueTest {
  /**
   * Test {@link EnumUtilities#readEnum(String, Class, Function)}.
   *
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  @DisplayName(
      "Test readEnum(String, Class, Function); given 'CONSTANT_ASCENT'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.readEnum(String, Class, Function)"})
  void testReadEnum_givenConstantAscent_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualReadEnumResult =
        EnumUtilities.readEnum("42", enumClass, failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply("42");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link EnumUtilities#readEnum(String, Class, Function)}.
   *
   * <ul>
   *   <li>When {@code CONSTANT_ASCENT}.
   *   <li>Then return {@code CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  @DisplayName(
      "Test readEnum(String, Class, Function); when 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.readEnum(String, Class, Function)"})
  void testReadEnum_whenConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act
    BaselineResizeBehavior actualReadEnumResult =
        EnumUtilities.readEnum("CONSTANT_ASCENT", enumClass, mock(Function.class));

    // Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); given 'CONSTANT_ASCENT'; when '42'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_givenConstantAscent_when42_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases("42", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply("42");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.
   *   <li>When {@code Enum}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); given 'CONSTANT_ASCENT'; when 'java.lang.Enum'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_givenConstantAscent_whenJavaLangEnum_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases(
            "java.lang.Enum", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply("java.lang.Enum");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>When {@code CONSTANT_ASCENT}.
   *   <li>Then return {@code CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); when 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases(
            "CONSTANT_ASCENT", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>When {@code Enum class must be supplied}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); when 'Enum class must be supplied'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenEnumClassMustBeSupplied_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases(
            "Enum class must be supplied", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply("Enum class must be supplied");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>When {@code failedParseSupplier cannot be null}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); when 'failedParseSupplier cannot be null'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenFailedParseSupplierCannotBeNull_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases(
            "failedParseSupplier cannot be null", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply("failedParseSupplier cannot be null");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   *
   * <ul>
   *   <li>When {@code value cannot be empty}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function,
   * Aliases)}
   */
  @Test
  @DisplayName(
      "Test parseEnumWithAliases(String, Class, Function, Aliases); when 'value cannot be empty'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenValueCannotBeEmpty_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult =
        EnumUtilities.parseEnumWithAliases(
            "value cannot be empty", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply("value cannot be empty");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

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
    assertTrue(actualNamesResult.contains("RELEASE_11"));
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
