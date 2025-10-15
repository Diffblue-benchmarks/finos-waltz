package org.finos.waltz.service.workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.service.workflow.ImmutableAssessmentContextValue.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentContextValueDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#ratingComment(String)}
   *   <li>{@link Builder#ratingExternalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue Builder.build()",
    "Builder Builder.ratingComment(String)",
    "Builder Builder.ratingExternalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentContextValue actualImmutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Assert
    assertEquals("42", actualImmutableAssessmentContextValue.getRatingExternalId());
    assertEquals("Rating Code", actualImmutableAssessmentContextValue.getRatingCode());
    assertEquals("Rating Comment", actualImmutableAssessmentContextValue.getRatingComment());
    assertEquals("Rating Name", actualImmutableAssessmentContextValue.getRatingName());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    ImmutableAssessmentContextValue instance =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentContextValue actualImmutableAssessmentContextValue = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentContextValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    ImmutableAssessmentContextValue instance =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment(null)
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentContextValue actualImmutableAssessmentContextValue = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentContextValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentContextValue)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentContextValue)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentContextValue)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();
    ImmutableAssessmentContextValue instance =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId(null)
            .ratingName("Rating Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentContextValue actualImmutableAssessmentContextValue = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentContextValue);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingCode(String)}.
   *
   * <ul>
   *   <li>When {@code Rating Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingCode(String)}
   */
  @Test
  @DisplayName("Test Builder ratingCode(String); when 'Rating Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingCode(String)"})
  void testBuilderRatingCode_whenRatingCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act
    Builder actualRatingCodeResult = builderResult.ratingCode("Rating Code");

    // Assert
    assertSame(builderResult, actualRatingCodeResult);
  }

  /**
   * Test Builder {@link Builder#ratingName(String)}.
   *
   * <ul>
   *   <li>When {@code Rating Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingName(String)}
   */
  @Test
  @DisplayName("Test Builder ratingName(String); when 'Rating Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingName(String)"})
  void testBuilderRatingName_whenRatingName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentContextValue.builder();

    // Act
    Builder actualRatingNameResult = builderResult.ratingName("Rating Name");

    // Assert
    assertSame(builderResult, actualRatingNameResult);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#copyOf(AssessmentContextValue)}.
   *
   * <ul>
   *   <li>Then return RatingExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#copyOf(AssessmentContextValue)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentContextValue); then return RatingExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.copyOf(AssessmentContextValue)"
  })
  void testCopyOf_thenReturnRatingExternalIdIs42() {
    // Arrange
    ImmutableAssessmentContextValue instance =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutableAssessmentContextValue actualCopyOfResult =
        ImmutableAssessmentContextValue.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.getRatingExternalId());
    assertEquals("Rating Code", actualCopyOfResult.getRatingCode());
    assertEquals("Rating Comment", actualCopyOfResult.getRatingComment());
    assertEquals("Rating Name", actualCopyOfResult.getRatingName());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}, and {@link
   * ImmutableAssessmentContextValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentContextValue#equals(Object)}
   *   <li>{@link ImmutableAssessmentContextValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();
    ImmutableAssessmentContextValue immutableAssessmentContextValue2 =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentContextValue, immutableAssessmentContextValue2);
    assertEquals(
        immutableAssessmentContextValue.hashCode(), immutableAssessmentContextValue2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}, and {@link
   * ImmutableAssessmentContextValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentContextValue#equals(Object)}
   *   <li>{@link ImmutableAssessmentContextValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentContextValue, immutableAssessmentContextValue);
    int expectedHashCodeResult = immutableAssessmentContextValue.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentContextValue.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Name")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentContextValue,
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Code")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentContextValue,
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("Rating Code")
            .ratingName("Rating Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentContextValue,
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Code")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentContextValue,
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentContextValue.equals(Object)",
    "int ImmutableAssessmentContextValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build(),
        "Different type to ImmutableAssessmentContextValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentContextValue#toString()}
   *   <li>{@link ImmutableAssessmentContextValue#getRatingCode()}
   *   <li>{@link ImmutableAssessmentContextValue#getRatingComment()}
   *   <li>{@link ImmutableAssessmentContextValue#getRatingExternalId()}
   *   <li>{@link ImmutableAssessmentContextValue#getRatingName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentContextValue.getRatingCode()",
    "String ImmutableAssessmentContextValue.getRatingComment()",
    "String ImmutableAssessmentContextValue.getRatingExternalId()",
    "String ImmutableAssessmentContextValue.getRatingName()",
    "String ImmutableAssessmentContextValue.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentContextValue.toString();
    String actualRatingCode = immutableAssessmentContextValue.getRatingCode();
    String actualRatingComment = immutableAssessmentContextValue.getRatingComment();
    String actualRatingExternalId = immutableAssessmentContextValue.getRatingExternalId();

    // Assert
    assertEquals("42", actualRatingExternalId);
    assertEquals(
        "AssessmentContextValue{ratingCode=Rating Code, ratingName=Rating Name, ratingExternalId=42,"
            + " ratingComment=Rating Comment}",
        actualToStringResult);
    assertEquals("Rating Code", actualRatingCode);
    assertEquals("Rating Comment", actualRatingComment);
    assertEquals("Rating Name", immutableAssessmentContextValue.getRatingName());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingCode(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingCode(String)}
   */
  @Test
  @DisplayName("Test withRatingCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingCode(String)"
  })
  void testWithRatingCode() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("42")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutableAssessmentContextValue actualWithRatingCodeResult =
        immutableAssessmentContextValue.withRatingCode("42");

    // Assert
    assertSame(immutableAssessmentContextValue, actualWithRatingCodeResult);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingCode(String)}.
   *
   * <ul>
   *   <li>Then return RatingCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingCode(String)}
   */
  @Test
  @DisplayName("Test withRatingCode(String); then return RatingCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingCode(String)"
  })
  void testWithRatingCode_thenReturnRatingCodeIs42() {
    // Arrange and Act
    ImmutableAssessmentContextValue actualWithRatingCodeResult =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build()
            .withRatingCode("42");

    // Assert
    assertEquals("42", actualWithRatingCodeResult.getRatingCode());
    assertEquals("42", actualWithRatingCodeResult.getRatingExternalId());
    assertEquals("Rating Comment", actualWithRatingCodeResult.getRatingComment());
    assertEquals("Rating Name", actualWithRatingCodeResult.getRatingName());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingComment(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingComment(String)}
   */
  @Test
  @DisplayName("Test withRatingComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingComment(String)"
  })
  void testWithRatingComment() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("42")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutableAssessmentContextValue actualWithRatingCommentResult =
        immutableAssessmentContextValue.withRatingComment("42");

    // Assert
    assertSame(immutableAssessmentContextValue, actualWithRatingCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingComment(String)}.
   *
   * <ul>
   *   <li>Then return RatingComment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingComment(String)}
   */
  @Test
  @DisplayName("Test withRatingComment(String); then return RatingComment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingComment(String)"
  })
  void testWithRatingComment_thenReturnRatingCommentIs42() {
    // Arrange and Act
    ImmutableAssessmentContextValue actualWithRatingCommentResult =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build()
            .withRatingComment("42");

    // Assert
    assertEquals("42", actualWithRatingCommentResult.getRatingComment());
    assertEquals("42", actualWithRatingCommentResult.getRatingExternalId());
    assertEquals("Rating Code", actualWithRatingCommentResult.getRatingCode());
    assertEquals("Rating Name", actualWithRatingCommentResult.getRatingName());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingExternalId(String)}
   */
  @Test
  @DisplayName("Test withRatingExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingExternalId(String)"
  })
  void testWithRatingExternalId() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build();

    // Act
    ImmutableAssessmentContextValue actualWithRatingExternalIdResult =
        immutableAssessmentContextValue.withRatingExternalId("42");

    // Assert
    assertSame(immutableAssessmentContextValue, actualWithRatingExternalIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingExternalId(String)}.
   *
   * <ul>
   *   <li>Then return RatingExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingExternalId(String)}
   */
  @Test
  @DisplayName("Test withRatingExternalId(String); then return RatingExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingExternalId(String)"
  })
  void testWithRatingExternalId_thenReturnRatingExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentContextValue actualWithRatingExternalIdResult =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("Rating External Id")
            .ratingName("Rating Name")
            .build()
            .withRatingExternalId("42");

    // Assert
    assertEquals("42", actualWithRatingExternalIdResult.getRatingExternalId());
    assertEquals("Rating Code", actualWithRatingExternalIdResult.getRatingCode());
    assertEquals("Rating Comment", actualWithRatingExternalIdResult.getRatingComment());
    assertEquals("Rating Name", actualWithRatingExternalIdResult.getRatingName());
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingName(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingName(String)}
   */
  @Test
  @DisplayName("Test withRatingName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingName(String)"
  })
  void testWithRatingName() {
    // Arrange
    ImmutableAssessmentContextValue immutableAssessmentContextValue =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("42")
            .build();

    // Act
    ImmutableAssessmentContextValue actualWithRatingNameResult =
        immutableAssessmentContextValue.withRatingName("42");

    // Assert
    assertSame(immutableAssessmentContextValue, actualWithRatingNameResult);
  }

  /**
   * Test {@link ImmutableAssessmentContextValue#withRatingName(String)}.
   *
   * <ul>
   *   <li>Then return RatingExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentContextValue#withRatingName(String)}
   */
  @Test
  @DisplayName("Test withRatingName(String); then return RatingExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentContextValue ImmutableAssessmentContextValue.withRatingName(String)"
  })
  void testWithRatingName_thenReturnRatingExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentContextValue actualWithRatingNameResult =
        ImmutableAssessmentContextValue.builder()
            .ratingCode("Rating Code")
            .ratingComment("Rating Comment")
            .ratingExternalId("42")
            .ratingName("Rating Name")
            .build()
            .withRatingName("42");

    // Assert
    assertEquals("42", actualWithRatingNameResult.getRatingExternalId());
    assertEquals("42", actualWithRatingNameResult.getRatingName());
    assertEquals("Rating Code", actualWithRatingNameResult.getRatingCode());
    assertEquals("Rating Comment", actualWithRatingNameResult.getRatingComment());
  }
}
