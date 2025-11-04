package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

class ImmutableMeasurableAlignmentDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationIds() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  void testBuilderAddAllApplicationIds2() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#addApplicationIds(long)}
   */
  @Test
  void testBuilderAddApplicationIds() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#addApplicationIds(long[])}
   */
  @Test
  void testBuilderAddApplicationIds2() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addApplicationIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#applicationIds(Iterable)}
   */
  @Test
  void testBuilderApplicationIds() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#applicationIds(Iterable)}
   */
  @Test
  void testBuilderApplicationIds2() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#from(MeasurableAlignment)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(new HashSet<>());
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    ImmutableMeasurableAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    assertSame(json, builderResult.build().measurable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#from(MeasurableAlignment)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurable()).thenReturn(new ImmutableMeasurable.Json());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).applicationIds();
    verify(instance).measurable();
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#from(MeasurableAlignment)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(resultLongSet);
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    ImmutableMeasurableAlignment.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    ImmutableMeasurableAlignment buildResult = builderResult.build();
    Set<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertTrue(applicationIdsResult.contains(-2L));
    assertSame(json, buildResult.measurable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment.Builder#measurable(Measurable)}
   */
  @Test
  void testBuilderMeasurable() {
    // Arrange
    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();

    // Act
    ImmutableMeasurableAlignment.Builder actualMeasurableResult = builderResult.measurable(measurable);

    // Assert
    assertSame(measurable, builderResult.build().measurable());
    assertSame(builderResult, actualMeasurableResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#copyOf(MeasurableAlignment)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(new HashSet<>());
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    ImmutableMeasurableAlignment actualCopyOfResult = ImmutableMeasurableAlignment.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    assertTrue(actualCopyOfResult.applicationIds().isEmpty());
    assertSame(json, actualCopyOfResult.measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#copyOf(MeasurableAlignment)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(resultLongSet);
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    ImmutableMeasurableAlignment actualCopyOfResult = ImmutableMeasurableAlignment.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    Set<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertTrue(applicationIdsResult.contains(1L));
    assertSame(json, actualCopyOfResult.measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#copyOf(MeasurableAlignment)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    MeasurableAlignment instance = mock(MeasurableAlignment.class);
    when(instance.applicationIds()).thenReturn(resultLongSet);
    ImmutableMeasurable.Json json = new ImmutableMeasurable.Json();
    when(instance.measurable()).thenReturn(json);

    // Act
    ImmutableMeasurableAlignment actualCopyOfResult = ImmutableMeasurableAlignment.copyOf(instance);

    // Assert
    verify(instance).applicationIds();
    verify(instance).measurable();
    assertEquals(resultLongSet, actualCopyOfResult.applicationIds());
    assertSame(json, actualCopyOfResult.measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#fromJson(ImmutableMeasurableAlignment.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableAlignment.Json json = new ImmutableMeasurableAlignment.Json();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();
    json.setMeasurable(measurable);
    json.setApplicationIds(null);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applicationIds().isEmpty());
    assertSame(measurable, actualFromJsonResult.measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#fromJson(ImmutableMeasurableAlignment.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Long> applicationIds = new LinkedHashSet<>();
    applicationIds.add(1L);

    ImmutableMeasurableAlignment.Json json = new ImmutableMeasurableAlignment.Json();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();
    json.setMeasurable(measurable);
    json.setApplicationIds(applicationIds);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    Set<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertTrue(applicationIdsResult.contains(1L));
    assertSame(measurable, actualFromJsonResult.measurable());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableAlignment#fromJson(ImmutableMeasurableAlignment.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> applicationIds = new LinkedHashSet<>();
    applicationIds.add(-1L);
    applicationIds.add(1L);

    ImmutableMeasurableAlignment.Json json = new ImmutableMeasurableAlignment.Json();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();
    json.setMeasurable(measurable);
    json.setApplicationIds(applicationIds);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    assertEquals(applicationIds, actualFromJsonResult.applicationIds());
    assertSame(measurable, actualFromJsonResult.measurable());
  }

  /**
   * Method under test: {@link ImmutableMeasurableAlignment.Json#applicationIds()}
   */
  @Test
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableAlignment.Json()).applicationIds());
  }

  /**
   * Method under test: {@link ImmutableMeasurableAlignment.Json#measurable()}
   */
  @Test
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableAlignment.Json()).measurable());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableAlignment.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableAlignment.Json actualJson = new ImmutableMeasurableAlignment.Json();

    // Assert
    assertNull(actualJson.measurable);
    assertTrue(actualJson.applicationIds.isEmpty());
  }
}
