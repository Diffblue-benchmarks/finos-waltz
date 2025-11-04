package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.rating.RatingSchemeItem;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingDetailDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#assessmentRating(AssessmentRating)}
   */
  @Test
  void testBuilderAssessmentRating() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRating(new ImmutableAssessmentRating.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#assessmentRating(AssessmentRating)}
   */
  @Test
  void testBuilderAssessmentRating2() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    builderResult.assessmentDefinition(mock(AssessmentDefinition.class));

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentRating(new ImmutableAssessmentRating.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#from(AssessmentRatingDetail)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    when(instance.ratingDefinition()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentRating()).thenReturn(new ImmutableAssessmentRating.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#from(AssessmentRatingDetail)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.assessmentDefinition()).thenReturn(ofResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, builderResult.build().assessmentRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#from(AssessmentRatingDetail)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> emptyResult = Optional.empty();
    when(instance.assessmentDefinition()).thenReturn(emptyResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, builderResult.build().assessmentRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#from(AssessmentRatingDetail)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();
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
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Builder#ratingDefinition(RatingSchemeItem)}
   */
  @Test
  void testBuilderRatingDefinition() {
    // Arrange
    ImmutableAssessmentRatingDetail.Builder builderResult = ImmutableAssessmentRatingDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingDefinition(mock(RatingSchemeItem.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail#copyOf(AssessmentRatingDetail)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> ofResult = Optional.of(mock(AssessmentDefinition.class));
    when(instance.assessmentDefinition()).thenReturn(ofResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingDetail actualCopyOfResult = ImmutableAssessmentRatingDetail.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, actualCopyOfResult.assessmentRating());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail#copyOf(AssessmentRatingDetail)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentRatingDetail instance = mock(AssessmentRatingDetail.class);
    Optional<AssessmentDefinition> emptyResult = Optional.empty();
    when(instance.assessmentDefinition()).thenReturn(emptyResult);
    when(instance.ratingDefinition()).thenReturn(mock(RatingSchemeItem.class));
    ImmutableAssessmentRating.Json json = new ImmutableAssessmentRating.Json();
    when(instance.assessmentRating()).thenReturn(json);

    // Act
    ImmutableAssessmentRatingDetail actualCopyOfResult = ImmutableAssessmentRatingDetail.copyOf(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).assessmentRating();
    verify(instance).ratingDefinition();
    assertSame(json, actualCopyOfResult.assessmentRating());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail#fromJson(ImmutableAssessmentRatingDetail.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRatingDetail.Json json = new ImmutableAssessmentRatingDetail.Json();
    ImmutableAssessmentRating.Json assessmentRating = new ImmutableAssessmentRating.Json();
    json.setAssessmentRating(assessmentRating);
    json.setRatingDefinition(mock(RatingSchemeItem.class));
    json.setAssessmentDefinition(null);

    // Act
    ImmutableAssessmentRatingDetail actualFromJsonResult = ImmutableAssessmentRatingDetail.fromJson(json);

    // Assert
    assertSame(assessmentRating, actualFromJsonResult.assessmentRating());
    RatingSchemeItem expectedRatingDefinitionResult = json.ratingDefinition;
    assertSame(expectedRatingDefinitionResult, actualFromJsonResult.ratingDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Json#assessmentDefinition()}
   */
  @Test
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingDetail.Json()).assessmentDefinition());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Json#assessmentRating()}
   */
  @Test
  void testJsonAssessmentRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingDetail.Json()).assessmentRating());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRatingDetail.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRatingDetail.Json actualJson = new ImmutableAssessmentRatingDetail.Json();

    // Assert
    assertNull(actualJson.assessmentRating);
    assertNull(actualJson.ratingDefinition);
    assertFalse(actualJson.assessmentDefinition.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRatingDetail.Json#ratingDefinition()}
   */
  @Test
  void testJsonRatingDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRatingDetail.Json()).ratingDefinition());
  }
}
