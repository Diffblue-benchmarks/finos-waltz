package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableSurveyQuestionResponseContextValue.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionResponseContextValueDiffblueTest {
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
    "ImmutableSurveyQuestionResponseContextValue Builder.build()",
    "Builder Builder.comment(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextValue actualImmutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualImmutableSurveyQuestionResponseContextValue.getValue());
    assertEquals("Comment", actualImmutableSurveyQuestionResponseContextValue.getComment());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextValue)}.
   *
   * <ul>
   *   <li>Then builder build is builder comment {@code Comment} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyQuestionResponseContextValue); then builder build is builder comment 'Comment' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextValue)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCommentCommentValue42Build() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();
    ImmutableSurveyQuestionResponseContextValue instance =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponseContextValue actualImmutableSurveyQuestionResponseContextValue =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponseContextValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionResponseContextValue)}.
   *
   * <ul>
   *   <li>Then builder build is builder comment {@code null} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName(
      "Test Builder from(SurveyQuestionResponseContextValue); then builder build is builder comment 'null' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionResponseContextValue)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCommentNullValue42Build() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();
    ImmutableSurveyQuestionResponseContextValue instance =
        ImmutableSurveyQuestionResponseContextValue.builder().comment(null).value("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableSurveyQuestionResponseContextValue actualImmutableSurveyQuestionResponseContextValue =
        builderResult.build();
    assertEquals(instance, actualImmutableSurveyQuestionResponseContextValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#value(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#value(String)}
   */
  @Test
  @DisplayName("Test Builder value(String); when '42'; then builder build Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.value(String)"})
  void testBuilderValue_when42_thenBuilderBuildValueIs42() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionResponseContextValue.builder();

    // Act
    Builder actualValueResult = builderResult.value("42");

    // Assert
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        builderResult.build();
    assertEquals("42", immutableSurveyQuestionResponseContextValue.getValue());
    assertNull(immutableSurveyQuestionResponseContextValue.getComment());
    assertSame(builderResult, actualValueResult);
  }

  /**
   * Test {@link
   * ImmutableSurveyQuestionResponseContextValue#copyOf(SurveyQuestionResponseContextValue)}.
   *
   * <ul>
   *   <li>When builder comment {@code Comment} value {@code 42} build.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSurveyQuestionResponseContextValue#copyOf(SurveyQuestionResponseContextValue)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SurveyQuestionResponseContextValue); when builder comment 'Comment' value '42' build; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextValue ImmutableSurveyQuestionResponseContextValue.copyOf(SurveyQuestionResponseContextValue)"
  })
  void testCopyOf_whenBuilderCommentCommentValue42Build_thenReturnValueIs42() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue instance =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionResponseContextValue actualCopyOfResult =
        ImmutableSurveyQuestionResponseContextValue.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.getValue());
    assertEquals("Comment", actualCopyOfResult.getComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponseContextValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue2 =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyQuestionResponseContextValue, immutableSurveyQuestionResponseContextValue2);
    assertEquals(
        immutableSurveyQuestionResponseContextValue.hashCode(),
        immutableSurveyQuestionResponseContextValue2.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}, and {@link
   * ImmutableSurveyQuestionResponseContextValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(
        immutableSurveyQuestionResponseContextValue, immutableSurveyQuestionResponseContextValue);
    int expectedHashCodeResult = immutableSurveyQuestionResponseContextValue.hashCode();
    assertEquals(expectedHashCodeResult, immutableSurveyQuestionResponseContextValue.hashCode());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder().comment("42").value("42").build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponseContextValue,
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("Value")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableSurveyQuestionResponseContextValue,
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSurveyQuestionResponseContextValue.equals(Object)",
    "int ImmutableSurveyQuestionResponseContextValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build(),
        "Different type to ImmutableSurveyQuestionResponseContextValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#toString()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#getComment()}
   *   <li>{@link ImmutableSurveyQuestionResponseContextValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSurveyQuestionResponseContextValue.getComment()",
    "String ImmutableSurveyQuestionResponseContextValue.getValue()",
    "String ImmutableSurveyQuestionResponseContextValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act
    String actualToStringResult = immutableSurveyQuestionResponseContextValue.toString();
    String actualComment = immutableSurveyQuestionResponseContextValue.getComment();

    // Assert
    assertEquals("42", immutableSurveyQuestionResponseContextValue.getValue());
    assertEquals("Comment", actualComment);
    assertEquals(
        "SurveyQuestionResponseContextValue{value=42, comment=Comment}", actualToStringResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#withComment(String)}.
   *
   * <ul>
   *   <li>Given builder comment {@code Comment} value {@code 42} build.
   *   <li>Then return Comment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#withComment(String)}
   */
  @Test
  @DisplayName(
      "Test withComment(String); given builder comment 'Comment' value '42' build; then return Comment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextValue ImmutableSurveyQuestionResponseContextValue.withComment(String)"
  })
  void testWithComment_givenBuilderCommentCommentValue42Build_thenReturnCommentIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextValue actualWithCommentResult =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build()
            .withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.getComment());
    assertEquals("42", actualWithCommentResult.getValue());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#withComment(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code 42} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); then return builder comment '42' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextValue ImmutableSurveyQuestionResponseContextValue.withComment(String)"
  })
  void testWithComment_thenReturnBuilderComment42Value42Build() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder().comment("42").value("42").build();

    // Act
    ImmutableSurveyQuestionResponseContextValue actualWithCommentResult =
        immutableSurveyQuestionResponseContextValue.withComment("42");

    // Assert
    assertSame(immutableSurveyQuestionResponseContextValue, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#withValue(String)}.
   *
   * <ul>
   *   <li>Given builder comment {@code Comment} value {@code value} build.
   *   <li>Then return Value is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#withValue(String)}
   */
  @Test
  @DisplayName(
      "Test withValue(String); given builder comment 'Comment' value 'value' build; then return Value is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextValue ImmutableSurveyQuestionResponseContextValue.withValue(String)"
  })
  void testWithValue_givenBuilderCommentCommentValueValueBuild_thenReturnValueIs42() {
    // Arrange and Act
    ImmutableSurveyQuestionResponseContextValue actualWithValueResult =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("value")
            .build()
            .withValue("42");

    // Assert
    assertEquals("42", actualWithValueResult.getValue());
    assertEquals("Comment", actualWithValueResult.getComment());
  }

  /**
   * Test {@link ImmutableSurveyQuestionResponseContextValue#withValue(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code Comment} value {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSurveyQuestionResponseContextValue#withValue(String)}
   */
  @Test
  @DisplayName("Test withValue(String); then return builder comment 'Comment' value '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSurveyQuestionResponseContextValue ImmutableSurveyQuestionResponseContextValue.withValue(String)"
  })
  void testWithValue_thenReturnBuilderCommentCommentValue42Build() {
    // Arrange
    ImmutableSurveyQuestionResponseContextValue immutableSurveyQuestionResponseContextValue =
        ImmutableSurveyQuestionResponseContextValue.builder()
            .comment("Comment")
            .value("42")
            .build();

    // Act
    ImmutableSurveyQuestionResponseContextValue actualWithValueResult =
        immutableSurveyQuestionResponseContextValue.withValue("42");

    // Assert
    assertSame(immutableSurveyQuestionResponseContextValue, actualWithValueResult);
  }
}
