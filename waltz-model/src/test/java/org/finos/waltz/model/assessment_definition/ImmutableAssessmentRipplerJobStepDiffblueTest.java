package org.finos.waltz.model.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobStepDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep.Builder#from(AssessmentRipplerJobStep)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentRipplerJobStep.Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();
    AssessmentRipplerJobStep instance = mock(AssessmentRipplerJobStep.class);
    when(instance.toDef()).thenReturn("Def");
    when(instance.fromDef()).thenReturn("jane.doe@example.org");

    // Act
    ImmutableAssessmentRipplerJobStep.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).fromDef();
    verify(instance).toDef();
    ImmutableAssessmentRipplerJobStep buildResult = builderResult.build();
    assertEquals("Def", buildResult.toDef());
    assertEquals("jane.doe@example.org", buildResult.fromDef());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep.Builder#from(AssessmentRipplerJobStep)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentRipplerJobStep.Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();
    AssessmentRipplerJobStep instance = mock(AssessmentRipplerJobStep.class);
    when(instance.toDef()).thenThrow(new IllegalStateException("instance"));
    when(instance.fromDef()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).fromDef();
    verify(instance).toDef();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep.Builder#fromDef(String)}
   */
  @Test
  void testBuilderFromDef() {
    // Arrange
    ImmutableAssessmentRipplerJobStep.Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fromDef("jane.doe@example.org"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep.Builder#toDef(String)}
   */
  @Test
  void testBuilderToDef() {
    // Arrange
    ImmutableAssessmentRipplerJobStep.Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.toDef("To Def"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep#copyOf(AssessmentRipplerJobStep)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentRipplerJobStep instance = mock(AssessmentRipplerJobStep.class);
    when(instance.toDef()).thenReturn("Def");
    when(instance.fromDef()).thenReturn("jane.doe@example.org");

    // Act
    ImmutableAssessmentRipplerJobStep actualCopyOfResult = ImmutableAssessmentRipplerJobStep.copyOf(instance);

    // Assert
    verify(instance).fromDef();
    verify(instance).toDef();
    assertEquals("Def", actualCopyOfResult.toDef());
    assertEquals("jane.doe@example.org", actualCopyOfResult.fromDef());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentRipplerJobStep#fromJson(ImmutableAssessmentRipplerJobStep.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableAssessmentRipplerJobStep.Json json = new ImmutableAssessmentRipplerJobStep.Json();
    json.setFromDef("Json");
    json.setToDef("Json");

    // Act
    ImmutableAssessmentRipplerJobStep actualFromJsonResult = ImmutableAssessmentRipplerJobStep.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.fromDef());
    assertEquals("Json", actualFromJsonResult.toDef());
  }

  /**
   * Method under test: {@link ImmutableAssessmentRipplerJobStep.Json#fromDef()}
   */
  @Test
  void testJsonFromDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRipplerJobStep.Json()).fromDef());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableAssessmentRipplerJobStep.Json}
   *   <li>{@link ImmutableAssessmentRipplerJobStep.Json#setFromDef(String)}
   *   <li>{@link ImmutableAssessmentRipplerJobStep.Json#setToDef(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableAssessmentRipplerJobStep.Json actualJson = new ImmutableAssessmentRipplerJobStep.Json();
    actualJson.setFromDef("jane.doe@example.org");
    actualJson.setToDef("To Def");

    // Assert
    assertEquals("To Def", actualJson.toDef);
    assertEquals("jane.doe@example.org", actualJson.fromDef);
  }

  /**
   * Method under test: {@link ImmutableAssessmentRipplerJobStep.Json#toDef()}
   */
  @Test
  void testJsonToDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentRipplerJobStep.Json()).toDef());
  }
}
