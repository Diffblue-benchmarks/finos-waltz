package org.finos.waltz.model.assessment_definition;

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
import java.util.List;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration.Builder;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobConfiguration.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobConfigurationDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSteps(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllSteps(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSteps(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllSteps(Iterable)"})
  void testBuilderAddAllSteps_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSteps(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addSteps(AssessmentRipplerJobStep)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRipplerJobStep.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSteps(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName("Test Builder addSteps(AssessmentRipplerJobStep) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSteps(AssessmentRipplerJobStep)"})
  void testBuilderAddStepsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json()));
  }

  /**
   * Test Builder {@link Builder#addSteps(AssessmentRipplerJobStep[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableAssessmentRipplerJobStep.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSteps(AssessmentRipplerJobStep[])}
   */
  @Test
  @DisplayName("Test Builder addSteps(AssessmentRipplerJobStep[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSteps(AssessmentRipplerJobStep[])"})
  void testBuilderAddStepsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json()));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableAssessmentRipplerJobStep.Json} (default constructor).</li>
   *   <li>Then builder build steps size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRipplerJobConfiguration); given ArrayList() add Json (default constructor); then builder build steps size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobConfiguration)"})
  void testBuilderFrom_givenArrayListAddJson_thenBuilderBuildStepsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    ArrayList<AssessmentRipplerJobStep> assessmentRipplerJobStepList = new ArrayList<>();
    ImmutableAssessmentRipplerJobStep.Json json = new ImmutableAssessmentRipplerJobStep.Json();
    assessmentRipplerJobStepList.add(json);
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(assessmentRipplerJobStepList);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    List<AssessmentRipplerJobStep> stepsResult = builderResult.build().steps();
    assertEquals(1, stepsResult.size());
    assertEquals(assessmentRipplerJobStepList, actualFromResult.build().steps());
    assertSame(json, stepsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobConfiguration)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRipplerJobConfiguration); given ArrayList(); then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobConfiguration)"})
  void testBuilderFrom_givenArrayList_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRipplerJobConfiguration); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobConfiguration)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).steps();
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
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
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#steps(Iterable)}
   */
  @Test
  @DisplayName("Test Builder steps(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.steps(Iterable)"})
  void testBuilderSteps_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobConfiguration.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.steps(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
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
    assertNull(actualJson.name);
    assertTrue(actualJson.steps.isEmpty());
  }

  /**
   * Test Json {@link Json#steps()}.
   * <p>
   * Method under test: {@link Json#steps()}
   */
  @Test
  @DisplayName("Test Json steps()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.steps()"})
  void testJsonSteps() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).steps());
  }
}
