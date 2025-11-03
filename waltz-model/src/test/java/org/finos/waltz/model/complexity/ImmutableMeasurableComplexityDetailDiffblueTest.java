package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityDetail.Builder;
import org.finos.waltz.model.complexity.ImmutableMeasurableComplexityDetail.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableComplexityDetailDiffblueTest {
  /**
   * Test Builder {@link Builder#complexityKind(String)}.
   * <p>
   * Method under test: {@link Builder#complexityKind(String)}
   */
  @Test
  @DisplayName("Test Builder complexityKind(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.complexityKind(String)"})
  void testBuilderComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind("Complexity Kind"));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableComplexityDetail)}.
   * <ul>
   *   <li>Then builder build complexityKind is {@code Complexity Kind}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableComplexityDetail)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableComplexityDetail); then builder build complexityKind is 'Complexity Kind'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableComplexityDetail)"})
  void testBuilderFrom_thenBuilderBuildComplexityKindIsComplexityKind() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();
    MeasurableComplexityDetail instance = mock(MeasurableComplexityDetail.class);
    when(instance.complexityKind()).thenReturn("Complexity Kind");
    when(instance.measurableCategory()).thenReturn("Measurable Category");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complexityKind();
    verify(instance).measurableCategory();
    ImmutableMeasurableComplexityDetail buildResult = builderResult.build();
    assertEquals("Complexity Kind", buildResult.complexityKind());
    assertEquals("Measurable Category", buildResult.measurableCategory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableComplexityDetail)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableComplexityDetail)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableComplexityDetail); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableComplexityDetail)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();
    MeasurableComplexityDetail instance = mock(MeasurableComplexityDetail.class);
    when(instance.complexityKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableCategory()).thenReturn("Measurable Category");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).complexityKind();
    verify(instance).measurableCategory();
  }

  /**
   * Test Builder {@link Builder#measurableCategory(String)}.
   * <p>
   * Method under test: {@link Builder#measurableCategory(String)}
   */
  @Test
  @DisplayName("Test Builder measurableCategory(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableCategory(String)"})
  void testBuilderMeasurableCategory() {
    // Arrange
    Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategory("Measurable Category"));
  }

  /**
   * Test Json {@link Json#complexityKind()}.
   * <p>
   * Method under test: {@link Json#complexityKind()}
   */
  @Test
  @DisplayName("Test Json complexityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.complexityKind()"})
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).complexityKind());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComplexityKind(String)}
   *   <li>{@link Json#setMeasurableCategory(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComplexityKind(String)",
      "void Json.setMeasurableCategory(String)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplexityKind("Complexity Kind");
    actualJson.setMeasurableCategory("Measurable Category");

    // Assert
    assertEquals("Complexity Kind", actualJson.complexityKind);
    assertEquals("Measurable Category", actualJson.measurableCategory);
  }

  /**
   * Test Json {@link Json#measurableCategory()}.
   * <p>
   * Method under test: {@link Json#measurableCategory()}
   */
  @Test
  @DisplayName("Test Json measurableCategory()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.measurableCategory()"})
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableCategory());
  }
}
