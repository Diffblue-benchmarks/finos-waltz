package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AliasesDiffblueTest {
  /**
   * Test {@link Aliases#register(Object, String[])}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  @DisplayName("Test register(Object, String[]); when MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases Aliases.register(Object, String[])"})
  void testRegister_whenMin_value() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register(Integer.MIN_VALUE, "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Test {@link Aliases#register(Object, String[])}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  @DisplayName("Test register(Object, String[]); when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases Aliases.register(Object, String[])"})
  void testRegister_whenMinusOne() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register(-1, "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Test {@link Aliases#register(Object, String[])}.
   *
   * <ul>
   *   <li>When space and {@code Aliases}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  @DisplayName("Test register(Object, String[]); when space and 'Aliases'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases Aliases.register(Object, String[])"})
  void testRegister_whenSpaceAndAliases() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val", " ", "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Test {@link Aliases#register(Object, String[])}.
   *
   * <ul>
   *   <li>When {@code Val}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  @DisplayName("Test register(Object, String[]); when 'Val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases Aliases.register(Object, String[])"})
  void testRegister_whenVal() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val", "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Test {@link Aliases#register(Object, String[])}.
   *
   * <ul>
   *   <li>When {@code Val}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  @DisplayName("Test register(Object, String[]); when 'Val'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases Aliases.register(Object, String[])"})
  void testRegister_whenVal2() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Test {@link Aliases#lookup(String)}.
   *
   * <ul>
   *   <li>When {@code 42 Alias}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  @DisplayName("Test lookup(String); when '42 Alias'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional Aliases.lookup(String)"})
  void testLookup_when42Alias() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("42 Alias").isPresent());
  }

  /**
   * Test {@link Aliases#lookup(String)}.
   *
   * <ul>
   *   <li>When {@code 42 42}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  @DisplayName("Test lookup(String); when '42 42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional Aliases.lookup(String)"})
  void testLookup_when4242() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("42 42").isPresent());
  }

  /**
   * Test {@link Aliases#lookup(String)}.
   *
   * <ul>
   *   <li>When {@code Alias}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  @DisplayName("Test lookup(String); when 'Alias'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional Aliases.lookup(String)"})
  void testLookup_whenAlias() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias").isPresent());
  }

  /**
   * Test {@link Aliases#lookup(String)}.
   *
   * <ul>
   *   <li>When {@code Alias 42}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  @DisplayName("Test lookup(String); when 'Alias 42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional Aliases.lookup(String)"})
  void testLookup_whenAlias42() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias 42").isPresent());
  }

  /**
   * Test {@link Aliases#lookup(String)}.
   *
   * <ul>
   *   <li>When {@code Alias Alias}.
   * </ul>
   *
   * <p>Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  @DisplayName("Test lookup(String); when 'Alias Alias'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Optional Aliases.lookup(String)"})
  void testLookup_whenAliasAlias() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias Alias").isPresent());
  }
}
