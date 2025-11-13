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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.checkpoint.CheckpointGoal;
import org.finos.waltz.model.checkpoint.GoalType;
import org.finos.waltz.model.checkpoint.ImmutableCheckpointGoal;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPackItem.Builder;
import org.finos.waltz.model.performance_metric.pack.ImmutableMetricPackItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMetricPackItemDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllGoals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllGoals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllGoals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllGoals(Iterable)"})
  void testBuilderAddAllGoals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualAddAllGoalsResult = builderResult.addAllGoals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllGoalsResult);
  }

  /**
   * Test Builder {@link Builder#addGoals(CheckpointGoal)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGoals(CheckpointGoal)}
   */
  @Test
  @DisplayName("Test Builder addGoals(CheckpointGoal) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGoals(CheckpointGoal)"})
  void testBuilderAddGoalsWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualAddGoalsResult =
        builderResult.addGoals(
            ImmutableCheckpointGoal.builder()
                .checkpointId(1L)
                .goalType(GoalType.ABOVE_THRESHOLD)
                .value(10.0d)
                .build());

    // Assert
    assertSame(builderResult, actualAddGoalsResult);
  }

  /**
   * Test Builder {@link Builder#addGoals(CheckpointGoal[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addGoals(CheckpointGoal[])}
   */
  @Test
  @DisplayName("Test Builder addGoals(CheckpointGoal[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addGoals(CheckpointGoal[])"})
  void testBuilderAddGoalsWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualAddGoalsResult =
        builderResult.addGoals(
            ImmutableCheckpointGoal.builder()
                .checkpointId(1L)
                .goalType(GoalType.ABOVE_THRESHOLD)
                .value(10.0d)
                .build());

    // Assert
    assertSame(builderResult, actualAddGoalsResult);
  }

  /**
   * Test Builder {@link Builder#baseLine(double)}.
   *
   * <p>Method under test: {@link Builder#baseLine(double)}
   */
  @Test
  @DisplayName("Test Builder baseLine(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.baseLine(double)"})
  void testBuilderBaseLine() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualBaseLineResult = builderResult.baseLine(10.0d);

    // Assert
    assertSame(builderResult, actualBaseLineResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualIdResult =
        ImmutableMetricPackItem.builder().baseLine(10.0d).definitionId(1L).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableMetricPackItem actualImmutableMetricPackItem =
        actualIdResult.id(id).sectionName("Section Name").build();

    // Assert
    assertEquals("Section Name", actualImmutableMetricPackItem.sectionName());
    assertEquals(10.0d, actualImmutableMetricPackItem.baseLine());
    assertEquals(1L, actualImmutableMetricPackItem.definitionId());
    assertTrue(actualImmutableMetricPackItem.goals().isEmpty());
  }

  /**
   * Test Builder {@link Builder#definitionId(long)}.
   *
   * <p>Method under test: {@link Builder#definitionId(long)}
   */
  @Test
  @DisplayName("Test Builder definitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.definitionId(long)"})
  void testBuilderDefinitionId() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualDefinitionIdResult = builderResult.definitionId(1L);

    // Assert
    assertSame(builderResult, actualDefinitionIdResult);
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
    Builder builderResult = ImmutableMetricPackItem.builder();
    ImmutableMetricPackItem instance =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    ImmutableMetricPackItem actualImmutableMetricPackItem =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableMetricPackItem);
    ImmutableMetricPackItem actualImmutableMetricPackItem2 = builderResult.build();
    assertEquals(instance, actualImmutableMetricPackItem2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_thenReturnBuilder() {
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
    Builder builderResult = ImmutableMetricPackItem.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   *
   * <p>Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName("Test Builder from(MetricPackItem) with 'MetricPackItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();
    ImmutableMetricPackItem instance =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMetricPackItem actualImmutableMetricPackItem = builderResult.build();
    assertEquals(instance, actualImmutableMetricPackItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MetricPackItem)} with {@code MetricPackItem}.
   *
   * <ul>
   *   <li>Then return build goals size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MetricPackItem)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MetricPackItem) with 'MetricPackItem'; then return build goals size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MetricPackItem)"})
  void testBuilderFromWithMetricPackItem_thenReturnBuildGoalsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    Builder builderResult2 = ImmutableMetricPackItem.builder();
    builderResult2.addGoals(
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build());

    // Act and Assert
    List<CheckpointGoal> goalsResult =
        builderResult
            .from(
                builderResult2
                    .baseLine(10.0d)
                    .definitionId(1L)
                    .id(1L)
                    .sectionName("Section Name")
                    .build())
            .build()
            .goals();
    assertEquals(1, goalsResult.size());
    CheckpointGoal getResult = goalsResult.get(0);
    assertTrue(getResult instanceof ImmutableCheckpointGoal);
    assertEquals(10.0d, getResult.value());
    assertEquals(1L, getResult.checkpointId());
    assertEquals(GoalType.ABOVE_THRESHOLD, getResult.goalType());
  }

  /**
   * Test Builder {@link Builder#goals(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#goals(Iterable)}
   */
  @Test
  @DisplayName("Test Builder goals(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.goals(Iterable)"})
  void testBuilderGoals_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualGoalsResult = builderResult.goals(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualGoalsResult);
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
    Builder builderResult = ImmutableMetricPackItem.builder();

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
    Builder builderResult = ImmutableMetricPackItem.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#sectionName(String)}.
   *
   * <ul>
   *   <li>When {@code Section Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sectionName(String)}
   */
  @Test
  @DisplayName("Test Builder sectionName(String); when 'Section Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sectionName(String)"})
  void testBuilderSectionName_whenSectionName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();

    // Act
    Builder actualSectionNameResult = builderResult.sectionName("Section Name");

    // Assert
    assertSame(builderResult, actualSectionNameResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}.
   *
   * <ul>
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#copyOf(MetricPackItem)}
   */
  @Test
  @DisplayName("Test copyOf(MetricPackItem); then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.copyOf(MetricPackItem)"})
  void testCopyOf_thenReturnSectionName() {
    // Arrange
    ImmutableMetricPackItem instance =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableMetricPackItem actualCopyOfResult = ImmutableMetricPackItem.copyOf(instance);

    // Assert
    assertEquals("Section Name", actualCopyOfResult.sectionName());
    assertEquals(10.0d, actualCopyOfResult.baseLine());
    assertEquals(1L, actualCopyOfResult.definitionId());
    assertTrue(actualCopyOfResult.goals().isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}, and {@link
   * ImmutableMetricPackItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPackItem#equals(Object)}
   *   <li>{@link ImmutableMetricPackItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();
    ImmutableMetricPackItem immutableMetricPackItem2 =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertEquals(immutableMetricPackItem, immutableMetricPackItem2);
    assertEquals(immutableMetricPackItem.hashCode(), immutableMetricPackItem2.hashCode());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}, and {@link
   * ImmutableMetricPackItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPackItem#equals(Object)}
   *   <li>{@link ImmutableMetricPackItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertEquals(immutableMetricPackItem, immutableMetricPackItem);
    int expectedHashCodeResult = immutableMetricPackItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableMetricPackItem.hashCode());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMetricPackItem.builder();
    builderResult.addGoals(
        ImmutableCheckpointGoal.builder()
            .checkpointId(1L)
            .goalType(GoalType.ABOVE_THRESHOLD)
            .value(10.0d)
            .build());
    ImmutableMetricPackItem immutableMetricPackItem =
        builderResult.baseLine(10.0d).definitionId(1L).id(1L).sectionName("Section Name").build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPackItem,
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(0.5d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPackItem,
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(2L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPackItem,
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(2L)
            .sectionName("Section Name")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPackItem,
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("baseLine")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableMetricPackItem,
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build());
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMetricPackItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMetricPackItem.equals(Object)",
    "int ImmutableMetricPackItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build(),
        "Different type to ImmutableMetricPackItem");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMetricPackItem#baseLine()}
   *   <li>{@link ImmutableMetricPackItem#definitionId()}
   *   <li>{@link ImmutableMetricPackItem#goals()}
   *   <li>{@link ImmutableMetricPackItem#sectionName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "double ImmutableMetricPackItem.baseLine()",
    "long ImmutableMetricPackItem.definitionId()",
    "List ImmutableMetricPackItem.goals()",
    "String ImmutableMetricPackItem.sectionName()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    double actualBaseLineResult = immutableMetricPackItem.baseLine();
    long actualDefinitionIdResult = immutableMetricPackItem.definitionId();
    List<CheckpointGoal> actualGoalsResult = immutableMetricPackItem.goals();

    // Assert
    assertEquals("Section Name", immutableMetricPackItem.sectionName());
    assertEquals(10.0d, actualBaseLineResult);
    assertEquals(1L, actualDefinitionIdResult);
    assertTrue(actualGoalsResult.isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#id()}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableMetricPackItem.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#baseLine()}.
   *
   * <p>Method under test: {@link Json#baseLine()}
   */
  @Test
  @DisplayName("Test Json baseLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double Json.baseLine()"})
  void testJsonBaseLine() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().baseLine());
  }

  /**
   * Test Json {@link Json#definitionId()}.
   *
   * <p>Method under test: {@link Json#definitionId()}
   */
  @Test
  @DisplayName("Test Json definitionId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.definitionId()"})
  void testJsonDefinitionId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().definitionId());
  }

  /**
   * Test Json {@link Json#goals()}.
   *
   * <p>Method under test: {@link Json#goals()}
   */
  @Test
  @DisplayName("Test Json goals()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.goals()"})
  void testJsonGoals() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().goals());
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
   *
   * <p>Method under test: {@link Json#sectionName()}
   */
  @Test
  @DisplayName("Test Json sectionName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.sectionName()"})
  void testJsonSectionName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sectionName());
  }

  /**
   * Test Json {@link Json#setBaseLine(double)}.
   *
   * <p>Method under test: {@link Json#setBaseLine(double)}
   */
  @Test
  @DisplayName("Test Json setBaseLine(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Json#setDefinitionId(long)}
   */
  @Test
  @DisplayName("Test Json setDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableMetricPackItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableMetricPackItem.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "MetricPackItem{id=1, definitionId=1, sectionName=Section Name, baseLine=10.0, goals=[]}",
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withBaseLine(double)}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withBaseLine(double)}
   */
  @Test
  @DisplayName("Test withBaseLine(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withBaseLine(double)"})
  void testWithBaseLine() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableMetricPackItem actualWithBaseLineResult = immutableMetricPackItem.withBaseLine(10.0d);

    // Assert
    assertSame(immutableMetricPackItem, actualWithBaseLineResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#withBaseLine(double)}.
   *
   * <ul>
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withBaseLine(double)}
   */
  @Test
  @DisplayName("Test withBaseLine(double); then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withBaseLine(double)"})
  void testWithBaseLine_thenReturnSectionName() {
    // Arrange and Act
    ImmutableMetricPackItem actualWithBaseLineResult =
        ImmutableMetricPackItem.builder()
            .baseLine(0.5d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .withBaseLine(10.0d);

    // Assert
    assertEquals("Section Name", actualWithBaseLineResult.sectionName());
    assertEquals(10.0d, actualWithBaseLineResult.baseLine());
    assertEquals(1L, actualWithBaseLineResult.definitionId());
    assertTrue(actualWithBaseLineResult.goals().isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withDefinitionId(long)}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withDefinitionId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withDefinitionId(long)"})
  void testWithDefinitionId() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(42L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableMetricPackItem actualWithDefinitionIdResult =
        immutableMetricPackItem.withDefinitionId(42L);

    // Assert
    assertSame(immutableMetricPackItem, actualWithDefinitionIdResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#withDefinitionId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withDefinitionId(long)}
   */
  @Test
  @DisplayName("Test withDefinitionId(long); then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withDefinitionId(long)"})
  void testWithDefinitionId_thenReturnSectionName() {
    // Arrange and Act
    ImmutableMetricPackItem actualWithDefinitionIdResult =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .withDefinitionId(42L);

    // Assert
    assertEquals("Section Name", actualWithDefinitionIdResult.sectionName());
    assertEquals(10.0d, actualWithDefinitionIdResult.baseLine());
    assertEquals(42L, actualWithDefinitionIdResult.definitionId());
    assertTrue(actualWithDefinitionIdResult.goals().isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withGoals(CheckpointGoal[])} with {@code CheckpointGoal[]}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withGoals(CheckpointGoal[])}
   */
  @Test
  @DisplayName("Test withGoals(CheckpointGoal[]) with 'CheckpointGoal[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withGoals(CheckpointGoal[])"})
  void testWithGoalsWithCheckpointGoal() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableMetricPackItem actualWithGoalsResult =
        immutableMetricPackItem.withGoals(
            ImmutableCheckpointGoal.builder()
                .checkpointId(1L)
                .goalType(GoalType.ABOVE_THRESHOLD)
                .value(10.0d)
                .build());

    // Assert
    List<CheckpointGoal> goalsResult = actualWithGoalsResult.goals();
    assertEquals(1, goalsResult.size());
    CheckpointGoal getResult = goalsResult.get(0);
    assertTrue(getResult instanceof ImmutableCheckpointGoal);
    assertEquals("Section Name", actualWithGoalsResult.sectionName());
    assertEquals(10.0d, getResult.value());
    assertEquals(10.0d, actualWithGoalsResult.baseLine());
    assertEquals(1L, getResult.checkpointId());
    assertEquals(1L, actualWithGoalsResult.definitionId());
    assertEquals(GoalType.ABOVE_THRESHOLD, getResult.goalType());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableMetricPackItem actualWithIdResult = immutableMetricPackItem.withId(optional);

    // Assert
    assertSame(immutableMetricPackItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; when of forty-two; then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnSectionName() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableMetricPackItem actualWithIdResult = immutableMetricPackItem.withId(optional);

    // Assert
    assertEquals("Section Name", actualWithIdResult.sectionName());
    assertEquals(10.0d, actualWithIdResult.baseLine());
    assertEquals(1L, actualWithIdResult.definitionId());
    assertTrue(actualWithIdResult.goals().isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build();

    // Act
    ImmutableMetricPackItem actualWithIdResult = immutableMetricPackItem.withId(1L);

    // Assert
    assertSame(immutableMetricPackItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Section Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Section Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnSectionName() {
    // Arrange and Act
    ImmutableMetricPackItem actualWithIdResult =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .withId(42L);

    // Assert
    assertEquals("Section Name", actualWithIdResult.sectionName());
    assertEquals(10.0d, actualWithIdResult.baseLine());
    assertEquals(1L, actualWithIdResult.definitionId());
    assertTrue(actualWithIdResult.goals().isEmpty());
  }

  /**
   * Test {@link ImmutableMetricPackItem#withSectionName(String)}.
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withSectionName(String)"})
  void testWithSectionName() {
    // Arrange
    ImmutableMetricPackItem immutableMetricPackItem =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("42")
            .build();

    // Act
    ImmutableMetricPackItem actualWithSectionNameResult =
        immutableMetricPackItem.withSectionName("42");

    // Assert
    assertSame(immutableMetricPackItem, actualWithSectionNameResult);
  }

  /**
   * Test {@link ImmutableMetricPackItem#withSectionName(String)}.
   *
   * <ul>
   *   <li>Then return sectionName is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMetricPackItem#withSectionName(String)}
   */
  @Test
  @DisplayName("Test withSectionName(String); then return sectionName is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMetricPackItem ImmutableMetricPackItem.withSectionName(String)"})
  void testWithSectionName_thenReturnSectionNameIs42() {
    // Arrange and Act
    ImmutableMetricPackItem actualWithSectionNameResult =
        ImmutableMetricPackItem.builder()
            .baseLine(10.0d)
            .definitionId(1L)
            .id(1L)
            .sectionName("Section Name")
            .build()
            .withSectionName("42");

    // Assert
    assertEquals("42", actualWithSectionNameResult.sectionName());
    assertEquals(10.0d, actualWithSectionNameResult.baseLine());
    assertEquals(1L, actualWithSectionNameResult.definitionId());
    assertTrue(actualWithSectionNameResult.goals().isEmpty());
  }
}
