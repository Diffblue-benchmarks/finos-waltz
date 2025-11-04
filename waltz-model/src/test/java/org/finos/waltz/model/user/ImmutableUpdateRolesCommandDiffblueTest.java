package org.finos.waltz.model.user;

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
import org.junit.jupiter.api.Test;

class ImmutableUpdateRolesCommandDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#addAllRoles(Iterable)}
   */
  @Test
  void testBuilderAddAllRoles() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRoles(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#addAllRoles(Iterable)}
   */
  @Test
  void testBuilderAddAllRoles2() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableUpdateRolesCommand.Builder actualAddAllRolesResult = builderResult.addAllRoles(elements);

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
    assertSame(builderResult, actualAddAllRolesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#addRoles(String)}
   */
  @Test
  void testBuilderAddRoles() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act
    ImmutableUpdateRolesCommand.Builder actualAddRolesResult = builderResult.addRoles("Element");

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Element"));
    assertSame(builderResult, actualAddRolesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#addRoles(String[])}
   */
  @Test
  void testBuilderAddRoles2() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act
    ImmutableUpdateRolesCommand.Builder actualAddRolesResult = builderResult.addRoles("Elements");

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
    assertSame(builderResult, actualAddRolesResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateRolesCommand.Builder#build()}
   *   <li>{@link ImmutableUpdateRolesCommand.Builder#comment(String)}
   * </ul>
   */
  @Test
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateRolesCommand actualBuildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Assert
    assertEquals("Comment", actualBuildResult.comment());
    assertTrue(actualBuildResult.roles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#from(UpdateRolesCommand)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.roles()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateRolesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    assertEquals("Comment", builderResult.build().comment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#from(UpdateRolesCommand)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn(null);
    when(instance.roles()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateRolesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    assertNull(builderResult.build().comment());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#from(UpdateRolesCommand)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.roles()).thenReturn(stringSet);

    // Act
    ImmutableUpdateRolesCommand.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    ImmutableUpdateRolesCommand buildResult = builderResult.build();
    assertEquals("Comment", buildResult.comment());
    Set<String> rolesResult = buildResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("instance"));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#roles(Iterable)}
   */
  @Test
  void testBuilderRoles() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roles(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand.Builder#roles(Iterable)}
   */
  @Test
  void testBuilderRoles2() {
    // Arrange
    ImmutableUpdateRolesCommand.Builder builderResult = ImmutableUpdateRolesCommand.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableUpdateRolesCommand.Builder actualRolesResult = builderResult.roles(elements);

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
    assertSame(builderResult, actualRolesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#copyOf(UpdateRolesCommand)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.roles()).thenReturn(new HashSet<>());

    // Act
    ImmutableUpdateRolesCommand actualCopyOfResult = ImmutableUpdateRolesCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    assertEquals("Comment", actualCopyOfResult.comment());
    assertTrue(actualCopyOfResult.roles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#copyOf(UpdateRolesCommand)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.roles()).thenReturn(stringSet);

    // Act
    ImmutableUpdateRolesCommand actualCopyOfResult = ImmutableUpdateRolesCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    assertEquals("Comment", actualCopyOfResult.comment());
    Set<String> rolesResult = actualCopyOfResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("instance"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#copyOf(UpdateRolesCommand)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("roles element");
    stringSet.add("instance");
    UpdateRolesCommand instance = mock(UpdateRolesCommand.class);
    when(instance.comment()).thenReturn("Comment");
    when(instance.roles()).thenReturn(stringSet);

    // Act
    ImmutableUpdateRolesCommand actualCopyOfResult = ImmutableUpdateRolesCommand.copyOf(instance);

    // Assert
    verify(instance).comment();
    verify(instance).roles();
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals(stringSet, actualCopyOfResult.roles());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#fromJson(ImmutableUpdateRolesCommand.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUpdateRolesCommand.Json json = new ImmutableUpdateRolesCommand.Json();

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.comment());
    Set<String> rolesResult = actualFromJsonResult.roles();
    assertTrue(rolesResult.isEmpty());
    assertSame(json.roles, rolesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#fromJson(ImmutableUpdateRolesCommand.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableUpdateRolesCommand.Json json = new ImmutableUpdateRolesCommand.Json();
    json.setRoles(null);
    json.setComment(null);

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.comment());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#fromJson(ImmutableUpdateRolesCommand.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ImmutableUpdateRolesCommand.Json json = new ImmutableUpdateRolesCommand.Json();
    json.setRoles(null);
    json.setComment("Json");

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.comment());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#fromJson(ImmutableUpdateRolesCommand.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("Json");

    ImmutableUpdateRolesCommand.Json json = new ImmutableUpdateRolesCommand.Json();
    json.setRoles(roles);
    json.setComment(null);

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.comment());
    Set<String> rolesResult = actualFromJsonResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Json"));
  }

  /**
   * Method under test:
   * {@link ImmutableUpdateRolesCommand#fromJson(ImmutableUpdateRolesCommand.Json)}
   */
  @Test
  void testFromJson5() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("roles element");
    roles.add("Json");

    ImmutableUpdateRolesCommand.Json json = new ImmutableUpdateRolesCommand.Json();
    json.setRoles(roles);
    json.setComment(null);

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.comment());
    assertEquals(roles, actualFromJsonResult.roles());
  }

  /**
   * Method under test: {@link ImmutableUpdateRolesCommand.Json#comment()}
   */
  @Test
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateRolesCommand.Json()).comment());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUpdateRolesCommand.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUpdateRolesCommand.Json actualJson = new ImmutableUpdateRolesCommand.Json();

    // Assert
    assertNull(actualJson.comment);
    assertTrue(actualJson.roles.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableUpdateRolesCommand.Json#roles()}
   */
  @Test
  void testJsonRoles() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUpdateRolesCommand.Json()).roles());
  }
}
