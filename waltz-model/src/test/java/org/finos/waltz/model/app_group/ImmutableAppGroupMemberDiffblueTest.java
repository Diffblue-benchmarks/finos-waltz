package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.app_group.ImmutableAppGroupMember.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupMember.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupMemberDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAppGroupMember actualImmutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableAppGroupMember.userId());
    assertEquals(1L, actualImmutableAppGroupMember.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualImmutableAppGroupMember.role());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupMember)}.
   *
   * <ul>
   *   <li>Then builder build is builder groupId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppGroupMember)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppGroupMember); then builder build is builder groupId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupMember)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderGroupIdOneRoleViewerUserId42Build() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();
    ImmutableAppGroupMember instance =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAppGroupMember actualImmutableAppGroupMember = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupMember);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#groupId(long)}.
   *
   * <p>Method under test: {@link Builder#groupId(long)}
   */
  @Test
  @DisplayName("Test Builder groupId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.groupId(long)"})
  void testBuilderGroupId() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act
    Builder actualGroupIdResult = builderResult.groupId(1L);

    // Assert
    assertSame(builderResult, actualGroupIdResult);
  }

  /**
   * Test Builder {@link Builder#role(AppGroupMemberRole)}.
   *
   * <p>Method under test: {@link Builder#role(AppGroupMemberRole)}
   */
  @Test
  @DisplayName("Test Builder role(AppGroupMemberRole)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.role(AppGroupMemberRole)"})
  void testBuilderRole() {
    // Arrange
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act
    Builder actualRoleResult = builderResult.role(AppGroupMemberRole.VIEWER);

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
    Builder builderResult = ImmutableAppGroupMember.builder();

    // Act
    Builder actualUserIdResult = builderResult.userId("42");

    // Assert
    assertSame(builderResult, actualUserIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupMember#copyOf(AppGroupMember)}.
   *
   * <ul>
   *   <li>When builder groupId one role {@code VIEWER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#copyOf(AppGroupMember)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppGroupMember); when builder groupId one role 'VIEWER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember ImmutableAppGroupMember.copyOf(AppGroupMember)"})
  void testCopyOf_whenBuilderGroupIdOneRoleViewerUserId42Build_thenReturnUserIdIs42() {
    // Arrange
    ImmutableAppGroupMember instance =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableAppGroupMember actualCopyOfResult = ImmutableAppGroupMember.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.userId());
    assertEquals(1L, actualCopyOfResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualCopyOfResult.role());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}, and {@link
   * ImmutableAppGroupMember#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupMember#equals(Object)}
   *   <li>{@link ImmutableAppGroupMember#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();
    ImmutableAppGroupMember immutableAppGroupMember2 =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupMember, immutableAppGroupMember2);
    assertEquals(immutableAppGroupMember.hashCode(), immutableAppGroupMember2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}, and {@link
   * ImmutableAppGroupMember#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupMember#equals(Object)}
   *   <li>{@link ImmutableAppGroupMember#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertEquals(immutableAppGroupMember, immutableAppGroupMember);
    int expectedHashCodeResult = immutableAppGroupMember.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroupMember.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(2L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupMember,
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.OWNER)
            .userId("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupMember,
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("User Id")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAppGroupMember,
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build());
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAppGroupMember#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupMember.equals(Object)",
    "int ImmutableAppGroupMember.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build(),
        "Different type to ImmutableAppGroupMember");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupMember#toString()}
   *   <li>{@link ImmutableAppGroupMember#groupId()}
   *   <li>{@link ImmutableAppGroupMember#role()}
   *   <li>{@link ImmutableAppGroupMember#userId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAppGroupMember.groupId()",
    "AppGroupMemberRole ImmutableAppGroupMember.role()",
    "String ImmutableAppGroupMember.toString()",
    "String ImmutableAppGroupMember.userId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    String actualToStringResult = immutableAppGroupMember.toString();
    long actualGroupIdResult = immutableAppGroupMember.groupId();
    AppGroupMemberRole actualRoleResult = immutableAppGroupMember.role();

    // Assert
    assertEquals("42", immutableAppGroupMember.userId());
    assertEquals("AppGroupMember{groupId=1, userId=42, role=VIEWER}", actualToStringResult);
    assertEquals(1L, actualGroupIdResult);
    assertEquals(AppGroupMemberRole.VIEWER, actualRoleResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRole(AppGroupMemberRole)}
   *   <li>{@link Json#setUserId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setRole(AppGroupMemberRole)",
    "void Json.setUserId(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRole(AppGroupMemberRole.VIEWER);
    actualJson.setUserId("42");

    // Assert
    assertEquals("42", actualJson.userId);
    assertEquals(0L, actualJson.groupId);
    assertEquals(AppGroupMemberRole.VIEWER, actualJson.role);
    assertFalse(actualJson.groupIdIsSet);
  }

  /**
   * Test Json {@link Json#groupId()}.
   *
   * <p>Method under test: {@link Json#groupId()}
   */
  @Test
  @DisplayName("Test Json groupId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.groupId()"})
  void testJsonGroupId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().groupId());
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
  @MethodsUnderTest({"AppGroupMemberRole Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().role());
  }

  /**
   * Test Json {@link Json#setGroupId(long)}.
   *
   * <p>Method under test: {@link Json#setGroupId(long)}
   */
  @Test
  @DisplayName("Test Json setGroupId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setGroupId(long)"})
  void testJsonSetGroupId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setGroupId(1L);

    // Assert
    assertEquals(1L, json.groupId);
    assertTrue(json.groupIdIsSet);
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
   * Test {@link ImmutableAppGroupMember#withGroupId(long)}.
   *
   * <ul>
   *   <li>Then return builder groupId forty-two role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withGroupId(long)}
   */
  @Test
  @DisplayName(
      "Test withGroupId(long); then return builder groupId forty-two role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember ImmutableAppGroupMember.withGroupId(long)"})
  void testWithGroupId_thenReturnBuilderGroupIdFortyTwoRoleViewerUserId42Build() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(42L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableAppGroupMember actualWithGroupIdResult = immutableAppGroupMember.withGroupId(42L);

    // Assert
    assertSame(immutableAppGroupMember, actualWithGroupIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupMember#withGroupId(long)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withGroupId(long)}
   */
  @Test
  @DisplayName("Test withGroupId(long); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember ImmutableAppGroupMember.withGroupId(long)"})
  void testWithGroupId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAppGroupMember actualWithGroupIdResult =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build()
            .withGroupId(42L);

    // Assert
    assertEquals("42", actualWithGroupIdResult.userId());
    assertEquals(42L, actualWithGroupIdResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualWithGroupIdResult.role());
  }

  /**
   * Test {@link ImmutableAppGroupMember#withRole(AppGroupMemberRole)}.
   *
   * <ul>
   *   <li>Given builder groupId one role {@code OWNER} userId {@code 42} build.
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withRole(AppGroupMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(AppGroupMemberRole); given builder groupId one role 'OWNER' userId '42' build; then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupMember ImmutableAppGroupMember.withRole(AppGroupMemberRole)"
  })
  void testWithRole_givenBuilderGroupIdOneRoleOwnerUserId42Build_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAppGroupMember actualWithRoleResult =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.OWNER)
            .userId("42")
            .build()
            .withRole(AppGroupMemberRole.VIEWER);

    // Assert
    assertEquals("42", actualWithRoleResult.userId());
    assertEquals(1L, actualWithRoleResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualWithRoleResult.role());
  }

  /**
   * Test {@link ImmutableAppGroupMember#withRole(AppGroupMemberRole)}.
   *
   * <ul>
   *   <li>Then return builder groupId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withRole(AppGroupMemberRole)}
   */
  @Test
  @DisplayName(
      "Test withRole(AppGroupMemberRole); then return builder groupId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupMember ImmutableAppGroupMember.withRole(AppGroupMemberRole)"
  })
  void testWithRole_thenReturnBuilderGroupIdOneRoleViewerUserId42Build() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableAppGroupMember actualWithRoleResult =
        immutableAppGroupMember.withRole(AppGroupMemberRole.VIEWER);

    // Assert
    assertSame(immutableAppGroupMember, actualWithRoleResult);
  }

  /**
   * Test {@link ImmutableAppGroupMember#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return builder groupId one role {@code VIEWER} userId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withUserId(String)}
   */
  @Test
  @DisplayName(
      "Test withUserId(String); then return builder groupId one role 'VIEWER' userId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember ImmutableAppGroupMember.withUserId(String)"})
  void testWithUserId_thenReturnBuilderGroupIdOneRoleViewerUserId42Build() {
    // Arrange
    ImmutableAppGroupMember immutableAppGroupMember =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("42")
            .build();

    // Act
    ImmutableAppGroupMember actualWithUserIdResult = immutableAppGroupMember.withUserId("42");

    // Assert
    assertSame(immutableAppGroupMember, actualWithUserIdResult);
  }

  /**
   * Test {@link ImmutableAppGroupMember#withUserId(String)}.
   *
   * <ul>
   *   <li>Then return userId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupMember#withUserId(String)}
   */
  @Test
  @DisplayName("Test withUserId(String); then return userId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupMember ImmutableAppGroupMember.withUserId(String)"})
  void testWithUserId_thenReturnUserIdIs42() {
    // Arrange and Act
    ImmutableAppGroupMember actualWithUserIdResult =
        ImmutableAppGroupMember.builder()
            .groupId(1L)
            .role(AppGroupMemberRole.VIEWER)
            .userId("userId")
            .build()
            .withUserId("42");

    // Assert
    assertEquals("42", actualWithUserIdResult.userId());
    assertEquals(1L, actualWithUserIdResult.groupId());
    assertEquals(AppGroupMemberRole.VIEWER, actualWithUserIdResult.role());
  }
}
