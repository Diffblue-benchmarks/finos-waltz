package org.finos.waltz.model.assessment_rating.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedItem.Builder;
import org.finos.waltz.model.assessment_rating.bulk_upload.ImmutableAssessmentRatingParsedItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingParsedItemDiffblueTest {
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
    "ImmutableAssessmentRatingParsedItem Builder.build()",
    "Builder Builder.comment(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem actualImmutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Assert
    assertEquals("42", actualImmutableAssessmentRatingParsedItem.externalId());
    assertEquals("Comment", actualImmutableAssessmentRatingParsedItem.comment());
    assertEquals("Rating Code", actualImmutableAssessmentRatingParsedItem.ratingCode());
    assertFalse(actualImmutableAssessmentRatingParsedItem.isReadOnly());
  }

  /**
   * Test Builder {@link Builder#externalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#externalId(String)}
   */
  @Test
  @DisplayName("Test Builder externalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(String)"})
  void testBuilderExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act
    Builder actualExternalIdResult = builderResult.externalId("42");

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedItem)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedItem)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    ImmutableAssessmentRatingParsedItem instance =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingParsedItem actualImmutableAssessmentRatingParsedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingParsedItem)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingParsedItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingParsedItem)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();
    ImmutableAssessmentRatingParsedItem instance =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment(null)
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingParsedItem actualImmutableAssessmentRatingParsedItem =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingParsedItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
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
    Builder builderResult = ImmutableAssessmentRatingParsedItem.builder();

    // Act
    Builder actualRatingCodeResult = builderResult.ratingCode("Rating Code");

    // Assert
    assertSame(builderResult, actualRatingCodeResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#copyOf(AssessmentRatingParsedItem)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingParsedItem#copyOf(AssessmentRatingParsedItem)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentRatingParsedItem); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.copyOf(AssessmentRatingParsedItem)"
  })
  void testCopyOf_thenReturnExternalIdIs42() {
    // Arrange
    ImmutableAssessmentRatingParsedItem instance =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    ImmutableAssessmentRatingParsedItem actualCopyOfResult =
        ImmutableAssessmentRatingParsedItem.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.externalId());
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Rating Code", actualCopyOfResult.ratingCode());
    assertFalse(actualCopyOfResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}, and {@link
   * ImmutableAssessmentRatingParsedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem2 =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingParsedItem, immutableAssessmentRatingParsedItem2);
    assertEquals(
        immutableAssessmentRatingParsedItem.hashCode(),
        immutableAssessmentRatingParsedItem2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}, and {@link
   * ImmutableAssessmentRatingParsedItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingParsedItem, immutableAssessmentRatingParsedItem);
    int expectedHashCodeResult = immutableAssessmentRatingParsedItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingParsedItem.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("42")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedItem,
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("Rating Code")
            .ratingCode("Rating Code")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedItem,
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("42")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingParsedItem,
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingParsedItem.equals(Object)",
    "int ImmutableAssessmentRatingParsedItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build(),
        "Different type to ImmutableAssessmentRatingParsedItem");
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Json} (default constructor) Comment is {@code externalId}.
   *   <li>Then return comment is {@code externalId}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given '42'; when Json (default constructor) Comment is 'externalId'; then return comment is 'externalId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.fromJson(Json)"
  })
  void testFromJson_given42_whenJsonCommentIsExternalId_thenReturnCommentIsExternalId() {
    // Arrange
    Json json = new Json();
    json.setComment("externalId");
    json.setRatingCode("externalId");
    json.setExternalId("42");

    // Act
    ImmutableAssessmentRatingParsedItem actualFromJsonResult =
        ImmutableAssessmentRatingParsedItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("externalId", actualFromJsonResult.comment());
    assertEquals("externalId", actualFromJsonResult.ratingCode());
    assertFalse(actualFromJsonResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Json} (default constructor) RatingCode is {@code externalId}.
   *   <li>Then return comment is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given '42'; when Json (default constructor) RatingCode is 'externalId'; then return comment is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.fromJson(Json)"
  })
  void testFromJson_given42_whenJsonRatingCodeIsExternalId_thenReturnCommentIsNull() {
    // Arrange
    Json json = new Json();
    json.setRatingCode("externalId");
    json.setExternalId("42");

    // Act
    ImmutableAssessmentRatingParsedItem actualFromJsonResult =
        ImmutableAssessmentRatingParsedItem.fromJson(json);

    // Assert
    assertEquals("42", actualFromJsonResult.externalId());
    assertEquals("externalId", actualFromJsonResult.ratingCode());
    assertNull(actualFromJsonResult.comment());
    assertFalse(actualFromJsonResult.isReadOnly());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingParsedItem#toString()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#comment()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#externalId()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#isReadOnly()}
   *   <li>{@link ImmutableAssessmentRatingParsedItem#ratingCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRatingParsedItem.comment()",
    "String ImmutableAssessmentRatingParsedItem.externalId()",
    "boolean ImmutableAssessmentRatingParsedItem.isReadOnly()",
    "String ImmutableAssessmentRatingParsedItem.ratingCode()",
    "String ImmutableAssessmentRatingParsedItem.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingParsedItem.toString();
    String actualCommentResult = immutableAssessmentRatingParsedItem.comment();
    String actualExternalIdResult = immutableAssessmentRatingParsedItem.externalId();
    boolean actualIsReadOnlyResult = immutableAssessmentRatingParsedItem.isReadOnly();

    // Assert
    assertEquals("42", actualExternalIdResult);
    assertEquals(
        "AssessmentRatingParsedItem{externalId=42, ratingCode=Rating Code, isReadOnly=false, comment=Comment}",
        actualToStringResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals("Rating Code", immutableAssessmentRatingParsedItem.ratingCode());
    assertFalse(actualIsReadOnlyResult);
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
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setExternalId(String)}
   *   <li>{@link Json#setRatingCode(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComment(String)",
    "void Json.setExternalId(String)",
    "void Json.setRatingCode(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setExternalId("42");
    actualJson.setRatingCode("Rating Code");

    // Assert
    assertEquals("42", actualJson.externalId);
    assertEquals("Comment", actualJson.comment);
    assertEquals("Rating Code", actualJson.ratingCode);
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
  }

  /**
   * Test Json {@link Json#ratingCode()}.
   *
   * <p>Method under test: {@link Json#ratingCode()}
   */
  @Test
  @DisplayName("Test Json ratingCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingCode()"})
  void testJsonRatingCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingCode());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withComment(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code 42} externalId {@code 42} ratingCode {@code Rating
   *       Code} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withComment(String)}
   */
  @Test
  @DisplayName(
      "Test withComment(String); then return builder comment '42' externalId '42' ratingCode 'Rating Code' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withComment(String)"
  })
  void testWithComment_thenReturnBuilderComment42ExternalId42RatingCodeRatingCodeBuild() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("42")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    ImmutableAssessmentRatingParsedItem actualWithCommentResult =
        immutableAssessmentRatingParsedItem.withComment("42");

    // Assert
    assertSame(immutableAssessmentRatingParsedItem, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withComment(String)}.
   *
   * <ul>
   *   <li>Then return comment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); then return comment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withComment(String)"
  })
  void testWithComment_thenReturnCommentIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem actualWithCommentResult =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build()
            .withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.comment());
    assertEquals("42", actualWithCommentResult.externalId());
    assertEquals("Rating Code", actualWithCommentResult.ratingCode());
    assertFalse(actualWithCommentResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withExternalId(String)"
  })
  void testWithExternalId() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("0123456789ABCDEF")
            .ratingCode("Rating Code")
            .build();

    // Act
    ImmutableAssessmentRatingParsedItem actualWithExternalIdResult =
        immutableAssessmentRatingParsedItem.withExternalId("0123456789ABCDEF");

    // Assert
    assertSame(immutableAssessmentRatingParsedItem, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withExternalId(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String); then return externalId is '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withExternalId(String)"
  })
  void testWithExternalId_thenReturnExternalIdIs0123456789abcdef() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem actualWithExternalIdResult =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualWithExternalIdResult.externalId());
    assertEquals("Comment", actualWithExternalIdResult.comment());
    assertEquals("Rating Code", actualWithExternalIdResult.ratingCode());
    assertFalse(actualWithExternalIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build();

    // Act
    ImmutableAssessmentRatingParsedItem actualWithIsReadOnlyResult =
        immutableAssessmentRatingParsedItem.withIsReadOnly(false);

    // Assert
    assertSame(immutableAssessmentRatingParsedItem, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean); when 'true'; then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly_whenTrue_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem actualWithIsReadOnlyResult =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build()
            .withIsReadOnly(true);

    // Assert
    assertEquals("42", actualWithIsReadOnlyResult.externalId());
    assertEquals("Comment", actualWithIsReadOnlyResult.comment());
    assertEquals("Rating Code", actualWithIsReadOnlyResult.ratingCode());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withRatingCode(String)}.
   *
   * <ul>
   *   <li>Then return builder comment {@code Comment} externalId {@code 42} ratingCode {@code 42}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withRatingCode(String)}
   */
  @Test
  @DisplayName(
      "Test withRatingCode(String); then return builder comment 'Comment' externalId '42' ratingCode '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withRatingCode(String)"
  })
  void testWithRatingCode_thenReturnBuilderCommentCommentExternalId42RatingCode42Build() {
    // Arrange
    ImmutableAssessmentRatingParsedItem immutableAssessmentRatingParsedItem =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("42")
            .build();

    // Act
    ImmutableAssessmentRatingParsedItem actualWithRatingCodeResult =
        immutableAssessmentRatingParsedItem.withRatingCode("42");

    // Assert
    assertSame(immutableAssessmentRatingParsedItem, actualWithRatingCodeResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingParsedItem#withRatingCode(String)}.
   *
   * <ul>
   *   <li>Then return externalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingParsedItem#withRatingCode(String)}
   */
  @Test
  @DisplayName("Test withRatingCode(String); then return externalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingParsedItem ImmutableAssessmentRatingParsedItem.withRatingCode(String)"
  })
  void testWithRatingCode_thenReturnExternalIdIs42() {
    // Arrange and Act
    ImmutableAssessmentRatingParsedItem actualWithRatingCodeResult =
        ImmutableAssessmentRatingParsedItem.builder()
            .comment("Comment")
            .externalId("42")
            .ratingCode("Rating Code")
            .build()
            .withRatingCode("42");

    // Assert
    assertEquals("42", actualWithRatingCodeResult.externalId());
    assertEquals("42", actualWithRatingCodeResult.ratingCode());
    assertEquals("Comment", actualWithRatingCodeResult.comment());
    assertFalse(actualWithRatingCodeResult.isReadOnly());
  }
}
