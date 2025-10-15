package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StatusToEntityLifecycleStatusDiffblueTest {
  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code 42 abgeschaltet}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 abgeschaltet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_when42Abgeschaltet() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 abgeschaltet"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code 42 foo}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_when42Foo() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 foo"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code 42 42}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_when4242() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("42 42"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code abgeschaltet 42}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'abgeschaltet 42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenAbgeschaltet42() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("abgeschaltet 42"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code abgeschaltet abgeschaltet}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'abgeschaltet abgeschaltet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenAbgeschaltetAbgeschaltet() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE,
        StatusToEntityLifecycleStatus.apply("abgeschaltet abgeschaltet"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code abgeschaltet foo}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'abgeschaltet foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenAbgeschaltetFoo() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("abgeschaltet foo"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenFoo() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code foo 42}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo 42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenFoo42() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo 42"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code foo abgeschaltet}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo abgeschaltet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenFooAbgeschaltet() {
    // Arrange, Act and Assert
    assertEquals(
        EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo abgeschaltet"));
  }

  /**
   * Test {@link StatusToEntityLifecycleStatus#apply(String)}.
   *
   * <ul>
   *   <li>When {@code foo foo}.
   * </ul>
   *
   * <p>Method under test: {@link StatusToEntityLifecycleStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityLifecycleStatus StatusToEntityLifecycleStatus.apply(String)"})
  void testApply_whenFooFoo() {
    // Arrange, Act and Assert
    assertEquals(EntityLifecycleStatus.ACTIVE, StatusToEntityLifecycleStatus.apply("foo foo"));
  }
}
