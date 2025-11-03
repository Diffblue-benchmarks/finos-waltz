package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.lang.Character.UnicodeScript;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumUtilitiesDiffblueTest {
  /**
   * Test {@link EnumUtilities#readEnum(String, Class, Function)}.
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  @DisplayName("Test readEnum(String, Class, Function); given 'CONSTANT_ASCENT'; when '42'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.readEnum(String, Class, Function)"})
  void testReadEnum_givenConstantAscent_when42_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualReadEnumResult = EnumUtilities.readEnum("42", enumClass, failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply(eq("42"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link EnumUtilities#readEnum(String, Class, Function)}.
   * <ul>
   *   <li>When {@code CONSTANT_ASCENT}.</li>
   *   <li>Then return {@code CONSTANT_ASCENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  @DisplayName("Test readEnum(String, Class, Function); when 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.readEnum(String, Class, Function)"})
  void testReadEnum_whenConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act and Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT,
        EnumUtilities.readEnum("CONSTANT_ASCENT", enumClass, mock(Function.class)));
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); given 'CONSTANT_ASCENT'; when '42'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_givenConstantAscent_when42_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities.parseEnumWithAliases("42", enumClass,
        failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("42"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>Given {@code CONSTANT_ASCENT}.</li>
   *   <li>When {@code java.lang.Enum}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); given 'CONSTANT_ASCENT'; when 'java.lang.Enum'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_givenConstantAscent_whenJavaLangEnum_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities.parseEnumWithAliases("java.lang.Enum",
        enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("java.lang.Enum"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>When {@code CONSTANT_ASCENT}.</li>
   *   <li>Then return {@code CONSTANT_ASCENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); when 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);

    // Act and Assert
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT,
        EnumUtilities.parseEnumWithAliases("CONSTANT_ASCENT", enumClass, failedParseSupplier, new Aliases<>()));
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>When {@code Enum class must be supplied}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); when 'Enum class must be supplied'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenEnumClassMustBeSupplied_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("Enum class must be supplied", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("Enum class must be supplied"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>When {@code failedParseSupplier cannot be null}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); when 'failedParseSupplier cannot be null'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenFailedParseSupplierCannotBeNull_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("failedParseSupplier cannot be null", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("failedParseSupplier cannot be null"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>When {@code value cannot be empty}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); when 'value cannot be empty'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenValueCannotBeEmpty_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("value cannot be empty", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("value cannot be empty"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}.
   * <ul>
   *   <li>When {@code value cannot be null}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  @DisplayName("Test parseEnumWithAliases(String, Class, Function, Aliases); when 'value cannot be null'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum EnumUtilities.parseEnumWithAliases(String, Class, Function, Aliases)"})
  void testParseEnumWithAliases_whenValueCannotBeNull_thenCallsApply() {
    // Arrange
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities.parseEnumWithAliases("value cannot be null",
        enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("value cannot be null"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Test {@link EnumUtilities#names(Enum[])} with {@code Enum[]}.
   * <ul>
   *   <li>When {@link UnicodeScript} with one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EnumUtilities#names(Object[])}
   */
  @Test
  @DisplayName("Test names(Enum[]) with 'Enum[]'; when UnicodeScript with one; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set EnumUtilities.names(java.lang.Enum[])"})
  void testNamesWithEnum_whenUnicodeScriptWithOne_thenReturnSizeIsOne() {
    // Arrange and Act
    Set<String> actualNamesResult = EnumUtilities.names(UnicodeScript.of(1));

    // Assert
    assertEquals(1, actualNamesResult.size());
    assertTrue(actualNamesResult.contains("COMMON"));
  }
}
