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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentDefinitionRatingOperations.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableAssessmentRatingOperations.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentDefinitionRatingOperationsDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllRatingOperations(Iterable)}.
   * <ul>
   *   <li>Then return build ratingOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRatingOperations(Iterable); then return build ratingOperations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRatingOperations(Iterable)"})
  void testBuilderAddAllRatingOperations_thenReturnBuildRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddAllRatingOperationsResult = builderResult.addAllRatingOperations(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllRatingOperationsResult.build().ratingOperations().isEmpty());
    assertSame(builderResult, actualAddAllRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations)"})
  void testBuilderAddRatingOperationsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddRatingOperationsResult = builderResult.addRatingOperations(new Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations)} with {@code element}.
   * <ul>
   *   <li>Given builder ratingOperations {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations) with 'element'; given builder ratingOperations ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations)"})
  void testBuilderAddRatingOperationsWithElement_givenBuilderRatingOperationsArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.ratingOperations(new ArrayList<>());

    // Act
    Builder actualAddRatingOperationsResult = builderResult.addRatingOperations(new Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations[])"})
  void testBuilderAddRatingOperationsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act
    Builder actualAddRatingOperationsResult = builderResult.addRatingOperations(new Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#addRatingOperations(AssessmentRatingOperations[])} with {@code elements}.
   * <ul>
   *   <li>Given builder ratingOperations {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test Builder addRatingOperations(AssessmentRatingOperations[]) with 'elements'; given builder ratingOperations ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRatingOperations(AssessmentRatingOperations[])"})
  void testBuilderAddRatingOperationsWithElements_givenBuilderRatingOperationsArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.ratingOperations(new ArrayList<>());

    // Act
    Builder actualAddRatingOperationsResult = builderResult.addRatingOperations(new Json());

    // Assert
    assertEquals(1, builderResult.build().ratingOperations().size());
    assertSame(builderResult, actualAddRatingOperationsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAssessmentDefinitionRatingOperations Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    // Act and Assert
    assertTrue(builderResult.ratingOperations(new ArrayList<>()).build().ratingOperations().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   * <ul>
   *   <li>Given builder addRatingOperations {@link Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentDefinitionRatingOperations); given builder addRatingOperations Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_givenBuilderAddRatingOperationsJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.addRatingOperations(new Json());
    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations instance = builderResult2.ratingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertSame(builderResult, builderResult.from(instance));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   * <ul>
   *   <li>Given {@link Json} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentDefinitionRatingOperations); given Json (default constructor); when ArrayList() add Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_givenJson_whenArrayListAddJson() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();

    ArrayList<AssessmentRatingOperations> elements = new ArrayList<>();
    elements.add(new Json());
    ImmutableAssessmentDefinitionRatingOperations instance = ImmutableAssessmentDefinitionRatingOperations.builder()
        .ratingOperations(elements)
        .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentDefinitionRatingOperations)}.
   * <ul>
   *   <li>Then builder build is builder ratingOperations {@link ArrayList#ArrayList()} build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentDefinitionRatingOperations); then builder build is builder ratingOperations ArrayList() build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentDefinitionRatingOperations)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRatingOperationsArrayListBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations instance = builderResult2.ratingOperations(new ArrayList<>()).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingOperations(Iterable)}.
   * <ul>
   *   <li>Given builder.</li>
   *   <li>Then return build ratingOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingOperations(Iterable); given builder; then return build ratingOperations Empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then builder build ratingOperations is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#ratingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test Builder ratingOperations(Iterable); when 'null'; then builder build ratingOperations is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingOperations(Iterable)"})
  void testBuilderRatingOperations_whenNull_thenBuilderBuildRatingOperationsIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    builderResult.ratingOperations(null);

    // Act
    Builder actualRatingOperationsResult = builderResult.ratingOperations(null);

    // Assert
    assertNull(builderResult.build().ratingOperations());
    assertSame(builderResult, actualRatingOperationsResult);
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}.
   * <ul>
   *   <li>Then return ratingOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#copyOf(AssessmentDefinitionRatingOperations)}
   */
  @Test
  @DisplayName("Test copyOf(AssessmentDefinitionRatingOperations); then return ratingOperations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.copyOf(AssessmentDefinitionRatingOperations)"})
  void testCopyOf_thenReturnRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations instance = builderResult.ratingOperations(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(ImmutableAssessmentDefinitionRatingOperations.copyOf(instance).ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}, and {@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
      "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();
    Builder builderResult2 = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult2 = builderResult2.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}, and {@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
      "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
      "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<AssessmentRatingOperations> elements = new ArrayList<>();
    elements.add(new Json());
    ImmutableAssessmentDefinitionRatingOperations buildResult = ImmutableAssessmentDefinitionRatingOperations.builder()
        .ratingOperations(elements)
        .build();
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult2 = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
      "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAssessmentDefinitionRatingOperations.equals(Object)",
      "int ImmutableAssessmentDefinitionRatingOperations.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAssessmentDefinitionRatingOperations");
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return ratingOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given HashSet(); then return ratingOperations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)"})
  void testFromJson_givenHashSet_thenReturnRatingOperationsEmpty() {
    // Arrange
    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(new HashSet<>());

    // Act and Assert
    assertTrue(ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Json} (default constructor).</li>
   *   <li>Then return ratingOperations is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return ratingOperations is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRatingOperationsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(new Json());
    ratingOperations.add(new Json());

    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(ratingOperations);

    // Act and Assert
    assertEquals(ratingOperations, ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link Json} (default constructor).</li>
   *   <li>Then return ratingOperations size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return ratingOperations size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRatingOperationsSizeIsOne() {
    // Arrange
    LinkedHashSet<AssessmentRatingOperations> ratingOperations = new LinkedHashSet<>();
    ratingOperations.add(new Json());

    ImmutableAssessmentDefinitionRatingOperations.Json json = new ImmutableAssessmentDefinitionRatingOperations.Json();
    json.setRatingOperations(ratingOperations);

    // Act and Assert
    assertEquals(1, ImmutableAssessmentDefinitionRatingOperations.fromJson(json).ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(Json)}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentDefinitionRatingOperations.Json} (default constructor).</li>
   *   <li>Then return ratingOperations is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return ratingOperations is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.fromJson(ImmutableAssessmentDefinitionRatingOperations.Json)"})
  void testFromJson_whenJson_thenReturnRatingOperationsIsNull() {
    // Arrange, Act and Assert
    assertNull(
        ImmutableAssessmentDefinitionRatingOperations.fromJson(new ImmutableAssessmentDefinitionRatingOperations.Json())
            .ratingOperations());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#toString()}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations#ratingOperations()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableAssessmentDefinitionRatingOperations.ratingOperations()",
      "String ImmutableAssessmentDefinitionRatingOperations.toString()"})
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act
    String actualToStringResult = buildResult.toString();

    // Assert
    assertEquals("AssessmentDefinitionRatingOperations{ratingOperations=[]}", actualToStringResult);
    assertTrue(buildResult.ratingOperations().isEmpty());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImmutableAssessmentDefinitionRatingOperations.Json}
   *   <li>{@link ImmutableAssessmentDefinitionRatingOperations.Json#setRatingOperations(Set)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImmutableAssessmentDefinitionRatingOperations.Json.<init>()",
      "void ImmutableAssessmentDefinitionRatingOperations.Json.setRatingOperations(Set)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentDefinitionRatingOperations.Json actualJson = new ImmutableAssessmentDefinitionRatingOperations.Json();
    actualJson.setRatingOperations(new HashSet<>());

    // Assert
    assertTrue(actualJson.ratingOperations.isEmpty());
  }

  /**
   * Test Json {@link ImmutableAssessmentDefinitionRatingOperations.Json#ratingOperations()}.
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations.Json#ratingOperations()}
   */
  @Test
  @DisplayName("Test Json ratingOperations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableAssessmentDefinitionRatingOperations.Json.ratingOperations()"})
  void testJsonRatingOperations() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentDefinitionRatingOperations.Json()).ratingOperations());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])} with {@code AssessmentRatingOperations[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"})
  void testWithRatingOperationsWithAssessmentRatingOperations() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertNull(buildResult.withRatingOperations((AssessmentRatingOperations[]) null).ratingOperations());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])} with {@code AssessmentRatingOperations[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"})
  void testWithRatingOperationsWithAssessmentRatingOperations2() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertEquals(1, buildResult.withRatingOperations(new Json()).ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])} with {@code AssessmentRatingOperations[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"})
  void testWithRatingOperationsWithAssessmentRatingOperations3() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertTrue(buildResult.withRatingOperations().ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])} with {@code AssessmentRatingOperations[]}.
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(AssessmentRatingOperations[])}
   */
  @Test
  @DisplayName("Test withRatingOperations(AssessmentRatingOperations[]) with 'AssessmentRatingOperations[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(AssessmentRatingOperations[])"})
  void testWithRatingOperationsWithAssessmentRatingOperations4() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();
    Json json = new Json();

    // Act and Assert
    assertEquals(2, buildResult.withRatingOperations(json, new Json()).ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return ratingOperations Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingOperations(Iterable) with 'Iterable'; then return ratingOperations Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"})
  void testWithRatingOperationsWithIterable_thenReturnRatingOperationsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();
    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualWithRatingOperationsResult = buildResult
        .withRatingOperations(elements);

    // Assert
    verify(elements).iterator();
    assertTrue(actualWithRatingOperationsResult.ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return ratingOperations size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingOperations(Iterable) with 'Iterable'; then return ratingOperations size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"})
  void testWithRatingOperationsWithIterable_thenReturnRatingOperationsSizeIsTwo() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    ArrayList<AssessmentRatingOperations> assessmentRatingOperationsList = new ArrayList<>();
    assessmentRatingOperationsList.add(new Json());
    assessmentRatingOperationsList.add(new Json());
    Iterable<AssessmentRatingOperations> elements = mock(Iterable.class);
    when(elements.iterator()).thenReturn(assessmentRatingOperationsList.iterator());

    // Act
    ImmutableAssessmentDefinitionRatingOperations actualWithRatingOperationsResult = buildResult
        .withRatingOperations(elements);

    // Assert
    verify(elements).iterator();
    assertEquals(2, actualWithRatingOperationsResult.ratingOperations().size());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingOperations(Iterable) with 'Iterable'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"})
  void testWithRatingOperationsWithIterable_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertTrue(buildResult.withRatingOperations(new ArrayList<>()).ratingOperations().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return ratingOperations is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAssessmentDefinitionRatingOperations#withRatingOperations(Iterable)}
   */
  @Test
  @DisplayName("Test withRatingOperations(Iterable) with 'Iterable'; when 'null'; then return ratingOperations is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAssessmentDefinitionRatingOperations ImmutableAssessmentDefinitionRatingOperations.withRatingOperations(Iterable)"})
  void testWithRatingOperationsWithIterable_whenNull_thenReturnRatingOperationsIsNull() {
    // Arrange
    Builder builderResult = ImmutableAssessmentDefinitionRatingOperations.builder();
    ImmutableAssessmentDefinitionRatingOperations buildResult = builderResult.ratingOperations(new ArrayList<>())
        .build();

    // Act and Assert
    assertNull(
        buildResult.withRatingOperations((Iterable<? extends AssessmentRatingOperations>) null).ratingOperations());
  }
}
