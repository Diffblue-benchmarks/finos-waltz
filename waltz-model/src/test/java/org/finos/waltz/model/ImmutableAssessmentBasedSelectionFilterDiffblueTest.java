package org.finos.waltz.model;

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
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter.Builder;
import org.finos.waltz.model.ImmutableAssessmentBasedSelectionFilter.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentBasedSelectionFilterDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingIds(Iterable)"})
  void testBuilderAddAllRatingIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllRatingIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingIds(Iterable)"})
  void testBuilderAddAllRatingIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatingIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addRatingIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRatingIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingIds(long)"})
  void testBuilderAddRatingIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L));
  }

  /**
   * Test Builder {@link Builder#addRatingIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRatingIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingIds(long[])"})
  void testBuilderAddRatingIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#definitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#definitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definitionId(Long)"})
  void testBuilderDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().definitionId().longValue());
    assertSame(builderResult, actualDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentBasedSelectionFilter)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then builder build ratingIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentBasedSelectionFilter); given HashSet() add minus two; then builder build ratingIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentBasedSelectionFilter)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenBuilderBuildRatingIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    ImmutableAssessmentBasedSelectionFilter buildResult = builderResult.build();
    Set<Long> ratingIdsResult = buildResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, buildResult.definitionId().longValue());
    assertTrue(ratingIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentBasedSelectionFilter)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build definitionId longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentBasedSelectionFilter); given HashSet(); then builder build definitionId longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentBasedSelectionFilter)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildDefinitionIdLongValueIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    AssessmentBasedSelectionFilter instance = mock(AssessmentBasedSelectionFilter.class);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionId();
    verify(instance).ratingIds();
    assertEquals(1L, builderResult.build().definitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingIds(Iterable)"})
  void testBuilderRatingIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(elements));
  }

  /**
   * Test Builder {@link Builder#ratingIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingIds(Iterable)"})
  void testBuilderRatingIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#definitionId()}.
   * <p>
   * Method under test: {@link Json#definitionId()}
   */
  @Test
  @DisplayName("Test Json definitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.definitionId()"})
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
    assertNull(actualJson.definitionId);
    assertTrue(actualJson.ratingIds.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingIds()}.
   * <p>
   * Method under test: {@link Json#ratingIds()}
   */
  @Test
  @DisplayName("Test Json ratingIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.ratingIds()"})
  void testJsonRatingIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingIds());
  }
}
