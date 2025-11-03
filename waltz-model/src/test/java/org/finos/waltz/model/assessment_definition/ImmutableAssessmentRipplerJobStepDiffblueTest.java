package org.finos.waltz.model.assessment_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobStep.Builder;
import org.finos.waltz.model.assessment_definition.ImmutableAssessmentRipplerJobStep.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentRipplerJobStepDiffblueTest {
  /**
   * Test Builder {@link Builder#fromDef(String)}.
   * <p>
   * Method under test: {@link Builder#fromDef(String)}
   */
  @Test
  @DisplayName("Test Builder fromDef(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fromDef(String)"})
  void testBuilderFromDef() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fromDef("jane.doe@example.org"));
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobStep)}.
   * <ul>
   *   <li>Given {@code Def}.</li>
   *   <li>Then builder build toDef is {@code Def}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRipplerJobStep); given 'Def'; then builder build toDef is 'Def'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobStep)"})
  void testBuilderFrom_givenDef_thenBuilderBuildToDefIsDef() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();
    AssessmentRipplerJobStep instance = mock(AssessmentRipplerJobStep.class);
    when(instance.toDef()).thenReturn("Def");
    when(instance.fromDef()).thenReturn("jane.doe@example.org");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).fromDef();
    verify(instance).toDef();
    ImmutableAssessmentRipplerJobStep buildResult = builderResult.build();
    assertEquals("Def", buildResult.toDef());
    assertEquals("jane.doe@example.org", buildResult.fromDef());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(AssessmentRipplerJobStep)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AssessmentRipplerJobStep)}
   */
  @Test
  @DisplayName("Test Builder from(AssessmentRipplerJobStep); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AssessmentRipplerJobStep)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();
    AssessmentRipplerJobStep instance = mock(AssessmentRipplerJobStep.class);
    when(instance.toDef()).thenThrow(new IllegalStateException("instance"));
    when(instance.fromDef()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).fromDef();
    verify(instance).toDef();
  }

  /**
   * Test Builder {@link Builder#toDef(String)}.
   * <p>
   * Method under test: {@link Builder#toDef(String)}
   */
  @Test
  @DisplayName("Test Builder toDef(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.toDef(String)"})
  void testBuilderToDef() {
    // Arrange
    Builder builderResult = ImmutableAssessmentRipplerJobStep.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.toDef("To Def"));
  }

  /**
   * Test Json {@link Json#fromDef()}.
   * <p>
   * Method under test: {@link Json#fromDef()}
   */
  @Test
  @DisplayName("Test Json fromDef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.fromDef()"})
  void testJsonFromDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fromDef());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFromDef(String)}
   *   <li>{@link Json#setToDef(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setFromDef(String)", "void Json.setToDef(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setFromDef("jane.doe@example.org");
    actualJson.setToDef("To Def");

    // Assert
    assertEquals("To Def", actualJson.toDef);
    assertEquals("jane.doe@example.org", actualJson.fromDef);
  }

  /**
   * Test Json {@link Json#toDef()}.
   * <p>
   * Method under test: {@link Json#toDef()}
   */
  @Test
  @DisplayName("Test Json toDef()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.toDef()"})
  void testJsonToDef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).toDef());
  }
}
