package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingIds(Iterable)"})
  void testBuilderAddAllRatingIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllRatingIdsResult = builderResult.addAllRatingIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllRatingIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRatingIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingIds(Iterable)"})
  void testBuilderAddAllRatingIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    Builder actualAddAllRatingIdsResult = builderResult.addAllRatingIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRatingIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addRatingIds(long)}
   */
  @Test
  @DisplayName("Test Builder addRatingIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingIds(long)"})
  void testBuilderAddRatingIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    Builder actualAddRatingIdsResult = builderResult.addRatingIds(1L);

    // Assert
    assertSame(builderResult, actualAddRatingIdsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addRatingIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addRatingIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingIds(long[])"})
  void testBuilderAddRatingIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    Builder actualAddRatingIdsResult = builderResult.addRatingIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddRatingIdsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentBasedSelectionFilter Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentBasedSelectionFilter actualImmutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableAssessmentBasedSelectionFilter.definitionId().longValue());
    assertTrue(actualImmutableAssessmentBasedSelectionFilter.ratingIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#definitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#definitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addRatingIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentBasedSelectionFilter); given minus two; when builder addRatingIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentBasedSelectionFilter)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddRatingIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    Builder builderResult2 = ImmutableAssessmentBasedSelectionFilter.builder();
    builderResult2.addRatingIds(-2L);
    ImmutableAssessmentBasedSelectionFilter instance = builderResult2.definitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentBasedSelectionFilter actualImmutableAssessmentBasedSelectionFilter =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentBasedSelectionFilter);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentBasedSelectionFilter)}.
   *
   * <ul>
   *   <li>Then builder build is builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentBasedSelectionFilter); then builder build is builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentBasedSelectionFilter)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderDefinitionIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    ImmutableAssessmentBasedSelectionFilter instance =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentBasedSelectionFilter actualImmutableAssessmentBasedSelectionFilter =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentBasedSelectionFilter);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingIds(Iterable)"})
  void testBuilderRatingIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualRatingIdsResult = builderResult.ratingIds(elements);

    // Assert
    assertSame(builderResult, actualRatingIdsResult);
  }

  /**
   * Test Builder {@link Builder#ratingIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingIds(Iterable)"})
  void testBuilderRatingIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();

    // Act
    Builder actualRatingIdsResult = builderResult.ratingIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingIdsResult);
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#copyOf(AssessmentBasedSelectionFilter)}.
   *
   * <ul>
   *   <li>When builder definitionId one build.
   *   <li>Then return definitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentBasedSelectionFilter#copyOf(AssessmentBasedSelectionFilter)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentBasedSelectionFilter); when builder definitionId one build; then return definitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.copyOf(AssessmentBasedSelectionFilter)"
  })
  void testCopyOf_whenBuilderDefinitionIdOneBuild_thenReturnDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter instance =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act
    ImmutableAssessmentBasedSelectionFilter actualCopyOfResult =
        ImmutableAssessmentBasedSelectionFilter.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.definitionId().longValue());
    assertTrue(actualCopyOfResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}, and {@link
   * ImmutableAssessmentBasedSelectionFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter2 =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentBasedSelectionFilter, immutableAssessmentBasedSelectionFilter2);
    assertEquals(
        immutableAssessmentBasedSelectionFilter.hashCode(),
        immutableAssessmentBasedSelectionFilter2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}, and {@link
   * ImmutableAssessmentBasedSelectionFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentBasedSelectionFilter, immutableAssessmentBasedSelectionFilter);
    int expectedHashCodeResult = immutableAssessmentBasedSelectionFilter.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentBasedSelectionFilter.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentBasedSelectionFilter.builder();
    builderResult.addRatingIds(1L);
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        builderResult.definitionId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentBasedSelectionFilter,
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentBasedSelectionFilter,
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentBasedSelectionFilter.equals(Object)",
    "int ImmutableAssessmentBasedSelectionFilter.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build(),
        "Different type to ImmutableAssessmentBasedSelectionFilter");
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) RatingIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) RatingIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonRatingIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setDefinitionId(1L);
    json.setRatingIds(new HashSet<>());

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult =
        ImmutableAssessmentBasedSelectionFilter.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.definitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add minus one.
   *   <li>Then return ratingIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add minus one; then return ratingIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddMinusOne_thenReturnRatingIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(-1L);
    ratingIds.add(1L);

    Json json = new Json();
    json.setDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult =
        ImmutableAssessmentBasedSelectionFilter.fromJson(json);

    // Assert
    assertEquals(ratingIds, actualFromJsonResult.ratingIds());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return ratingIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return ratingIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddOne_thenReturnRatingIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(1L);

    Json json = new Json();
    json.setDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult =
        ImmutableAssessmentBasedSelectionFilter.fromJson(json);

    // Assert
    Set<Long> ratingIdsResult = actualFromJsonResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) RatingIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) RatingIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonRatingIdsIsNull() {
    // Arrange
    Json json = new Json();
    json.setDefinitionId(1L);
    json.setRatingIds(null);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualFromJsonResult =
        ImmutableAssessmentBasedSelectionFilter.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.definitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#toString()}
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#definitionId()}
   *   <li>{@link ImmutableAssessmentBasedSelectionFilter#ratingIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableAssessmentBasedSelectionFilter.definitionId()",
    "Set ImmutableAssessmentBasedSelectionFilter.ratingIds()",
    "String ImmutableAssessmentBasedSelectionFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act
    String actualToStringResult = immutableAssessmentBasedSelectionFilter.toString();
    Long actualDefinitionIdResult = immutableAssessmentBasedSelectionFilter.definitionId();
    Set<Long> actualRatingIdsResult = immutableAssessmentBasedSelectionFilter.ratingIds();

    // Assert
    assertEquals(
        "AssessmentBasedSelectionFilter{definitionId=1, ratingIds=[]}", actualToStringResult);
    assertEquals(1L, actualDefinitionIdResult.longValue());
    assertTrue(actualRatingIdsResult.isEmpty());
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
  @MethodsUnderTest({"Long Json.definitionId()"})
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
    assertNull(actualJson.definitionId);
    assertTrue(actualJson.ratingIds.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingIds()}.
   *
   * <p>Method under test: {@link Json#ratingIds()}
   */
  @Test
  @DisplayName("Test Json ratingIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingIds()"})
  void testJsonRatingIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingIds());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#withDefinitionId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return definitionId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#withDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withDefinitionId(Long); when forty-two; then return definitionId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.withDefinitionId(Long)"
  })
  void testWithDefinitionId_whenFortyTwo_thenReturnDefinitionIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableAssessmentBasedSelectionFilter actualWithDefinitionIdResult =
        ImmutableAssessmentBasedSelectionFilter.builder()
            .definitionId(1L)
            .build()
            .withDefinitionId(42L);

    // Assert
    assertEquals(42L, actualWithDefinitionIdResult.definitionId().longValue());
    assertTrue(actualWithDefinitionIdResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#withDefinitionId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder definitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#withDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withDefinitionId(Long); when one; then return builder definitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.withDefinitionId(Long)"
  })
  void testWithDefinitionId_whenOne_thenReturnBuilderDefinitionIdOneBuild() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    // Act
    ImmutableAssessmentBasedSelectionFilter actualWithDefinitionIdResult =
        immutableAssessmentBasedSelectionFilter.withDefinitionId(1L);

    // Assert
    assertSame(immutableAssessmentBasedSelectionFilter, actualWithDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#withRatingIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return definitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#withRatingIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingIds(Iterable) with 'Iterable'; given one; then return definitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.withRatingIds(Iterable)"
  })
  void testWithRatingIdsWithIterable_givenOne_thenReturnDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableAssessmentBasedSelectionFilter immutableAssessmentBasedSelectionFilter =
        ImmutableAssessmentBasedSelectionFilter.builder().definitionId(1L).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAssessmentBasedSelectionFilter actualWithRatingIdsResult =
        immutableAssessmentBasedSelectionFilter.withRatingIds(elements);

    // Assert
    assertEquals(1L, actualWithRatingIdsResult.definitionId().longValue());
    assertEquals(elements, actualWithRatingIdsResult.ratingIds());
  }

  /**
   * Test {@link ImmutableAssessmentBasedSelectionFilter#withRatingIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableAssessmentBasedSelectionFilter#withRatingIds(long[])}
   */
  @Test
  @DisplayName("Test withRatingIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentBasedSelectionFilter ImmutableAssessmentBasedSelectionFilter.withRatingIds(long[])"
  })
  void testWithRatingIdsWithLong() {
    // Arrange and Act
    ImmutableAssessmentBasedSelectionFilter actualWithRatingIdsResult =
        ImmutableAssessmentBasedSelectionFilter.builder()
            .definitionId(1L)
            .build()
            .withRatingIds(1L, -1L, 1L, -1L);

    // Assert
    assertEquals(1L, actualWithRatingIdsResult.definitionId().longValue());
    Set<Long> ratingIdsResult = actualWithRatingIdsResult.ratingIds();
    assertEquals(2, ratingIdsResult.size());
    assertTrue(ratingIdsResult.contains(-1L));
    assertTrue(ratingIdsResult.contains(1L));
  }
}
