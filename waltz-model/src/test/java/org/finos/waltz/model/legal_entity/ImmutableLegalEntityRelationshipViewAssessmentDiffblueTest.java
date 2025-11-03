package org.finos.waltz.model.legal_entity;

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
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewAssessment.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewAssessment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewAssessmentDiffblueTest {
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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatingIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   * <p>
   * Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentDefinitionId(Long)"})
  void testBuilderAssessmentDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    // Act
    Builder actualAssessmentDefinitionIdResult = builderResult.assessmentDefinitionId(1L);

    // Assert
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualAssessmentDefinitionIdResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewAssessment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewAssessment); given HashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewAssessment)"})
  void testBuilderFrom_givenHashSet() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(new HashSet<>());

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    assertEquals(1L, builderResult.build().assessmentDefinitionId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewAssessment)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then builder build ratingIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipViewAssessment); given HashSet() add minus two; then builder build ratingIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewAssessment)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenBuilderBuildRatingIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    LegalEntityRelationshipViewAssessment instance = mock(LegalEntityRelationshipViewAssessment.class);
    when(instance.assessmentDefinitionId()).thenReturn(1L);
    when(instance.ratingIds()).thenReturn(resultLongSet);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).assessmentDefinitionId();
    verify(instance).ratingIds();
    ImmutableLegalEntityRelationshipViewAssessment buildResult = builderResult.build();
    Set<Long> ratingIdsResult = buildResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertEquals(1L, buildResult.assessmentDefinitionId().longValue());
    assertTrue(ratingIdsResult.contains(-2L));
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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingIds(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#assessmentDefinitionId()}.
   * <p>
   * Method under test: {@link Json#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.assessmentDefinitionId()"})
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentDefinitionId());
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
    assertNull(actualJson.assessmentDefinitionId);
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
