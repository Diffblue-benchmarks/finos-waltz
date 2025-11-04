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
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#addAllParents(Iterable)}
   */
  @Test
  void testBuilderAddAllParents() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllParents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#addParents(MeasurableHierarchyAlignment)}
   */
  @Test
  void testBuilderAddParents() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#addParents(MeasurableHierarchyAlignment)}
   */
  @Test
  void testBuilderAddParents2() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    ImmutableMeasurableHierarchyAlignment.Json element = new ImmutableMeasurableHierarchyAlignment.Json();
    element.setParentReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(element));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#addParents(MeasurableHierarchyAlignment[])}
   */
  @Test
  void testBuilderAddParents3() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(new ImmutableMeasurableHierarchyAlignment.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#addParents(MeasurableHierarchyAlignment[])}
   */
  @Test
  void testBuilderAddParents4() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    ImmutableMeasurableHierarchyAlignment.Json json = new ImmutableMeasurableHierarchyAlignment.Json();
    json.setParentReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addParents(json));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#from(MeasurableHierarchy)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    ImmutableMeasurableHierarchy buildResult = builderResult.build();
    assertEquals(1, buildResult.maxDepth().intValue());
    assertEquals(1L, buildResult.measurableId().longValue());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#from(MeasurableHierarchy)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    HashSet<MeasurableHierarchyAlignment> measurableHierarchyAlignmentSet = new HashSet<>();
    measurableHierarchyAlignmentSet.add(new ImmutableMeasurableHierarchyAlignment.Json());
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(measurableHierarchyAlignmentSet);

    // Act
    ImmutableMeasurableHierarchy.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#measurableId(Long)}
   */
  @Test
  void testBuilderMeasurableId() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act
    ImmutableMeasurableHierarchy.Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    ImmutableMeasurableHierarchy buildResult = builderResult.build();
    assertEquals(1, buildResult.maxDepth().intValue());
    assertEquals(1L, buildResult.measurableId().longValue());
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#measurableId(Long)}
   */
  @Test
  void testBuilderMeasurableId2() {
    // Arrange
    ImmutableMeasurableHierarchyAlignment.Json element = new ImmutableMeasurableHierarchyAlignment.Json();
    element.setParentReference(mock(EntityReference.class));
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();
    builderResult.addParents(element);

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy.Builder#parents(Iterable)}
   */
  @Test
  void testBuilderParents() {
    // Arrange
    ImmutableMeasurableHierarchy.Builder builderResult = ImmutableMeasurableHierarchy.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parents(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy#copyOf(MeasurableHierarchy)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(new HashSet<>());

    // Act
    ImmutableMeasurableHierarchy actualCopyOfResult = ImmutableMeasurableHierarchy.copyOf(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    assertEquals(1, actualCopyOfResult.maxDepth().intValue());
    assertEquals(1L, actualCopyOfResult.measurableId().longValue());
    assertTrue(actualCopyOfResult.parents().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy#copyOf(MeasurableHierarchy)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    MeasurableHierarchyAlignment measurableHierarchyAlignment = mock(MeasurableHierarchyAlignment.class);
    when(measurableHierarchyAlignment.level()).thenReturn(1);
    MeasurableHierarchyAlignment measurableHierarchyAlignment2 = mock(MeasurableHierarchyAlignment.class);
    when(measurableHierarchyAlignment2.level()).thenReturn(1);

    HashSet<MeasurableHierarchyAlignment> measurableHierarchyAlignmentSet = new HashSet<>();
    measurableHierarchyAlignmentSet.add(measurableHierarchyAlignment2);
    measurableHierarchyAlignmentSet.add(measurableHierarchyAlignment);
    MeasurableHierarchy instance = mock(MeasurableHierarchy.class);
    when(instance.measurableId()).thenReturn(1L);
    when(instance.parents()).thenReturn(measurableHierarchyAlignmentSet);

    // Act
    ImmutableMeasurableHierarchy actualCopyOfResult = ImmutableMeasurableHierarchy.copyOf(instance);

    // Assert
    verify(instance).measurableId();
    verify(instance).parents();
    verify(measurableHierarchyAlignment2).level();
    verify(measurableHierarchyAlignment).level();
    assertEquals(1, actualCopyOfResult.maxDepth().intValue());
    assertEquals(1L, actualCopyOfResult.measurableId().longValue());
    assertEquals(measurableHierarchyAlignmentSet, actualCopyOfResult.parents());
  }

  /**
   * Method under test:
   * {@link ImmutableMeasurableHierarchy#fromJson(ImmutableMeasurableHierarchy.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMeasurableHierarchy.Json json = new ImmutableMeasurableHierarchy.Json();
    json.setMeasurableId(1L);
    json.setParents(null);

    // Act
    ImmutableMeasurableHierarchy actualFromJsonResult = ImmutableMeasurableHierarchy.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.maxDepth().intValue());
    assertEquals(1L, actualFromJsonResult.measurableId().longValue());
    assertTrue(actualFromJsonResult.parents().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMeasurableHierarchy.Json#maxDepth()}
   */
  @Test
  void testJsonMaxDepth() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableHierarchy.Json()).maxDepth());
  }

  /**
   * Method under test: {@link ImmutableMeasurableHierarchy.Json#measurableId()}
   */
  @Test
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableHierarchy.Json()).measurableId());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMeasurableHierarchy.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMeasurableHierarchy.Json actualJson = new ImmutableMeasurableHierarchy.Json();

    // Assert
    assertNull(actualJson.measurableId);
    assertTrue(actualJson.parents.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMeasurableHierarchy.Json#parents()}
   */
  @Test
  void testJsonParents() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMeasurableHierarchy.Json()).parents());
  }
}
