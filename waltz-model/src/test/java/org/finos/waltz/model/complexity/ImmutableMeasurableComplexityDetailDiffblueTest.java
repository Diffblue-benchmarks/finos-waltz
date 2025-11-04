package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableComplexityDetailDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Builder#complexityKind(String)}
   */
  @Test
  void testBuilderComplexityKind() {
    // Arrange
    ImmutableMeasurableComplexityDetail.Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.complexityKind("Complexity Kind"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Builder#from(MeasurableComplexityDetail)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableComplexityDetail.Builder builderResult = ImmutableMeasurableComplexityDetail.builder();
    MeasurableComplexityDetail instance = mock(MeasurableComplexityDetail.class);
    when(instance.complexityKind()).thenReturn("Complexity Kind");
    when(instance.measurableCategory()).thenReturn("Measurable Category");

    // Act
    ImmutableMeasurableComplexityDetail.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).complexityKind();
    verify(instance).measurableCategory();
    ImmutableMeasurableComplexityDetail buildResult = builderResult.build();
    assertEquals("Complexity Kind", buildResult.complexityKind());
    assertEquals("Measurable Category", buildResult.measurableCategory());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Builder#from(MeasurableComplexityDetail)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableComplexityDetail.Builder builderResult = ImmutableMeasurableComplexityDetail.builder();
    MeasurableComplexityDetail instance = mock(MeasurableComplexityDetail.class);
    when(instance.complexityKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableCategory()).thenReturn("Measurable Category");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).complexityKind();
    verify(instance).measurableCategory();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Builder#measurableCategory(String)}
   */
  @Test
  void testBuilderMeasurableCategory() {
    // Arrange
    ImmutableMeasurableComplexityDetail.Builder builderResult = ImmutableMeasurableComplexityDetail.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableCategory("Measurable Category"));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail#copyOf(MeasurableComplexityDetail)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableComplexityDetail instance = mock(MeasurableComplexityDetail.class);
    when(instance.complexityKind()).thenReturn("Complexity Kind");
    when(instance.measurableCategory()).thenReturn("Measurable Category");

    // Act
    ImmutableMeasurableComplexityDetail actualCopyOfResult = ImmutableMeasurableComplexityDetail.copyOf(instance);

    // Assert
    verify(instance).complexityKind();
    verify(instance).measurableCategory();
    assertEquals("Complexity Kind", actualCopyOfResult.complexityKind());
    assertEquals("Measurable Category", actualCopyOfResult.measurableCategory());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail#fromJson(ImmutableMeasurableComplexityDetail.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableComplexityDetail.Json json = new ImmutableMeasurableComplexityDetail.Json();
    json.setMeasurableCategory("Json");
    json.setComplexityKind("Json");

    // Act
    ImmutableMeasurableComplexityDetail actualFromJsonResult = ImmutableMeasurableComplexityDetail.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.complexityKind());
    assertEquals("Json", actualFromJsonResult.measurableCategory());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Json#complexityKind()}
   */
  @Test
  void testJsonComplexityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableComplexityDetail.Json()).complexityKind());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link ImmutableMeasurableComplexityDetail.Json}
   *   <li>
   * {@link ImmutableMeasurableComplexityDetail.Json#setComplexityKind(String)}
   *   <li>
   * {@link ImmutableMeasurableComplexityDetail.Json#setMeasurableCategory(String)}
   * </ul>
   */
  @Test
  void testJsonGettersAndSetters() {
    // Arrange and Act
    ImmutableMeasurableComplexityDetail.Json actualJson = new ImmutableMeasurableComplexityDetail.Json();
    actualJson.setComplexityKind("Complexity Kind");
    actualJson.setMeasurableCategory("Measurable Category");

    // Assert
    assertEquals("Complexity Kind", actualJson.complexityKind);
    assertEquals("Measurable Category", actualJson.measurableCategory);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityDetail.Json#measurableCategory()}
   */
  @Test
  void testJsonMeasurableCategory() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableComplexityDetail.Json()).measurableCategory());
  }
}
