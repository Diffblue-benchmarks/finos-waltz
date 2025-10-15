package org.finos.waltz.model.role.RoleView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.role.ImmutableRole;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView.Builder;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoleViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllUsers(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUsers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllUsers(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUsers(Iterable)"})
  void testBuilderAddAllUsers_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllUsersResult = builderResult.addAllUsers(elements);

    // Assert
    assertSame(builderResult, actualAddAllUsersResult);
  }

  /**
   * Test Builder {@link Builder#addAllUsers(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUsers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUsers(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUsers(Iterable)"})
  void testBuilderAddAllUsers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act
    Builder actualAddAllUsersResult = builderResult.addAllUsers(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllUsersResult);
  }

  /**
   * Test Builder {@link Builder#addUsers(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addUsers(String)}
   */
  @Test
  @DisplayName("Test Builder addUsers(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUsers(String)"})
  void testBuilderAddUsersWithElement() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act
    Builder actualAddUsersResult = builderResult.addUsers("Element");

    // Assert
    assertSame(builderResult, actualAddUsersResult);
  }

  /**
   * Test Builder {@link Builder#addUsers(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addUsers(String[])}
   */
  @Test
  @DisplayName("Test Builder addUsers(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUsers(String[])"})
  void testBuilderAddUsersWithElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act
    Builder actualAddUsersResult = builderResult.addUsers("Elements");

    // Assert
    assertSame(builderResult, actualAddUsersResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRoleView.builder();
    ImmutableRole role =
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build();
    ImmutableRoleView actualImmutableRoleView = actualBuilderResult.role(role).build();

    // Assert
    assertTrue(actualImmutableRoleView.users().isEmpty());
    assertSame(role, actualImmutableRoleView.role());
  }

  /**
   * Test Builder {@link Builder#from(RoleView)}.
   *
   * <p>Method under test: {@link Builder#from(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test Builder from(RoleView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RoleView.RoleView)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    Builder builderResult2 = ImmutableRoleView.builder();
    ImmutableRoleView instance =
        builderResult2
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRoleView actualImmutableRoleView = builderResult.build();
    assertEquals(instance, actualImmutableRoleView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RoleView)}.
   *
   * <ul>
   *   <li>Given {@code instance}.
   *   <li>When builder addUsers {@code instance}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test Builder from(RoleView); given 'instance'; when builder addUsers 'instance'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RoleView.RoleView)"})
  void testBuilderFrom_givenInstance_whenBuilderAddUsersInstance() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    Builder builderResult2 = ImmutableRoleView.builder();
    builderResult2.addUsers("instance");
    ImmutableRoleView instance =
        builderResult2
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRoleView actualImmutableRoleView = builderResult.build();
    assertEquals(instance, actualImmutableRoleView);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#role(Role)}.
   *
   * <ul>
   *   <li>When {@link Role}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#role(Role)}
   */
  @Test
  @DisplayName("Test Builder role(Role); when Role; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.role(Role)"})
  void testBuilderRole_whenRole_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    Role role = mock(Role.class);

    // Act
    Builder actualRoleResult = builderResult.role(role);

    // Assert
    assertSame(builderResult, actualRoleResult);
    assertSame(role, builderResult.build().role());
  }

  /**
   * Test Builder {@link Builder#users(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#users(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder users(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.users(Iterable)"})
  void testBuilderUsers_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualUsersResult = builderResult.users(elements);

    // Assert
    assertSame(builderResult, actualUsersResult);
  }

  /**
   * Test Builder {@link Builder#users(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#users(Iterable)}
   */
  @Test
  @DisplayName("Test Builder users(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.users(Iterable)"})
  void testBuilderUsers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act
    Builder actualUsersResult = builderResult.users(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualUsersResult);
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#copyOf(RoleView)}.
   *
   * <ul>
   *   <li>Then role return {@link ImmutableRole}.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#copyOf(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test copyOf(RoleView); then role return ImmutableRole")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RoleView.ImmutableRoleView RoleView.ImmutableRoleView.copyOf(RoleView.RoleView)"
  })
  void testCopyOf_thenRoleReturnImmutableRole() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView instance =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoleView actualCopyOfResult = ImmutableRoleView.copyOf(instance);

    // Assert
    Role roleResult = actualCopyOfResult.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    assertTrue(actualCopyOfResult.users().isEmpty());
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}, and {@link
   * RoleView.ImmutableRoleView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RoleView.ImmutableRoleView#equals(Object)}
   *   <li>{@link RoleView.ImmutableRoleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView2 =
        builderResult2
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableRoleView, immutableRoleView2);
    assertEquals(immutableRoleView.hashCode(), immutableRoleView2.hashCode());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}, and {@link
   * RoleView.ImmutableRoleView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RoleView.ImmutableRoleView#equals(Object)}
   *   <li>{@link RoleView.ImmutableRoleView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableRoleView, immutableRoleView);
    int expectedHashCodeResult = immutableRoleView.hashCode();
    assertEquals(expectedHashCodeResult, immutableRoleView.hashCode());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    builderResult.addUsers("Key");
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoleView.builder();

    // Act and Assert
    assertNotEquals(
        immutableRoleView,
        builderResult2
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("Key")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoleView.builder();

    // Act and Assert
    assertNotEquals(
        immutableRoleView,
        builderResult2
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RoleView.ImmutableRoleView.equals(Object)",
    "int RoleView.ImmutableRoleView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableRoleView");
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Users is {@link HashSet#HashSet()}.
   *   <li>Then return users Empty.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Users is HashSet(); then return users Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonUsersIsHashSet_thenReturnUsersEmpty() {
    // Arrange
    Json json = new Json();
    json.setRole(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
    json.setUsers(new HashSet<>());

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.users().isEmpty());
    Role expectedRoleResult = json.role;
    assertSame(expectedRoleResult, actualFromJsonResult.role());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Json}.
   *   <li>Then return users size is one.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'Json'; then return users size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnUsersSizeIsOne() {
    // Arrange
    LinkedHashSet<String> users = new LinkedHashSet<>();
    users.add("Json");

    Json json = new Json();
    json.setRole(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
    json.setUsers(users);

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    Set<String> usersResult = actualFromJsonResult.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("Json"));
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code role}.
   *   <li>Then return users is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'role'; then return users is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddRole_thenReturnUsersIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<String> users = new LinkedHashSet<>();
    users.add("role");
    users.add("Json");

    Json json = new Json();
    json.setRole(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
    json.setUsers(users);

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    assertEquals(users, actualFromJsonResult.users());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Users is {@code null}.
   *   <li>Then return users Empty.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Users is 'null'; then return users Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonUsersIsNull_thenReturnUsersEmpty() {
    // Arrange
    Json json = new Json();
    json.setRole(
        ImmutableRole.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .isCustom(true)
            .key("Key")
            .name("Name")
            .build());
    json.setUsers(null);

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.users().isEmpty());
    Role expectedRoleResult = json.role;
    assertSame(expectedRoleResult, actualFromJsonResult.role());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RoleView.ImmutableRoleView#toString()}
   *   <li>{@link RoleView.ImmutableRoleView#role()}
   *   <li>{@link RoleView.ImmutableRoleView#users()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Role RoleView.ImmutableRoleView.role()",
    "String RoleView.ImmutableRoleView.toString()",
    "Set RoleView.ImmutableRoleView.users()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableRoleView.toString();
    Role actualRoleResult = immutableRoleView.role();

    // Assert
    assertTrue(actualRoleResult instanceof ImmutableRole);
    assertEquals(
        "RoleView{role=Role{id=1, key=Key, name=Name, description=The characteristics of someone or something,"
            + " isCustom=true, userSelectable=true}, users=[]}",
        actualToStringResult);
    assertTrue(immutableRoleView.users().isEmpty());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.role);
    assertTrue(actualJson.users.isEmpty());
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
  @MethodsUnderTest({"Role Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().role());
  }

  /**
   * Test Json {@link Json#users()}.
   *
   * <p>Method under test: {@link Json#users()}
   */
  @Test
  @DisplayName("Test Json users()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.users()"})
  void testJsonUsers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().users());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#withRole(Role)}.
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#withRole(Role)}
   */
  @Test
  @DisplayName("Test withRole(Role)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.withRole(Role)"})
  void testWithRole() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoleView actualWithRoleResult =
        immutableRoleView.withRole(
            ImmutableRole.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .isCustom(true)
                .key("Key")
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRoleView, actualWithRoleResult);
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#withUsers(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then role return {@link ImmutableRole}.
   * </ul>
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#withUsers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withUsers(Iterable) with 'Iterable'; given 'Elements'; then role return ImmutableRole")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.withUsers(Iterable)"})
  void testWithUsersWithIterable_givenElements_thenRoleReturnImmutableRole() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    ImmutableRoleView immutableRoleView =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableRoleView actualWithUsersResult = immutableRoleView.withUsers(elements);

    // Assert
    Role roleResult = actualWithUsersResult.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
    assertEquals(elements, actualWithUsersResult.users());
  }

  /**
   * Test {@link RoleView.ImmutableRoleView#withUsers(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link RoleView.ImmutableRoleView#withUsers(String[])}
   */
  @Test
  @DisplayName("Test withUsers(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RoleView.ImmutableRoleView RoleView.ImmutableRoleView.withUsers(String[])"})
  void testWithUsersWithString() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act
    ImmutableRoleView actualWithUsersResult =
        builderResult
            .role(
                ImmutableRole.builder()
                    .description("The characteristics of someone or something")
                    .id(1L)
                    .isCustom(true)
                    .key("Key")
                    .name("Name")
                    .build())
            .build()
            .withUsers("Elements");

    // Assert
    Role roleResult = actualWithUsersResult.role();
    assertTrue(roleResult instanceof ImmutableRole);
    assertEquals("Key", roleResult.key());
    assertEquals("Name", roleResult.name());
    assertEquals("The characteristics of someone or something", roleResult.description());
    Set<String> usersResult = actualWithUsersResult.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("Elements"));
    assertTrue(roleResult.isCustom());
    assertTrue(roleResult.userSelectable());
  }
}
