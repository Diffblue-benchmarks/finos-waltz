package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentDefinitionRatingOperationsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingOperations(Iterable)}.
   *
   * <ul>
   *   <li>Then return build ratingOperations Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRatingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllRatingOperations(Iterable); then return build ratingOperations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRatingOperations(Iterable)"})
  void testBuilderAddAllRatingOperations_thenReturnBuildRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddAllRatingOperationsResult =
        builderResult.addAllRatingOperations(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllRatingOperationsResult.build().ratingOperations().isEmpty());
    assertSame(builderResult, actualAddAllRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations)"})
  void testBuilderAddRatingOperationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddRatingOperationsResult =
        builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations)} with {@code
   * element}.
   *
   * <p>Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations)"})
  void testBuilderAddRatingOperationsWithElement2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Act
    Builder actualAddRatingOperationsResult =
        builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(2, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations[])"})
  void testBuilderAddRatingOperationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddRatingOperationsResult =
        builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations[])} with {@code
   * elements}.
   *
   * <p>Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations[])"})
  void testBuilderAddRatingOperationsWithElements2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Act
    Builder actualAddRatingOperationsResult =
        builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Assert
    assertEquals(2, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentDefinitionRatingOperations Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    Builder actualAddAllRatingOperationsResult =
        actualBuilderResult.addAllRatingOperations(new ArrayList<>());
    Builder actualAddRatingOperationsResult =
        actualAddAllRatingOperationsResult.addRatingOperations(
            ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    Builder actualAddRatingOperationsResult2 =
        actualAddRatingOperationsResult.addRatingOperations(
            ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    // Assert
    assertTrue(
        actualAddRatingOperationsResult2
            .ratingOperations(new ArrayList<>())
            .build()
            .ratingOperations()
            .isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   *
   * <ul>
   *   <li>Given builder addRatingOperations builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentDefinitionRatingOperations); given builder addRatingOperations builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_givenBuilderAddRatingOperationsBuilderRatingIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(builderResult2.addAllRatingOperations(new ArrayList<>()).build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   *
   * <ul>
   *   <li>Given builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentDefinitionRatingOperations); given builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_givenBuilderRatingIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult2.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations instance =
        builderResult2.addAllRatingOperations(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentDefinitionRatingOperations
        actualImmutableAssessmentDefinitionRatingOperations = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentDefinitionRatingOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   *
   * <ul>
   *   <li>Then builder build is builder addAllRatingOperations {@link ArrayList#ArrayList()} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentDefinitionRatingOperations); then builder build is builder addAllRatingOperations ArrayList() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderAddAllRatingOperationsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations instance =
        builderResult2.addAllRatingOperations(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentDefinitionRatingOperations
        actualImmutableAssessmentDefinitionRatingOperations = builderResult.build();
    assertEquals(instance, actualImmutableAssessmentDefinitionRatingOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingOperations(Iterable)}.
   *
   * <ul>
   *   <li>Given builder.
   *   <li>Then return build ratingOperations Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder ratingOperations(Iterable); given builder; then return build ratingOperations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingOperations(Iterable)"})
  void testBuilderRatingOperations_givenBuilder_thenReturnBuildRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualRatingOperationsResult = builderResult.ratingOperations(new ArrayList<>());

    // Assert
    assertTrue(actualRatingOperationsResult.build().ratingOperations().isEmpty());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#ratingOperations(Iterable)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then builder build ratingOperations is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#ratingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder ratingOperations(Iterable); when 'null'; then builder build ratingOperations is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingOperations(Iterable)"})
  void testBuilderRatingOperations_whenNull_thenBuilderBuildRatingOperationsIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(new ImmutableAssessmentRatingOperations.Json());

    // Act
    Builder actualRatingOperationsResult = builderResult.ratingOperations(null);

    // Assert
    assertNull(builderResult.build().ratingOperations());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}.
   *
   * <ul>
   *   <li>Then return ratingOperations Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentDefinitionRatingOperations); then return ratingOperations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.copyOf(AssessmentDefinitionRatingOperations)"
  })
  void testCopyOf_thenReturnRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations instance =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(
        ImmutableAssessmentDefinitionRatingOperations.copyOf(instance)
            .ratingOperations()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}, and {@link
   * ImmutableAssessmentDefinitionRatingOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
    "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations2 =
        builderResult2.addAllRatingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(
        immutableAssessmentDefinitionRatingOperations,
        immutableAssessmentDefinitionRatingOperations2);
    assertEquals(
        immutableAssessmentDefinitionRatingOperations.hashCode(),
        immutableAssessmentDefinitionRatingOperations2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}, and {@link
   * ImmutableAssessmentDefinitionRatingOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
    "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(
        immutableAssessmentDefinitionRatingOperations,
        immutableAssessmentDefinitionRatingOperations);
    int expectedHashCodeResult = immutableAssessmentDefinitionRatingOperations.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentDefinitionRatingOperations.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
    "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentDefinitionRatingOperations,
        builderResult2.addAllRatingOperations(new ArrayList<>()).build());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
    "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertNotEquals(builderResult.addAllRatingOperations(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
    "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertNotEquals(
        builderResult.addAllRatingOperations(new ArrayList<>()).build(),
        "Different type to ImmutableAssessmentDefinitionRatingOperations");
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return ratingOperations Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet(); then return ratingOperations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(Json)"
  })
  void testFromJson_givenHashSet_thenReturnRatingOperationsEmpty() {
    // Arrange
    Json json = new Json();
    json.setRatingOperations(new HashSet<>());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualFromJsonResult =
        ImmutableAssessmentDefinitionRatingOperations.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link
   *       ImmutableAssessmentRatingOperations.Json} (default constructor).
   *   <li>Then return ratingOperations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return ratingOperations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRatingOperationsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(new ImmutableAssessmentRatingOperations.Json());

    Json json = new Json();
    json.setRatingOperations(ratingOperations);

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualFromJsonResult =
        ImmutableAssessmentDefinitionRatingOperations.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return ratingOperations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return ratingOperations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(Json)"
  })
  void testFromJson_thenReturnRatingOperationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    ratingOperations.add(new ImmutableAssessmentRatingOperations.Json());

    Json json = new Json();
    json.setRatingOperations(ratingOperations);

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualFromJsonResult =
        ImmutableAssessmentDefinitionRatingOperations.fromJson(json);

    // Assert
    assertEquals(ratingOperations, actualFromJsonResult.ratingOperations());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return ratingOperations is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return ratingOperations is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnRatingOperationsIsNull() {
    // Arrange and Act
    ImmutableAssessmentDefinitionRatingOperations actualFromJsonResult =
        ImmutableAssessmentDefinitionRatingOperations.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.ratingOperations());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#toString()}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#ratingOperations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableAssessmentDefinitionRatingOperations.ratingOperations()",
    "String ImmutableAssessmentDefinitionRatingOperations.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    // Act
    String actualToStringResult = immutableAssessmentDefinitionRatingOperations.toString();

    // Assert
    assertEquals("AssessmentDefinitionRatingOperations{ratingOperations=[]}", actualToStringResult);
    assertTrue(immutableAssessmentDefinitionRatingOperations.ratingOperations().isEmpty());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRatingOperations(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRatingOperations(Set)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRatingOperations(new HashSet<>());

    // Assert
    assertTrue(actualJson.ratingOperations.isEmpty());
  }

  /**
   * Test Json {@link Json#ratingOperations()}.
   *
   * <p>Method under test: {@link Json#ratingOperations()}
   */
  @Test
  @DisplayName("Test Json ratingOperations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.ratingOperations()"})
  void testJsonRatingOperations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingOperations());
  }

  /**
   * Test {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   * with {@code AssessmentRatingOperations[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"
  })
  void testWithRatingOperationsWithAssessmentRatingOperations() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertNull(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .withRatingOperations((AssessmentRatingOperations[]) null)
            .ratingOperations());
  }

  /**
   * Test {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   * with {@code AssessmentRatingOperations[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"
  })
  void testWithRatingOperationsWithAssessmentRatingOperations2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(
        1,
        immutableAssessmentDefinitionRatingOperations
            .withRatingOperations(
                ImmutableAssessmentRatingOperations.builder().ratingId(1L).build())
            .ratingOperations()
            .size());
  }

  /**
   * Test {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   * with {@code AssessmentRatingOperations[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"
  })
  void testWithRatingOperationsWithAssessmentRatingOperations3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertTrue(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .withRatingOperations()
            .ratingOperations()
            .isEmpty());
  }

  /**
   * Test {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   * with {@code AssessmentRatingOperations[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"
  })
  void testWithRatingOperationsWithAssessmentRatingOperations4() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act and Assert
    assertEquals(
        1,
        immutableAssessmentDefinitionRatingOperations
            .withRatingOperations(
                immutableAssessmentRatingOperations,
                ImmutableAssessmentRatingOperations.builder().ratingId(1L).build())
            .ratingOperations()
            .size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Then return ratingOperations Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(Iterable) with 'Iterable'; then return ratingOperations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"
  })
  void testWithRatingOperationsWithIterable_thenReturnRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualWithRatingOperationsResult =
        immutableAssessmentDefinitionRatingOperations.withRatingOperations(elements);

    // Assert
    verify(elements).iterator();
    assertTrue(actualWithRatingOperationsResult.ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>Then return ratingOperations size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(Iterable) with 'Iterable'; then return ratingOperations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"
  })
  void testWithRatingOperationsWithIterable_thenReturnRatingOperationsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    assessmentRatingOperationsList.add(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
    assessmentRatingOperationsList.add(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());

    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualWithRatingOperationsResult =
        immutableAssessmentDefinitionRatingOperations.withRatingOperations(elements);

    // Assert
    verify(elements).iterator();
    assertEquals(1, actualWithRatingOperationsResult.ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingOperations(Iterable) with 'Iterable'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"
  })
  void testWithRatingOperationsWithIterable_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations immutableAssessmentDefinitionRatingOperations =
        builderResult.addAllRatingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(
        immutableAssessmentDefinitionRatingOperations
            .withRatingOperations(new ArrayList<>())
            .ratingOperations()
            .isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with
   * {@code Iterable}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ratingOperations is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withRatingOperations(Iterable) with 'Iterable'; when 'null'; then return ratingOperations is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"
  })
  void testWithRatingOperationsWithIterable_whenNull_thenReturnRatingOperationsIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertNull(
        builderResult
            .addAllRatingOperations(new ArrayList<>())
            .build()
            .withRatingOperations((Iterable<? extends AssessmentRatingOperations>) null)
            .ratingOperations());
  }
}
