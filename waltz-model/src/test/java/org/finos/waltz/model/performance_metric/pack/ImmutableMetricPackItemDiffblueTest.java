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
import java.util.Optional;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPackItem.Builder;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPackItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGoals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllGoals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGoals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllGoals(Iterable)"})
  void testBuilderAddAllGoals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllGoals(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addGoals(CheckpointGoal)} with {@code element}.
   * <ul>
   *   <li>When {@link CheckpointGoal}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGoals(CheckpointGoal)}
   */
  @Test
  @DisplayName("Test Builder addGoals(CheckpointGoal) with 'element'; when CheckpointGoal; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGoals(CheckpointGoal)"})
  void testBuilderAddGoalsWithElement_whenCheckpointGoal_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGoals(mock(CheckpointGoal.class)));
  }

  /**
   * Test Builder {@link Builder#addGoals(CheckpointGoal[])} with {@code elements}.
   * <ul>
   *   <li>When {@link CheckpointGoal}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addGoals(CheckpointGoal[])}
   */
  @Test
  @DisplayName("Test Builder addGoals(CheckpointGoal[]) with 'elements'; when CheckpointGoal; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addGoals(CheckpointGoal[])"})
  void testBuilderAddGoalsWithElements_whenCheckpointGoal_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addGoals(mock(CheckpointGoal.class)));
  }

  /**
   * Test Builder {@link Builder#baseLine(double)}.
   * <p>
   * Method under test: {@link Builder#baseLine(double)}
   */
  @Test
  @DisplayName("Test Builder baseLine(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.baseLine(double)"})
  void testBuilderBaseLine() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.baseLine(10.0d));
  }

  /**
   * Test Builder {@link Builder#definitionId(long)}.
   * <p>
   * Method under test: {@link Builder#definitionId(long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definitionId(long)"})
  void testBuilderDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionId(1L));
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
    Builder builderResult = ImmutableMetricPackItem.builder();
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
    Builder builderResult = ImmutableMetricPackItem.builder();
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
    Builder builderResult = ImmutableMetricPackItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link MetricPackItem} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPackItem) with 'MetricPackItem'; given empty; when MetricPackItem id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem_givenEmpty_whenMetricPackItemIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    ImmutableMetricPackItem buildResult = actualFromResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(10.0d, buildResult.baseLine());
    assertEquals(1L, buildResult.definitionId());
    assertTrue(buildResult.goals().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   * <ul>
   *   <li>Then builder build sectionName is {@code Section Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPackItem) with 'MetricPackItem'; then builder build sectionName is 'Section Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem_thenBuilderBuildSectionNameIsSectionName() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   * <ul>
   *   <li>Then return build sectionName is {@code Section Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPackItem) with 'MetricPackItem'; then return build sectionName is 'Section Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem_thenReturnBuildSectionNameIsSectionName() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenReturn(10.0d);
    when(instance.goals()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.definitionId()).thenReturn(1L);
    when(instance.sectionName()).thenReturn("Section Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    verify(instance).baseLine();
    verify(instance).definitionId();
    verify(instance).goals();
    verify(instance).sectionName();
    ImmutableMetricPackItem buildResult = actualFromResult.build();
    assertEquals("Section Name", buildResult.sectionName());
    assertEquals(10.0d, buildResult.baseLine());
    assertEquals(1L, buildResult.definitionId());
    assertTrue(buildResult.goals().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPackItem) with 'MetricPackItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();
    MetricPackItem instance = mock(MetricPackItem.class);
    when(instance.baseLine()).thenThrow(new IllegalStateException("instance"));
    when(instance.sectionName()).thenReturn("Section Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).baseLine();
    verify(instance).sectionName();
  }

  /**
   * Test Builder {@link Builder#goals(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#goals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder goals(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.goals(Iterable)"})
  void testBuilderGoals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.goals(new ArrayList<>()));
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
    Builder builderResult = ImmutableMetricPackItem.builder();

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
    Builder builderResult = ImmutableMetricPackItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#sectionName(String)}.
   * <p>
   * Method under test: {@link Builder#sectionName(String)}
   */
  @Test
  @DisplayName("Test Builder sectionName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sectionName(String)"})
  void testBuilderSectionName() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.sectionName("Section Name"));
  }

  /**
   * Test Json {@link Json#baseLine()}.
   * <p>
   * Method under test: {@link Json#baseLine()}
   */
  @Test
  @DisplayName("Test Json baseLine()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"double Json.baseLine()"})
  void testJsonBaseLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).baseLine());
  }

  /**
   * Test Json {@link Json#definitionId()}.
   * <p>
   * Method under test: {@link Json#definitionId()}
   */
  @Test
  @DisplayName("Test Json definitionId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.definitionId()"})
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definitionId());
  }

  /**
   * Test Json {@link Json#goals()}.
   * <p>
   * Method under test: {@link Json#goals()}
   */
  @Test
  @DisplayName("Test Json goals()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Json.goals()"})
  void testJsonGoals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).goals());
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
    assertNull(actualJson.sectionName);
    assertEquals(0.0d, actualJson.baseLine);
    assertEquals(0L, actualJson.definitionId);
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.baseLineIsSet);
    assertFalse(actualJson.definitionIdIsSet);
    assertTrue(actualJson.goals.isEmpty());
  }

  /**
   * Test Json {@link Json#sectionName()}.
   * <p>
   * Method under test: {@link Json#sectionName()}
   */
  @Test
  @DisplayName("Test Json sectionName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).sectionName());
  }

  /**
   * Test Json {@link Json#setBaseLine(double)}.
   * <p>
   * Method under test: {@link Json#setBaseLine(double)}
   */
  @Test
  @DisplayName("Test Json setBaseLine(double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setBaseLine(double)"})
  void testJsonSetBaseLine() {
    // Arrange
    Json json = new Json();

    // Act
    json.setBaseLine(10.0d);

    // Assert
    assertEquals(10.0d, json.baseLine);
    assertTrue(json.baseLineIsSet);
  }

  /**
   * Test Json {@link Json#setDefinitionId(long)}.
   * <p>
   * Method under test: {@link Json#setDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setDefinitionId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setDefinitionId(long)"})
  void testJsonSetDefinitionId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDefinitionId(1L);

    // Assert
    assertEquals(1L, json.definitionId);
    assertTrue(json.definitionIdIsSet);
  }
}
