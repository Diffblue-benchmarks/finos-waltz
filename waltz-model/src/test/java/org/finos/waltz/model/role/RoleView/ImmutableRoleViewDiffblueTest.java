package org.finos.waltz.model.role.RoleView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.role.Role;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView.Builder;
import org.finos.waltz.model.role.RoleView.ImmutableRoleView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoleViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllUsers(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllUsers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUsers(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllUsers(Iterable)"})
  void testBuilderAddAllUsers_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsers(elements));
  }

  /**
   * Test Builder {@link Builder#addAllUsers(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllUsers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUsers(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllUsers(Iterable)"})
  void testBuilderAddAllUsers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsers(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addUsers(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addUsers(String)}
   */
  @Test
  @DisplayName("Test Builder addUsers(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addUsers(String)"})
  void testBuilderAddUsersWithElement() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addUsers("Element"));
  }

  /**
   * Test Builder {@link Builder#addUsers(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addUsers(String[])}
   */
  @Test
  @DisplayName("Test Builder addUsers(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addUsers(String[])"})
  void testBuilderAddUsersWithElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addUsers("Elements"));
  }

  /**
   * Test Builder {@link Builder#from(RoleView)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code instance}.</li>
   *   <li>Then return build users size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test Builder from(RoleView); given HashSet() add 'instance'; then return build users size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoleView.RoleView)"})
  void testBuilderFrom_givenHashSetAddInstance_thenReturnBuildUsersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(stringSet);
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    Set<String> usersResult = actualFromResult.build().users();
    assertEquals(1, usersResult.size());
    Set<String> usersResult2 = builderResult.build().users();
    assertEquals(1, usersResult2.size());
    assertTrue(usersResult.contains("instance"));
    assertTrue(usersResult2.contains("instance"));
  }

  /**
   * Test Builder {@link Builder#from(RoleView)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build users Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test Builder from(RoleView); given HashSet(); then return build users Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoleView.RoleView)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildUsersEmpty() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(new HashSet<>());
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    assertTrue(actualFromResult.build().users().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RoleView)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoleView.RoleView)}
   */
  @Test
  @DisplayName("Test Builder from(RoleView); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoleView.RoleView)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenThrow(new IllegalStateException("instance"));
    when(instance.role()).thenReturn(mock(Role.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).role();
    verify(instance).users();
  }

  /**
   * Test Builder {@link Builder#role(Role)}.
   * <ul>
   *   <li>When {@link Role}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#role(Role)}
   */
  @Test
  @DisplayName("Test Builder role(Role); when Role; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.role(Role)"})
  void testBuilderRole_whenRole_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();
    Role role = mock(Role.class);

    // Act and Assert
    assertSame(builderResult, builderResult.role(role));
    assertSame(role, builderResult.build().role());
  }

  /**
   * Test Builder {@link Builder#users(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#users(Iterable)}
   */
  @Test
  @DisplayName("Test Builder users(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.users(Iterable)"})
  void testBuilderUsers_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.users(elements));
  }

  /**
   * Test Builder {@link Builder#users(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#users(Iterable)}
   */
  @Test
  @DisplayName("Test Builder users(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.users(Iterable)"})
  void testBuilderUsers_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.users(new ArrayList<>()));
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#role()}
   */
  @Test
  @DisplayName("Test Json role()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Role Json.role()"})
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).role());
  }

  /**
   * Test Json {@link Json#users()}.
   * <p>
   * Method under test: {@link Json#users()}
   */
  @Test
  @DisplayName("Test Json users()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.users()"})
  void testJsonUsers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).users());
  }
}
