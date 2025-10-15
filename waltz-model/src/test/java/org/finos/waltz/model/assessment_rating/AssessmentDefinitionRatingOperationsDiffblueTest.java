package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AssessmentDefinitionRatingOperationsDiffblueTest {
  /**
   * Test {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test findForRatingId(Long); given builder addRatingOperations builder ratingId 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findForRatingId(Long)"})
  void testFindForRatingId_givenBuilderAddRatingOperationsBuilderRatingIdNullBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(null).build());

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .findForRatingId(1L)
            .isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test findForRatingId(Long); given builder addRatingOperations builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findForRatingId(Long)"})
  void testFindForRatingId_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .findForRatingId(1L)
            .isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId two build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test findForRatingId(Long); given builder addRatingOperations builder ratingId two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findForRatingId(Long)"})
  void testFindForRatingId_givenBuilderAddRatingOperationsBuilderRatingIdTwoBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(2L).build());

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .findForRatingId(1L)
            .isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId two build.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test findForRatingId(Long); given builder addRatingOperations builder ratingId two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findForRatingId(Long)"})
  void testFindForRatingId_givenBuilderAddRatingOperationsBuilderRatingIdTwoBuild2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(2L).build());
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .findForRatingId(1L)
            .isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findForRatingId(Long)}
   */
  @Test
  @DisplayName("Test findForRatingId(Long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findForRatingId(Long)"})
  void testFindForRatingId_thenReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .findForRatingId(1L)
            .isEmpty());
  }

  /**
   * Test {@link AssessmentDefinitionRatingOperations#findDefault()}.
   *
   * <ul>
   *   <li>Given builder addAllRatingOperations {@link ArrayList#ArrayList()} build.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssessmentDefinitionRatingOperations#findDefault()}
   */
  @Test
  @DisplayName(
      "Test findDefault(); given builder addAllRatingOperations ArrayList() build; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set AssessmentDefinitionRatingOperations.findDefault()"})
  void testFindDefault_givenBuilderAddAllRatingOperationsArrayListBuild_thenReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertTrue(
        builderResult.addAllRatingOperations(new ArrayList<>()).build().findDefault().isEmpty());
  }
}
