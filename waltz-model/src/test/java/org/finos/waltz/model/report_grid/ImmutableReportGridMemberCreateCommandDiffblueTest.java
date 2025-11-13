package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridMemberCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportGridMemberCreateCommand actualImmutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableReportGridMemberCreateCommand.userId());
    assertEquals(1L, actualImmutableReportGridMemberCreateCommand.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualImmutableReportGridMemberCreateCommand.role());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMemberCreateCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder gridId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridMemberCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridMemberCreateCommand); then builder build is builder gridId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberCreateCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderGridIdOneRoleViewerUserId42Build() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();
    ImmutableReportGridMemberCreateCommand instance =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridMemberCreateCommand actualImmutableReportGridMemberCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridMemberCreateCommand);
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
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act
    Builder actualGridIdResult = builderResult.gridId(1L);

    // Assert
    assertSame(builderResult, actualGridIdResult);
  }

  /**
   * Test Builder {@link Builder#role(ReportGridMemberRole)}.
   *
   * <p>Method under test: {@link Builder#role(ReportGridMemberRole)}
   */
  @Test
  @DisplayName("Test Builder role(ReportGridMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.role(ReportGridMemberRole)"})
  void testBuilderRole() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act
    Builder actualRoleResult = builderResult.role(ReportGridMemberRole.VIEWER);

    // Assert
    assertSame(builderResult, actualRoleResult);
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
    Builder builderResult = ImmutableReportGridMemberCreateCommand.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#copyOf(ReportGridMemberCreateCommand)}.
   *
   * <ul>
   *   <li>When builder gridId one role {@code VIEWER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberCreateCommand#copyOf(ReportGridMemberCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridMemberCreateCommand); when builder gridId one role 'VIEWER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.copyOf(ReportGridMemberCreateCommand)"
  })
  void testCopyOf_whenBuilderGridIdOneRoleViewerUserId42Build_thenReturnUserIdIs42() {
    // Arrange
    ImmutableReportGridMemberCreateCommand instance =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberCreateCommand actualCopyOfResult =
        ImmutableReportGridMemberCreateCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand2 =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridMemberCreateCommand, immutableReportGridMemberCreateCommand2);
    assertEquals(
        immutableReportGridMemberCreateCommand.hashCode(),
        immutableReportGridMemberCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableReportGridMemberCreateCommand, immutableReportGridMemberCreateCommand);
    int expectedHashCodeResult = immutableReportGridMemberCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridMemberCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(2L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberCreateCommand,
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.OWNER)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberCreateCommand,
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("User Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberCreateCommand,
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberCreateCommand.equals(Object)",
    "int ImmutableReportGridMemberCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build(),
        "Different type to ImmutableReportGridMemberCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberCreateCommand#toString()}
   *   <li>{@link ImmutableReportGridMemberCreateCommand#gridId()}
   *   <li>{@link ImmutableReportGridMemberCreateCommand#role()}
   *   <li>{@link ImmutableReportGridMemberCreateCommand#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableReportGridMemberCreateCommand.gridId()",
    "ReportGridMemberRole ImmutableReportGridMemberCreateCommand.role()",
    "String ImmutableReportGridMemberCreateCommand.toString()",
    "String ImmutableReportGridMemberCreateCommand.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableReportGridMemberCreateCommand.toString();
    long actualGridIdResult = immutableReportGridMemberCreateCommand.gridId();
    ReportGridMemberRole actualRoleResult = immutableReportGridMemberCreateCommand.role();

    // Assert
    assertEquals("42", immutableReportGridMemberCreateCommand.userId());
    assertEquals(
        "ReportGridMemberCreateCommand{gridId=1, userId=42, role=VIEWER}", actualToStringResult);
    assertEquals(1L, actualGridIdResult);
    assertEquals(ReportGridMemberRole.VIEWER, actualRoleResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRole(ReportGridMemberRole)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setRole(ReportGridMemberRole)",
    "void Json.setUserId(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRole(ReportGridMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.gridId);
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
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
   * Test Json {@link Json#role()}.
   *
   * <p>Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().role());
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
   * Test {@link ImmutableReportGridMemberCreateCommand#withGridId(long)}.
   *
   * <ul>
   *   <li>Given builder gridId one role {@code VIEWER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#withGridId(long)}
   */
  @Test
  @DisplayName(
      "Test withGridId(long); given builder gridId one role 'VIEWER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withGridId(long)"
  })
  void testWithGridId_givenBuilderGridIdOneRoleViewerUserId42Build_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberCreateCommand actualWithGridIdResult =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build()
            .withGridId(42L);

    // Assert
    assertEquals("42", actualWithGridIdResult.userId());
    assertEquals(42L, actualWithGridIdResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithGridIdResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#withGridId(long)}.
   *
   * <ul>
   *   <li>Then return builder gridId forty-two role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#withGridId(long)}
   */
  @Test
  @DisplayName(
      "Test withGridId(long); then return builder gridId forty-two role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withGridId(long)"
  })
  void testWithGridId_thenReturnBuilderGridIdFortyTwoRoleViewerUserId42Build() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(42L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberCreateCommand actualWithGridIdResult =
        immutableReportGridMemberCreateCommand.withGridId(42L);

    // Assert
    assertSame(immutableReportGridMemberCreateCommand, actualWithGridIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#withRole(ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given builder gridId one role {@code OWNER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberCreateCommand#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(ReportGridMemberRole); given builder gridId one role 'OWNER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withRole(ReportGridMemberRole)"
  })
  void testWithRole_givenBuilderGridIdOneRoleOwnerUserId42Build_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberCreateCommand actualWithRoleResult =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.OWNER)
            .userId("42")
            .build()
            .withRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertEquals("42", actualWithRoleResult.userId());
    assertEquals(1L, actualWithRoleResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithRoleResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#withRole(ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Then return builder gridId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberCreateCommand#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(ReportGridMemberRole); then return builder gridId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withRole(ReportGridMemberRole)"
  })
  void testWithRole_thenReturnBuilderGridIdOneRoleViewerUserId42Build() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberCreateCommand actualWithRoleResult =
        immutableReportGridMemberCreateCommand.withRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertSame(immutableReportGridMemberCreateCommand, actualWithRoleResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return builder gridId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); then return builder gridId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnBuilderGridIdOneRoleViewerUserId42Build() {
    // Arrange
    ImmutableReportGridMemberCreateCommand immutableReportGridMemberCreateCommand =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberCreateCommand actualWithUserIdResult =
        immutableReportGridMemberCreateCommand.withUserId("42");

    // Assert
    assertSame(immutableReportGridMemberCreateCommand, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberCreateCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberCreateCommand#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberCreateCommand ImmutableReportGridMemberCreateCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberCreateCommand actualWithUserIdResult =
        ImmutableReportGridMemberCreateCommand.builder()
            .gridId(1L)
            .role(ReportGridMemberRole.VIEWER)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals(1L, actualWithUserIdResult.gridId());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithUserIdResult.role());
  }
}
