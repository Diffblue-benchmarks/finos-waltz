package org.finos.waltz.model.legal_entity;

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
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewAssessment.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipViewAssessment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewAssessmentDiffblueTest {
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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    // Act
    Builder actualAddRatingIdsResult = builderResult.addRatingIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddRatingIdsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link Builder#assessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test Builder assessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipViewAssessment Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipViewAssessment
        actualImmutableLegalEntityRelationshipViewAssessment =
            ImmutableLegalEntityRelationshipViewAssessment.builder()
                .assessmentDefinitionId(1L)
                .build();

    // Assert
    assertEquals(
        1L,
        actualImmutableLegalEntityRelationshipViewAssessment.assessmentDefinitionId().longValue());
    assertTrue(actualImmutableLegalEntityRelationshipViewAssessment.ratingIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewAssessment)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addRatingIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LegalEntityRelationshipViewAssessment); given minus two; when builder addRatingIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewAssessment)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddRatingIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    Builder builderResult2 = ImmutableLegalEntityRelationshipViewAssessment.builder();
    builderResult2.addRatingIds(-2L);
    ImmutableLegalEntityRelationshipViewAssessment instance =
        builderResult2.assessmentDefinitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipViewAssessment
        actualImmutableLegalEntityRelationshipViewAssessment = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipViewAssessment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipViewAssessment)}.
   *
   * <ul>
   *   <li>Then builder build is builder assessmentDefinitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LegalEntityRelationshipViewAssessment); then builder build is builder assessmentDefinitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipViewAssessment)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderAssessmentDefinitionIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();
    ImmutableLegalEntityRelationshipViewAssessment instance =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableLegalEntityRelationshipViewAssessment
        actualImmutableLegalEntityRelationshipViewAssessment = builderResult.build();
    assertEquals(instance, actualImmutableLegalEntityRelationshipViewAssessment);
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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

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
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();

    // Act
    Builder actualRatingIdsResult = builderResult.ratingIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRatingIdsResult);
  }

  /**
   * Test {@link
   * ImmutableLegalEntityRelationshipViewAssessment#copyOf(LegalEntityRelationshipViewAssessment)}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewAssessment#copyOf(LegalEntityRelationshipViewAssessment)}
   */
  @Test
  @DisplayName(
      "Test copyOf(LegalEntityRelationshipViewAssessment); then return assessmentDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.copyOf(LegalEntityRelationshipViewAssessment)"
  })
  void testCopyOf_thenReturnAssessmentDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment instance =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualCopyOfResult =
        ImmutableLegalEntityRelationshipViewAssessment.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.assessmentDefinitionId().longValue());
    assertTrue(actualCopyOfResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipViewAssessment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment2 =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipViewAssessment,
        immutableLegalEntityRelationshipViewAssessment2);
    assertEquals(
        immutableLegalEntityRelationshipViewAssessment.hashCode(),
        immutableLegalEntityRelationshipViewAssessment2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}, and {@link
   * ImmutableLegalEntityRelationshipViewAssessment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act and Assert
    assertEquals(
        immutableLegalEntityRelationshipViewAssessment,
        immutableLegalEntityRelationshipViewAssessment);
    int expectedHashCodeResult = immutableLegalEntityRelationshipViewAssessment.hashCode();
    assertEquals(expectedHashCodeResult, immutableLegalEntityRelationshipViewAssessment.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipViewAssessment.builder();
    builderResult.addRatingIds(1L);
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        builderResult.assessmentDefinitionId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipViewAssessment,
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableLegalEntityRelationshipViewAssessment,
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build(),
        null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableLegalEntityRelationshipViewAssessment.equals(Object)",
    "int ImmutableLegalEntityRelationshipViewAssessment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build(),
        "Different type to ImmutableLegalEntityRelationshipViewAssessment");
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) RatingIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) RatingIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonRatingIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(new HashSet<>());

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewAssessment.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add minus one.
   *   <li>Then return ratingIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add minus one; then return ratingIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddMinusOne_thenReturnRatingIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(-1L);
    ratingIds.add(1L);

    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewAssessment.fromJson(json);

    // Assert
    assertEquals(ratingIds, actualFromJsonResult.ratingIds());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return ratingIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return ratingIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddOne_thenReturnRatingIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> ratingIds = new LinkedHashSet<>();
    ratingIds.add(1L);

    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(ratingIds);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewAssessment.fromJson(json);

    // Assert
    Set<Long> ratingIdsResult = actualFromJsonResult.ratingIds();
    assertEquals(1, ratingIdsResult.size());
    assertTrue(ratingIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) RatingIds is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableLegalEntityRelationshipViewAssessment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) RatingIds is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonRatingIdsIsNull() {
    // Arrange
    Json json = new Json();
    json.setAssessmentDefinitionId(1L);
    json.setRatingIds(null);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualFromJsonResult =
        ImmutableLegalEntityRelationshipViewAssessment.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.assessmentDefinitionId().longValue());
    assertTrue(actualFromJsonResult.ratingIds().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#toString()}
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#assessmentDefinitionId()}
   *   <li>{@link ImmutableLegalEntityRelationshipViewAssessment#ratingIds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long ImmutableLegalEntityRelationshipViewAssessment.assessmentDefinitionId()",
    "Set ImmutableLegalEntityRelationshipViewAssessment.ratingIds()",
    "String ImmutableLegalEntityRelationshipViewAssessment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act
    String actualToStringResult = immutableLegalEntityRelationshipViewAssessment.toString();
    Long actualAssessmentDefinitionIdResult =
        immutableLegalEntityRelationshipViewAssessment.assessmentDefinitionId();
    Set<Long> actualRatingIdsResult = immutableLegalEntityRelationshipViewAssessment.ratingIds();

    // Assert
    assertEquals(
        "LegalEntityRelationshipViewAssessment{assessmentDefinitionId=1, ratingIds=[]}",
        actualToStringResult);
    assertEquals(1L, actualAssessmentDefinitionIdResult.longValue());
    assertTrue(actualRatingIdsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#assessmentDefinitionId()}.
   *
   * <p>Method under test: {@link Json#assessmentDefinitionId()}
   */
  @Test
  @DisplayName("Test Json assessmentDefinitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.assessmentDefinitionId()"})
  void testJsonAssessmentDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().assessmentDefinitionId());
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
    assertNull(actualJson.assessmentDefinitionId);
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
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#withAssessmentDefinitionId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewAssessment#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName("Test withAssessmentDefinitionId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipViewAssessment actualWithAssessmentDefinitionIdResult =
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build()
            .withAssessmentDefinitionId(42L);

    // Assert
    assertEquals(42L, actualWithAssessmentDefinitionIdResult.assessmentDefinitionId().longValue());
    assertTrue(actualWithAssessmentDefinitionIdResult.ratingIds().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#withAssessmentDefinitionId(Long)}.
   *
   * <ul>
   *   <li>Then return builder assessmentDefinitionId one build.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewAssessment#withAssessmentDefinitionId(Long)}
   */
  @Test
  @DisplayName(
      "Test withAssessmentDefinitionId(Long); then return builder assessmentDefinitionId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.withAssessmentDefinitionId(Long)"
  })
  void testWithAssessmentDefinitionId_thenReturnBuilderAssessmentDefinitionIdOneBuild() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualWithAssessmentDefinitionIdResult =
        immutableLegalEntityRelationshipViewAssessment.withAssessmentDefinitionId(1L);

    // Assert
    assertSame(
        immutableLegalEntityRelationshipViewAssessment, actualWithAssessmentDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#withRatingIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return assessmentDefinitionId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewAssessment#withRatingIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingIds(Iterable) with 'Iterable'; then return assessmentDefinitionId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.withRatingIds(Iterable)"
  })
  void testWithRatingIdsWithIterable_thenReturnAssessmentDefinitionIdLongValueIsOne() {
    // Arrange
    ImmutableLegalEntityRelationshipViewAssessment immutableLegalEntityRelationshipViewAssessment =
        ImmutableLegalEntityRelationshipViewAssessment.builder().assessmentDefinitionId(1L).build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableLegalEntityRelationshipViewAssessment actualWithRatingIdsResult =
        immutableLegalEntityRelationshipViewAssessment.withRatingIds(elements);

    // Assert
    assertEquals(1L, actualWithRatingIdsResult.assessmentDefinitionId().longValue());
    assertEquals(elements, actualWithRatingIdsResult.ratingIds());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipViewAssessment#withRatingIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link
   * ImmutableLegalEntityRelationshipViewAssessment#withRatingIds(long[])}
   */
  @Test
  @DisplayName("Test withRatingIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableLegalEntityRelationshipViewAssessment ImmutableLegalEntityRelationshipViewAssessment.withRatingIds(long[])"
  })
  void testWithRatingIdsWithLong() {
    // Arrange and Act
    ImmutableLegalEntityRelationshipViewAssessment actualWithRatingIdsResult =
        ImmutableLegalEntityRelationshipViewAssessment.builder()
            .assessmentDefinitionId(1L)
            .build()
            .withRatingIds(1L, -1L, 1L, -1L);

    // Assert
    assertEquals(1L, actualWithRatingIdsResult.assessmentDefinitionId().longValue());
    Set<Long> ratingIdsResult = actualWithRatingIdsResult.ratingIds();
    assertEquals(2, ratingIdsResult.size());
    assertTrue(ratingIdsResult.contains(-1L));
    assertTrue(ratingIdsResult.contains(1L));
  }
}
