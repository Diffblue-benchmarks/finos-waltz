package org.finos.waltz.model.reportee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.reportee.ImmutableReportee.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReporteeDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportee actualImmutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Assert
    assertEquals("42", actualImmutableReportee.employeeId());
    assertEquals("42", actualImmutableReportee.managerId());
    assertEquals(1, actualImmutableReportee.level());
  }

  /**
   * Test Builder {@link Builder#employeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act
    Builder actualEmployeeIdResult = builderResult.employeeId("42");

    // Assert
    assertSame(builderResult, actualEmployeeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(Reportee)}.
   *
   * <ul>
   *   <li>Then builder build is builder employeeId {@code 42} level one managerId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(Reportee)}
   */
  @Test
  @DisplayName(
      "Test Builder from(Reportee); then builder build is builder employeeId '42' level one managerId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Reportee)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderEmployeeId42LevelOneManagerId42Build() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();
    ImmutableReportee instance =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportee actualImmutableReportee = builderResult.build();
    assertEquals(instance, actualImmutableReportee);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#level(int)}.
   *
   * <p>Method under test: {@link Builder#level(int)}
   */
  @Test
  @DisplayName("Test Builder level(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.level(int)"})
  void testBuilderLevel() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act
    Builder actualLevelResult = builderResult.level(1);

    // Assert
    assertSame(builderResult, actualLevelResult);
  }

  /**
   * Test Builder {@link Builder#managerId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#managerId(String)}
   */
  @Test
  @DisplayName("Test Builder managerId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.managerId(String)"})
  void testBuilderManagerId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportee.builder();

    // Act
    Builder actualManagerIdResult = builderResult.managerId("42");

    // Assert
    assertSame(builderResult, actualManagerIdResult);
  }

  /**
   * Test {@link ImmutableReportee#copyOf(Reportee)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#copyOf(Reportee)}
   */
  @Test
  @DisplayName("Test copyOf(Reportee); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.copyOf(Reportee)"})
  void testCopyOf_thenReturnEmployeeIdIs42() {
    // Arrange
    ImmutableReportee instance =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act
    ImmutableReportee actualCopyOfResult = ImmutableReportee.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("42", actualCopyOfResult.managerId());
    assertEquals(1, actualCopyOfResult.level());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}, and {@link ImmutableReportee#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportee#equals(Object)}
   *   <li>{@link ImmutableReportee#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();
    ImmutableReportee immutableReportee2 =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act and Assert
    assertEquals(immutableReportee, immutableReportee2);
    assertEquals(immutableReportee.hashCode(), immutableReportee2.hashCode());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}, and {@link ImmutableReportee#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportee#equals(Object)}
   *   <li>{@link ImmutableReportee#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act and Assert
    assertEquals(immutableReportee, immutableReportee);
    int expectedHashCodeResult = immutableReportee.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportee.hashCode());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("Employee Id").level(1).managerId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableReportee,
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(0).managerId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableReportee,
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("Manager Id").build();

    // Act and Assert
    assertNotEquals(
        immutableReportee,
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build());
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build(), null);
  }

  /**
   * Test {@link ImmutableReportee#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportee.equals(Object)",
    "int ImmutableReportee.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build(),
        "Different type to ImmutableReportee");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportee#toString()}
   *   <li>{@link ImmutableReportee#employeeId()}
   *   <li>{@link ImmutableReportee#level()}
   *   <li>{@link ImmutableReportee#managerId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableReportee.employeeId()",
    "int ImmutableReportee.level()",
    "String ImmutableReportee.managerId()",
    "String ImmutableReportee.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act
    String actualToStringResult = immutableReportee.toString();
    String actualEmployeeIdResult = immutableReportee.employeeId();
    int actualLevelResult = immutableReportee.level();

    // Assert
    assertEquals("42", actualEmployeeIdResult);
    assertEquals("42", immutableReportee.managerId());
    assertEquals("Reportee{employeeId=42, managerId=42, level=1}", actualToStringResult);
    assertEquals(1, actualLevelResult);
  }

  /**
   * Test {@link ImmutableReportee#withEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return builder employeeId {@code 42} level one managerId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withEmployeeId(String)}
   */
  @Test
  @DisplayName(
      "Test withEmployeeId(String); then return builder employeeId '42' level one managerId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withEmployeeId(String)"})
  void testWithEmployeeId_thenReturnBuilderEmployeeId42LevelOneManagerId42Build() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act
    ImmutableReportee actualWithEmployeeIdResult = immutableReportee.withEmployeeId("42");

    // Assert
    assertSame(immutableReportee, actualWithEmployeeIdResult);
  }

  /**
   * Test {@link ImmutableReportee#withEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withEmployeeId(String); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withEmployeeId(String)"})
  void testWithEmployeeId_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutableReportee actualWithEmployeeIdResult =
        ImmutableReportee.builder()
            .employeeId("employeeId")
            .level(1)
            .managerId("42")
            .build()
            .withEmployeeId("42");

    // Assert
    assertEquals("42", actualWithEmployeeIdResult.employeeId());
    assertEquals("42", actualWithEmployeeIdResult.managerId());
    assertEquals(1, actualWithEmployeeIdResult.level());
  }

  /**
   * Test {@link ImmutableReportee#withLevel(int)}.
   *
   * <ul>
   *   <li>Then return builder employeeId {@code 42} level forty-two managerId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withLevel(int)}
   */
  @Test
  @DisplayName(
      "Test withLevel(int); then return builder employeeId '42' level forty-two managerId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withLevel(int)"})
  void testWithLevel_thenReturnBuilderEmployeeId42LevelFortyTwoManagerId42Build() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(42).managerId("42").build();

    // Act
    ImmutableReportee actualWithLevelResult = immutableReportee.withLevel(42);

    // Assert
    assertSame(immutableReportee, actualWithLevelResult);
  }

  /**
   * Test {@link ImmutableReportee#withLevel(int)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withLevel(int)}
   */
  @Test
  @DisplayName("Test withLevel(int); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withLevel(int)"})
  void testWithLevel_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutableReportee actualWithLevelResult =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build().withLevel(42);

    // Assert
    assertEquals("42", actualWithLevelResult.employeeId());
    assertEquals("42", actualWithLevelResult.managerId());
    assertEquals(42, actualWithLevelResult.level());
  }

  /**
   * Test {@link ImmutableReportee#withManagerId(String)}.
   *
   * <ul>
   *   <li>Then return builder employeeId {@code 42} level one managerId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withManagerId(String)}
   */
  @Test
  @DisplayName(
      "Test withManagerId(String); then return builder employeeId '42' level one managerId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withManagerId(String)"})
  void testWithManagerId_thenReturnBuilderEmployeeId42LevelOneManagerId42Build() {
    // Arrange
    ImmutableReportee immutableReportee =
        ImmutableReportee.builder().employeeId("42").level(1).managerId("42").build();

    // Act
    ImmutableReportee actualWithManagerIdResult = immutableReportee.withManagerId("42");

    // Assert
    assertSame(immutableReportee, actualWithManagerIdResult);
  }

  /**
   * Test {@link ImmutableReportee#withManagerId(String)}.
   *
   * <ul>
   *   <li>Then return employeeId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportee#withManagerId(String)}
   */
  @Test
  @DisplayName("Test withManagerId(String); then return employeeId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportee ImmutableReportee.withManagerId(String)"})
  void testWithManagerId_thenReturnEmployeeIdIs42() {
    // Arrange and Act
    ImmutableReportee actualWithManagerIdResult =
        ImmutableReportee.builder()
            .employeeId("42")
            .level(1)
            .managerId("managerId")
            .build()
            .withManagerId("42");

    // Assert
    assertEquals("42", actualWithManagerIdResult.employeeId());
    assertEquals("42", actualWithManagerIdResult.managerId());
    assertEquals(1, actualWithManagerIdResult.level());
  }
}
