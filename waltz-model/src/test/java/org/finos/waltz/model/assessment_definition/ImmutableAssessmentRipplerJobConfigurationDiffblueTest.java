package org.finos.waltz.model.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration.Builder;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobConfigurationDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSteps(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllSteps(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSteps(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllSteps(Iterable)"})
  void testBuilderAddAllSteps_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act
    Builder actualAddAllStepsResult = builderResult.addAllSteps(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllStepsResult);
  }

  /**
   * Test Builder {@link Builder#addSteps(AssessmentRipplerJobStep)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRipplerJobStep.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSteps(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName(
      "Test Builder addSteps(AssessmentRipplerJobStep) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSteps(AssessmentRipplerJobStep)"})
  void testBuilderAddStepsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act
    Builder actualAddStepsResult =
        builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json());

    // Assert
    assertSame(builderResult, actualAddStepsResult);
  }

  /**
   * Test Builder {@link Builder#addSteps(AssessmentRipplerJobStep[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableAssessmentRipplerJobStep.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addSteps(AssessmentRipplerJobStep[])}
   */
  @Test
  @DisplayName(
      "Test Builder addSteps(AssessmentRipplerJobStep[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addSteps(AssessmentRipplerJobStep[])"})
  void testBuilderAddStepsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act
    Builder actualAddStepsResult =
        builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json());

    // Assert
    assertSame(builderResult, actualAddStepsResult);
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
  @MethodsUnderTest({"ImmutableAssessmentRipplerJobConfiguration Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobConfiguration actualImmutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableAssessmentRipplerJobConfiguration.name());
    assertTrue(actualImmutableAssessmentRipplerJobConfiguration.steps().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobConfiguration)}.
   *
   * <ul>
   *   <li>Then return build steps size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRipplerJobConfiguration); then return build steps size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobConfiguration)"})
  void testBuilderFrom_thenReturnBuildStepsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    Builder builderResult2 = ImmutableAssessmentRipplerJobConfiguration.builder();
    builderResult2.addSteps(
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build());

    // Act and Assert
    List<AssessmentRipplerJobStep> stepsResult =
        builderResult.from(builderResult2.name("Name").build()).build().steps();
    assertEquals(1, stepsResult.size());
    AssessmentRipplerJobStep getResult = stepsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRipplerJobStep);
    assertEquals("To Def", getResult.toDef());
    assertEquals("jane.doe@example.org", getResult.fromDef());
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobConfiguration)}.
   *
   * <ul>
   *   <li>When builder name {@code Name} build.
   *   <li>Then builder build is builder name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AssessmentRipplerJobConfiguration); when builder name 'Name' build; then builder build is builder name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobConfiguration)"})
  void testBuilderFrom_whenBuilderNameNameBuild_thenBuilderBuildIsBuilderNameNameBuild() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();
    ImmutableAssessmentRipplerJobConfiguration instance =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAssessmentRipplerJobConfiguration actualImmutableAssessmentRipplerJobConfiguration =
        builderResult.build();
    assertEquals(instance, actualImmutableAssessmentRipplerJobConfiguration);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#steps(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#steps(Iterable)}
   */
  @Test
  @DisplayName("Test Builder steps(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.steps(Iterable)"})
  void testBuilderSteps_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act
    Builder actualStepsResult = builderResult.steps(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualStepsResult);
  }

  /**
   * Test {@link
   * ImmutableAssessmentRipplerJobConfiguration#copyOf(AssessmentRipplerJobConfiguration)}.
   *
   * <ul>
   *   <li>When builder name {@code Name} build.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRipplerJobConfiguration#copyOf(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AssessmentRipplerJobConfiguration); when builder name 'Name' build; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.copyOf(AssessmentRipplerJobConfiguration)"
  })
  void testCopyOf_whenBuilderNameNameBuild_thenReturnName() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration instance =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualCopyOfResult =
        ImmutableAssessmentRipplerJobConfiguration.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.steps().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}, and {@link
   * ImmutableAssessmentRipplerJobConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration2 =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRipplerJobConfiguration, immutableAssessmentRipplerJobConfiguration2);
    assertEquals(
        immutableAssessmentRipplerJobConfiguration.hashCode(),
        immutableAssessmentRipplerJobConfiguration2.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}, and {@link
   * ImmutableAssessmentRipplerJobConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act and Assert
    assertEquals(
        immutableAssessmentRipplerJobConfiguration, immutableAssessmentRipplerJobConfiguration);
    int expectedHashCodeResult = immutableAssessmentRipplerJobConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, immutableAssessmentRipplerJobConfiguration.hashCode());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();
    builderResult.addSteps(
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build());
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        builderResult.name("Name").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRipplerJobConfiguration,
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("java.lang.String").build();

    // Act and Assert
    assertNotEquals(
        immutableAssessmentRipplerJobConfiguration,
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build(), null);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAssessmentRipplerJobConfiguration.equals(Object)",
    "int ImmutableAssessmentRipplerJobConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build(),
        "Different type to ImmutableAssessmentRipplerJobConfiguration");
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRipplerJobStep.Json}
   *       (default constructor).
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return steps size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); when Json (default constructor) Name is 'Json'; then return steps size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_whenJsonNameIsJson_thenReturnStepsSizeIsOne() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> steps = new ArrayList<>();
    ImmutableAssessmentRipplerJobStep.Json json = new ImmutableAssessmentRipplerJobStep.Json();
    steps.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setSteps(steps);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult =
        ImmutableAssessmentRipplerJobConfiguration.fromJson(json2);

    // Assert
    List<AssessmentRipplerJobStep> stepsResult = actualFromJsonResult.steps();
    assertEquals(1, stepsResult.size());
    assertSame(json, stepsResult.get(0));
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return name is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) Name is 'Json'; then return name is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.fromJson(Json)"
  })
  void testFromJson_givenArrayList_whenJsonNameIsJson_thenReturnNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setSteps(new ArrayList<>());

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult =
        ImmutableAssessmentRipplerJobConfiguration.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertTrue(actualFromJsonResult.steps().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Steps is {@code null}.
   *   <li>Then return name is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Steps is 'null'; then return name is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonStepsIsNull_thenReturnNameIsJson() {
    // Arrange
    Json json = new Json();
    json.setName("Json");
    json.setSteps(null);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult =
        ImmutableAssessmentRipplerJobConfiguration.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertTrue(actualFromJsonResult.steps().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return steps size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return steps size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.fromJson(Json)"
  })
  void testFromJson_thenReturnStepsSizeIsTwo() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> steps = new ArrayList<>();
    steps.add(
        ImmutableAssessmentRipplerJobStep.builder()
            .fromDef("jane.doe@example.org")
            .toDef("To Def")
            .build());
    ImmutableAssessmentRipplerJobStep.Json json = new ImmutableAssessmentRipplerJobStep.Json();
    steps.add(json);

    Json json2 = new Json();
    json2.setName("Json");
    json2.setSteps(steps);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult =
        ImmutableAssessmentRipplerJobConfiguration.fromJson(json2);

    // Assert
    List<AssessmentRipplerJobStep> stepsResult = actualFromJsonResult.steps();
    assertEquals(2, stepsResult.size());
    AssessmentRipplerJobStep getResult = stepsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRipplerJobStep);
    assertEquals("To Def", getResult.toDef());
    assertEquals("jane.doe@example.org", getResult.fromDef());
    assertSame(json, stepsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#toString()}
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#name()}
   *   <li>{@link ImmutableAssessmentRipplerJobConfiguration#steps()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableAssessmentRipplerJobConfiguration.name()",
    "List ImmutableAssessmentRipplerJobConfiguration.steps()",
    "String ImmutableAssessmentRipplerJobConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act
    String actualToStringResult = immutableAssessmentRipplerJobConfiguration.toString();
    String actualNameResult = immutableAssessmentRipplerJobConfiguration.name();

    // Assert
    assertEquals("AssessmentRipplerJobConfiguration{name=Name, steps=[]}", actualToStringResult);
    assertEquals("Name", actualNameResult);
    assertTrue(immutableAssessmentRipplerJobConfiguration.steps().isEmpty());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.name);
    assertTrue(actualJson.steps.isEmpty());
  }

  /**
   * Test Json {@link Json#steps()}.
   *
   * <p>Method under test: {@link Json#steps()}
   */
  @Test
  @DisplayName("Test Json steps()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.steps()"})
  void testJsonSteps() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().steps());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#withName(String)}.
   *
   * <ul>
   *   <li>Given builder name {@code 42} build.
   *   <li>Then return builder name {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#withName(String)}
   */
  @Test
  @DisplayName(
      "Test withName(String); given builder name '42' build; then return builder name '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.withName(String)"
  })
  void testWithName_givenBuilderName42Build_thenReturnBuilderName42Build() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("42").build();

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualWithNameResult =
        immutableAssessmentRipplerJobConfiguration.withName("42");

    // Assert
    assertSame(immutableAssessmentRipplerJobConfiguration, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#withName(String)}.
   *
   * <ul>
   *   <li>Given builder name {@code Name} build.
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAssessmentRipplerJobConfiguration#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); given builder name 'Name' build; then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.withName(String)"
  })
  void testWithName_givenBuilderNameNameBuild_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobConfiguration actualWithNameResult =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build().withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertTrue(actualWithNameResult.steps().isEmpty());
  }

  /**
   * Test {@link ImmutableAssessmentRipplerJobConfiguration#withSteps(AssessmentRipplerJobStep[])}
   * with {@code AssessmentRipplerJobStep[]}.
   *
   * <p>Method under test: {@link
   * ImmutableAssessmentRipplerJobConfiguration#withSteps(AssessmentRipplerJobStep[])}
   */
  @Test
  @DisplayName("Test withSteps(AssessmentRipplerJobStep[]) with 'AssessmentRipplerJobStep[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAssessmentRipplerJobConfiguration ImmutableAssessmentRipplerJobConfiguration.withSteps(AssessmentRipplerJobStep[])"
  })
  void testWithStepsWithAssessmentRipplerJobStep() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration immutableAssessmentRipplerJobConfiguration =
        ImmutableAssessmentRipplerJobConfiguration.builder().name("Name").build();

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualWithStepsResult =
        immutableAssessmentRipplerJobConfiguration.withSteps(
            ImmutableAssessmentRipplerJobStep.builder()
                .fromDef("jane.doe@example.org")
                .toDef("To Def")
                .build());

    // Assert
    List<AssessmentRipplerJobStep> stepsResult = actualWithStepsResult.steps();
    assertEquals(1, stepsResult.size());
    AssessmentRipplerJobStep getResult = stepsResult.get(0);
    assertTrue(getResult instanceof ImmutableAssessmentRipplerJobStep);
    assertEquals("Name", actualWithStepsResult.name());
    assertEquals("To Def", getResult.toDef());
    assertEquals("jane.doe@example.org", getResult.fromDef());
  }
}
