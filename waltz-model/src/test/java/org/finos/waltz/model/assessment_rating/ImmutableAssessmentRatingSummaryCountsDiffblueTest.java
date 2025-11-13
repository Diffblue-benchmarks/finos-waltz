package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingSummaryCounts.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingSummaryCounts.Json;
import org.finos.waltz.model.tally.ImmutableOrderedTally;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingSummaryCountsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingCounts(Iterable)"})
  void testBuilderAddAllRatingCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act
    Builder actualAddAllRatingCountsResult = builderResult.addAllRatingCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingCountsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingCounts(Tally)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatingCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addRatingCounts(Tally) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingCounts(Tally)"})
  void testBuilderAddRatingCountsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    ImmutableOrderedTally.Builder<Long> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddRatingCountsResult =
        builderResult.addRatingCounts(builderResult2.count(10.0d).id(1L).index(1).build());

    // Assert
    assertSame(builderResult, actualAddRatingCountsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingCounts(Tally[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRatingCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addRatingCounts(Tally[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingCounts(Tally[])"})
  void testBuilderAddRatingCountsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    ImmutableOrderedTally.Builder<Long> builderResult2 = ImmutableOrderedTally.builder();

    // Act
    Builder actualAddRatingCountsResult =
        builderResult.addRatingCounts(builderResult2.count(10.0d).id(1L).index(1).build());

    // Assert
    assertSame(builderResult, actualAddRatingCountsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAssessmentRatingSummaryCounts Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingSummaryCounts actualImmutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableAssessmentRatingSummaryCounts.definitionId());
    assertTrue(actualImmutableAssessmentRatingSummaryCounts.ratingCounts().isEmpty());
  }

  /**
   * Test Builder {@link Builder#definitionId(long)}.
   *
   * <p>Method under test: {@link Builder#definitionId(long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definitionId(long)"})
  void testBuilderDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act
    Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().definitionId());
    assertSame(builderResult, actualDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingSummaryCounts)}.
   *
   * <ul>
   *   <li>Given builder count ten id one index one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingSummaryCounts); given builder count ten id one index one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingSummaryCounts)"})
  void testBuilderFrom_givenBuilderCountTenIdOneIndexOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    Builder builderResult2 = ImmutableAssessmentRatingSummaryCounts.builder();

    ImmutableOrderedTally.Builder<Long> builderResult3 = ImmutableOrderedTally.builder();
    builderResult2.addRatingCounts(builderResult3.count(10.0d).id(1L).index(1).build());
    ImmutableAssessmentRatingSummaryCounts instance = builderResult2.definitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingSummaryCounts actualImmutableAssessmentRatingSummaryCounts =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingSummaryCounts);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingSummaryCounts)}.
   *
   * <ul>
   *   <li>Then builder build is builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingSummaryCounts); then builder build is builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingSummaryCounts)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDefinitionIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();
    ImmutableAssessmentRatingSummaryCounts instance =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingSummaryCounts actualImmutableAssessmentRatingSummaryCounts =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingSummaryCounts);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingCounts(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingCounts(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingCounts(Iterable)"})
  void testBuilderRatingCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act
    Builder actualRatingCountsResult = builderResult.ratingCounts(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingCountsResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#copyOf(AssessmentRatingSummaryCounts)}.
   *
   * <ul>
   *   <li>When builder definitionId one build.
   *   <li>Then return definitionId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingSummaryCounts#copyOf(AssessmentRatingSummaryCounts)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingSummaryCounts); when builder definitionId one build; then return definitionId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingSummaryCounts ImmutableAssessmentRatingSummaryCounts.copyOf(AssessmentRatingSummaryCounts)"
  })
  void testCopyOf_whenBuilderDefinitionIdOneBuild_thenReturnDefinitionIdIsOne() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts instance =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Act
    ImmutableAssessmentRatingSummaryCounts actualCopyOfResult =
        ImmutableAssessmentRatingSummaryCounts.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertTrue(actualCopyOfResult.ratingCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}, and {@link
   * ImmutableAssessmentRatingSummaryCounts#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts2 =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingSummaryCounts, immutableAssessmentRatingSummaryCounts2);
    assertEquals(
        immutableAssessmentRatingSummaryCounts.hashCode(),
        immutableAssessmentRatingSummaryCounts2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}, and {@link
   * ImmutableAssessmentRatingSummaryCounts#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingSummaryCounts, immutableAssessmentRatingSummaryCounts);
    int expectedHashCodeResult = immutableAssessmentRatingSummaryCounts.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingSummaryCounts.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    ImmutableOrderedTally.Builder<Long> builderResult2 = ImmutableOrderedTally.builder();
    builderResult.addRatingCounts(builderResult2.count(10.0d).id(1L).index(1).build());
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        builderResult.definitionId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingSummaryCounts,
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingSummaryCounts,
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingSummaryCounts.equals(Object)",
    "int ImmutableAssessmentRatingSummaryCounts.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build(),
        "Different type to ImmutableAssessmentRatingSummaryCounts");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#toString()}
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#definitionId()}
   *   <li>{@link ImmutableAssessmentRatingSummaryCounts#ratingCounts()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAssessmentRatingSummaryCounts.definitionId()",
    "java.util.Set ImmutableAssessmentRatingSummaryCounts.ratingCounts()",
    "String ImmutableAssessmentRatingSummaryCounts.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    // Act
    String actualToStringResult = immutableAssessmentRatingSummaryCounts.toString();
    long actualDefinitionIdResult = immutableAssessmentRatingSummaryCounts.definitionId();

    // Assert
    assertEquals(
        "AssessmentRatingSummaryCounts{definitionId=1, ratingCounts=[]}", actualToStringResult);
    assertEquals(1L, actualDefinitionIdResult);
    assertTrue(immutableAssessmentRatingSummaryCounts.ratingCounts().isEmpty());
  }

  /**
   * Test Json {@link Json#definitionId()}.
   *
   * <p>Method under test: {@link Json#definitionId()}
   */
  @Test
  @DisplayName("Test Json definitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.definitionId()"})
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definitionId());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertEquals(0L, actualJson.definitionId);
    assertFalse(actualJson.definitionIdIsSet);
    assertTrue(actualJson.ratingCounts.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingCounts()}.
   *
   * <p>Method under test: {@link Json#ratingCounts()}
   */
  @Test
  @DisplayName("Test Json ratingCounts()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set Json.ratingCounts()"})
  void testJsonRatingCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingCounts());
  }

  /**
   * Test Json {@link Json#setDefinitionId(long)}.
   *
   * <p>Method under test: {@link Json#setDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDefinitionId(long)"})
  void testJsonSetDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#withDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return builder definitionId forty-two build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#withDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withDefinitionId(long); then return builder definitionId forty-two build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingSummaryCounts ImmutableAssessmentRatingSummaryCounts.withDefinitionId(long)"
  })
  void testWithDefinitionId_thenReturnBuilderDefinitionIdFortyTwoBuild() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(42L).build();

    // Act
    ImmutableAssessmentRatingSummaryCounts actualWithDefinitionIdResult =
        immutableAssessmentRatingSummaryCounts.withDefinitionId(42L);

    // Assert
    assertSame(immutableAssessmentRatingSummaryCounts, actualWithDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#withDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return definitionId is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#withDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withDefinitionId(long); then return definitionId is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingSummaryCounts ImmutableAssessmentRatingSummaryCounts.withDefinitionId(long)"
  })
  void testWithDefinitionId_thenReturnDefinitionIdIsFortyTwo() {
    // Arrange and Act
    ImmutableAssessmentRatingSummaryCounts actualWithDefinitionIdResult =
        ImmutableAssessmentRatingSummaryCounts.builder()
            .definitionId(1L)
            .build()
            .withDefinitionId(42L);

    // Assert
    assertEquals(42L, actualWithDefinitionIdResult.definitionId());
    assertTrue(actualWithDefinitionIdResult.ratingCounts().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingSummaryCounts#withRatingCounts(Tally[])} with {@code
   * Tally[]}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingSummaryCounts#withRatingCounts(Tally[])}
   */
  @Test
  @DisplayName("Test withRatingCounts(Tally[]) with 'Tally[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingSummaryCounts ImmutableAssessmentRatingSummaryCounts.withRatingCounts(Tally[])"
  })
  void testWithRatingCountsWithTally() {
    // Arrange
    ImmutableAssessmentRatingSummaryCounts immutableAssessmentRatingSummaryCounts =
        ImmutableAssessmentRatingSummaryCounts.builder().definitionId(1L).build();

    ImmutableOrderedTally.Builder<Long> builderResult = ImmutableOrderedTally.builder();

    // Act
    ImmutableAssessmentRatingSummaryCounts actualWithRatingCountsResult =
        immutableAssessmentRatingSummaryCounts.withRatingCounts(
            builderResult.count(10.0d).id(1L).index(1).build());

    // Assert
    assertEquals(1, actualWithRatingCountsResult.ratingCounts().size());
    assertEquals(1L, actualWithRatingCountsResult.definitionId());
  }
}
