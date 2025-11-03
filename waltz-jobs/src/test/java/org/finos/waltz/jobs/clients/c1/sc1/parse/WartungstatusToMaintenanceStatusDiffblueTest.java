package org.finos.waltz.jobs.clients.c1.sc1.parse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.clients.c1.sc1.model.MaintenanceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WartungstatusToMaintenanceStatusDiffblueTest {
  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung0-hauptwartung0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung0-hauptwartung0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung0Hauptwartung0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF,
        WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung 0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung 0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung0Hauptwartung2() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung 0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung0-hauptwartung42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung0-hauptwartung42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung0Hauptwartung42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartung42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung0-hauptwartungfoo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung0-hauptwartungfoo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung0Hauptwartungfoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung0-hauptwartungfoo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung42foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung42foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung42foo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung42foo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung420-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung420-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung420Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung420-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung422() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung 42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartung4242() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung4242"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartung foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartung foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0HauptwartungFoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartung foo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartungfoo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartungfoo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartungfoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartungfoo0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartungfoo0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartungfoo0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartungfoo42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartungfoo42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartungfoo42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoo42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 0-hauptwartungfoofoo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '0-hauptwartungfoofoo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when0Hauptwartungfoofoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("0-hauptwartungfoofoo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 42 foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when42Foo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 foo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 42foo0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42foo0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when42foo0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42foo0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 420-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '420-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when420Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 420-hauptwartung0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '420-hauptwartung0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when420Hauptwartung0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 42 0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when420Hauptwartung2() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 420-hauptwartung42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '420-hauptwartung42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when420Hauptwartung42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartung42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 420-hauptwartungfoo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '420-hauptwartungfoo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when420Hauptwartungfoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("420-hauptwartungfoo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 42 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when4242() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42 42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code 42420-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when '42420-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_when42420Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("42420-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo0-hauptwartung0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo0-hauptwartung0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo0Hauptwartung0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo 0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo 0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo0Hauptwartung2() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo 0-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo0-hauptwartung42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo0-hauptwartung42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo0Hauptwartung42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartung42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo0-hauptwartungfoo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo0-hauptwartungfoo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo0Hauptwartungfoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo0-hauptwartungfoo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo 42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo42() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo 42"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo420-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo420-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoo420Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo420-hauptwartung"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foo foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foo foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFooFoo() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foo foo"));
  }

  /**
   * Test {@link WartungstatusToMaintenanceStatus#apply(String)}.
   * <ul>
   *   <li>When {@code foofoo0-hauptwartung}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WartungstatusToMaintenanceStatus#apply(String)}
   */
  @Test
  @DisplayName("Test apply(String); when 'foofoo0-hauptwartung'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"MaintenanceStatus WartungstatusToMaintenanceStatus.apply(String)"})
  void testApply_whenFoofoo0Hauptwartung() {
    // Arrange, Act and Assert
    assertEquals(MaintenanceStatus.SELF, WartungstatusToMaintenanceStatus.apply("foofoo0-hauptwartung"));
  }
}
