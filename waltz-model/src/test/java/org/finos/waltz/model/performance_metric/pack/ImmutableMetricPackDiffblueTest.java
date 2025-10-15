package org.finos.waltz.model.performance_metric.pack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.Quarter;
import org.finos.waltz.model.checkpoint.Checkpoint;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.finos.waltz.model.checkpoint.ImmutableCheckpoint;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPack.Builder;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPack.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllCheckpoints(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllCheckpoints(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllCheckpoints(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllCheckpoints(Iterable)"})
  void testBuilderAddAllCheckpoints_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddAllCheckpointsResult = builderResult.addAllCheckpoints(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllCheckpointsResult);
  }

  /**
   * Test Builder {@link Builder#addAllItems(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllItems(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllItems(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllItems(Iterable)"})
  void testBuilderAddAllItems_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddAllItemsResult = builderResult.addAllItems(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllItemsResult);
  }

  /**
   * Test Builder {@link Builder#addAllRelatedReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllRelatedReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRelatedReferences(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllRelatedReferences(Iterable)"})
  void testBuilderAddAllRelatedReferences_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddAllRelatedReferencesResult =
        builderResult.addAllRelatedReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllRelatedReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addCheckpoints(Checkpoint)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link Checkpoint}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCheckpoints(Checkpoint)}
   */
  @Test
  @DisplayName(
      "Test Builder addCheckpoints(Checkpoint) with 'element'; when Checkpoint; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCheckpoints(Checkpoint)"})
  void testBuilderAddCheckpointsWithElement_whenCheckpoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddCheckpointsResult = builderResult.addCheckpoints(mock(Checkpoint.class));

    // Assert
    assertSame(builderResult, actualAddCheckpointsResult);
  }

  /**
   * Test Builder {@link Builder#addCheckpoints(Checkpoint[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link Checkpoint}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addCheckpoints(Checkpoint[])}
   */
  @Test
  @DisplayName(
      "Test Builder addCheckpoints(Checkpoint[]) with 'elements'; when Checkpoint; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addCheckpoints(Checkpoint[])"})
  void testBuilderAddCheckpointsWithElements_whenCheckpoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddCheckpointsResult = builderResult.addCheckpoints(mock(Checkpoint.class));

    // Assert
    assertSame(builderResult, actualAddCheckpointsResult);
  }

  /**
   * Test Builder {@link Builder#addItems(MetricPackItem)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableMetricPackItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addItems(MetricPackItem)}
   */
  @Test
  @DisplayName(
      "Test Builder addItems(MetricPackItem) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addItems(MetricPackItem)"})
  void testBuilderAddItemsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddItemsResult = builderResult.addItems(new ImmutableMetricPackItem.Json());

    // Assert
    assertSame(builderResult, actualAddItemsResult);
  }

  /**
   * Test Builder {@link Builder#addItems(MetricPackItem[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableMetricPackItem.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addItems(MetricPackItem[])}
   */
  @Test
  @DisplayName(
      "Test Builder addItems(MetricPackItem[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addItems(MetricPackItem[])"})
  void testBuilderAddItemsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddItemsResult = builderResult.addItems(new ImmutableMetricPackItem.Json());

    // Assert
    assertSame(builderResult, actualAddItemsResult);
  }

  /**
   * Test Builder {@link Builder#addRelatedReferences(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRelatedReferences(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addRelatedReferences(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRelatedReferences(EntityReference)"})
  void testBuilderAddRelatedReferencesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddRelatedReferencesResult =
        builderResult.addRelatedReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddRelatedReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addRelatedReferences(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addRelatedReferences(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addRelatedReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addRelatedReferences(EntityReference[])"})
  void testBuilderAddRelatedReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualAddRelatedReferencesResult =
        builderResult.addRelatedReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddRelatedReferencesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack Builder.build()", "Builder Builder.description(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableMetricPack actualImmutableMetricPack = actualIdResult.id(id).name("Name").build();

    // Assert
    assertEquals("Name", actualImmutableMetricPack.name());
    assertEquals(
        "The characteristics of someone or something", actualImmutableMetricPack.description());
    assertTrue(actualImmutableMetricPack.checkpoints().isEmpty());
  }

  /**
   * Test Builder {@link Builder#checkpoints(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#checkpoints(Iterable)}
   */
  @Test
  @DisplayName("Test Builder checkpoints(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.checkpoints(Iterable)"})
  void testBuilderCheckpoints_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualCheckpointsResult = builderResult.checkpoints(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualCheckpointsResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    ImmutableMetricPack instance =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    ImmutableMetricPack actualImmutableMetricPack =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableMetricPack);
    ImmutableMetricPack actualImmutableMetricPack2 = builderResult.build();
    assertEquals(instance, actualImmutableMetricPack2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
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
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    ImmutableMetricPack instance =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    ImmutableMetricPack actualImmutableMetricPack =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableMetricPack);
    ImmutableMetricPack actualImmutableMetricPack2 = builderResult.build();
    assertEquals(instance, actualImmutableMetricPack2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MetricPack)} with {@code MetricPack}.
   *
   * <p>Method under test: {@link Builder#from(MetricPack)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPack) with 'MetricPack'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MetricPack)"})
  void testBuilderFromWithMetricPack() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    ImmutableMetricPack instance =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMetricPack actualImmutableMetricPack = builderResult.build();
    assertEquals(instance, actualImmutableMetricPack);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    ImmutableMetricPack instance =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    ImmutableMetricPack actualImmutableMetricPack =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableMetricPack);
    ImmutableMetricPack actualImmutableMetricPack2 = builderResult.build();
    assertEquals(instance, actualImmutableMetricPack2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    ImmutableMetricPack immutableMetricPack = builderResult.build();
    assertEquals("Name", immutableMetricPack.name());
    assertNull(actualFromResult.build().description());
    assertNull(immutableMetricPack.description());
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#items(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#items(Iterable)}
   */
  @Test
  @DisplayName("Test Builder items(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.items(Iterable)"})
  void testBuilderItems_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualItemsResult = builderResult.items(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualItemsResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableMetricPack immutableMetricPack = builderResult.build();
    assertEquals("Name", immutableMetricPack.name());
    assertNull(immutableMetricPack.description());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#relatedReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#relatedReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder relatedReferences(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.relatedReferences(Iterable)"})
  void testBuilderRelatedReferences_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();

    // Act
    Builder actualRelatedReferencesResult = builderResult.relatedReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualRelatedReferencesResult);
  }

  /**
   * Test {@link ImmutableMetricPack#copyOf(MetricPack)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#copyOf(MetricPack)}
   */
  @Test
  @DisplayName("Test copyOf(MetricPack); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.copyOf(MetricPack)"})
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableMetricPack instance =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualCopyOfResult = ImmutableMetricPack.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    List<Checkpoint> checkpointsResult = actualCopyOfResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualCopyOfResult.items());
    assertSame(checkpointsResult, actualCopyOfResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}, and {@link ImmutableMetricPack#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPack#equals(Object)}
   *   <li>{@link ImmutableMetricPack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    ImmutableMetricPack immutableMetricPack2 =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableMetricPack, immutableMetricPack2);
    assertEquals(immutableMetricPack.hashCode(), immutableMetricPack2.hashCode());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}, and {@link ImmutableMetricPack#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPack#equals(Object)}
   *   <li>{@link ImmutableMetricPack#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertEquals(immutableMetricPack, immutableMetricPack);
    int expectedHashCodeResult = immutableMetricPack.hashCode();
    assertEquals(expectedHashCodeResult, immutableMetricPack.hashCode());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addCheckpoints(
        ImmutableCheckpoint.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .quarter(Quarter.Q1)
            .year(1)
            .build());
    ImmutableMetricPack immutableMetricPack =
        builderResult
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPack,
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addItems(
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
    ImmutableMetricPack immutableMetricPack =
        builderResult
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPack,
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMetricPack.builder();
    builderResult.addRelatedReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableMetricPack immutableMetricPack =
        builderResult
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPack,
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMetricPack#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPack.equals(Object)",
    "int ImmutableMetricPack.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build(),
        "Different type to ImmutableMetricPack");
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Checkpoint}.
   *   <li>Then return name is {@code checkpoints element}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Checkpoint; then return name is 'checkpoints element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_givenArrayListAddCheckpoint_thenReturnNameIsCheckpointsElement() {
    // Arrange
    ArrayList<Checkpoint> checkpoints = new ArrayList<>();
    checkpoints.add(mock(Checkpoint.class));

    Json json = new Json();
    json.setId(null);
    json.setName("checkpoints element");
    json.setDescription(null);
    json.setCheckpoints(checkpoints);
    json.setItems(null);
    json.setRelatedReferences(null);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    assertEquals("checkpoints element", actualFromJsonResult.name());
    assertEquals(1, actualFromJsonResult.checkpoints().size());
    List<MetricPackItem> itemsResult = actualFromJsonResult.items();
    assertTrue(itemsResult.isEmpty());
    assertSame(itemsResult, actualFromJsonResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableMetricPackItem.Json} (default
   *       constructor).
   *   <li>Then return name is {@code items element}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return name is 'items element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnNameIsItemsElement() {
    // Arrange
    ArrayList<MetricPackItem> items = new ArrayList<>();
    ImmutableMetricPackItem.Json json = new ImmutableMetricPackItem.Json();
    items.add(json);

    Json json2 = new Json();
    json2.setId(null);
    json2.setName("items element");
    json2.setDescription(null);
    json2.setCheckpoints(null);
    json2.setItems(items);
    json2.setRelatedReferences(null);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json2);

    // Assert
    assertEquals("items element", actualFromJsonResult.name());
    assertEquals(items, actualFromJsonResult.items());
    List<CheckpointGoal> expectedRelatedReferencesResult = json.goals;
    assertSame(expectedRelatedReferencesResult, actualFromJsonResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Name is {@code name}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Name is 'name'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_givenName_whenJsonNameIsName_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("name");
    json.setDescription(null);
    json.setCheckpoints(null);
    json.setItems(null);
    json.setRelatedReferences(null);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    List<Checkpoint> checkpointsResult = actualFromJsonResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualFromJsonResult.items());
    assertSame(checkpointsResult, actualFromJsonResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code name}.
   *   <li>When {@link Json} (default constructor) Name is {@code name}.
   *   <li>Then return items is {@link Json} (default constructor) {@link Json#relatedReferences}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'name'; when Json (default constructor) Name is 'name'; then return items is Json (default constructor) relatedReferences")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_givenName_whenJsonNameIsName_thenReturnItemsIsJsonRelatedReferences() {
    // Arrange
    Json json = new Json();
    json.setName("name");

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    List<EntityReference> entityReferenceList = json.relatedReferences;
    assertSame(entityReferenceList, actualFromJsonResult.items());
    assertSame(entityReferenceList, actualFromJsonResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return description is {@code The characteristics of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_thenReturnDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("name");
    json.setDescription("The characteristics of someone or something");
    json.setCheckpoints(null);
    json.setItems(null);
    json.setRelatedReferences(null);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    assertEquals("The characteristics of someone or something", actualFromJsonResult.description());
    assertEquals("name", actualFromJsonResult.name());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return name is {@code relatedReferences element}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return name is 'relatedReferences element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_thenReturnNameIsRelatedReferencesElement() {
    // Arrange
    ArrayList<EntityReference> relatedReferences = new ArrayList<>();
    relatedReferences.add(mock(EntityReference.class));

    Json json = new Json();
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
    assertEquals(1, actualFromJsonResult.relatedReferences().size());
  }

  /**
   * Test {@link ImmutableMetricPack#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return relatedReferences size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return relatedReferences size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.fromJson(Json)"})
  void testFromJson_thenReturnRelatedReferencesSizeIsTwo() {
    // Arrange
    ArrayList<EntityReference> relatedReferences = new ArrayList<>();
    relatedReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    relatedReferences.add(mock(EntityReference.class));

    Json json = new Json();
    json.setId(null);
    json.setName("relatedReferences element");
    json.setDescription(null);
    json.setCheckpoints(null);
    json.setItems(null);
    json.setRelatedReferences(relatedReferences);

    // Act
    ImmutableMetricPack actualFromJsonResult = ImmutableMetricPack.fromJson(json);

    // Assert
    List<EntityReference> relatedReferencesResult = actualFromJsonResult.relatedReferences();
    assertEquals(2, relatedReferencesResult.size());
    EntityReference getResult = relatedReferencesResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPack#checkpoints()}
   *   <li>{@link ImmutableMetricPack#description()}
   *   <li>{@link ImmutableMetricPack#items()}
   *   <li>{@link ImmutableMetricPack#name()}
   *   <li>{@link ImmutableMetricPack#relatedReferences()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableMetricPack.checkpoints()",
    "String ImmutableMetricPack.description()",
    "List ImmutableMetricPack.items()",
    "String ImmutableMetricPack.name()",
    "List ImmutableMetricPack.relatedReferences()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    List<Checkpoint> actualCheckpointsResult = immutableMetricPack.checkpoints();
    String actualDescriptionResult = immutableMetricPack.description();
    List<MetricPackItem> actualItemsResult = immutableMetricPack.items();
    String actualNameResult = immutableMetricPack.name();
    List<EntityReference> actualRelatedReferencesResult = immutableMetricPack.relatedReferences();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertTrue(actualCheckpointsResult.isEmpty());
    assertSame(actualCheckpointsResult, actualItemsResult);
    assertSame(actualCheckpointsResult, actualRelatedReferencesResult);
  }

  /**
   * Test {@link ImmutableMetricPack#id()}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMetricPack.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#checkpoints()}.
   *
   * <p>Method under test: {@link Json#checkpoints()}
   */
  @Test
  @DisplayName("Test Json checkpoints()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.checkpoints()"})
  void testJsonCheckpoints() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().checkpoints());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#items()}.
   *
   * <p>Method under test: {@link Json#items()}
   */
  @Test
  @DisplayName("Test Json items()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.items()"})
  void testJsonItems() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().items());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#relatedReferences()}
   */
  @Test
  @DisplayName("Test Json relatedReferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.relatedReferences()"})
  void testJsonRelatedReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#toString()}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMetricPack.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "MetricPack{id=1, name=Name, checkpoints=[], items=[], relatedReferences=[]}",
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMetricPack#withCheckpoints(Checkpoint[])} with {@code Checkpoint[]}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withCheckpoints(Checkpoint[])}
   */
  @Test
  @DisplayName("Test withCheckpoints(Checkpoint[]) with 'Checkpoint[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withCheckpoints(Checkpoint[])"})
  void testWithCheckpointsWithCheckpoint() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualWithCheckpointsResult =
        immutableMetricPack.withCheckpoints(
            ImmutableCheckpoint.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .name("Name")
                .quarter(Quarter.Q1)
                .year(1)
                .build());

    // Assert
    List<Checkpoint> checkpointsResult = actualWithCheckpointsResult.checkpoints();
    assertEquals(1, checkpointsResult.size());
    Checkpoint getResult = checkpointsResult.get(0);
    assertTrue(getResult instanceof ImmutableCheckpoint);
    assertEquals("Name", getResult.name());
    assertEquals("Name", actualWithCheckpointsResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithCheckpointsResult.description());
    assertEquals(1, getResult.year());
    assertEquals(Quarter.Q1, getResult.quarter());
    List<MetricPackItem> itemsResult = actualWithCheckpointsResult.items();
    assertTrue(itemsResult.isEmpty());
    assertSame(itemsResult, actualWithCheckpointsResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualWithDescriptionResult = immutableMetricPack.withDescription("42");

    // Assert
    assertEquals(immutableMetricPack, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMetricPack#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return builder description {@code 42} id one name {@code Name} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#withDescription(String)}
   */
  @Test
  @DisplayName(
      "Test withDescription(String); then return builder description '42' id one name 'Name' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withDescription(String)"})
  void testWithDescription_thenReturnBuilderDescription42IdOneNameNameBuild() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder().description("42").id(1L).name("Name").build();

    // Act
    ImmutableMetricPack actualWithDescriptionResult = immutableMetricPack.withDescription("42");

    // Assert
    assertSame(immutableMetricPack, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableMetricPack#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMetricPack actualWithIdResult = immutableMetricPack.withId(optional);

    // Assert
    assertSame(immutableMetricPack, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMetricPack#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(2L)
            .name("Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMetricPack actualWithIdResult = immutableMetricPack.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    List<Checkpoint> checkpointsResult = actualWithIdResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualWithIdResult.items());
    assertSame(checkpointsResult, actualWithIdResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualWithIdResult = immutableMetricPack.withId(1L);

    // Assert
    assertSame(immutableMetricPack, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMetricPack#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableMetricPack actualWithIdResult =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    List<Checkpoint> checkpointsResult = actualWithIdResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualWithIdResult.items());
    assertSame(checkpointsResult, actualWithIdResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#withItems(MetricPackItem[])} with {@code MetricPackItem[]}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withItems(MetricPackItem[])}
   */
  @Test
  @DisplayName("Test withItems(MetricPackItem[]) with 'MetricPackItem[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withItems(MetricPackItem[])"})
  void testWithItemsWithMetricPackItem() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualWithItemsResult =
        immutableMetricPack.withItems(
            ImmutableMetricPackItem.builder()
                .baseLine(10.0d)
                .definitionId(1L)
                .id(1L)
                .sectionName("Section Name")
                .build());

    // Assert
    List<MetricPackItem> itemsResult = actualWithItemsResult.items();
    assertEquals(1, itemsResult.size());
    MetricPackItem getResult = itemsResult.get(0);
    assertTrue(getResult instanceof ImmutableMetricPackItem);
    assertEquals("Name", actualWithItemsResult.name());
    assertEquals("Section Name", getResult.sectionName());
    assertEquals(
        "The characteristics of someone or something", actualWithItemsResult.description());
    assertEquals(10.0d, getResult.baseLine());
    assertEquals(1L, getResult.definitionId());
    List<Checkpoint> checkpointsResult = actualWithItemsResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualWithItemsResult.relatedReferences());
    assertSame(checkpointsResult, getResult.goals());
  }

  /**
   * Test {@link ImmutableMetricPack#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("42")
            .build();

    // Act
    ImmutableMetricPack actualWithNameResult = immutableMetricPack.withName("42");

    // Assert
    assertSame(immutableMetricPack, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableMetricPack#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPack#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPack ImmutableMetricPack.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableMetricPack actualWithNameResult =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    List<Checkpoint> checkpointsResult = actualWithNameResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualWithNameResult.items());
    assertSame(checkpointsResult, actualWithNameResult.relatedReferences());
  }

  /**
   * Test {@link ImmutableMetricPack#withRelatedReferences(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link ImmutableMetricPack#withRelatedReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test withRelatedReferences(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMetricPack ImmutableMetricPack.withRelatedReferences(EntityReference[])"
  })
  void testWithRelatedReferencesWithEntityReference() {
    // Arrange
    ImmutableMetricPack immutableMetricPack =
        ImmutableMetricPack.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .build();

    // Act
    ImmutableMetricPack actualWithRelatedReferencesResult =
        immutableMetricPack.withRelatedReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    List<EntityReference> relatedReferencesResult =
        actualWithRelatedReferencesResult.relatedReferences();
    assertEquals(1, relatedReferencesResult.size());
    EntityReference getResult = relatedReferencesResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithRelatedReferencesResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRelatedReferencesResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    List<Checkpoint> checkpointsResult = actualWithRelatedReferencesResult.checkpoints();
    assertTrue(checkpointsResult.isEmpty());
    assertSame(checkpointsResult, actualWithRelatedReferencesResult.items());
  }
}
