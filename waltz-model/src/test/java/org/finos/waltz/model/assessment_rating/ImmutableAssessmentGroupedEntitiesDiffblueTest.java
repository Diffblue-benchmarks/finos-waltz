package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.assessment_definition.AssessmentDefinition;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentGroupedEntities.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentGroupedEntities.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentGroupedEntitiesDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingEntityLists(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingEntityLists(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingEntityLists(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingEntityLists(Iterable)"})
  void testBuilderAddAllRatingEntityLists_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingEntityLists(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRatingEntityLists(RatingEntityList)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableRatingEntityList.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingEntityLists(RatingEntityList)}
   */
  @Test
  @DisplayName("Test Builder addRatingEntityLists(RatingEntityList) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingEntityLists(RatingEntityList)"})
  void testBuilderAddRatingEntityListsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json()));
  }

  /**
   * Test Builder {@link Builder#addRatingEntityLists(RatingEntityList[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableRatingEntityList.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingEntityLists(RatingEntityList[])}
   */
  @Test
  @DisplayName("Test Builder addRatingEntityLists(RatingEntityList[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingEntityLists(RatingEntityList[])"})
  void testBuilderAddRatingEntityListsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingEntityLists(new ImmutableRatingEntityList.Json()));
  }

  /**
   * Test Builder {@link Builder#assessmentDefinition(AssessmentDefinition)}.
   * <ul>
   *   <li>When {@link AssessmentDefinition}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentDefinition(AssessmentDefinition)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinition(AssessmentDefinition); when AssessmentDefinition; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinition(AssessmentDefinition)"})
  void testBuilderAssessmentDefinition_whenAssessmentDefinition_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentDefinition assessmentDefinition = mock(AssessmentDefinition.class);

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentDefinition(assessmentDefinition));
    assertSame(assessmentDefinition, builderResult.build().assessmentDefinition());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentGroupedEntities)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableRatingEntityList.Json} (default constructor).</li>
   *   <li>Then return build ratingEntityLists size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentGroupedEntities); given HashSet() add Json (default constructor); then return build ratingEntityLists size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentGroupedEntities)"})
  void testBuilderFrom_givenHashSetAddJson_thenReturnBuildRatingEntityListsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    HashSet<RatingEntityList> ratingEntityListSet = new HashSet<>();
    ratingEntityListSet.add(new ImmutableRatingEntityList.Json());
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(ratingEntityListSet);
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertEquals(1, actualFromResult.build().ratingEntityLists().size());
    assertEquals(1, builderResult.build().ratingEntityLists().size());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentGroupedEntities)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build ratingEntityLists Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentGroupedEntities); given HashSet(); then return build ratingEntityLists Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentGroupedEntities)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildRatingEntityListsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenReturn(new HashSet<>());
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
    assertTrue(actualFromResult.build().ratingEntityLists().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentGroupedEntities)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentGroupedEntities)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentGroupedEntities); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentGroupedEntities)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();
    AssessmentGroupedEntities instance = mock(AssessmentGroupedEntities.class);
    when(instance.ratingEntityLists()).thenThrow(new IllegalStateException("instance"));
    when(instance.assessmentDefinition()).thenReturn(mock(AssessmentDefinition.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).assessmentDefinition();
    verify(instance).ratingEntityLists();
  }

  /**
   * Test Builder {@link Builder#ratingEntityLists(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingEntityLists(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingEntityLists(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingEntityLists(Iterable)"})
  void testBuilderRatingEntityLists_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentGroupedEntities.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingEntityLists(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#assessmentDefinition()}.
   * <p>
   * Method under test: {@link Json#assessmentDefinition()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssessmentDefinition Json.assessmentDefinition()"})
  void testJsonAssessmentDefinition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentDefinition());
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
    assertNull(actualJson.assessmentDefinition);
    assertTrue(actualJson.ratingEntityLists.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingEntityLists()}.
   * <p>
   * Method under test: {@link Json#ratingEntityLists()}
   */
  @Test
  @DisplayName("Test Json ratingEntityLists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.ratingEntityLists()"})
  void testJsonRatingEntityLists() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingEntityLists());
  }
}
