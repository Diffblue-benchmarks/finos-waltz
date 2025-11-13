package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RatingSchemeItemDiffblueTest {
  /**
   * Test {@link RatingSchemeItem#userSelectable()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeItem#userSelectable()}
   */
  @Test
  @DisplayName("Test userSelectable(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSchemeItem.userSelectable()"})
  void testUserSelectable_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .userSelectable());
  }

  /**
   * Test {@link RatingSchemeItem#isRestricted()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeItem#isRestricted()}
   */
  @Test
  @DisplayName("Test isRestricted(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSchemeItem.isRestricted()"})
  void testIsRestricted_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .isRestricted());
  }

  /**
   * Test {@link RatingSchemeItem#requiresComment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RatingSchemeItem#requiresComment()}
   */
  @Test
  @DisplayName("Test requiresComment(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RatingSchemeItem.requiresComment()"})
  void testRequiresComment_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .requiresComment());
  }
}
