package org.finos.waltz.model.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#addAllSteps(Iterable)}
   */
  @Test
  void testBuilderAddAllSteps() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSteps(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#addSteps(AssessmentRipplerJobStep)}
   */
  @Test
  void testBuilderAddSteps() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#addSteps(AssessmentRipplerJobStep[])}
   */
  @Test
  void testBuilderAddSteps2() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSteps(new ImmutableAssessmentRipplerJobStep.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentRipplerJobConfiguration.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).steps();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#from(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    ArrayList<AssessmentRipplerJobStep> assessmentRipplerJobStepList = new ArrayList<>();
    ImmutableAssessmentRipplerJobStep.Json json = new ImmutableAssessmentRipplerJobStep.Json();
    assessmentRipplerJobStepList.add(json);
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(assessmentRipplerJobStepList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentRipplerJobConfiguration.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    ImmutableAssessmentRipplerJobConfiguration buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    List<AssessmentRipplerJobStep> stepsResult = buildResult.steps();
    assertEquals(1, stepsResult.size());
    assertSame(json, stepsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    // Act
    ImmutableAssessmentRipplerJobConfiguration.Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertEquals("Name", builderResult.build().name());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Builder#steps(Iterable)}
   */
  @Test
  void testBuilderSteps() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Builder builderResult = ImmutableAssessmentRipplerJobConfiguration
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.steps(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#copyOf(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualCopyOfResult = ImmutableAssessmentRipplerJobConfiguration
        .copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    assertEquals("Name", actualCopyOfResult.name());
    assertTrue(actualCopyOfResult.steps().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#copyOf(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> assessmentRipplerJobStepList = new ArrayList<>();
    assessmentRipplerJobStepList.add(new ImmutableAssessmentRipplerJobStep.Json());
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(assessmentRipplerJobStepList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualCopyOfResult = ImmutableAssessmentRipplerJobConfiguration
        .copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(assessmentRipplerJobStepList, actualCopyOfResult.steps());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#copyOf(AssessmentRipplerJobConfiguration)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> assessmentRipplerJobStepList = new ArrayList<>();
    assessmentRipplerJobStepList.add(new ImmutableAssessmentRipplerJobStep.Json());
    assessmentRipplerJobStepList.add(new ImmutableAssessmentRipplerJobStep.Json());
    AssessmentRipplerJobConfiguration instance = mock(AssessmentRipplerJobConfiguration.class);
    when(instance.steps()).thenReturn(assessmentRipplerJobStepList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualCopyOfResult = ImmutableAssessmentRipplerJobConfiguration
        .copyOf(instance);

    // Assert
    verify(instance).name();
    verify(instance).steps();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals(assessmentRipplerJobStepList, actualCopyOfResult.steps());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(ImmutableAssessmentRipplerJobConfiguration.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRipplerJobConfiguration.Json json = new ImmutableAssessmentRipplerJobConfiguration.Json();
    json.setName("Json");
    json.setSteps(null);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult = ImmutableAssessmentRipplerJobConfiguration
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertTrue(actualFromJsonResult.steps().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(ImmutableAssessmentRipplerJobConfiguration.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> steps = new ArrayList<>();
    steps.add(new ImmutableAssessmentRipplerJobStep.Json());

    ImmutableAssessmentRipplerJobConfiguration.Json json = new ImmutableAssessmentRipplerJobConfiguration.Json();
    json.setName("Json");
    json.setSteps(steps);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult = ImmutableAssessmentRipplerJobConfiguration
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(steps, actualFromJsonResult.steps());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration#fromJson(ImmutableAssessmentRipplerJobConfiguration.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<AssessmentRipplerJobStep> steps = new ArrayList<>();
    steps.add(new ImmutableAssessmentRipplerJobStep.Json());
    steps.add(new ImmutableAssessmentRipplerJobStep.Json());

    ImmutableAssessmentRipplerJobConfiguration.Json json = new ImmutableAssessmentRipplerJobConfiguration.Json();
    json.setName("Json");
    json.setSteps(steps);

    // Act
    ImmutableAssessmentRipplerJobConfiguration actualFromJsonResult = ImmutableAssessmentRipplerJobConfiguration
        .fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(steps, actualFromJsonResult.steps());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRipplerJobConfiguration.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentRipplerJobConfiguration.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobConfiguration.Json actualJson = new ImmutableAssessmentRipplerJobConfiguration.Json();

    // Assert
    assertNull(actualJson.name);
    assertTrue(actualJson.steps.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobConfiguration.Json#steps()}
   */
  @Test
  void testJsonSteps() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentRipplerJobConfiguration.Json()).steps());
  }
}
