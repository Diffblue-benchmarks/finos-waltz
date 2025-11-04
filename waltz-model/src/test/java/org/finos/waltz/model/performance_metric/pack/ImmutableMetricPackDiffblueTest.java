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
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.checkpoint.Checkpoint;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMetricPack#builder()}
   *   <li>{@link ImmutableMetricPack#description(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableMetricPack.Builder actualIdResult = ImmutableMetricPack.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addAllCheckpoints(Iterable)}
   */
  @Test
  void testBuilderAddAllCheckpoints() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCheckpoints(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#addAllItems(Iterable)}
   */
  @Test
  void testBuilderAddAllItems() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllItems(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#addAllItems(Iterable)}
   */
  @Test
  void testBuilderAddAllItems2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addAllItems(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addAllRelatedReferences(Iterable)}
   */
  @Test
  void testBuilderAddAllRelatedReferences() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRelatedReferences(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addCheckpoints(Checkpoint)}
   */
  @Test
  void testBuilderAddCheckpoints() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCheckpoints(mock(Checkpoint.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addCheckpoints(Checkpoint[])}
   */
  @Test
  void testBuilderAddCheckpoints2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCheckpoints(mock(Checkpoint.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addItems(MetricPackItem)}
   */
  @Test
  void testBuilderAddItems() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addItems(MetricPackItem)}
   */
  @Test
  void testBuilderAddItems2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addItems(MetricPackItem[])}
   */
  @Test
  void testBuilderAddItems3() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addItems(MetricPackItem[])}
   */
  @Test
  void testBuilderAddItems4() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addRelatedReferences(EntityReference)}
   */
  @Test
  void testBuilderAddRelatedReferences() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRelatedReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#addRelatedReferences(EntityReference[])}
   */
  @Test
  void testBuilderAddRelatedReferences2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRelatedReferences(mock(EntityReference.class)));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#checkpoints(Iterable)}
   */
  @Test
  void testBuilderCheckpoints() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.checkpoints(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn(null);
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    ArrayList<Checkpoint> checkpointList = new ArrayList<>();
    checkpointList.add(mock(Checkpoint.class));
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(checkpointList);
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.checkpoints().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    ArrayList<MetricPackItem> metricPackItemList = new ArrayList<>();
    ImmutableMetricPackItem.Json json = new ImmutableMetricPackItem.Json();
    metricPackItemList.add(json);
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(metricPackItemList);
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<MetricPackItem> itemsResult = buildResult.items();
    assertEquals(1, itemsResult.size());
    assertSame(json, itemsResult.get(0));
    assertSame(builderResult, actualFromResult);
    List<CheckpointGoal> checkpointGoalList = json.goals;
    assertSame(checkpointGoalList, buildResult.checkpoints());
    assertSame(checkpointGoalList, buildResult.relatedReferences());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(entityReferenceList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.relatedReferences().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#from(MetricPack)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#items(Iterable)}
   */
  @Test
  void testBuilderItems() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.items(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#items(Iterable)}
   */
  @Test
  void testBuilderItems2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act and Assert
    assertSame(builderResult, builderResult.items(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act
    ImmutableMetricPack.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(mock(Checkpoint.class));

    // Act
    ImmutableMetricPack.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1, buildResult.checkpoints().size());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack.Builder#relatedReferences(Iterable)}
   */
  @Test
  void testBuilderRelatedReferences() {
    // Arrange
    ImmutableMetricPack.Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relatedReferences(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<Checkpoint> checkpointsResult = actualCopyOfResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualCopyOfResult.items());
    assertSame(checkpointsResult, actualCopyOfResult.relatedReferences());
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<Checkpoint> checkpointList = new ArrayList<>();
    checkpointList.add(mock(Checkpoint.class));
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(checkpointList);
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.checkpoints().size());
    List<MetricPackItem> itemsResult = actualCopyOfResult.items();
    assertTrue(itemsResult.isEmpty());
    assertSame(itemsResult, actualCopyOfResult.relatedReferences());
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<Checkpoint> checkpointList = new ArrayList<>();
    checkpointList.add(mock(Checkpoint.class));
    checkpointList.add(mock(Checkpoint.class));
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(checkpointList);
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<MetricPackItem> itemsResult = actualCopyOfResult.items();
    assertTrue(itemsResult.isEmpty());
    assertEquals(checkpointList, actualCopyOfResult.checkpoints());
    assertSame(itemsResult, actualCopyOfResult.relatedReferences());
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<MetricPackItem> metricPackItemList = new ArrayList<>();
    ImmutableMetricPackItem.Json json = new ImmutableMetricPackItem.Json();
    metricPackItemList.add(json);
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(metricPackItemList);
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<Checkpoint> checkpointsResult = actualCopyOfResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertEquals(metricPackItemList, actualCopyOfResult.items());
    List<CheckpointGoal> checkpointGoalList = json.goals;
    assertSame(checkpointGoalList, checkpointsResult);
    assertSame(checkpointGoalList, actualCopyOfResult.relatedReferences());
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    entityReferenceList.add(mock(EntityReference.class));
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(entityReferenceList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.relatedReferences().size());
    List<Checkpoint> checkpointsResult = actualCopyOfResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualCopyOfResult.items());
  }

  /**
   * Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<Checkpoint> checkpointsResult = actualCopyOfResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualCopyOfResult.items());
    assertSame(checkpointsResult, actualCopyOfResult.relatedReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack#fromJson(ImmutableMetricPack.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableMetricPack.Json json = new ImmutableMetricPack.Json();
    json.setName("name");

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    List<Checkpoint> checkpointsResult = actualFromJsonResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    List<EntityReference> entityReferenceList = json.relatedReferences;
    assertSame(entityReferenceList, checkpointsResult);
    assertSame(entityReferenceList, actualFromJsonResult.items());
    assertSame(entityReferenceList, actualFromJsonResult.relatedReferences());
  }

  /**
   * Method under test:
   * {@link ImmutableMetricPack#fromJson(ImmutableMetricPack.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<EntityReference> relatedReferences = new ArrayList<>();
    relatedReferences.add(mock(EntityReference.class));

    ImmutableMetricPack.Json json = new ImmutableMetricPack.Json();
    json.setId(null);
    json.setName("relatedReferences element");
    json.setDescription(null);
    json.setCheckpoints(null);
    json.setItems(null);
    json.setRelatedReferences(relatedReferences);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    assertEquals("relatedReferences element", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(1, actualFromJsonResult.relatedReferences().size());
    List<Checkpoint> checkpointsResult = actualFromJsonResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualFromJsonResult.items());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#checkpoints()}
   */
  @Test
  void testJsonCheckpoints() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).checkpoints());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#items()}
   */
  @Test
  void testJsonItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).items());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableMetricPack.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableMetricPack.Json actualJson = new ImmutableMetricPack.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.checkpoints.isEmpty());
    assertTrue(actualJson.items.isEmpty());
    assertTrue(actualJson.relatedReferences.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableMetricPack.Json#relatedReferences()}
   */
  @Test
  void testJsonRelatedReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableMetricPack.Json()).relatedReferences());
  }
}
