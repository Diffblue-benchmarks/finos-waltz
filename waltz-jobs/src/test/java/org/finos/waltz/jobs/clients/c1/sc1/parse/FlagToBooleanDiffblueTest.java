package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlagToBooleanDiffblueTest {
  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code 42 foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_when42Foo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("42 foo"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code 42 x}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 x'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_when42X_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("42 x"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code 42 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_when4242_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("42 42"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code foo 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo 42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenFoo42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("foo 42"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code foo foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenFooFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("foo foo"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code foo x}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo x'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenFooX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("foo x"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("foo"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code x 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'x 42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenX42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("x 42"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code x foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'x foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenXFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("x foo"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code x x}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'x x'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenXX_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FlagToBoolean.apply("x x"));
  }

  /**
   * Test {@link FlagToBoolean#apply(String)}.
   * <ul>
   *   <li>When {@code x}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FlagToBoolean#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'x'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean FlagToBoolean.apply(String)"})
  void testApply_whenX_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FlagToBoolean.apply("x"));
  }
}
