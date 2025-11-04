package org.finos.waltz.model.role.RoleView;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.role.Role;
import org.junit.jupiter.api.Test;

class ImmutableRoleViewDiffblueTest {
  /**
   * Method under test: {@link ImmutableRoleView.Builder#addAllUsers(Iterable)}
   */
  @Test
  void testBuilderAddAllUsers() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsers(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#addAllUsers(Iterable)}
   */
  @Test
  void testBuilderAddAllUsers2() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUsers(elements));
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#addUsers(String)}
   */
  @Test
  void testBuilderAddUsers() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addUsers("Element"));
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#addUsers(String[])}
   */
  @Test
  void testBuilderAddUsers2() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addUsers("Elements"));
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#from(RoleView)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(new HashSet<>());
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    ImmutableRoleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#from(RoleView)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(stringSet);
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    ImmutableRoleView.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    Set<String> usersResult = builderResult.build().users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("instance"));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#from(RoleView)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenThrow(new IllegalStateException("instance"));
    when(instance.role()).thenReturn(mock(Role.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).role();
    verify(instance).users();
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#role(Role)}
   */
  @Test
  void testBuilderRole() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();
    Role role = mock(Role.class);

    // Act and Assert
    assertSame(builderResult, builderResult.role(role));
    assertSame(role, builderResult.build().role());
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#users(Iterable)}
   */
  @Test
  void testBuilderUsers() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.users(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableRoleView.Builder#users(Iterable)}
   */
  @Test
  void testBuilderUsers2() {
    // Arrange
    ImmutableRoleView.Builder builderResult = ImmutableRoleView.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.users(elements));
  }

  /**
   * Method under test: {@link ImmutableRoleView#copyOf(RoleView)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(new HashSet<>());
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    ImmutableRoleView actualCopyOfResult = ImmutableRoleView.copyOf(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    assertTrue(actualCopyOfResult.users().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRoleView#copyOf(RoleView)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(stringSet);
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    ImmutableRoleView actualCopyOfResult = ImmutableRoleView.copyOf(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    Set<String> usersResult = actualCopyOfResult.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("instance"));
  }

  /**
   * Method under test: {@link ImmutableRoleView#copyOf(RoleView)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("role");
    stringSet.add("instance");
    RoleView instance = mock(RoleView.class);
    when(instance.users()).thenReturn(stringSet);
    when(instance.role()).thenReturn(mock(Role.class));

    // Act
    ImmutableRoleView actualCopyOfResult = ImmutableRoleView.copyOf(instance);

    // Assert
    verify(instance).role();
    verify(instance).users();
    assertEquals(stringSet, actualCopyOfResult.users());
  }

  /**
   * Method under test: {@link ImmutableRoleView#fromJson(ImmutableRoleView.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRoleView.Json json = new ImmutableRoleView.Json();
    json.setRole(mock(Role.class));

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    Set<String> usersResult = actualFromJsonResult.users();
    assertTrue(usersResult.isEmpty());
    Role expectedRoleResult = json.role;
    assertSame(expectedRoleResult, actualFromJsonResult.role());
    assertSame(json.users, usersResult);
  }

  /**
   * Method under test: {@link ImmutableRoleView#fromJson(ImmutableRoleView.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<String> users = new LinkedHashSet<>();
    users.add("Json");

    ImmutableRoleView.Json json = new ImmutableRoleView.Json();
    json.setRole(mock(Role.class));
    json.setUsers(users);

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    Set<String> usersResult = actualFromJsonResult.users();
    assertEquals(1, usersResult.size());
    assertTrue(usersResult.contains("Json"));
    Role expectedRoleResult = json.role;
    assertSame(expectedRoleResult, actualFromJsonResult.role());
  }

  /**
   * Method under test: {@link ImmutableRoleView#fromJson(ImmutableRoleView.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<String> users = new LinkedHashSet<>();
    users.add("users element");
    users.add("Json");

    ImmutableRoleView.Json json = new ImmutableRoleView.Json();
    json.setRole(mock(Role.class));
    json.setUsers(users);

    // Act
    ImmutableRoleView actualFromJsonResult = ImmutableRoleView.fromJson(json);

    // Assert
    assertEquals(users, actualFromJsonResult.users());
    Role expectedRoleResult = json.role;
    assertSame(expectedRoleResult, actualFromJsonResult.role());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRoleView.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRoleView.Json actualJson = new ImmutableRoleView.Json();

    // Assert
    assertNull(actualJson.role);
    assertTrue(actualJson.users.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRoleView.Json#role()}
   */
  @Test
  void testJsonRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoleView.Json()).role());
  }

  /**
   * Method under test: {@link ImmutableRoleView.Json#users()}
   */
  @Test
  void testJsonUsers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRoleView.Json()).users());
  }
}
