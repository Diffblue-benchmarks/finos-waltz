package org.finos.waltz.model.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.user.ImmutableUpdateRolesCommand.Builder;
import org.finos.waltz.model.user.ImmutableUpdateRolesCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableUpdateRolesCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRoles(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>Then builder build roles is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRoles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRoles(Iterable); given 'Elements'; then builder build roles is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRoles(Iterable)"})
  void testBuilderAddAllRoles_givenElements_thenBuilderBuildRolesIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualAddAllRolesResult = builderResult.addAllRoles(elements);

    // Assert
    assertEquals(elements, builderResult.build().roles());
    assertSame(builderResult, actualAddAllRolesResult);
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
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

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
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act
    Builder actualAddRolesResult = builderResult.addRoles("Element");

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Element"));
    assertSame(builderResult, actualAddRolesResult);
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
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act
    Builder actualAddRolesResult = builderResult.addRoles("Elements");

    // Assert
    Set<String> rolesResult = builderResult.build().roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
    assertSame(builderResult, actualAddRolesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand Builder.build()", "Builder Builder.comment(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableUpdateRolesCommand actualBuildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Assert
    assertEquals("Comment", actualBuildResult.comment());
    assertTrue(actualBuildResult.roles().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(UpdateRolesCommand)}.
   * <ul>
   *   <li>Given {@code instance}.</li>
   *   <li>When builder addRoles {@code instance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateRolesCommand); given 'instance'; when builder addRoles 'instance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateRolesCommand)"})
  void testBuilderFrom_givenInstance_whenBuilderAddRolesInstance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();
    Builder builderResult2 = ImmutableUpdateRolesCommand.builder();
    builderResult2.addRoles("instance");
    ImmutableUpdateRolesCommand instance = builderResult2.comment("Comment").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(UpdateRolesCommand)}.
   * <ul>
   *   <li>Then return build is builder comment {@code Comment} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateRolesCommand); then return build is builder comment 'Comment' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateRolesCommand)"})
  void testBuilderFrom_thenReturnBuildIsBuilderCommentCommentBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();
    ImmutableUpdateRolesCommand instance = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(UpdateRolesCommand)}.
   * <ul>
   *   <li>Then return build is builder comment {@code null} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test Builder from(UpdateRolesCommand); then return build is builder comment 'null' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(UpdateRolesCommand)"})
  void testBuilderFrom_thenReturnBuildIsBuilderCommentNullBuild() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();
    ImmutableUpdateRolesCommand instance = ImmutableUpdateRolesCommand.builder().comment(null).build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#roles(Iterable)}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>Then builder build roles is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#roles(Iterable)}
   */
  @Test
  @DisplayName("Test Builder roles(Iterable); given 'Elements'; then builder build roles is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.roles(Iterable)"})
  void testBuilderRoles_givenElements_thenBuilderBuildRolesIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    Builder actualRolesResult = builderResult.roles(elements);

    // Assert
    assertEquals(elements, builderResult.build().roles());
    assertSame(builderResult, actualRolesResult);
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
    Builder builderResult = ImmutableUpdateRolesCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.roles(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#copyOf(UpdateRolesCommand)}.
   * <ul>
   *   <li>When builder comment {@code Comment} build.</li>
   *   <li>Then return {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#copyOf(UpdateRolesCommand)}
   */
  @Test
  @DisplayName("Test copyOf(UpdateRolesCommand); when builder comment 'Comment' build; then return 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.copyOf(UpdateRolesCommand)"})
  void testCopyOf_whenBuilderCommentCommentBuild_thenReturnComment() {
    // Arrange
    ImmutableUpdateRolesCommand instance = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act
    ImmutableUpdateRolesCommand actualCopyOfResult = ImmutableUpdateRolesCommand.copyOf(instance);

    // Assert
    assertEquals("Comment", actualCopyOfResult.comment());
    assertTrue(actualCopyOfResult.roles().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}, and {@link ImmutableUpdateRolesCommand#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateRolesCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRolesCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();
    ImmutableUpdateRolesCommand buildResult2 = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}, and {@link ImmutableUpdateRolesCommand#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateRolesCommand#equals(Object)}
   *   <li>{@link ImmutableUpdateRolesCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableUpdateRolesCommand.builder();
    builderResult.addRoles("Element");
    ImmutableUpdateRolesCommand buildResult = builderResult.comment("Comment").build();
    ImmutableUpdateRolesCommand buildResult2 = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("java.lang.String").build();
    ImmutableUpdateRolesCommand buildResult2 = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableUpdateRolesCommand.equals(Object)",
      "int ImmutableUpdateRolesCommand.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableUpdateRolesCommand");
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code Json}.</li>
   *   <li>When {@link Json} (default constructor) Comment is {@code Json}.</li>
   *   <li>Then return comment is {@code Json}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'Json'; when Json (default constructor) Comment is 'Json'; then return comment is 'Json'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonCommentIsJson_thenReturnCommentIsJson() {
    // Arrange
    Json json = new Json();
    json.setRoles(null);
    json.setComment("Json");

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.comment());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code Json}.</li>
   *   <li>Then return roles size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add 'Json'; then return roles size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRolesSizeIsOne() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("Json");

    Json json = new Json();
    json.setRoles(roles);
    json.setComment(null);

    // Act and Assert
    Set<String> rolesResult = ImmutableUpdateRolesCommand.fromJson(json).roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Json"));
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code roles element}.</li>
   *   <li>Then return roles is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add 'roles element'; then return roles is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddRolesElement_thenReturnRolesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<String> roles = new LinkedHashSet<>();
    roles.add("roles element");
    roles.add("Json");

    Json json = new Json();
    json.setRoles(roles);
    json.setComment(null);

    // Act and Assert
    assertEquals(roles, ImmutableUpdateRolesCommand.fromJson(json).roles());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Roles is {@code null}.</li>
   *   <li>Then return comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Roles is 'null'; then return comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonRolesIsNull_thenReturnCommentIsNull() {
    // Arrange
    Json json = new Json();
    json.setRoles(null);
    json.setComment(null);

    // Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(json);

    // Assert
    assertNull(actualFromJsonResult.comment());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return comment is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCommentIsNull() {
    // Arrange and Act
    ImmutableUpdateRolesCommand actualFromJsonResult = ImmutableUpdateRolesCommand.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.comment());
    assertTrue(actualFromJsonResult.roles().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableUpdateRolesCommand#toString()}
   *   <li>{@link ImmutableUpdateRolesCommand#comment()}
   *   <li>{@link ImmutableUpdateRolesCommand#roles()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ImmutableUpdateRolesCommand.comment()", "Set ImmutableUpdateRolesCommand.roles()",
      "String ImmutableUpdateRolesCommand.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act
    String actualToStringResult = buildResult.toString();
    String actualCommentResult = buildResult.comment();

    // Assert
    assertEquals("Comment", actualCommentResult);
    assertEquals("UpdateRolesCommand{roles=[], comment=Comment}", actualToStringResult);
    assertTrue(buildResult.roles().isEmpty());
  }

  /**
   * Test Json {@link Json#comment()}.
   * <p>
   * Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).comment());
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
    assertNull(actualJson.comment);
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
  @MethodsUnderTest({"Set Json.roles()"})
  void testJsonRoles() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).roles());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#withComment(String)}.
   * <ul>
   *   <li>Given builder comment {@code 42} build.</li>
   *   <li>Then return builder comment {@code 42} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); given builder comment '42' build; then return builder comment '42' build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.withComment(String)"})
  void testWithComment_givenBuilderComment42Build_thenReturnBuilderComment42Build() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("42").build();

    // Act and Assert
    assertSame(buildResult, buildResult.withComment("42"));
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#withComment(String)}.
   * <ul>
   *   <li>Given builder comment {@code Comment} build.</li>
   *   <li>Then return comment is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); given builder comment 'Comment' build; then return comment is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.withComment(String)"})
  void testWithComment_givenBuilderCommentCommentBuild_thenReturnCommentIs42() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act
    ImmutableUpdateRolesCommand actualWithCommentResult = buildResult.withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.comment());
    assertTrue(actualWithCommentResult.roles().isEmpty());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#withRoles(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given {@code Elements}.</li>
   *   <li>Then return {@code Comment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#withRoles(Iterable)}
   */
  @Test
  @DisplayName("Test withRoles(Iterable) with 'Iterable'; given 'Elements'; then return 'Comment'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.withRoles(Iterable)"})
  void testWithRolesWithIterable_givenElements_thenReturnComment() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableUpdateRolesCommand actualWithRolesResult = buildResult.withRoles(elements);

    // Assert
    assertEquals("Comment", actualWithRolesResult.comment());
    assertEquals(elements, actualWithRolesResult.roles());
  }

  /**
   * Test {@link ImmutableUpdateRolesCommand#withRoles(String[])} with {@code String[]}.
   * <p>
   * Method under test: {@link ImmutableUpdateRolesCommand#withRoles(String[])}
   */
  @Test
  @DisplayName("Test withRoles(String[]) with 'String[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableUpdateRolesCommand ImmutableUpdateRolesCommand.withRoles(String[])"})
  void testWithRolesWithString() {
    // Arrange
    ImmutableUpdateRolesCommand buildResult = ImmutableUpdateRolesCommand.builder().comment("Comment").build();

    // Act
    ImmutableUpdateRolesCommand actualWithRolesResult = buildResult.withRoles("Elements");

    // Assert
    assertEquals("Comment", actualWithRolesResult.comment());
    Set<String> rolesResult = actualWithRolesResult.roles();
    assertEquals(1, rolesResult.size());
    assertTrue(rolesResult.contains("Elements"));
  }
}
