package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingSummaryCounts.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingSummaryCounts.Json;
import org.finos.waltz.model.tally.Tally;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingSummaryCountsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingCounts(Iterable)"})
  void testBuilderAddAllRatingCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingCounts(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRatingCounts(Tally)} with {@code element}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingCounts(Tally)}
   */
  @Test
  @DisplayName("Test Builder addRatingCounts(Tally) with 'element'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingCounts(Tally)"})
  void testBuilderAddRatingCountsWithElement_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#addRatingCounts(Tally[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Tally}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingCounts(Tally[])}
   */
  @Test
  @DisplayName("Test Builder addRatingCounts(Tally[]) with 'elements'; when Tally; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingCounts(Tally[])"})
  void testBuilderAddRatingCountsWithElements_whenTally_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingCounts(mock(Tally.class)));
  }

  /**
   * Test Builder {@link Builder#definitionId(long)}.
   * <p>
   * Method under test: {@link Builder#definitionId(long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link Tally}.</li>
   *   <li>Then builder build ratingCounts size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingSummaryCounts); given HashSet() add Tally; then builder build ratingCounts size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingSummaryCounts)"})
  void testBuilderFrom_givenHashSetAddTally_thenBuilderBuildRatingCountsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    HashSet<Tally<Long>> tallySet = new HashSet<>();
    tallySet.add(mock(Tally.class));
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(tallySet);
    when(instance.definitionId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    ImmutableAssessmentRatingSummaryCounts buildResult = builderResult.build();
    assertEquals(1, buildResult.ratingCounts().size());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingSummaryCounts)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build definitionId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRatingSummaryCounts)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRatingSummaryCounts); given HashSet(); then builder build definitionId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingSummaryCounts)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildDefinitionIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();
    AssessmentRatingSummaryCounts instance = mock(AssessmentRatingSummaryCounts.class);
    when(instance.ratingCounts()).thenReturn(new HashSet<>());
    when(instance.definitionId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingCounts();
    assertEquals(1L, builderResult.build().definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingCounts(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingCounts(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingCounts(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingCounts(Iterable)"})
  void testBuilderRatingCounts_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingSummaryCounts.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingCounts(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#definitionId()}.
   * <p>
   * Method under test: {@link Json#definitionId()}
   */
  @Test
  @DisplayName("Test Json definitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.definitionId()"})
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definitionId());
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
    assertEquals(0L, actualJson.definitionId);
    assertFalse(actualJson.definitionIdIsSet);
    assertTrue(actualJson.ratingCounts.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingCounts()}.
   * <p>
   * Method under test: {@link Json#ratingCounts()}
   */
  @Test
  @DisplayName("Test Json ratingCounts()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.ratingCounts()"})
  void testJsonRatingCounts() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingCounts());
  }

  /**
   * Test Json {@link Json#setDefinitionId(long)}.
   * <p>
   * Method under test: {@link Json#setDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
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
}
