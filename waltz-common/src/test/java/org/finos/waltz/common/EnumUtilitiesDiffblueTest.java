package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumUtilitiesDiffblueTest {
  /**
   * Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  void testReadEnum() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualReadEnumResult = EnumUtilities.readEnum("42", enumClass,
        failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply(eq("42"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Method under test: {@link EnumUtilities#readEnum(String, Class, Function)}
   */
  @Test
  void testReadEnum2() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;

    // Act and Assert
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT,
        EnumUtilities.readEnum("CONSTANT_ASCENT", enumClass, mock(Function.class)));
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities.parseEnumWithAliases("42",
        enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("42"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases2() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("value cannot be empty", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("value cannot be empty"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases3() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("Enum class must be supplied", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("Enum class must be supplied"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases4() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("failedParseSupplier cannot be null", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("failedParseSupplier cannot be null"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases5() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);

    // Act and Assert
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT,
        EnumUtilities.parseEnumWithAliases("CONSTANT_ASCENT", enumClass, failedParseSupplier, new Aliases<>()));
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases6() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("java.lang.Enum", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("java.lang.Enum"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumUtilities#parseEnumWithAliases(String, Class, Function, Aliases)}
   */
  @Test
  void testParseEnumWithAliases7() {
    // Arrange
    Class<Component.BaselineResizeBehavior> enumClass = Component.BaselineResizeBehavior.class;
    Function<String, Component.BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(Component.BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    Component.BaselineResizeBehavior actualParseEnumWithAliasesResult = EnumUtilities
        .parseEnumWithAliases("value cannot be null", enumClass, failedParseSupplier, new Aliases<>());

    // Assert
    verify(failedParseSupplier).apply(eq("value cannot be null"));
    assertEquals(Component.BaselineResizeBehavior.CONSTANT_ASCENT, actualParseEnumWithAliasesResult);
  }

  /**
   * Method under test: {@link EnumUtilities#names(Collection)}
   */
  @Test
  void testNames() {
    // Arrange and Act
    Set<String> actualNamesResult = EnumUtilities.names(new ArrayList<>());

    // Assert
    assertTrue(actualNamesResult.isEmpty());
  }

  /**
   * Method under test: {@link EnumUtilities#names(Object[])}
   */
  @Test
  void testNames2() {
    // Arrange and Act
    Set<String> actualNamesResult = EnumUtilities.names(Character.UnicodeScript.of(1));

    // Assert
    assertEquals(1, actualNamesResult.size());
    assertTrue(actualNamesResult.contains("COMMON"));
  }
}
