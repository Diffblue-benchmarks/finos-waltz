package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberDeleteCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberDeleteCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMemberDeleteCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportGridMemberDeleteCommand actualImmutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Assert
    assertEquals("42", actualImmutableReportGridMemberDeleteCommand.userId());
    assertEquals(1L, actualImmutableReportGridMemberDeleteCommand.gridId());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder gridId one userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridMemberDeleteCommand); then builder build is builder gridId one userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberDeleteCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderGridIdOneUserId42Build() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();
    ImmutableReportGridMemberDeleteCommand instance =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridMemberDeleteCommand actualImmutableReportGridMemberDeleteCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridMemberDeleteCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#gridId(long)}.
   *
   * <p>Method under test: {@link Builder#gridId(long)}
   */
  @Test
  @DisplayName("Test Builder gridId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.gridId(long)"})
  void testBuilderGridId() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act
    Builder actualGridIdResult = builderResult.gridId(1L);

    // Assert
    assertSame(builderResult, actualGridIdResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberDeleteCommand.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#copyOf(ReportGridMemberDeleteCommand)}.
   *
   * <ul>
   *   <li>When builder gridId one userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberDeleteCommand#copyOf(ReportGridMemberDeleteCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridMemberDeleteCommand); when builder gridId one userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberDeleteCommand ImmutableReportGridMemberDeleteCommand.copyOf(ReportGridMemberDeleteCommand)"
  })
  void testCopyOf_whenBuilderGridIdOneUserId42Build_thenReturnUserIdIs42() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand instance =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act
    ImmutableReportGridMemberDeleteCommand actualCopyOfResult =
        ImmutableReportGridMemberDeleteCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.gridId());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand2 =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act and Assert
    assertEquals(immutableReportGridMemberDeleteCommand, immutableReportGridMemberDeleteCommand2);
    assertEquals(
        immutableReportGridMemberDeleteCommand.hashCode(),
        immutableReportGridMemberDeleteCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberDeleteCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act and Assert
    assertEquals(immutableReportGridMemberDeleteCommand, immutableReportGridMemberDeleteCommand);
    int expectedHashCodeResult = immutableReportGridMemberDeleteCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridMemberDeleteCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(2L).userId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberDeleteCommand,
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("User Id").build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberDeleteCommand,
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build(), null);
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberDeleteCommand.equals(Object)",
    "int ImmutableReportGridMemberDeleteCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build(),
        "Different type to ImmutableReportGridMemberDeleteCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#toString()}
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#gridId()}
   *   <li>{@link ImmutableReportGridMemberDeleteCommand#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableReportGridMemberDeleteCommand.gridId()",
    "String ImmutableReportGridMemberDeleteCommand.toString()",
    "String ImmutableReportGridMemberDeleteCommand.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act
    String actualToStringResult = immutableReportGridMemberDeleteCommand.toString();
    long actualGridIdResult = immutableReportGridMemberDeleteCommand.gridId();

    // Assert
    assertEquals("42", immutableReportGridMemberDeleteCommand.userId());
    assertEquals("ReportGridMemberDeleteCommand{gridId=1, userId=42}", actualToStringResult);
    assertEquals(1L, actualGridIdResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setUserId(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.gridId);
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Test Json {@link Json#gridId()}.
   *
   * <p>Method under test: {@link Json#gridId()}
   */
  @Test
  @DisplayName("Test Json gridId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.gridId()"})
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridId());
  }

  /**
   * Test Json {@link Json#setGridId(long)}.
   *
   * <p>Method under test: {@link Json#setGridId(long)}
   */
  @Test
  @DisplayName("Test Json setGridId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setGridId(long)"})
  void testJsonSetGridId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
  }

  /**
   * Test Json {@link Json#userId()}.
   *
   * <p>Method under test: {@link Json#userId()}
   */
  @Test
  @DisplayName("Test Json userId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userId()"})
  void testJsonUserId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userId());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#withGridId(long)}.
   *
   * <ul>
   *   <li>Given builder gridId one userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#withGridId(long)}
   */
  @Test
  @DisplayName(
      "Test withGridId(long); given builder gridId one userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberDeleteCommand ImmutableReportGridMemberDeleteCommand.withGridId(long)"
  })
  void testWithGridId_givenBuilderGridIdOneUserId42Build_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberDeleteCommand actualWithGridIdResult =
        ImmutableReportGridMemberDeleteCommand.builder()
            .gridId(1L)
            .userId("42")
            .build()
            .withGridId(42L);

    // Assert
    assertEquals("42", actualWithGridIdResult.userId());
    assertEquals(42L, actualWithGridIdResult.gridId());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#withGridId(long)}.
   *
   * <ul>
   *   <li>Then return builder gridId forty-two userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#withGridId(long)}
   */
  @Test
  @DisplayName("Test withGridId(long); then return builder gridId forty-two userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberDeleteCommand ImmutableReportGridMemberDeleteCommand.withGridId(long)"
  })
  void testWithGridId_thenReturnBuilderGridIdFortyTwoUserId42Build() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(42L).userId("42").build();

    // Act
    ImmutableReportGridMemberDeleteCommand actualWithGridIdResult =
        immutableReportGridMemberDeleteCommand.withGridId(42L);

    // Assert
    assertSame(immutableReportGridMemberDeleteCommand, actualWithGridIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Given builder gridId one userId {@code userId} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); given builder gridId one userId 'userId' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberDeleteCommand ImmutableReportGridMemberDeleteCommand.withUserId(String)"
  })
  void testWithUserId_givenBuilderGridIdOneUserIdUserIdBuild_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberDeleteCommand actualWithUserIdResult =
        ImmutableReportGridMemberDeleteCommand.builder()
            .gridId(1L)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals(1L, actualWithUserIdResult.gridId());
  }

  /**
   * Test {@link ImmutableReportGridMemberDeleteCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return builder gridId one userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberDeleteCommand#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return builder gridId one userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberDeleteCommand ImmutableReportGridMemberDeleteCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnBuilderGridIdOneUserId42Build() {
    // Arrange
    ImmutableReportGridMemberDeleteCommand immutableReportGridMemberDeleteCommand =
        ImmutableReportGridMemberDeleteCommand.builder().gridId(1L).userId("42").build();

    // Act
    ImmutableReportGridMemberDeleteCommand actualWithUserIdResult =
        immutableReportGridMemberDeleteCommand.withUserId("42");

    // Assert
    assertSame(immutableReportGridMemberDeleteCommand, actualWithUserIdResult);
  }
}
