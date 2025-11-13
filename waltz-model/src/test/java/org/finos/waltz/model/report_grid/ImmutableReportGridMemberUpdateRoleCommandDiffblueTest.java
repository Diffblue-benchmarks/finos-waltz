package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberUpdateRoleCommand.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridMemberUpdateRoleCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridMemberUpdateRoleCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#role(ReportGridMemberRole)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand Builder.build()",
    "Builder Builder.role(ReportGridMemberRole)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableReportGridMemberUpdateRoleCommand actualImmutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableReportGridMemberUpdateRoleCommand.userId());
    assertEquals(
        ReportGridMemberRole.VIEWER, actualImmutableReportGridMemberUpdateRoleCommand.role());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>Then builder build is builder role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridMemberUpdateRoleCommand); then builder build is builder role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridMemberUpdateRoleCommand)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRoleViewerUserId42Build() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand.builder();
    ImmutableReportGridMemberUpdateRoleCommand instance =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridMemberUpdateRoleCommand actualImmutableReportGridMemberUpdateRoleCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridMemberUpdateRoleCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#userId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userId(String)}
   */
  @Test
  @DisplayName("Test Builder userId(String); when '42'; then builder build userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userId(String)"})
  void testBuilderUserId_when42_thenBuilderBuildUserIdIs42() {
    // Arrange
    Builder builderResult = ImmutableReportGridMemberUpdateRoleCommand.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        builderResult.build();
    assertEquals("42", immutableReportGridMemberUpdateRoleCommand.userId());
    assertEquals(ReportGridMemberRole.VIEWER, immutableReportGridMemberUpdateRoleCommand.role());
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link
   * ImmutableReportGridMemberUpdateRoleCommand#copyOf(ReportGridMemberUpdateRoleCommand)}.
   *
   * <ul>
   *   <li>When builder role {@code VIEWER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberUpdateRoleCommand#copyOf(ReportGridMemberUpdateRoleCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridMemberUpdateRoleCommand); when builder role 'VIEWER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.copyOf(ReportGridMemberUpdateRoleCommand)"
  })
  void testCopyOf_whenBuilderRoleViewerUserId42Build_thenReturnUserIdIs42() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand instance =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualCopyOfResult =
        ImmutableReportGridMemberUpdateRoleCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberUpdateRoleCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand2 =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridMemberUpdateRoleCommand, immutableReportGridMemberUpdateRoleCommand2);
    assertEquals(
        immutableReportGridMemberUpdateRoleCommand.hashCode(),
        immutableReportGridMemberUpdateRoleCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}, and {@link
   * ImmutableReportGridMemberUpdateRoleCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridMemberUpdateRoleCommand, immutableReportGridMemberUpdateRoleCommand);
    int expectedHashCodeResult = immutableReportGridMemberUpdateRoleCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridMemberUpdateRoleCommand.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.OWNER)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberUpdateRoleCommand,
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("User Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridMemberUpdateRoleCommand,
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridMemberUpdateRoleCommand.equals(Object)",
    "int ImmutableReportGridMemberUpdateRoleCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build(),
        "Different type to ImmutableReportGridMemberUpdateRoleCommand");
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Role is {@code null}.
   *   <li>Then return userId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Role is 'null'; then return userId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonRoleIsNull_thenReturnUserIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserId("Json");
    json.setRole(null);

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualFromJsonResult =
        ImmutableReportGridMemberUpdateRoleCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code VIEWER}.
   *   <li>When {@link Json} (default constructor) Role is {@code VIEWER}.
   *   <li>Then return userId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'VIEWER'; when Json (default constructor) Role is 'VIEWER'; then return userId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.fromJson(Json)"
  })
  void testFromJson_givenViewer_whenJsonRoleIsViewer_thenReturnUserIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserId("Json");
    json.setRole(ReportGridMemberRole.VIEWER);

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualFromJsonResult =
        ImmutableReportGridMemberUpdateRoleCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualFromJsonResult.role());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#toString()}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#role()}
   *   <li>{@link ImmutableReportGridMemberUpdateRoleCommand#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReportGridMemberRole ImmutableReportGridMemberUpdateRoleCommand.role()",
    "String ImmutableReportGridMemberUpdateRoleCommand.toString()",
    "String ImmutableReportGridMemberUpdateRoleCommand.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableReportGridMemberUpdateRoleCommand.toString();
    ReportGridMemberRole actualRoleResult = immutableReportGridMemberUpdateRoleCommand.role();

    // Assert
    assertEquals("42", immutableReportGridMemberUpdateRoleCommand.userId());
    assertEquals("ReportGridMemberUpdateRoleCommand{userId=42, role=VIEWER}", actualToStringResult);
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
    assertEquals(ReportGridMemberRole.VIEWER, actualJson.role);
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
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#withRole(ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Given builder role {@code OWNER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberUpdateRoleCommand#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(ReportGridMemberRole); given builder role 'OWNER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.withRole(ReportGridMemberRole)"
  })
  void testWithRole_givenBuilderRoleOwnerUserId42Build_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberUpdateRoleCommand actualWithRoleResult =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.OWNER)
            .userId("42")
            .build()
            .withRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertEquals("42", actualWithRoleResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithRoleResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#withRole(ReportGridMemberRole)}.
   *
   * <ul>
   *   <li>Then return builder role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridMemberUpdateRoleCommand#withRole(ReportGridMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(ReportGridMemberRole); then return builder role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.withRole(ReportGridMemberRole)"
  })
  void testWithRole_thenReturnBuilderRoleViewerUserId42Build() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualWithRoleResult =
        immutableReportGridMemberUpdateRoleCommand.withRole(ReportGridMemberRole.VIEWER);

    // Assert
    assertSame(immutableReportGridMemberUpdateRoleCommand, actualWithRoleResult);
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Given builder role {@code VIEWER} userId {@code userId} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); given builder role 'VIEWER' userId 'userId' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.withUserId(String)"
  })
  void testWithUserId_givenBuilderRoleViewerUserIdUserIdBuild_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableReportGridMemberUpdateRoleCommand actualWithUserIdResult =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals(ReportGridMemberRole.VIEWER, actualWithUserIdResult.role());
  }

  /**
   * Test {@link ImmutableReportGridMemberUpdateRoleCommand#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return builder role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridMemberUpdateRoleCommand#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return builder role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridMemberUpdateRoleCommand ImmutableReportGridMemberUpdateRoleCommand.withUserId(String)"
  })
  void testWithUserId_thenReturnBuilderRoleViewerUserId42Build() {
    // Arrange
    ImmutableReportGridMemberUpdateRoleCommand immutableReportGridMemberUpdateRoleCommand =
        ImmutableReportGridMemberUpdateRoleCommand.builder()
            .role(ReportGridMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableReportGridMemberUpdateRoleCommand actualWithUserIdResult =
        immutableReportGridMemberUpdateRoleCommand.withUserId("42");

    // Assert
    assertSame(immutableReportGridMemberUpdateRoleCommand, actualWithUserIdResult);
  }
}
