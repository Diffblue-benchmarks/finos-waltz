package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingOperations.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingOperations.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRatingOperationsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllOperations(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then builder build operations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOperations(Iterable); given 'ADD'; then builder build operations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_givenAdd_thenBuilderBuildOperationsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    Builder actualAddAllOperationsResult = builderResult.addAllOperations(elements);

    // Assert
    assertEquals(elements, builderResult.build().operations());
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addAllOperations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then builder build operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllOperations(Iterable); when ArrayList(); then builder build operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllOperations(Iterable)"})
  void testBuilderAddAllOperations_whenArrayList_thenBuilderBuildOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    Builder actualAddAllOperationsResult = builderResult.addAllOperations(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().operations().isEmpty());
    assertSame(builderResult, actualAddAllOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addOperations(Operation)}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Operation)"})
  void testBuilderAddOperationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    Builder actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addOperations(Operation[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addOperations(Operation[])}
   */
  @Test
  @DisplayName("Test Builder addOperations(Operation[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addOperations(Operation[])"})
  void testBuilderAddOperationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    Builder actualAddOperationsResult = builderResult.addOperations(Operation.ADD);

    // Assert
    Set<Operation> operationsResult = builderResult.build().operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
    assertSame(builderResult, actualAddOperationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#ratingId(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations Builder.build()",
    "Builder Builder.ratingId(Long)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualImmutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableAssessmentRatingOperations.ratingId().longValue());
    assertFalse(actualImmutableAssessmentRatingOperations.isDefault());
    assertTrue(actualImmutableAssessmentRatingOperations.operations().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingOperations)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>When builder addOperations {@code ADD}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingOperations); given 'ADD'; when builder addOperations 'ADD'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingOperations)"})
  void testBuilderFrom_givenAdd_whenBuilderAddOperationsAdd() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    Builder builderResult2 = ImmutableAssessmentRatingOperations.builder();
    builderResult2.addOperations(Operation.ADD);
    ImmutableAssessmentRatingOperations instance = builderResult2.ratingId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingOperations actualImmutableAssessmentRatingOperations =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingOperations)}.
   *
   * <ul>
   *   <li>Then builder build is builder ratingId {@code null} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingOperations); then builder build is builder ratingId 'null' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingOperations)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRatingIdNullBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();
    ImmutableAssessmentRatingOperations instance =
        ImmutableAssessmentRatingOperations.builder().ratingId(null).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingOperations actualImmutableAssessmentRatingOperations =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRatingOperations)}.
   *
   * <ul>
   *   <li>Then builder build is builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRatingOperations); then builder build is builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRatingOperations)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRatingIdOneBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();
    ImmutableAssessmentRatingOperations instance =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRatingOperations actualImmutableAssessmentRatingOperations =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRatingOperations);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then builder build operations is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder operations(Iterable); given 'ADD'; then builder build operations is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_givenAdd_thenBuilderBuildOperationsIsLinkedHashSet() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    Builder actualOperationsResult = builderResult.operations(elements);

    // Assert
    assertEquals(elements, builderResult.build().operations());
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Test Builder {@link Builder#operations(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then builder build operations Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#operations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder operations(Iterable); when ArrayList(); then builder build operations Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.operations(Iterable)"})
  void testBuilderOperations_whenArrayList_thenBuilderBuildOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();

    // Act
    Builder actualOperationsResult = builderResult.operations(new ArrayList<>());

    // Assert
    assertTrue(builderResult.build().operations().isEmpty());
    assertSame(builderResult, actualOperationsResult);
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#copyOf(AssessmentRatingOperations)}.
   *
   * <ul>
   *   <li>When builder ratingId one build.
   *   <li>Then return ratingId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRatingOperations#copyOf(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRatingOperations); when builder ratingId one build; then return ratingId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.copyOf(AssessmentRatingOperations)"
  })
  void testCopyOf_whenBuilderRatingIdOneBuild_thenReturnRatingIdLongValueIsOne() {
    // Arrange
    ImmutableAssessmentRatingOperations instance =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act
    ImmutableAssessmentRatingOperations actualCopyOfResult =
        ImmutableAssessmentRatingOperations.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.ratingId().longValue());
    assertFalse(actualCopyOfResult.isDefault());
    assertTrue(actualCopyOfResult.operations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}, and {@link
   * ImmutableAssessmentRatingOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations2 =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingOperations, immutableAssessmentRatingOperations2);
    assertEquals(
        immutableAssessmentRatingOperations.hashCode(),
        immutableAssessmentRatingOperations2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}, and {@link
   * ImmutableAssessmentRatingOperations#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act and Assert
    assertEquals(immutableAssessmentRatingOperations, immutableAssessmentRatingOperations);
    int expectedHashCodeResult = immutableAssessmentRatingOperations.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRatingOperations.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRatingOperations.builder();
    builderResult.addOperations(Operation.ADD);
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        builderResult.ratingId(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingOperations,
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(2L).build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRatingOperations,
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAssessmentRatingOperations.builder().ratingId(1L).build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.equals(Object)",
    "int ImmutableAssessmentRatingOperations.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build(),
        "Different type to ImmutableAssessmentRatingOperations");
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code ADD}.
   *   <li>Then return operations size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add 'ADD'; then return operations size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.fromJson(Json)"
  })
  void testFromJson_givenLinkedHashSetAddAdd_thenReturnOperationsSizeIsOne() {
    // Arrange
    LinkedHashSet<Operation> operations = new LinkedHashSet<>();
    operations.add(Operation.ADD);

    Json json = new Json();
    json.setRatingId(1L);
    json.setOperations(operations);

    // Act
    ImmutableAssessmentRatingOperations actualFromJsonResult =
        ImmutableAssessmentRatingOperations.fromJson(json);

    // Assert
    Set<Operation> operationsResult = actualFromJsonResult.operations();
    assertEquals(1, operationsResult.size());
    assertTrue(operationsResult.contains(Operation.ADD));
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Operations is {@code null}.
   *   <li>Then return ratingId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Operations is 'null'; then return ratingId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonOperationsIsNull_thenReturnRatingIdLongValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setRatingId(1L);
    json.setOperations(null);

    // Act
    ImmutableAssessmentRatingOperations actualFromJsonResult =
        ImmutableAssessmentRatingOperations.fromJson(json);

    // Assert
    assertEquals(1L, actualFromJsonResult.ratingId().longValue());
    assertFalse(actualFromJsonResult.isDefault());
    assertTrue(actualFromJsonResult.operations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return ratingId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return ratingId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnRatingIdIsNull() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualFromJsonResult =
        ImmutableAssessmentRatingOperations.fromJson(new Json());

    // Assert
    assertNull(actualFromJsonResult.ratingId());
    assertTrue(actualFromJsonResult.operations().isEmpty());
    assertTrue(actualFromJsonResult.isDefault());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRatingOperations#toString()}
   *   <li>{@link ImmutableAssessmentRatingOperations#isDefault()}
   *   <li>{@link ImmutableAssessmentRatingOperations#operations()}
   *   <li>{@link ImmutableAssessmentRatingOperations#ratingId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRatingOperations.isDefault()",
    "Set ImmutableAssessmentRatingOperations.operations()",
    "Long ImmutableAssessmentRatingOperations.ratingId()",
    "String ImmutableAssessmentRatingOperations.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act
    String actualToStringResult = immutableAssessmentRatingOperations.toString();
    boolean actualIsDefaultResult = immutableAssessmentRatingOperations.isDefault();
    Set<Operation> actualOperationsResult = immutableAssessmentRatingOperations.operations();

    // Assert
    assertEquals(
        "AssessmentRatingOperations{ratingId=1, operations=[], isDefault=false}",
        actualToStringResult);
    assertEquals(1L, immutableAssessmentRatingOperations.ratingId().longValue());
    assertFalse(actualIsDefaultResult);
    assertTrue(actualOperationsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#isDefault()}.
   *
   * <p>Method under test: {@link Json#isDefault()}
   */
  @Test
  @DisplayName("Test Json isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isDefault()"})
  void testJsonIsDefault() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isDefault());
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
    assertNull(actualJson.ratingId);
    assertTrue(actualJson.operations.isEmpty());
  }

  /**
   * Test Json {@link Json#operations()}.
   *
   * <p>Method under test: {@link Json#operations()}
   */
  @Test
  @DisplayName("Test Json operations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.operations()"})
  void testJsonOperations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().operations());
  }

  /**
   * Test Json {@link Json#ratingId()}.
   *
   * <p>Method under test: {@link Json#ratingId()}
   */
  @Test
  @DisplayName("Test Json ratingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.ratingId()"})
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingId());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#withOperations(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@code ADD}.
   *   <li>Then return ratingId longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#withOperations(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withOperations(Iterable) with 'Iterable'; given 'ADD'; then return ratingId longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.withOperations(Iterable)"
  })
  void testWithOperationsWithIterable_givenAdd_thenReturnRatingIdLongValueIsOne() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    LinkedHashSet<Operation> elements = new LinkedHashSet<>();
    elements.add(Operation.ADD);

    // Act
    ImmutableAssessmentRatingOperations actualWithOperationsResult =
        immutableAssessmentRatingOperations.withOperations(elements);

    // Assert
    assertEquals(1L, actualWithOperationsResult.ratingId().longValue());
    assertFalse(actualWithOperationsResult.isDefault());
    assertEquals(elements, actualWithOperationsResult.operations());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#withOperations(Operation[])} with {@code
   * Operation[]}.
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#withOperations(Operation[])}
   */
  @Test
  @DisplayName("Test withOperations(Operation[]) with 'Operation[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.withOperations(Operation[])"
  })
  void testWithOperationsWithOperation() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualWithOperationsResult =
        ImmutableAssessmentRatingOperations.builder()
            .ratingId(1L)
            .build()
            .withOperations(Operation.ADD);

    // Assert
    Set<Operation> operationsResult = actualWithOperationsResult.operations();
    assertEquals(1, operationsResult.size());
    assertEquals(1L, actualWithOperationsResult.ratingId().longValue());
    assertFalse(actualWithOperationsResult.isDefault());
    assertTrue(operationsResult.contains(Operation.ADD));
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#withRatingId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return ratingId longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#withRatingId(Long)}
   */
  @Test
  @DisplayName(
      "Test withRatingId(Long); when forty-two; then return ratingId longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.withRatingId(Long)"
  })
  void testWithRatingId_whenFortyTwo_thenReturnRatingIdLongValueIsFortyTwo() {
    // Arrange and Act
    ImmutableAssessmentRatingOperations actualWithRatingIdResult =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build().withRatingId(42L);

    // Assert
    assertEquals(42L, actualWithRatingIdResult.ratingId().longValue());
    assertFalse(actualWithRatingIdResult.isDefault());
    assertTrue(actualWithRatingIdResult.operations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRatingOperations#withRatingId(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder ratingId one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRatingOperations#withRatingId(Long)}
   */
  @Test
  @DisplayName("Test withRatingId(Long); when one; then return builder ratingId one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRatingOperations ImmutableAssessmentRatingOperations.withRatingId(Long)"
  })
  void testWithRatingId_whenOne_thenReturnBuilderRatingIdOneBuild() {
    // Arrange
    ImmutableAssessmentRatingOperations immutableAssessmentRatingOperations =
        ImmutableAssessmentRatingOperations.builder().ratingId(1L).build();

    // Act
    ImmutableAssessmentRatingOperations actualWithRatingIdResult =
        immutableAssessmentRatingOperations.withRatingId(1L);

    // Assert
    assertSame(immutableAssessmentRatingOperations, actualWithRatingIdResult);
  }
}
