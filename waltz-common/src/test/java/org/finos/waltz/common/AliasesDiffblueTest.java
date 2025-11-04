package org.finos.waltz.common;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AliasesDiffblueTest {
  /**
   * Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  void testRegister() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val", "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  void testRegister2() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register(-1, "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  void testRegister3() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register(Integer.MIN_VALUE, "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  void testRegister4() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Method under test: {@link Aliases#register(Object, String[])}
   */
  @Test
  void testRegister5() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act
    Aliases actualRegisterResult = aliases.register("Val", " ", "Aliases");

    // Assert
    assertFalse(actualRegisterResult.lookup("Alias").isPresent());
    assertSame(aliases, actualRegisterResult);
  }

  /**
   * Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  void testLookup() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias").isPresent());
  }

  /**
   * Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  void testLookup2() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias Alias").isPresent());
  }

  /**
   * Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  void testLookup3() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("Alias 42").isPresent());
  }

  /**
   * Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  void testLookup4() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("42 Alias").isPresent());
  }

  /**
   * Method under test: {@link Aliases#lookup(String)}
   */
  @Test
  void testLookup5() {
    // Arrange
    Aliases<Object> aliases = new Aliases<>();

    // Act and Assert
    assertFalse(aliases.lookup("42 42").isPresent());
  }
}
