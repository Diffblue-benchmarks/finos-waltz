package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingCount.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableAssessmentRatingCount.Json;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingCountDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRatingCount Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCountResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableRatingSchemeItem rating =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    ImmutableAssessmentRatingCount actualImmutableAssessmentRatingCount =
        actualCountResult.rating(rating).build();

    // Assert
    assertEquals(3, actualImmutableAssessmentRatingCount.count());
    assertSame(rating, actualImmutableAssessmentRatingCount.rating());
  }

  /**
   * Test Builder {@link Builder#count(int)}.
   *
   * <p>Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingCount)}.
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingCount)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingCount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingCount)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingCount.builder();

    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount instance =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingCount actualImmutableAssessmentRatingCount = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingCount);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(RatingSchemeItem)}.
   *
   * <ul>
   *   <li>When {@link RatingSchemeItem}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder rating(RatingSchemeItem); when RatingSchemeItem; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(RatingSchemeItem)"})
  void testBuilderRating_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingCount.builder();

    // Act
    Builder actualRatingResult = builderResult.rating(mock(RatingSchemeItem.class));

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#copyOf(AssessmentRatingCount)}.
   *
   * <ul>
   *   <li>Then rating return {@link ImmutableRatingSchemeItem}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#copyOf(AssessmentRatingCount)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentRatingCount); then rating return ImmutableRatingSchemeItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingCount ImmutableAssessmentRatingCount.copyOf(AssessmentRatingCount)"
  })
  void testCopyOf_thenRatingReturnImmutableRatingSchemeItem() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount instance =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingCount actualCopyOfResult =
        ImmutableAssessmentRatingCount.copyOf(instance);

    // Assert
    RatingSchemeItem ratingResult = actualCopyOfResult.rating();
    assertTrue(ratingResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", ratingResult.color());
    assertEquals("Name", ratingResult.name());
    assertEquals("Rating Group", ratingResult.ratingGroup());
    assertEquals("Rating", ratingResult.rating());
    assertEquals("The characteristics of someone or something", ratingResult.description());
    assertEquals(0, ratingResult.position());
    assertEquals(1L, ratingResult.ratingSchemeId());
    assertEquals(3, actualCopyOfResult.count());
    assertFalse(ratingResult.isRestricted());
    assertFalse(ratingResult.requiresComment());
    assertTrue(ratingResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}, and {@link
   * ImmutableAssessmentRatingCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingCount#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder countResult2 = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount2 =
        countResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingCount, immutableAssessmentRatingCount2);
    assertEquals(
        immutableAssessmentRatingCount.hashCode(), immutableAssessmentRatingCount2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}, and {@link
   * ImmutableAssessmentRatingCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingCount#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingCount, immutableAssessmentRatingCount);
    int expectedHashCodeResult = immutableAssessmentRatingCount.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingCount.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(1);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder countResult2 = ImmutableAssessmentRatingCount.builder().count(3);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingCount,
        countResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Name")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    Builder countResult2 = ImmutableAssessmentRatingCount.builder().count(3);

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingCount,
        countResult2
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);

    // Act and Assert
    assertNotEquals(
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingCount.equals(Object)",
    "int ImmutableAssessmentRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);

    // Act and Assert
    assertNotEquals(
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build(),
        "Different type to ImmutableAssessmentRatingCount");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingCount#toString()}
   *   <li>{@link ImmutableAssessmentRatingCount#count()}
   *   <li>{@link ImmutableAssessmentRatingCount#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableAssessmentRatingCount.count()",
    "RatingSchemeItem ImmutableAssessmentRatingCount.rating()",
    "String ImmutableAssessmentRatingCount.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableAssessmentRatingCount.toString();
    int actualCountResult = immutableAssessmentRatingCount.count();

    // Assert
    assertTrue(immutableAssessmentRatingCount.rating() instanceof ImmutableRatingSchemeItem);
    assertEquals(
        "AssessmentRatingCount{count=3, rating=RatingSchemeItem{id=1, name=Name, position=0, externalId=42,"
            + " rating=Rating, color=Color, ratingSchemeId=1, userSelectable=true, isRestricted=false, ratingGroup=Rating"
            + " Group, requiresComment=false}}",
        actualToStringResult);
    assertEquals(3, actualCountResult);
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRating(RatingSchemeItem)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRating(RatingSchemeItem)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRating(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());

    // Assert
    RatingSchemeItem ratingSchemeItem = actualJson.rating;
    assertTrue(ratingSchemeItem instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", ratingSchemeItem.color());
    assertEquals("Name", ratingSchemeItem.name());
    assertEquals("Rating Group", ratingSchemeItem.ratingGroup());
    assertEquals("Rating", ratingSchemeItem.rating());
    assertEquals("The characteristics of someone or something", ratingSchemeItem.description());
    assertEquals(0, ratingSchemeItem.position());
    assertEquals(0, actualJson.count);
    assertEquals(1L, ratingSchemeItem.ratingSchemeId());
    assertFalse(ratingSchemeItem.isRestricted());
    assertFalse(ratingSchemeItem.requiresComment());
    assertFalse(actualJson.countIsSet);
    assertTrue(ratingSchemeItem.userSelectable());
  }

  /**
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RatingSchemeItem Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   *
   * <p>Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#withCount(int)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingCount ImmutableAssessmentRatingCount.withCount(int)"
  })
  void testWithCount() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(42);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingCount actualWithCountResult =
        immutableAssessmentRatingCount.withCount(42);

    // Assert
    assertSame(immutableAssessmentRatingCount, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#withCount(int)}.
   *
   * <ul>
   *   <li>Then rating return {@link ImmutableRatingSchemeItem}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int); then rating return ImmutableRatingSchemeItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingCount ImmutableAssessmentRatingCount.withCount(int)"
  })
  void testWithCount_thenRatingReturnImmutableRatingSchemeItem() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);

    // Act
    ImmutableAssessmentRatingCount actualWithCountResult =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build()
            .withCount(42);

    // Assert
    RatingSchemeItem ratingResult = actualWithCountResult.rating();
    assertTrue(ratingResult instanceof ImmutableRatingSchemeItem);
    assertEquals("Color", ratingResult.color());
    assertEquals("Name", ratingResult.name());
    assertEquals("Rating Group", ratingResult.ratingGroup());
    assertEquals("Rating", ratingResult.rating());
    assertEquals("The characteristics of someone or something", ratingResult.description());
    assertEquals(0, ratingResult.position());
    assertEquals(1L, ratingResult.ratingSchemeId());
    assertEquals(42, actualWithCountResult.count());
    assertFalse(ratingResult.isRestricted());
    assertFalse(ratingResult.requiresComment());
    assertTrue(ratingResult.userSelectable());
  }

  /**
   * Test {@link ImmutableAssessmentRatingCount#withRating(RatingSchemeItem)}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingCount#withRating(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test withRating(RatingSchemeItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingCount ImmutableAssessmentRatingCount.withRating(RatingSchemeItem)"
  })
  void testWithRating() {
    // Arrange
    Builder countResult = ImmutableAssessmentRatingCount.builder().count(3);
    ImmutableAssessmentRatingCount immutableAssessmentRatingCount =
        countResult
            .rating(
                ImmutableRatingSchemeItem.builder()
                    .color("Color")
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .rating("Rating")
                    .ratingGroup("Rating Group")
                    .ratingSchemeId(1L)
                    .build())
            .build();

    // Act
    ImmutableAssessmentRatingCount actualWithRatingResult =
        immutableAssessmentRatingCount.withRating(
            ImmutableRatingSchemeItem.builder()
                .color("Color")
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .name("Name")
                .rating("Rating")
                .ratingGroup("Rating Group")
                .ratingSchemeId(1L)
                .build());

    // Assert
    assertEquals(immutableAssessmentRatingCount, actualWithRatingResult);
  }
}
