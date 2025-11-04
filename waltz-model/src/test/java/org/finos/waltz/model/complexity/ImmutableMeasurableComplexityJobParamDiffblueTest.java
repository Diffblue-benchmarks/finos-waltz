package org.finos.waltz.model.complexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableComplexityJobParamDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#addAllMeasurableComplexities(Iterable)}
   */
  @Test
  void testBuilderAddAllMeasurableComplexities() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualAddAllMeasurableComplexitiesResult = builderResult
        .addAllMeasurableComplexities(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllMeasurableComplexitiesResult.build().measurableComplexities().isEmpty());
    assertSame(builderResult, actualAddAllMeasurableComplexitiesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#addMeasurableComplexities(MeasurableComplexityDetail)}
   */
  @Test
  void testBuilderAddMeasurableComplexities() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualAddMeasurableComplexitiesResult = builderResult
        .addMeasurableComplexities(new ImmutableMeasurableComplexityDetail.Json());

    // Assert
    assertEquals(1, actualAddMeasurableComplexitiesResult.build().measurableComplexities().size());
    assertEquals(1, builderResult.build().measurableComplexities().size());
    assertSame(builderResult, actualAddMeasurableComplexitiesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#addMeasurableComplexities(MeasurableComplexityDetail[])}
   */
  @Test
  void testBuilderAddMeasurableComplexities2() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualAddMeasurableComplexitiesResult = builderResult
        .addMeasurableComplexities(new ImmutableMeasurableComplexityDetail.Json());

    // Assert
    assertEquals(1, actualAddMeasurableComplexitiesResult.build().measurableComplexities().size());
    assertEquals(1, builderResult.build().measurableComplexities().size());
    assertSame(builderResult, actualAddMeasurableComplexitiesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableMeasurableComplexityJobParam.builder().build().measurableComplexities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#from(MeasurableComplexityJobParam)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();
    MeasurableComplexityJobParam instance = mock(MeasurableComplexityJobParam.class);
    when(instance.measurableComplexities()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableComplexities();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#from(MeasurableComplexityJobParam)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    HashSet<MeasurableComplexityDetail> measurableComplexityDetailSet = new HashSet<>();
    measurableComplexityDetailSet.add(new ImmutableMeasurableComplexityDetail.Json());
    MeasurableComplexityJobParam instance = mock(MeasurableComplexityJobParam.class);
    when(instance.measurableComplexities()).thenReturn(measurableComplexityDetailSet);

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableComplexities();
    assertEquals(1, builderResult.build().measurableComplexities().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Builder#measurableComplexities(Iterable)}
   */
  @Test
  void testBuilderMeasurableComplexities() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Builder builderResult = ImmutableMeasurableComplexityJobParam.builder();

    // Act
    ImmutableMeasurableComplexityJobParam.Builder actualMeasurableComplexitiesResult = builderResult
        .measurableComplexities(new ArrayList<>());

    // Assert
    assertTrue(actualMeasurableComplexitiesResult.build().measurableComplexities().isEmpty());
    assertSame(builderResult, actualMeasurableComplexitiesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#copyOf(MeasurableComplexityJobParam)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableComplexityJobParam instance = mock(MeasurableComplexityJobParam.class);
    when(instance.measurableComplexities()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableComplexityJobParam actualCopyOfResult = ImmutableMeasurableComplexityJobParam.copyOf(instance);

    // Assert
    verify(instance).measurableComplexities();
    assertTrue(actualCopyOfResult.measurableComplexities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#copyOf(MeasurableComplexityJobParam)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<MeasurableComplexityDetail> measurableComplexityDetailSet = new HashSet<>();
    measurableComplexityDetailSet.add(new ImmutableMeasurableComplexityDetail.Json());
    MeasurableComplexityJobParam instance = mock(MeasurableComplexityJobParam.class);
    when(instance.measurableComplexities()).thenReturn(measurableComplexityDetailSet);

    // Act
    ImmutableMeasurableComplexityJobParam actualCopyOfResult = ImmutableMeasurableComplexityJobParam.copyOf(instance);

    // Assert
    verify(instance).measurableComplexities();
    assertEquals(1, actualCopyOfResult.measurableComplexities().size());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#copyOf(MeasurableComplexityJobParam)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<MeasurableComplexityDetail> measurableComplexityDetailSet = new HashSet<>();
    measurableComplexityDetailSet.add(new ImmutableMeasurableComplexityDetail.Json());
    measurableComplexityDetailSet.add(new ImmutableMeasurableComplexityDetail.Json());
    MeasurableComplexityJobParam instance = mock(MeasurableComplexityJobParam.class);
    when(instance.measurableComplexities()).thenReturn(measurableComplexityDetailSet);

    // Act
    ImmutableMeasurableComplexityJobParam actualCopyOfResult = ImmutableMeasurableComplexityJobParam.copyOf(instance);

    // Assert
    verify(instance).measurableComplexities();
    assertEquals(measurableComplexityDetailSet, actualCopyOfResult.measurableComplexities());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#fromJson(ImmutableMeasurableComplexityJobParam.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Json json = new ImmutableMeasurableComplexityJobParam.Json();

    // Act and Assert
    Set<MeasurableComplexityDetail> measurableComplexitiesResult = ImmutableMeasurableComplexityJobParam.fromJson(json)
        .measurableComplexities();
    assertTrue(measurableComplexitiesResult.isEmpty());
    assertSame(json.measurableComplexities, measurableComplexitiesResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#fromJson(ImmutableMeasurableComplexityJobParam.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableMeasurableComplexityJobParam.Json json = new ImmutableMeasurableComplexityJobParam.Json();
    json.setMeasurableComplexities(null);

    // Act and Assert
    assertTrue(ImmutableMeasurableComplexityJobParam.fromJson(json).measurableComplexities().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#fromJson(ImmutableMeasurableComplexityJobParam.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<MeasurableComplexityDetail> measurableComplexities = new LinkedHashSet<>();
    measurableComplexities.add(new ImmutableMeasurableComplexityDetail.Json());

    ImmutableMeasurableComplexityJobParam.Json json = new ImmutableMeasurableComplexityJobParam.Json();
    json.setMeasurableComplexities(measurableComplexities);

    // Act and Assert
    assertEquals(1, ImmutableMeasurableComplexityJobParam.fromJson(json).measurableComplexities().size());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam#fromJson(ImmutableMeasurableComplexityJobParam.Json)}
   */
  @Test
  void testFromJson4() {
    // Arrange
    LinkedHashSet<MeasurableComplexityDetail> measurableComplexities = new LinkedHashSet<>();
    measurableComplexities.add(new ImmutableMeasurableComplexityDetail.Json());
    measurableComplexities.add(new ImmutableMeasurableComplexityDetail.Json());

    ImmutableMeasurableComplexityJobParam.Json json = new ImmutableMeasurableComplexityJobParam.Json();
    json.setMeasurableComplexities(measurableComplexities);

    // Act and Assert
    assertEquals(measurableComplexities, ImmutableMeasurableComplexityJobParam.fromJson(json).measurableComplexities());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableComplexityJobParam.Json#measurableComplexities()}
   */
  @Test
  void testJsonMeasurableComplexities() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableMeasurableComplexityJobParam.Json()).measurableComplexities());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableComplexityJobParam.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableMeasurableComplexityJobParam.Json()).measurableComplexities.isEmpty());
  }
}
