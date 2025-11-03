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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.checkpoint.Checkpoint;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPack.Builder;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPack.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackDiffblueTest {
  /**
   * Test {@link ImmutableMetricPack#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableMetricPack#builder()}
   *   <li>{@link ImmutableMetricPack#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableMetricPack Builder.build()", "Builder Builder.description(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualIdResult = ImmutableMetricPack.builder()
        .description("The characteristics of someone or something")
        .id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Test Builder {@link Builder#addAllCheckpoints(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllCheckpoints(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCheckpoints(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllCheckpoints(Iterable)"})
  void testBuilderAddAllCheckpoints_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllCheckpoints(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllItems(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllItems(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllItems(Iterable)"})
  void testBuilderAddAllItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllItems(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRelatedReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRelatedReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRelatedReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRelatedReferences(Iterable)"})
  void testBuilderAddAllRelatedReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRelatedReferences(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addCheckpoints(Checkpoint)} with {@code element}.
   * <ul>
   *   <li>When {@link Checkpoint}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCheckpoints(Checkpoint)}
   */
  @Test
  @DisplayName("Test Builder addCheckpoints(Checkpoint) with 'element'; when Checkpoint; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCheckpoints(Checkpoint)"})
  void testBuilderAddCheckpointsWithElement_whenCheckpoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCheckpoints(mock(Checkpoint.class)));
  }

  /**
   * Test Builder {@link Builder#addCheckpoints(Checkpoint[])} with {@code elements}.
   * <ul>
   *   <li>When {@link Checkpoint}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addCheckpoints(Checkpoint[])}
   */
  @Test
  @DisplayName("Test Builder addCheckpoints(Checkpoint[]) with 'elements'; when Checkpoint; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addCheckpoints(Checkpoint[])"})
  void testBuilderAddCheckpointsWithElements_whenCheckpoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addCheckpoints(mock(Checkpoint.class)));
  }

  /**
   * Test Builder {@link Builder#addItems(MetricPackItem)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableMetricPackItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addItems(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder addItems(MetricPackItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addItems(MetricPackItem)"})
  void testBuilderAddItemsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Test Builder {@link Builder#addItems(MetricPackItem[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableMetricPackItem.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addItems(MetricPackItem[])}
   */
  @Test
  @DisplayName("Test Builder addItems(MetricPackItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addItems(MetricPackItem[])"})
  void testBuilderAddItemsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addItems(new ImmutableMetricPackItem.Json()));
  }

  /**
   * Test Builder {@link Builder#addRelatedReferences(EntityReference)} with {@code element}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRelatedReferences(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addRelatedReferences(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRelatedReferences(EntityReference)"})
  void testBuilderAddRelatedReferencesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRelatedReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#addRelatedReferences(EntityReference[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRelatedReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addRelatedReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRelatedReferences(EntityReference[])"})
  void testBuilderAddRelatedReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRelatedReferences(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#checkpoints(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#checkpoints(Iterable)}
   */
  @Test
  @DisplayName("Test Builder checkpoints(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.checkpoints(Iterable)"})
  void testBuilderCheckpoints_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.checkpoints(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<Checkpoint> checkpointsResult = buildResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, buildResult.items());
    assertSame(checkpointsResult, buildResult.relatedReferences());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link MetricPack} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; given empty; when MetricPack id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_givenEmpty_whenMetricPackIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<Checkpoint> checkpointsResult = buildResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, buildResult.items());
    assertSame(checkpointsResult, buildResult.relatedReferences());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Then builder build items size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; then builder build items size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_thenBuilderBuildItemsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = builderResult.build();
    List<MetricPackItem> itemsResult = buildResult.items();
    assertEquals(1, itemsResult.size());
    ImmutableMetricPack buildResult2 = actualFromResult.build();
    assertEquals(metricPackItemList, buildResult2.items());
    assertSame(json, itemsResult.get(0));
    List<CheckpointGoal> checkpointGoalList = json.goals;
    assertSame(checkpointGoalList, buildResult.checkpoints());
    assertSame(checkpointGoalList, buildResult2.relatedReferences());
    assertSame(checkpointGoalList, buildResult.relatedReferences());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Then return build checkpoints size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; then return build checkpoints size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_thenReturnBuildCheckpointsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    ImmutableMetricPack buildResult = actualFromResult.build();
    assertEquals(1, buildResult.checkpoints().size());
    assertEquals(1, builderResult.build().checkpoints().size());
    List<MetricPackItem> itemsResult = buildResult.items();
    assertTrue(itemsResult.isEmpty());
    assertSame(itemsResult, buildResult.relatedReferences());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenReturn(null);
    when(instance.checkpoints()).thenReturn(new ArrayList<>());
    when(instance.items()).thenReturn(new ArrayList<>());
    when(instance.relatedReferences()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertNull(actualFromResult.build().description());
    assertNull(builderResult.build().description());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Then return build relatedReferences size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; then return build relatedReferences size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_thenReturnBuildRelatedReferencesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

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
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).id();
    verify(instance).name();
    verify(instance).checkpoints();
    verify(instance).items();
    verify(instance).relatedReferences();
    assertEquals(1, actualFromResult.build().relatedReferences().size());
    assertEquals(1, builderResult.build().relatedReferences().size());
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    MetricPack instance = mock(MetricPack.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#items(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#items(Iterable)}
   */
  @Test
  @DisplayName("Test Builder items(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.items(Iterable)"})
  void testBuilderItems_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.items(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableMetricPack buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#relatedReferences(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#relatedReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder relatedReferences(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.relatedReferences(Iterable)"})
  void testBuilderRelatedReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.relatedReferences(new ArrayList<>()));
  }

  /**
   * Test Json {@link Json#checkpoints()}.
   * <p>
   * Method under test: {@link Json#checkpoints()}
   */
  @Test
  @DisplayName("Test Json checkpoints()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.checkpoints()"})
  void testJsonCheckpoints() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).checkpoints());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#items()}.
   * <p>
   * Method under test: {@link Json#items()}
   */
  @Test
  @DisplayName("Test Json items()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.items()"})
  void testJsonItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).items());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.checkpoints.isEmpty());
    assertTrue(actualJson.items.isEmpty());
    assertTrue(actualJson.relatedReferences.isEmpty());
  }

  /**
   * Test Json {@link Json#relatedReferences()}.
   * <p>
   * Method under test: {@link Json#relatedReferences()}
   */
  @Test
  @DisplayName("Test Json relatedReferences()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.relatedReferences()"})
  void testJsonRelatedReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).relatedReferences());
  }
}
