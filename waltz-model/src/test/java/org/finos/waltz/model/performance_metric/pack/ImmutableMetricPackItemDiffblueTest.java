package org.finos.waltz.model.performance_metric.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackItemDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#addAllGoals(Iterable)}
   */
  @Test
  void testBuilderAddAllGoals() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGoals(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#addGoals(CheckpointGoal)}
   */
  @Test
  void testBuilderAddGoals() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGoals(mock(CheckpointGoal.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#addGoals(CheckpointGoal[])}
   */
  @Test
  void testBuilderAddGoals2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGoals(mock(CheckpointGoal.class)));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#baseLine(double)}
   */
  @Test
  void testBuilderBaseLine() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.baseLine(10.0d));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#baseLine(double)}
   */
  @Test
  void testBuilderBaseLine2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(mock(CheckpointGoal.class));

    // Act and Assert
    assertSame(builderResult, builderResult.baseLine(10.0d));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#definitionId(long)}
   */
  @Test
  void testBuilderDefinitionId() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionId(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#definitionId(long)}
   */
  @Test
  void testBuilderDefinitionId2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(mock(CheckpointGoal.class));

    // Act and Assert
    assertSame(builderResult, builderResult.definitionId(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableMetricPackItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableMetricPackItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#from(MetricPackItem)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    ImmutableMetricPackItem buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(10.0d, buildResult.baseLine());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#from(MetricPackItem)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenThrow(new IllegalStateException("instance"));
    when(instance.sectionName()).thenReturn("Section Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).baseLine();
    verify(instance).sectionName();
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#from(MetricPackItem)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    ArrayList<CheckpointGoal> checkpointGoalList = new ArrayList<>();
    checkpointGoalList.add(mock(CheckpointGoal.class));
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(checkpointGoalList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    ImmutableMetricPackItem buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(1, buildResult.goals().size());
    assertEquals(10.0d, buildResult.baseLine());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#from(MetricPackItem)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    ImmutableMetricPackItem buildResult = builderResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(10.0d, buildResult.baseLine());
    assertEquals(1L, buildResult.definitionId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#goals(Iterable)}
   */
  @Test
  void testBuilderGoals() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.goals(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(mock(CheckpointGoal.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(mock(CheckpointGoal.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#sectionName(String)}
   */
  @Test
  void testBuilderSectionName() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName("Section Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPackItem.Builder#sectionName(String)}
   */
  @Test
  void testBuilderSectionName2() {
    // Arrange
    ImmutableMetricPackItem.Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(mock(CheckpointGoal.class));

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName("Section Name"));
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem actualCopyOfResult = ImmutableMetricPackItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(10.0d, actualCopyOfResult.baseLine());
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertTrue(actualCopyOfResult.goals().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<CheckpointGoal> checkpointGoalList = new ArrayList<>();
    checkpointGoalList.add(mock(CheckpointGoal.class));
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(checkpointGoalList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem actualCopyOfResult = ImmutableMetricPackItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(1, actualCopyOfResult.goals().size());
    assertEquals(10.0d, actualCopyOfResult.baseLine());
    assertEquals(1L, actualCopyOfResult.definitionId());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<CheckpointGoal> checkpointGoalList = new ArrayList<>();
    checkpointGoalList.add(mock(CheckpointGoal.class));
    checkpointGoalList.add(mock(CheckpointGoal.class));
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(checkpointGoalList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem actualCopyOfResult = ImmutableMetricPackItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(10.0d, actualCopyOfResult.baseLine());
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertEquals(checkpointGoalList, actualCopyOfResult.goals());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    ImmutableMetricPackItem actualCopyOfResult = ImmutableMetricPackItem.copyOf(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(10.0d, actualCopyOfResult.baseLine());
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertTrue(actualCopyOfResult.goals().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#baseLine()}
   */
  @Test
  void testJsonBaseLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPackItem.Json()).baseLine());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#definitionId()}
   */
  @Test
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPackItem.Json()).definitionId());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#goals()}
   */
  @Test
  void testJsonGoals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPackItem.Json()).goals());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPackItem.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMetricPackItem.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMetricPackItem.Json actualJson = new ImmutableMetricPackItem.Json();

    // Assert
    assertNull(actualJson.sectionName);
    assertEquals(0.0d, actualJson.baseLine);
    assertEquals(0L, actualJson.definitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.baseLineIsSet);
    assertFalse(actualJson.definitionIdIsSet);
    assertTrue(actualJson.goals.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#sectionName()}
   */
  @Test
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPackItem.Json()).sectionName());
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#setBaseLine(double)}
   */
  @Test
  void testJsonSetBaseLine() {
    // Arrange
    ImmutableMetricPackItem.Json json = new ImmutableMetricPackItem.Json();

    // Act
    json.setBaseLine(10.0d);

    // Assert
    assertEquals(10.0d, json.baseLine);
    assertTrue(json.baseLineIsSet);
  }

  /**
   * Method under test: {@link ImmutableMetricPackItem.Json#setDefinitionId(long)}
   */
  @Test
  void testJsonSetDefinitionId() {
    // Arrange
    ImmutableMetricPackItem.Json json = new ImmutableMetricPackItem.Json();

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }
}
