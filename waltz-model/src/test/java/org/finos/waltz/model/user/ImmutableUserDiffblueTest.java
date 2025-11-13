package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.UserNameProvider;
import org.finos.waltz.model.user.ImmutableUser.Builder;
import org.finos.waltz.model.user.ImmutableUser.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUserDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRoles(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRoles(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRoles(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRoles(Iterable)"})
  void testBuilderAddAllRoles_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllRolesResult = builderResult.addAllRoles(elements);

    // Assert
    assertSame(builderResult, actualAddAllRolesResult);
  }

  /**
   * Test Builder {@link Builder#addAllRoles(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRoles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRoles(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRoles(Iterable)"})
  void testBuilderAddAllRoles_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualAddAllRolesResult = builderResult.addAllRoles(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRolesResult);
  }

  /**
   * Test Builder {@link Builder#addRoles(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRoles(String)}
   */
  @Test
  @DisplayName("Test Builder addRoles(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRoles(String)"})
  void testBuilderAddRolesWithElement() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualAddRolesResult = builderResult.addRoles("Element");

    // Assert
    assertSame(builderResult, actualAddRolesResult);
  }

  /**
   * Test Builder {@link Builder#addRoles(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRoles(String[])}
   */
  @Test
  @DisplayName("Test Builder addRoles(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRoles(String[])"})
  void testBuilderAddRolesWithElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualAddRolesResult = builderResult.addRoles("Elements");

    // Assert
    assertSame(builderResult, actualAddRolesResult);
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
  @MethodsUnderTest({"ImmutableUser Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUser actualImmutableUser = ImmutableUser.builder().userName("janedoe").build();

    // Assert
    assertEquals("janedoe", actualImmutableUser.userName());
    assertTrue(actualImmutableUser.roles().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   *
   * <ul>
   *   <li>Then builder build is {@link UserUtilities#ANONYMOUS_USER}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserNameProvider) with 'UserNameProvider'; then builder build is ANONYMOUS_USER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_thenBuilderBuildIsAnonymous_user() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    User instance = UserUtilities.ANONYMOUS_USER;

    // Act
    Builder actualFromResult = builderResult.from((UserNameProvider) instance);

    // Assert
    ImmutableUser actualImmutableUser = builderResult.build();
    assertEquals(instance, actualImmutableUser);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UserNameProvider)} with {@code UserNameProvider}.
   *
   * <ul>
   *   <li>Then builder build userName is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserNameProvider) with 'UserNameProvider'; then builder build userName is 'janedoe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(UserNameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(UserNameProvider) with 'UserNameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(UserNameProvider)"})
  void testBuilderFromWithUserNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    UserNameProvider instance = mock(UserNameProvider.class);
    when(instance.userName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).userName();
  }

  /**
   * Test Builder {@link Builder#from(User)} with {@code User}.
   *
   * <ul>
   *   <li>Then builder build is builder userName {@code janedoe} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(User)}
   */
  @Test
  @DisplayName(
      "Test Builder from(User) with 'User'; then builder build is builder userName 'janedoe' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(User)"})
  void testBuilderFromWithUser_thenBuilderBuildIsBuilderUserNameJanedoeBuild() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    Builder builderResult2 = ImmutableUser.builder();
    builderResult2.addRoles("Element");
    ImmutableUser instance = builderResult2.userName("janedoe").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableUser actualImmutableUser = builderResult.build();
    assertEquals(instance, actualImmutableUser);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(User)} with {@code User}.
   *
   * <ul>
   *   <li>When {@link UserUtilities#ANONYMOUS_USER}.
   *   <li>Then return build is {@link UserUtilities#ANONYMOUS_USER}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(User)}
   */
  @Test
  @DisplayName(
      "Test Builder from(User) with 'User'; when ANONYMOUS_USER; then return build is ANONYMOUS_USER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(User)"})
  void testBuilderFromWithUser_whenAnonymous_user_thenReturnBuildIsAnonymous_user() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    User instance = UserUtilities.ANONYMOUS_USER;

    // Act and Assert
    ImmutableUser actualImmutableUser = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableUser);
    ImmutableUser actualImmutableUser2 = builderResult.build();
    assertEquals(instance, actualImmutableUser2);
  }

  /**
   * Test Builder {@link Builder#roles(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code Elements}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#roles(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder roles(Iterable); given 'Elements'; when LinkedHashSet() add 'Elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roles(Iterable)"})
  void testBuilderRoles_givenElements_whenLinkedHashSetAddElements() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualRolesResult = builderResult.roles(elements);

    // Assert
    assertSame(builderResult, actualRolesResult);
  }

  /**
   * Test Builder {@link Builder#roles(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#roles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder roles(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roles(Iterable)"})
  void testBuilderRoles_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualRolesResult = builderResult.roles(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRolesResult);
  }

  /**
   * Test Builder {@link Builder#userName(String)}.
   *
   * <ul>
   *   <li>When {@code janedoe}.
   *   <li>Then builder build userName is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#userName(String)}
   */
  @Test
  @DisplayName(
      "Test Builder userName(String); when 'janedoe'; then builder build userName is 'janedoe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userName(String)"})
  void testBuilderUserName_whenJanedoe_thenBuilderBuildUserNameIsJanedoe() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();

    // Act
    Builder actualUserNameResult = builderResult.userName("janedoe");

    // Assert
    assertEquals("janedoe", builderResult.build().userName());
    assertSame(builderResult, actualUserNameResult);
  }

  /**
   * Test {@link ImmutableUser#copyOf(User)}.
   *
   * <ul>
   *   <li>When {@link UserUtilities#ANONYMOUS_USER}.
   *   <li>Then return roles Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#copyOf(User)}
   */
  @Test
  @DisplayName("Test copyOf(User); when ANONYMOUS_USER; then return roles Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.copyOf(User)"})
  void testCopyOf_whenAnonymous_user_thenReturnRolesEmpty() {
    // Arrange and Act
    ImmutableUser actualCopyOfResult = ImmutableUser.copyOf(UserUtilities.ANONYMOUS_USER);

    // Assert
    assertTrue(actualCopyOfResult.roles().isEmpty());
    assertEquals(UserUtilities.ANONYMOUS_USERNAME, actualCopyOfResult.userName());
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}, and {@link ImmutableUser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUser#equals(Object)}
   *   <li>{@link ImmutableUser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("janedoe").build();
    ImmutableUser immutableUser2 = ImmutableUser.builder().userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableUser, immutableUser2);
    assertEquals(immutableUser.hashCode(), immutableUser2.hashCode());
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}, and {@link ImmutableUser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUser#equals(Object)}
   *   <li>{@link ImmutableUser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("janedoe").build();

    // Act and Assert
    assertEquals(immutableUser, immutableUser);
    int expectedHashCodeResult = immutableUser.hashCode();
    assertEquals(expectedHashCodeResult, immutableUser.hashCode());
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUser.builder();
    builderResult.addRoles("janedoe");
    ImmutableUser immutableUser = builderResult.userName("janedoe").build();

    // Act and Assert
    assertNotEquals(immutableUser, ImmutableUser.builder().userName("janedoe").build());
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("User Name").build();

    // Act and Assert
    assertNotEquals(immutableUser, ImmutableUser.builder().userName("janedoe").build());
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableUser.builder().userName("janedoe").build(), null);
  }

  /**
   * Test {@link ImmutableUser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableUser.equals(Object)", "int ImmutableUser.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableUser.builder().userName("janedoe").build(), "Different type to ImmutableUser");
  }

  /**
   * Test {@link ImmutableUser#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Roles is {@link HashSet#HashSet()}.
   *   <li>Then return userName is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Roles is HashSet(); then return userName is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonRolesIsHashSet_thenReturnUserNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setRoles(new HashSet<>());

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userName());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Test {@link ImmutableUser#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Json}.
   *   <li>Then return roles size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'Json'; then return roles size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRolesSizeIsOne() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("Json");

    Json json = new Json();
    json.setUserName("Json");
    json.setRoles(roles);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    Set<String> rolesResult = actualFromJsonResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Json"));
  }

  /**
   * Test {@link ImmutableUser#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code userName}.
   *   <li>Then return roles is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'userName'; then return roles is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddUserName_thenReturnRolesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("userName");
    roles.add("Json");

    Json json = new Json();
    json.setUserName("Json");
    json.setRoles(roles);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals(roles, actualFromJsonResult.roles());
  }

  /**
   * Test {@link ImmutableUser#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Roles is {@code null}.
   *   <li>Then return userName is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Roles is 'null'; then return userName is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonRolesIsNull_thenReturnUserNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setUserName("Json");
    json.setRoles(null);

    // Act
    ImmutableUser actualFromJsonResult = ImmutableUser.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.userName());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableUser#toString()}
   *   <li>{@link ImmutableUser#roles()}
   *   <li>{@link ImmutableUser#userName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableUser.roles()",
    "String ImmutableUser.toString()",
    "String ImmutableUser.userName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("janedoe").build();

    // Act
    String actualToStringResult = immutableUser.toString();
    Set<String> actualRolesResult = immutableUser.roles();

    // Assert
    assertEquals("User{userName=janedoe, roles=[]}", actualToStringResult);
    assertEquals("janedoe", immutableUser.userName());
    assertTrue(actualRolesResult.isEmpty());
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
    assertNull(actualJson.userName);
    assertTrue(actualJson.roles.isEmpty());
  }

  /**
   * Test Json {@link Json#roles()}.
   *
   * <p>Method under test: {@link Json#roles()}
   */
  @Test
  @DisplayName("Test Json roles()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.roles()"})
  void testJsonRoles() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().roles());
  }

  /**
   * Test Json {@link Json#userName()}.
   *
   * <p>Method under test: {@link Json#userName()}
   */
  @Test
  @DisplayName("Test Json userName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.userName()"})
  void testJsonUserName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userName());
  }

  /**
   * Test {@link ImmutableUser#withRoles(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Given {@code Elements}.
   *   <li>Then return userName is {@code janedoe}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#withRoles(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRoles(Iterable) with 'Iterable'; given 'Elements'; then return userName is 'janedoe'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.withRoles(Iterable)"})
  void testWithRolesWithIterable_givenElements_thenReturnUserNameIsJanedoe() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("janedoe").build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableUser actualWithRolesResult = immutableUser.withRoles(elements);

    // Assert
    assertEquals("janedoe", actualWithRolesResult.userName());
    assertEquals(elements, actualWithRolesResult.roles());
  }

  /**
   * Test {@link ImmutableUser#withRoles(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link ImmutableUser#withRoles(String[])}
   */
  @Test
  @DisplayName("Test withRoles(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.withRoles(String[])"})
  void testWithRolesWithString() {
    // Arrange and Act
    ImmutableUser actualWithRolesResult =
        ImmutableUser.builder().userName("janedoe").build().withRoles("Elements");

    // Assert
    assertEquals("janedoe", actualWithRolesResult.userName());
    Set<String> rolesResult = actualWithRolesResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
  }

  /**
   * Test {@link ImmutableUser#withUserName(String)}.
   *
   * <ul>
   *   <li>Given builder userName {@code 42} build.
   *   <li>Then return builder userName {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#withUserName(String)}
   */
  @Test
  @DisplayName(
      "Test withUserName(String); given builder userName '42' build; then return builder userName '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.withUserName(String)"})
  void testWithUserName_givenBuilderUserName42Build_thenReturnBuilderUserName42Build() {
    // Arrange
    ImmutableUser immutableUser = ImmutableUser.builder().userName("42").build();

    // Act
    ImmutableUser actualWithUserNameResult = immutableUser.withUserName("42");

    // Assert
    assertSame(immutableUser, actualWithUserNameResult);
  }

  /**
   * Test {@link ImmutableUser#withUserName(String)}.
   *
   * <ul>
   *   <li>Given builder userName {@code janedoe} build.
   *   <li>Then return userName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableUser#withUserName(String)}
   */
  @Test
  @DisplayName(
      "Test withUserName(String); given builder userName 'janedoe' build; then return userName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableUser ImmutableUser.withUserName(String)"})
  void testWithUserName_givenBuilderUserNameJanedoeBuild_thenReturnUserNameIs42() {
    // Arrange and Act
    ImmutableUser actualWithUserNameResult =
        ImmutableUser.builder().userName("janedoe").build().withUserName("42");

    // Assert
    assertEquals("42", actualWithUserNameResult.userName());
    assertTrue(actualWithUserNameResult.roles().isEmpty());
  }
}
