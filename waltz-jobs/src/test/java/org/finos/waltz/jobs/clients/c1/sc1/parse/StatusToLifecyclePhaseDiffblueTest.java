package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusToLifecyclePhaseDiffblueTest {
  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code 42 beendet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 beendet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_when42Beendet() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 beendet"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code 42 foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_when42Foo() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 foo"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code 42 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_when4242() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("42 42"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code beendet 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'beendet 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenBeendet42() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet 42"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code beendet beendet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'beendet beendet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenBeendetBeendet() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet beendet"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code beendet foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'beendet foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenBeendetFoo() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("beendet foo"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenFoo() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code foo 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenFoo42() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo 42"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code foo beendet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo beendet'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenFooBeendet() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo beendet"));
  }

  /**
   * Test {@link StatusToLifecyclePhase#apply(String)}.
   * <ul>
   *   <li>When {@code foo foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StatusToLifecyclePhase#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LifecyclePhase StatusToLifecyclePhase.apply(String)"})
  void testApply_whenFooFoo() {
    // Arrange, Act and Assert
    assertEquals(LifecyclePhase.PRODUCTION, StatusToLifecyclePhase.apply("foo foo"));
  }
}
