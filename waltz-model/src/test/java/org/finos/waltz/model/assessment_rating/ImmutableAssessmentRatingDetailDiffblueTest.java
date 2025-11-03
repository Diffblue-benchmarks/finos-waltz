package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingDetail.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingDetail.Json;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#assessmentDefinition(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#assessmentDefinition(Optional)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinition(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinition(Optional)"})
  void testBuilderAssessmentDefinitionWithOptional() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    Optional<? extends AssessmentDefinition> assessmentDefinition = Optional.of(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinition(assessmentDefinition));
  }

  /**
   * Test Builder {@link Builder#assessmentRating(AssessmentRating)}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRating.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentRating(AssessmentRating)}
   */
  @Test
  @DisplayName("Test Builder assessmentRating(AssessmentRating); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentRating(AssessmentRating)"})
  void testBuilderAssessmentRating_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRating(new ImmutableAssessmentRating.Json()));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    when(instance.ratingDefinition()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentRating()).thenReturn(new ImmutableAssessmentRating.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    when(instance.assessmentDefinition()).thenThrow(new IllegalStateException("instance"));
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    when(instance.assessmentRating()).thenReturn(new ImmutableAssessmentRating.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail); given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> emptyResult = Optional.empty();
    when(instance.assessmentDefinition()).thenReturn(emptyResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, builderResult.build().assessmentRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingDetail)}.
   * <ul>
   *   <li>Given {@link Optional} with {@link AssessmentDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingDetail)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingDetail); given Optional with AssessmentDefinition")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingDetail)"})
  void testBuilderFrom_givenOptionalWithAssessmentDefinition() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.assessmentDefinition()).thenReturn(ofResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, builderResult.build().assessmentRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingDefinition(RatingSchemeItem)}.
   * <ul>
   *   <li>When {@link RatingSchemeItem}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingDefinition(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder ratingDefinition(RatingSchemeItem); when RatingSchemeItem; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingDefinition(RatingSchemeItem)"})
  void testBuilderRatingDefinition_whenRatingSchemeItem_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingDefinition(mock(RatingSchemeItem.class)));
  }

  /**
   * Test Json {@link Json#assessmentDefinition()}.
   * <p>
   * Method under test: {@link Json#assessmentDefinition()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.assessmentDefinition()"})
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentDefinition());
  }

  /**
   * Test Json {@link Json#assessmentRating()}.
   * <p>
   * Method under test: {@link Json#assessmentRating()}
   */
  @Test
  @DisplayName("Test Json assessmentRating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentRating Json.assessmentRating()"})
  void testJsonAssessmentRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentRating());
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
    assertNull(actualJson.assessmentRating);
    assertNull(actualJson.ratingDefinition);
    assertFalse(actualJson.assessmentDefinition.isPresent());
  }

  /**
   * Test Json {@link Json#ratingDefinition()}.
   * <p>
   * Method under test: {@link Json#ratingDefinition()}
   */
  @Test
  @DisplayName("Test Json ratingDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RatingSchemeItem Json.ratingDefinition()"})
  void testJsonRatingDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingDefinition());
  }
}
