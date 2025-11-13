package org.finos.waltz.jobs.tools.importers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.tools.importers.ImmutableScenarioRatingRow.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableScenarioRatingRowDiffblueTest {
  /**
   * Test Builder {@link Builder#assetCode(String)}.
   *
   * <ul>
   *   <li>When {@code Asset Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#assetCode(String)}
   */
  @Test
  @DisplayName("Test Builder assetCode(String); when 'Asset Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.assetCode(String)"})
  void testBuilderAssetCode_whenAssetCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualAssetCodeResult = builderResult.assetCode("Asset Code");

    // Assert
    assertSame(builderResult, actualAssetCodeResult);
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
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow Builder.build()",
    "Builder Builder.description(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualImmutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Assert
    assertEquals("Asset Code", actualImmutableScenarioRatingRow.assetCode());
    assertEquals("Column", actualImmutableScenarioRatingRow.column());
    assertEquals("Provided By", actualImmutableScenarioRatingRow.providedBy());
    assertEquals("Rating", actualImmutableScenarioRatingRow.rating());
    assertEquals("Roadmap", actualImmutableScenarioRatingRow.roadmap());
    assertEquals("Row", actualImmutableScenarioRatingRow.row());
    assertEquals("Scenario", actualImmutableScenarioRatingRow.scenario());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableScenarioRatingRow.description());
  }

  /**
   * Test Builder {@link Builder#column(String)}.
   *
   * <ul>
   *   <li>When {@code Column}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#column(String)}
   */
  @Test
  @DisplayName("Test Builder column(String); when 'Column'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.column(String)"})
  void testBuilderColumn_whenColumn_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualColumnResult = builderResult.column("Column");

    // Assert
    assertSame(builderResult, actualColumnResult);
  }

  /**
   * Test Builder {@link Builder#from(ScenarioRatingRow)}.
   *
   * <p>Method under test: {@link Builder#from(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingRow)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();
    ImmutableScenarioRatingRow instance =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableScenarioRatingRow actualImmutableScenarioRatingRow = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ScenarioRatingRow)}.
   *
   * <p>Method under test: {@link Builder#from(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test Builder from(ScenarioRatingRow)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ScenarioRatingRow)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();
    ImmutableScenarioRatingRow instance =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description(null)
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableScenarioRatingRow actualImmutableScenarioRatingRow = builderResult.build();
    assertEquals(instance, actualImmutableScenarioRatingRow);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#providedBy(String)}.
   *
   * <ul>
   *   <li>When {@code Provided By}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#providedBy(String)}
   */
  @Test
  @DisplayName("Test Builder providedBy(String); when 'Provided By'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.providedBy(String)"})
  void testBuilderProvidedBy_whenProvidedBy_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualProvidedByResult = builderResult.providedBy("Provided By");

    // Assert
    assertSame(builderResult, actualProvidedByResult);
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   *
   * <ul>
   *   <li>When {@code Rating}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String); when 'Rating'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating_whenRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test Builder {@link Builder#roadmap(String)}.
   *
   * <ul>
   *   <li>When {@code Roadmap}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#roadmap(String)}
   */
  @Test
  @DisplayName("Test Builder roadmap(String); when 'Roadmap'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.roadmap(String)"})
  void testBuilderRoadmap_whenRoadmap_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualRoadmapResult = builderResult.roadmap("Roadmap");

    // Assert
    assertSame(builderResult, actualRoadmapResult);
  }

  /**
   * Test Builder {@link Builder#row(String)}.
   *
   * <ul>
   *   <li>When {@code Row}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#row(String)}
   */
  @Test
  @DisplayName("Test Builder row(String); when 'Row'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.row(String)"})
  void testBuilderRow_whenRow_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualRowResult = builderResult.row("Row");

    // Assert
    assertSame(builderResult, actualRowResult);
  }

  /**
   * Test Builder {@link Builder#scenario(String)}.
   *
   * <ul>
   *   <li>When {@code Scenario}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#scenario(String)}
   */
  @Test
  @DisplayName("Test Builder scenario(String); when 'Scenario'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenario(String)"})
  void testBuilderScenario_whenScenario_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableScenarioRatingRow.builder();

    // Act
    Builder actualScenarioResult = builderResult.scenario("Scenario");

    // Assert
    assertSame(builderResult, actualScenarioResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#copyOf(ScenarioRatingRow)}.
   *
   * <ul>
   *   <li>Then return {@code Asset Code}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#copyOf(ScenarioRatingRow)}
   */
  @Test
  @DisplayName("Test copyOf(ScenarioRatingRow); then return 'Asset Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow ImmutableScenarioRatingRow.copyOf(ScenarioRatingRow)"
  })
  void testCopyOf_thenReturnAssetCode() {
    // Arrange
    ImmutableScenarioRatingRow instance =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualCopyOfResult = ImmutableScenarioRatingRow.copyOf(instance);

    // Assert
    assertEquals("Asset Code", actualCopyOfResult.assetCode());
    assertEquals("Column", actualCopyOfResult.column());
    assertEquals("Provided By", actualCopyOfResult.providedBy());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("Roadmap", actualCopyOfResult.roadmap());
    assertEquals("Row", actualCopyOfResult.row());
    assertEquals("Scenario", actualCopyOfResult.scenario());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}, and {@link
   * ImmutableScenarioRatingRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingRow#equals(Object)}
   *   <li>{@link ImmutableScenarioRatingRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();
    ImmutableScenarioRatingRow immutableScenarioRatingRow2 =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertEquals(immutableScenarioRatingRow, immutableScenarioRatingRow2);
    assertEquals(immutableScenarioRatingRow.hashCode(), immutableScenarioRatingRow2.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}, and {@link
   * ImmutableScenarioRatingRow#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingRow#equals(Object)}
   *   <li>{@link ImmutableScenarioRatingRow#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertEquals(immutableScenarioRatingRow, immutableScenarioRatingRow);
    int expectedHashCodeResult = immutableScenarioRatingRow.hashCode();
    assertEquals(expectedHashCodeResult, immutableScenarioRatingRow.hashCode());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Roadmap")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Roadmap")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("Roadmap")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Roadmap")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Roadmap")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Scenario")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Roadmap")
            .scenario("Scenario")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Roadmap")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableScenarioRatingRow,
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableScenarioRatingRow.equals(Object)",
    "int ImmutableScenarioRatingRow.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build(),
        "Different type to ImmutableScenarioRatingRow");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableScenarioRatingRow#toString()}
   *   <li>{@link ImmutableScenarioRatingRow#assetCode()}
   *   <li>{@link ImmutableScenarioRatingRow#column()}
   *   <li>{@link ImmutableScenarioRatingRow#description()}
   *   <li>{@link ImmutableScenarioRatingRow#providedBy()}
   *   <li>{@link ImmutableScenarioRatingRow#rating()}
   *   <li>{@link ImmutableScenarioRatingRow#roadmap()}
   *   <li>{@link ImmutableScenarioRatingRow#row()}
   *   <li>{@link ImmutableScenarioRatingRow#scenario()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableScenarioRatingRow.assetCode()",
    "String ImmutableScenarioRatingRow.column()",
    "String ImmutableScenarioRatingRow.description()",
    "String ImmutableScenarioRatingRow.providedBy()",
    "String ImmutableScenarioRatingRow.rating()",
    "String ImmutableScenarioRatingRow.roadmap()",
    "String ImmutableScenarioRatingRow.row()",
    "String ImmutableScenarioRatingRow.scenario()",
    "String ImmutableScenarioRatingRow.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    String actualToStringResult = immutableScenarioRatingRow.toString();
    String actualAssetCodeResult = immutableScenarioRatingRow.assetCode();
    String actualColumnResult = immutableScenarioRatingRow.column();
    String actualDescriptionResult = immutableScenarioRatingRow.description();
    String actualProvidedByResult = immutableScenarioRatingRow.providedBy();
    String actualRatingResult = immutableScenarioRatingRow.rating();
    String actualRoadmapResult = immutableScenarioRatingRow.roadmap();
    String actualRowResult = immutableScenarioRatingRow.row();

    // Assert
    assertEquals("Asset Code", actualAssetCodeResult);
    assertEquals("Column", actualColumnResult);
    assertEquals("Provided By", actualProvidedByResult);
    assertEquals("Rating", actualRatingResult);
    assertEquals("Roadmap", actualRoadmapResult);
    assertEquals("Row", actualRowResult);
    assertEquals("Scenario", immutableScenarioRatingRow.scenario());
    assertEquals(
        "ScenarioRatingRow{roadmap=Roadmap, scenario=Scenario, column=Column, row=Row, assetCode=Asset Code,"
            + " rating=Rating, description=The characteristics of someone or something, providedBy=Provided By}",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withAssetCode(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withAssetCode(String)"})
  void testWithAssetCode() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("42")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithAssetCodeResult =
        immutableScenarioRatingRow.withAssetCode("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithAssetCodeResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withAssetCode(String)}.
   *
   * <ul>
   *   <li>Then return assetCode is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withAssetCode(String)}
   */
  @Test
  @DisplayName("Test withAssetCode(String); then return assetCode is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withAssetCode(String)"})
  void testWithAssetCode_thenReturnAssetCodeIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithAssetCodeResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withAssetCode("42");

    // Assert
    assertEquals("42", actualWithAssetCodeResult.assetCode());
    assertEquals("Column", actualWithAssetCodeResult.column());
    assertEquals("Provided By", actualWithAssetCodeResult.providedBy());
    assertEquals("Rating", actualWithAssetCodeResult.rating());
    assertEquals("Roadmap", actualWithAssetCodeResult.roadmap());
    assertEquals("Row", actualWithAssetCodeResult.row());
    assertEquals("Scenario", actualWithAssetCodeResult.scenario());
    assertEquals(
        "The characteristics of someone or something", actualWithAssetCodeResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withColumn(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withColumn(String)}
   */
  @Test
  @DisplayName("Test withColumn(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withColumn(String)"})
  void testWithColumn() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("42")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithColumnResult = immutableScenarioRatingRow.withColumn("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithColumnResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withColumn(String)}.
   *
   * <ul>
   *   <li>Then return column is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withColumn(String)}
   */
  @Test
  @DisplayName("Test withColumn(String); then return column is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withColumn(String)"})
  void testWithColumn_thenReturnColumnIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithColumnResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withColumn("42");

    // Assert
    assertEquals("42", actualWithColumnResult.column());
    assertEquals("Asset Code", actualWithColumnResult.assetCode());
    assertEquals("Provided By", actualWithColumnResult.providedBy());
    assertEquals("Rating", actualWithColumnResult.rating());
    assertEquals("Roadmap", actualWithColumnResult.roadmap());
    assertEquals("Row", actualWithColumnResult.row());
    assertEquals("Scenario", actualWithColumnResult.scenario());
    assertEquals(
        "The characteristics of someone or something", actualWithColumnResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("42")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithDescriptionResult =
        immutableScenarioRatingRow.withDescription("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withDescription(String)}.
   *
   * <ul>
   *   <li>Then return description is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String); then return description is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withDescription(String)"
  })
  void testWithDescription_thenReturnDescriptionIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithDescriptionResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withDescription("42");

    // Assert
    assertEquals("42", actualWithDescriptionResult.description());
    assertEquals("Asset Code", actualWithDescriptionResult.assetCode());
    assertEquals("Column", actualWithDescriptionResult.column());
    assertEquals("Provided By", actualWithDescriptionResult.providedBy());
    assertEquals("Rating", actualWithDescriptionResult.rating());
    assertEquals("Roadmap", actualWithDescriptionResult.roadmap());
    assertEquals("Row", actualWithDescriptionResult.row());
    assertEquals("Scenario", actualWithDescriptionResult.scenario());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withProvidedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withProvidedBy(String)}
   */
  @Test
  @DisplayName("Test withProvidedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withProvidedBy(String)"
  })
  void testWithProvidedBy() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("42")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithProvidedByResult =
        immutableScenarioRatingRow.withProvidedBy("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithProvidedByResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withProvidedBy(String)}.
   *
   * <ul>
   *   <li>Then return providedBy is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withProvidedBy(String)}
   */
  @Test
  @DisplayName("Test withProvidedBy(String); then return providedBy is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withProvidedBy(String)"
  })
  void testWithProvidedBy_thenReturnProvidedByIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithProvidedByResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withProvidedBy("42");

    // Assert
    assertEquals("42", actualWithProvidedByResult.providedBy());
    assertEquals("Asset Code", actualWithProvidedByResult.assetCode());
    assertEquals("Column", actualWithProvidedByResult.column());
    assertEquals("Rating", actualWithProvidedByResult.rating());
    assertEquals("Roadmap", actualWithProvidedByResult.roadmap());
    assertEquals("Row", actualWithProvidedByResult.row());
    assertEquals("Scenario", actualWithProvidedByResult.scenario());
    assertEquals(
        "The characteristics of someone or something", actualWithProvidedByResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRating(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRating(String)"})
  void testWithRating() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("42")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithRatingResult = immutableScenarioRatingRow.withRating("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRating(String)}.
   *
   * <ul>
   *   <li>Then return rating is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String); then return rating is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRating(String)"})
  void testWithRating_thenReturnRatingIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithRatingResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withRating("42");

    // Assert
    assertEquals("42", actualWithRatingResult.rating());
    assertEquals("Asset Code", actualWithRatingResult.assetCode());
    assertEquals("Column", actualWithRatingResult.column());
    assertEquals("Provided By", actualWithRatingResult.providedBy());
    assertEquals("Roadmap", actualWithRatingResult.roadmap());
    assertEquals("Row", actualWithRatingResult.row());
    assertEquals("Scenario", actualWithRatingResult.scenario());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRoadmap(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRoadmap(String)}
   */
  @Test
  @DisplayName("Test withRoadmap(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRoadmap(String)"})
  void testWithRoadmap() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("42")
            .row("Row")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithRoadmapResult =
        immutableScenarioRatingRow.withRoadmap("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithRoadmapResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRoadmap(String)}.
   *
   * <ul>
   *   <li>Then return roadmap is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRoadmap(String)}
   */
  @Test
  @DisplayName("Test withRoadmap(String); then return roadmap is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRoadmap(String)"})
  void testWithRoadmap_thenReturnRoadmapIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithRoadmapResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withRoadmap("42");

    // Assert
    assertEquals("42", actualWithRoadmapResult.roadmap());
    assertEquals("Asset Code", actualWithRoadmapResult.assetCode());
    assertEquals("Column", actualWithRoadmapResult.column());
    assertEquals("Provided By", actualWithRoadmapResult.providedBy());
    assertEquals("Rating", actualWithRoadmapResult.rating());
    assertEquals("Row", actualWithRoadmapResult.row());
    assertEquals("Scenario", actualWithRoadmapResult.scenario());
    assertEquals(
        "The characteristics of someone or something", actualWithRoadmapResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRow(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRow(String)}
   */
  @Test
  @DisplayName("Test withRow(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRow(String)"})
  void testWithRow() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("42")
            .scenario("Scenario")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithRowResult = immutableScenarioRatingRow.withRow("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithRowResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withRow(String)}.
   *
   * <ul>
   *   <li>Then return row is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withRow(String)}
   */
  @Test
  @DisplayName("Test withRow(String); then return row is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withRow(String)"})
  void testWithRow_thenReturnRowIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithRowResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withRow("42");

    // Assert
    assertEquals("42", actualWithRowResult.row());
    assertEquals("Asset Code", actualWithRowResult.assetCode());
    assertEquals("Column", actualWithRowResult.column());
    assertEquals("Provided By", actualWithRowResult.providedBy());
    assertEquals("Rating", actualWithRowResult.rating());
    assertEquals("Roadmap", actualWithRowResult.roadmap());
    assertEquals("Scenario", actualWithRowResult.scenario());
    assertEquals("The characteristics of someone or something", actualWithRowResult.description());
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withScenario(String)}.
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withScenario(String)}
   */
  @Test
  @DisplayName("Test withScenario(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withScenario(String)"})
  void testWithScenario() {
    // Arrange
    ImmutableScenarioRatingRow immutableScenarioRatingRow =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("42")
            .build();

    // Act
    ImmutableScenarioRatingRow actualWithScenarioResult =
        immutableScenarioRatingRow.withScenario("42");

    // Assert
    assertSame(immutableScenarioRatingRow, actualWithScenarioResult);
  }

  /**
   * Test {@link ImmutableScenarioRatingRow#withScenario(String)}.
   *
   * <ul>
   *   <li>Then return scenario is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableScenarioRatingRow#withScenario(String)}
   */
  @Test
  @DisplayName("Test withScenario(String); then return scenario is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableScenarioRatingRow ImmutableScenarioRatingRow.withScenario(String)"})
  void testWithScenario_thenReturnScenarioIs42() {
    // Arrange and Act
    ImmutableScenarioRatingRow actualWithScenarioResult =
        ImmutableScenarioRatingRow.builder()
            .assetCode("Asset Code")
            .column("Column")
            .description("The characteristics of someone or something")
            .providedBy("Provided By")
            .rating("Rating")
            .roadmap("Roadmap")
            .row("Row")
            .scenario("Scenario")
            .build()
            .withScenario("42");

    // Assert
    assertEquals("42", actualWithScenarioResult.scenario());
    assertEquals("Asset Code", actualWithScenarioResult.assetCode());
    assertEquals("Column", actualWithScenarioResult.column());
    assertEquals("Provided By", actualWithScenarioResult.providedBy());
    assertEquals("Rating", actualWithScenarioResult.rating());
    assertEquals("Roadmap", actualWithScenarioResult.roadmap());
    assertEquals("Row", actualWithScenarioResult.row());
    assertEquals(
        "The characteristics of someone or something", actualWithScenarioResult.description());
  }
}
