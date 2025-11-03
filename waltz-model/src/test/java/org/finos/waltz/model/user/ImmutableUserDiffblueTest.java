package org.finos.waltz.model.user;

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
import java.util.LinkedHashSet;
import org.finos.waltz.model.UserNameProvider;
import org.finos.waltz.model.user.ImmutableUser.Builder;
import org.finos.waltz.model.user.ImmutableUser.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRoles(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRoles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRoles(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRoles(Iterable)"})
  void testBuilderAddAllRoles_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRoles(elements));
  }

  /**
   * Test Builder {@link Builder#addAllRoles(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRoles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRoles(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRoles(Iterable)"})
  void testBuilderAddAllRoles_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRoles(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRoles(String)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRoles(String)}
   */
  @Test
  @DisplayName("Test Builder addRoles(String) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRoles(String)"})
  void testBuilderAddRolesWithElement() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRoles("Element"));
  }

  /**
   * Test Builder {@link Builder#addRoles(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder addRoles(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRoles(String[])"})
  void testBuilderAddRolesWithElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRoles("Elements"));
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   * <ul>
   *   <li>Then builder build is {@link UserUtilities#ANONYMOUS_USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(UserNameProvider) with 'UserNameProvider'; then builder build is ANONYMOUS_USER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_thenBuilderBuildIsAnonymous_user() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    User instance = UserUtilities.ANONYMOUS_USER;

    // Act
    Builder actualFromResult = builderResult.from((UserNameProvider) instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   * <ul>
   *   <li>Then builder build userName is {@code janedoe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(UserNameProvider) with 'UserNameProvider'; then builder build userName is 'janedoe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_thenBuilderBuildUserNameIsJanedoe() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenReturn("janedoe");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).userName();
    assertEquals("janedoe", builderResult.build().userName());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(UserNameProvider) with 'UserNameProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).userName();
  }

  /**
   * Test Builder {@link Builder#from(User)} with {@code User}.
   * <ul>
   *   <li>When {@link UserUtilities#ANONYMOUS_USER}.</li>
   *   <li>Then builder build is {@link UserUtilities#ANONYMOUS_USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(User)}
   */
  @Test
  @DisplayName("Test Builder from(User) with 'User'; when ANONYMOUS_USER; then builder build is ANONYMOUS_USER")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(User)"})
  void testBuilderFromWithUser_whenAnonymous_user_thenBuilderBuildIsAnonymous_user() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    User instance = UserUtilities.ANONYMOUS_USER;

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#roles(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#roles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder roles(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roles(Iterable)"})
  void testBuilderRoles_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.roles(elements));
  }

  /**
   * Test Builder {@link Builder#roles(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#roles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder roles(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roles(Iterable)"})
  void testBuilderRoles_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roles(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   * <p>
   * Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName("Test Builder userName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertEquals("janedoe", builderResult.build().userName());
    assertSame(builderResult, actualUserNameResult);
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
    assertNull(actualJson.userName);
    assertTrue(actualJson.roles.isEmpty());
  }

  /**
   * Test Json {@link Json#roles()}.
   * <p>
   * Method under test: {@link Json#roles()}
   */
  @Test
  @DisplayName("Test Json roles()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.roles()"})
  void testJsonRoles() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).roles());
  }

  /**
   * Test Json {@link Json#userName()}.
   * <p>
   * Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userName());
  }
}
