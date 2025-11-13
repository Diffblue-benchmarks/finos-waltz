package org.finos.waltz.model.changelog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.changelog.ImmutableChangeLogComment.Builder;
import org.finos.waltz.model.changelog.ImmutableChangeLogComment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeLogCommentDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeLogComment Builder.build()",
    "Builder Builder.comment(String)"
  })
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertEquals(
        "Comment", ImmutableChangeLogComment.builder().comment("Comment").build().comment());
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogComment)}.
   *
   * <ul>
   *   <li>Then builder build is builder comment {@code Comment} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ChangeLogComment)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ChangeLogComment); then builder build is builder comment 'Comment' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLogComment)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCommentCommentBuild() {
    // Arrange
    Builder builderResult = ImmutableChangeLogComment.builder();
    ImmutableChangeLogComment instance =
        ImmutableChangeLogComment.builder().comment("Comment").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeLogComment actualImmutableChangeLogComment = builderResult.build();
    assertEquals(instance, actualImmutableChangeLogComment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeLogComment)}.
   *
   * <ul>
   *   <li>Then builder build is builder comment {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ChangeLogComment)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ChangeLogComment); then builder build is builder comment 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeLogComment)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCommentNullBuild() {
    // Arrange
    Builder builderResult = ImmutableChangeLogComment.builder();
    ImmutableChangeLogComment instance = ImmutableChangeLogComment.builder().comment(null).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeLogComment actualImmutableChangeLogComment = builderResult.build();
    assertEquals(instance, actualImmutableChangeLogComment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableChangeLogComment#copyOf(ChangeLogComment)}.
   *
   * <ul>
   *   <li>When builder comment {@code Comment} build.
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#copyOf(ChangeLogComment)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ChangeLogComment); when builder comment 'Comment' build; then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeLogComment ImmutableChangeLogComment.copyOf(ChangeLogComment)"
  })
  void testCopyOf_whenBuilderCommentCommentBuild_thenReturnComment() {
    // Arrange
    ImmutableChangeLogComment instance =
        ImmutableChangeLogComment.builder().comment("Comment").build();

    // Act and Assert
    assertEquals("Comment", ImmutableChangeLogComment.copyOf(instance).comment());
  }

  /**
   * Test {@link ImmutableChangeLogComment#equals(Object)}, and {@link
   * ImmutableChangeLogComment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogComment#equals(Object)}
   *   <li>{@link ImmutableChangeLogComment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogComment.equals(Object)",
    "int ImmutableChangeLogComment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableChangeLogComment immutableChangeLogComment =
        ImmutableChangeLogComment.builder().comment("Comment").build();
    ImmutableChangeLogComment immutableChangeLogComment2 =
        ImmutableChangeLogComment.builder().comment("Comment").build();

    // Act and Assert
    assertEquals(immutableChangeLogComment, immutableChangeLogComment2);
    assertEquals(immutableChangeLogComment.hashCode(), immutableChangeLogComment2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLogComment#equals(Object)}, and {@link
   * ImmutableChangeLogComment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogComment#equals(Object)}
   *   <li>{@link ImmutableChangeLogComment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogComment.equals(Object)",
    "int ImmutableChangeLogComment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableChangeLogComment immutableChangeLogComment =
        ImmutableChangeLogComment.builder().comment("Comment").build();

    // Act and Assert
    assertEquals(immutableChangeLogComment, immutableChangeLogComment);
    int expectedHashCodeResult = immutableChangeLogComment.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeLogComment.hashCode());
  }

  /**
   * Test {@link ImmutableChangeLogComment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogComment.equals(Object)",
    "int ImmutableChangeLogComment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableChangeLogComment immutableChangeLogComment =
        ImmutableChangeLogComment.builder().comment("42").build();

    // Act and Assert
    assertNotEquals(
        immutableChangeLogComment, ImmutableChangeLogComment.builder().comment("Comment").build());
  }

  /**
   * Test {@link ImmutableChangeLogComment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogComment.equals(Object)",
    "int ImmutableChangeLogComment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableChangeLogComment.builder().comment("Comment").build(), null);
  }

  /**
   * Test {@link ImmutableChangeLogComment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeLogComment.equals(Object)",
    "int ImmutableChangeLogComment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableChangeLogComment.builder().comment("Comment").build(),
        "Different type to ImmutableChangeLogComment");
  }

  /**
   * Test {@link ImmutableChangeLogComment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Comment is {@code Json}.
   *   <li>Then return comment is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Comment is 'Json'; then return comment is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogComment ImmutableChangeLogComment.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonCommentIsJson_thenReturnCommentIsJson() {
    // Arrange
    Json json = new Json();
    json.setComment("Json");

    // Act
    ImmutableChangeLogComment actualFromJsonResult = ImmutableChangeLogComment.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.comment());
  }

  /**
   * Test {@link ImmutableChangeLogComment#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return comment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogComment ImmutableChangeLogComment.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnCommentIsNull() {
    // Arrange and Act
    ImmutableChangeLogComment actualFromJsonResult = ImmutableChangeLogComment.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.comment());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeLogComment#toString()}
   *   <li>{@link ImmutableChangeLogComment#comment()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableChangeLogComment.comment()",
    "String ImmutableChangeLogComment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableChangeLogComment immutableChangeLogComment =
        ImmutableChangeLogComment.builder().comment("Comment").build();

    // Act
    String actualToStringResult = immutableChangeLogComment.toString();

    // Assert
    assertEquals("ChangeLogComment{comment=Comment}", actualToStringResult);
    assertEquals("Comment", immutableChangeLogComment.comment());
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComment(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");

    // Assert
    assertEquals("Comment", actualJson.comment);
  }

  /**
   * Test {@link ImmutableChangeLogComment#withComment(String)}.
   *
   * <ul>
   *   <li>Given builder comment {@code 42} build.
   *   <li>Then return builder comment {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#withComment(String)}
   */
  @Test
  @DisplayName(
      "Test withComment(String); given builder comment '42' build; then return builder comment '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogComment ImmutableChangeLogComment.withComment(String)"})
  void testWithComment_givenBuilderComment42Build_thenReturnBuilderComment42Build() {
    // Arrange
    ImmutableChangeLogComment immutableChangeLogComment =
        ImmutableChangeLogComment.builder().comment("42").build();

    // Act
    ImmutableChangeLogComment actualWithCommentResult = immutableChangeLogComment.withComment("42");

    // Assert
    assertSame(immutableChangeLogComment, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableChangeLogComment#withComment(String)}.
   *
   * <ul>
   *   <li>Given builder comment {@code Comment} build.
   *   <li>Then return comment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeLogComment#withComment(String)}
   */
  @Test
  @DisplayName(
      "Test withComment(String); given builder comment 'Comment' build; then return comment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableChangeLogComment ImmutableChangeLogComment.withComment(String)"})
  void testWithComment_givenBuilderCommentCommentBuild_thenReturnCommentIs42() {
    // Arrange, Act and Assert
    assertEquals(
        "42",
        ImmutableChangeLogComment.builder().comment("Comment").build().withComment("42").comment());
  }
}
