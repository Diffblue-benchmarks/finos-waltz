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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.UserNameProvider;
import org.junit.jupiter.api.Test;

class ImmutableUserDiffblueTest {
  /**
   * Method under test: {@link ImmutableUser.Builder#addAllRoles(Iterable)}
   */
  @Test
  void testBuilderAddAllRoles() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRoles(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#addAllRoles(Iterable)}
   */
  @Test
  void testBuilderAddAllRoles2() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRoles(elements));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#addRoles(String)}
   */
  @Test
  void testBuilderAddRoles() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRoles("Element"));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#addRoles(String[])}
   */
  @Test
  void testBuilderAddRoles2() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRoles("Elements"));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#from(UserNameProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act
    ImmutableUser.Builder actualFromResult = builderResult.from((UserNameProvider) UserUtilities.ANONYMOUS_USER);

    // Assert
    assertEquals(UserUtilities.ANONYMOUS_USERNAME, builderResult.build().userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#from(UserNameProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenReturn("janedoe");

    // Act
    ImmutableUser.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).userName();
    assertEquals("janedoe", builderResult.build().userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#from(UserNameProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).userName();
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#from(User)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act
    ImmutableUser.Builder actualFromResult = builderResult.from(UserUtilities.ANONYMOUS_USER);

    // Assert
    assertEquals(UserUtilities.ANONYMOUS_USERNAME, builderResult.build().userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#roles(Iterable)}
   */
  @Test
  void testBuilderRoles() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roles(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#roles(Iterable)}
   */
  @Test
  void testBuilderRoles2() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.roles(elements));
  }

  /**
   * Method under test: {@link ImmutableUser.Builder#userName(String)}
   */
  @Test
  void testBuilderUserName() {
    // Arrange
    ImmutableUser.Builder builderResult = ImmutableUser.builder();

    // Act
    ImmutableUser.Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertEquals("janedoe", builderResult.build().userName());
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Method under test: {@link ImmutableUser#copyOf(User)}
   */
  @Test
  void testCopyOf() {
    // Arrange and Act
    ImmutableUser actualCopyOfResult = ImmutableUser.copyOf(UserUtilities.ANONYMOUS_USER);

    // Assert
    assertTrue(actualCopyOfResult.roles().isEmpty());
    assertEquals(UserUtilities.ANONYMOUS_USERNAME, actualCopyOfResult.userName());
  }

  /**
   * Method under test: {@link ImmutableUser#fromJson(ImmutableUser.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableUser.Json json = new ImmutableUser.Json();
    json.setUserName("Json");
    json.setRoles(null);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userName());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableUser#fromJson(ImmutableUser.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("Json");

    ImmutableUser.Json json = new ImmutableUser.Json();
    json.setUserName("Json");
    json.setRoles(roles);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userName());
    Set<String> rolesResult = actualFromJsonResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Json"));
  }

  /**
   * Method under test: {@link ImmutableUser#fromJson(ImmutableUser.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("userName");
    roles.add("Json");

    ImmutableUser.Json json = new ImmutableUser.Json();
    json.setUserName("Json");
    json.setRoles(roles);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userName());
    assertEquals(roles, actualFromJsonResult.roles());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableUser.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableUser.Json actualJson = new ImmutableUser.Json();

    // Assert
    assertNull(actualJson.userName);
    assertTrue(actualJson.roles.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableUser.Json#roles()}
   */
  @Test
  void testJsonRoles() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUser.Json()).roles());
  }

  /**
   * Method under test: {@link ImmutableUser.Json#userName()}
   */
  @Test
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableUser.Json()).userName());
  }
}
