package org.finos.waltz.model.scenario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand.Builder;
import org.finos.waltz.model.scenario.ImmutableChangeScenarioCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableChangeScenarioCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#appId(long)}.
   *
   * <p>Method under test: {@link Builder#appId(long)}
   */
  @Test
  @DisplayName("Test Builder appId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.appId(long)"})
  void testBuilderAppId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act
    Builder actualAppIdResult = builderResult.appId(1L);

    // Assert
    assertSame(builderResult, actualAppIdResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#comment(String)}
   *   <li>{@link Builder#previousRating(String)}
   *   <li>{@link Builder#rating(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand Builder.build()",
    "Builder Builder.comment(String)",
    "Builder Builder.previousRating(String)",
    "Builder Builder.rating(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualImmutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Assert
    assertEquals("Comment", actualImmutableChangeScenarioCommand.comment());
    assertEquals("Previous Rating", actualImmutableChangeScenarioCommand.previousRating());
    assertEquals("Rating", actualImmutableChangeScenarioCommand.rating());
    assertEquals(1L, actualImmutableChangeScenarioCommand.appId());
    assertEquals(1L, actualImmutableChangeScenarioCommand.columnId());
    assertEquals(1L, actualImmutableChangeScenarioCommand.ratingSchemeId());
    assertEquals(1L, actualImmutableChangeScenarioCommand.rowId());
    assertEquals(1L, actualImmutableChangeScenarioCommand.scenarioId());
    assertTrue(actualImmutableChangeScenarioCommand.hasRatingChanged());
  }

  /**
   * Test Builder {@link Builder#columnId(long)}.
   *
   * <p>Method under test: {@link Builder#columnId(long)}
   */
  @Test
  @DisplayName("Test Builder columnId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnId(long)"})
  void testBuilderColumnId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act
    Builder actualColumnIdResult = builderResult.columnId(1L);

    // Assert
    assertSame(builderResult, actualColumnIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ImmutableChangeScenarioCommand instance =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeScenarioCommand actualImmutableChangeScenarioCommand = builderResult.build();
    assertEquals(instance, actualImmutableChangeScenarioCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ImmutableChangeScenarioCommand instance =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment(null)
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeScenarioCommand actualImmutableChangeScenarioCommand = builderResult.build();
    assertEquals(instance, actualImmutableChangeScenarioCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ImmutableChangeScenarioCommand instance =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating(null)
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeScenarioCommand actualImmutableChangeScenarioCommand = builderResult.build();
    assertEquals(instance, actualImmutableChangeScenarioCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ChangeScenarioCommand)}.
   *
   * <p>Method under test: {@link Builder#from(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test Builder from(ChangeScenarioCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ChangeScenarioCommand)"})
  void testBuilderFrom4() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();
    ImmutableChangeScenarioCommand instance =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating(null)
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableChangeScenarioCommand actualImmutableChangeScenarioCommand = builderResult.build();
    assertEquals(instance, actualImmutableChangeScenarioCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act
    Builder actualRatingSchemeIdResult = builderResult.ratingSchemeId(1L);

    // Assert
    assertSame(builderResult, actualRatingSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#rowId(long)}.
   *
   * <p>Method under test: {@link Builder#rowId(long)}
   */
  @Test
  @DisplayName("Test Builder rowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowId(long)"})
  void testBuilderRowId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act
    Builder actualRowIdResult = builderResult.rowId(1L);

    // Assert
    assertSame(builderResult, actualRowIdResult);
  }

  /**
   * Test Builder {@link Builder#scenarioId(long)}.
   *
   * <p>Method under test: {@link Builder#scenarioId(long)}
   */
  @Test
  @DisplayName("Test Builder scenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.scenarioId(long)"})
  void testBuilderScenarioId() {
    // Arrange
    Builder builderResult = ImmutableChangeScenarioCommand.builder();

    // Act
    Builder actualScenarioIdResult = builderResult.scenarioId(1L);

    // Assert
    assertSame(builderResult, actualScenarioIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#copyOf(ChangeScenarioCommand)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#copyOf(ChangeScenarioCommand)}
   */
  @Test
  @DisplayName("Test copyOf(ChangeScenarioCommand); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.copyOf(ChangeScenarioCommand)"
  })
  void testCopyOf_thenReturnComment() {
    // Arrange
    ImmutableChangeScenarioCommand instance =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualCopyOfResult =
        ImmutableChangeScenarioCommand.copyOf(instance);

    // Assert
    assertEquals("Comment", actualCopyOfResult.comment());
    assertEquals("Previous Rating", actualCopyOfResult.previousRating());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.columnId());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(1L, actualCopyOfResult.rowId());
    assertEquals(1L, actualCopyOfResult.scenarioId());
    assertTrue(actualCopyOfResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}, and {@link
   * ImmutableChangeScenarioCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeScenarioCommand#equals(Object)}
   *   <li>{@link ImmutableChangeScenarioCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand2 =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableChangeScenarioCommand, immutableChangeScenarioCommand2);
    assertEquals(
        immutableChangeScenarioCommand.hashCode(), immutableChangeScenarioCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}, and {@link
   * ImmutableChangeScenarioCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeScenarioCommand#equals(Object)}
   *   <li>{@link ImmutableChangeScenarioCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableChangeScenarioCommand, immutableChangeScenarioCommand);
    int expectedHashCodeResult = immutableChangeScenarioCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableChangeScenarioCommand.hashCode());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(2L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(2L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("appId")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("appId")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("appId")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(2L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(2L)
            .scenarioId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableChangeScenarioCommand,
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableChangeScenarioCommand.equals(Object)",
    "int ImmutableChangeScenarioCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build(),
        "Different type to ImmutableChangeScenarioCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableChangeScenarioCommand#toString()}
   *   <li>{@link ImmutableChangeScenarioCommand#appId()}
   *   <li>{@link ImmutableChangeScenarioCommand#columnId()}
   *   <li>{@link ImmutableChangeScenarioCommand#comment()}
   *   <li>{@link ImmutableChangeScenarioCommand#hasRatingChanged()}
   *   <li>{@link ImmutableChangeScenarioCommand#previousRating()}
   *   <li>{@link ImmutableChangeScenarioCommand#rating()}
   *   <li>{@link ImmutableChangeScenarioCommand#ratingSchemeId()}
   *   <li>{@link ImmutableChangeScenarioCommand#rowId()}
   *   <li>{@link ImmutableChangeScenarioCommand#scenarioId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableChangeScenarioCommand.appId()",
    "long ImmutableChangeScenarioCommand.columnId()",
    "String ImmutableChangeScenarioCommand.comment()",
    "boolean ImmutableChangeScenarioCommand.hasRatingChanged()",
    "String ImmutableChangeScenarioCommand.previousRating()",
    "String ImmutableChangeScenarioCommand.rating()",
    "long ImmutableChangeScenarioCommand.ratingSchemeId()",
    "long ImmutableChangeScenarioCommand.rowId()",
    "long ImmutableChangeScenarioCommand.scenarioId()",
    "String ImmutableChangeScenarioCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    String actualToStringResult = immutableChangeScenarioCommand.toString();
    long actualAppIdResult = immutableChangeScenarioCommand.appId();
    long actualColumnIdResult = immutableChangeScenarioCommand.columnId();
    String actualCommentResult = immutableChangeScenarioCommand.comment();
    boolean actualHasRatingChangedResult = immutableChangeScenarioCommand.hasRatingChanged();
    String actualPreviousRatingResult = immutableChangeScenarioCommand.previousRating();
    String actualRatingResult = immutableChangeScenarioCommand.rating();
    long actualRatingSchemeIdResult = immutableChangeScenarioCommand.ratingSchemeId();
    long actualRowIdResult = immutableChangeScenarioCommand.rowId();

    // Assert
    assertEquals(
        "ChangeScenarioCommand{scenarioId=1, appId=1, columnId=1, rowId=1, ratingSchemeId=1, rating=Rating,"
            + " previousRating=Previous Rating, comment=Comment, hasRatingChanged=true}",
        actualToStringResult);
    assertEquals("Comment", actualCommentResult);
    assertEquals("Previous Rating", actualPreviousRatingResult);
    assertEquals("Rating", actualRatingResult);
    assertEquals(1L, actualAppIdResult);
    assertEquals(1L, actualColumnIdResult);
    assertEquals(1L, actualRatingSchemeIdResult);
    assertEquals(1L, actualRowIdResult);
    assertEquals(1L, immutableChangeScenarioCommand.scenarioId());
    assertTrue(actualHasRatingChangedResult);
  }

  /**
   * Test Json {@link Json#appId()}.
   *
   * <p>Method under test: {@link Json#appId()}
   */
  @Test
  @DisplayName("Test Json appId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.appId()"})
  void testJsonAppId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().appId());
  }

  /**
   * Test Json {@link Json#columnId()}.
   *
   * <p>Method under test: {@link Json#columnId()}
   */
  @Test
  @DisplayName("Test Json columnId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.columnId()"})
  void testJsonColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnId());
  }

  /**
   * Test Json {@link Json#comment()}.
   *
   * <p>Method under test: {@link Json#comment()}
   */
  @Test
  @DisplayName("Test Json comment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.comment()"})
  void testJsonComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().comment());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComment(String)}
   *   <li>{@link Json#setPreviousRating(String)}
   *   <li>{@link Json#setRating(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setComment(String)",
    "void Json.setPreviousRating(String)",
    "void Json.setRating(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComment("Comment");
    actualJson.setPreviousRating("Previous Rating");
    actualJson.setRating("Rating");

    // Assert
    assertEquals("Comment", actualJson.comment);
    assertEquals("Previous Rating", actualJson.previousRating);
    assertEquals("Rating", actualJson.rating);
    assertEquals(0L, actualJson.appId);
    assertEquals(0L, actualJson.columnId);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertEquals(0L, actualJson.rowId);
    assertEquals(0L, actualJson.scenarioId);
    assertFalse(actualJson.appIdIsSet);
    assertFalse(actualJson.columnIdIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
    assertFalse(actualJson.rowIdIsSet);
    assertFalse(actualJson.scenarioIdIsSet);
  }

  /**
   * Test Json {@link Json#hasRatingChanged()}.
   *
   * <p>Method under test: {@link Json#hasRatingChanged()}
   */
  @Test
  @DisplayName("Test Json hasRatingChanged()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.hasRatingChanged()"})
  void testJsonHasRatingChanged() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().hasRatingChanged());
  }

  /**
   * Test Json {@link Json#previousRating()}.
   *
   * <p>Method under test: {@link Json#previousRating()}
   */
  @Test
  @DisplayName("Test Json previousRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.previousRating()"})
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().previousRating());
  }

  /**
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeId());
  }

  /**
   * Test Json {@link Json#rowId()}.
   *
   * <p>Method under test: {@link Json#rowId()}
   */
  @Test
  @DisplayName("Test Json rowId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.rowId()"})
  void testJsonRowId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rowId());
  }

  /**
   * Test Json {@link Json#scenarioId()}.
   *
   * <p>Method under test: {@link Json#scenarioId()}
   */
  @Test
  @DisplayName("Test Json scenarioId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.scenarioId()"})
  void testJsonScenarioId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().scenarioId());
  }

  /**
   * Test Json {@link Json#setAppId(long)}.
   *
   * <p>Method under test: {@link Json#setAppId(long)}
   */
  @Test
  @DisplayName("Test Json setAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setAppId(long)"})
  void testJsonSetAppId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setAppId(1L);

    // Assert
    assertEquals(1L, json.appId);
    assertTrue(json.appIdIsSet);
  }

  /**
   * Test Json {@link Json#setColumnId(long)}.
   *
   * <p>Method under test: {@link Json#setColumnId(long)}
   */
  @Test
  @DisplayName("Test Json setColumnId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setColumnId(long)"})
  void testJsonSetColumnId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setColumnId(1L);

    // Assert
    assertEquals(1L, json.columnId);
    assertTrue(json.columnIdIsSet);
  }

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingSchemeId(long)"})
  void testJsonSetRatingSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Test Json {@link Json#setRowId(long)}.
   *
   * <p>Method under test: {@link Json#setRowId(long)}
   */
  @Test
  @DisplayName("Test Json setRowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRowId(long)"})
  void testJsonSetRowId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRowId(1L);

    // Assert
    assertEquals(1L, json.rowId);
    assertTrue(json.rowIdIsSet);
  }

  /**
   * Test Json {@link Json#setScenarioId(long)}.
   *
   * <p>Method under test: {@link Json#setScenarioId(long)}
   */
  @Test
  @DisplayName("Test Json setScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setScenarioId(long)"})
  void testJsonSetScenarioId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setScenarioId(1L);

    // Assert
    assertEquals(1L, json.scenarioId);
    assertTrue(json.scenarioIdIsSet);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withAppId(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withAppId(long)"
  })
  void testWithAppId() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(42L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithAppIdResult =
        immutableChangeScenarioCommand.withAppId(42L);

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithAppIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withAppId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withAppId(long)"
  })
  void testWithAppId_thenReturnComment() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithAppIdResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withAppId(42L);

    // Assert
    assertEquals("Comment", actualWithAppIdResult.comment());
    assertEquals("Previous Rating", actualWithAppIdResult.previousRating());
    assertEquals("Rating", actualWithAppIdResult.rating());
    assertEquals(1L, actualWithAppIdResult.columnId());
    assertEquals(1L, actualWithAppIdResult.ratingSchemeId());
    assertEquals(1L, actualWithAppIdResult.rowId());
    assertEquals(1L, actualWithAppIdResult.scenarioId());
    assertEquals(42L, actualWithAppIdResult.appId());
    assertTrue(actualWithAppIdResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withColumnId(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withColumnId(long)}
   */
  @Test
  @DisplayName("Test withColumnId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withColumnId(long)"
  })
  void testWithColumnId() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(42L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithColumnIdResult =
        immutableChangeScenarioCommand.withColumnId(42L);

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithColumnIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withColumnId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withColumnId(long)}
   */
  @Test
  @DisplayName("Test withColumnId(long); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withColumnId(long)"
  })
  void testWithColumnId_thenReturnComment() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithColumnIdResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withColumnId(42L);

    // Assert
    assertEquals("Comment", actualWithColumnIdResult.comment());
    assertEquals("Previous Rating", actualWithColumnIdResult.previousRating());
    assertEquals("Rating", actualWithColumnIdResult.rating());
    assertEquals(1L, actualWithColumnIdResult.appId());
    assertEquals(1L, actualWithColumnIdResult.ratingSchemeId());
    assertEquals(1L, actualWithColumnIdResult.rowId());
    assertEquals(1L, actualWithColumnIdResult.scenarioId());
    assertEquals(42L, actualWithColumnIdResult.columnId());
    assertTrue(actualWithColumnIdResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withComment(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withComment(String)"
  })
  void testWithComment() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("42")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithCommentResult =
        immutableChangeScenarioCommand.withComment("42");

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithCommentResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withComment(String)}.
   *
   * <ul>
   *   <li>Then return comment is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withComment(String)}
   */
  @Test
  @DisplayName("Test withComment(String); then return comment is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withComment(String)"
  })
  void testWithComment_thenReturnCommentIs42() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithCommentResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withComment("42");

    // Assert
    assertEquals("42", actualWithCommentResult.comment());
    assertEquals("Previous Rating", actualWithCommentResult.previousRating());
    assertEquals("Rating", actualWithCommentResult.rating());
    assertEquals(1L, actualWithCommentResult.appId());
    assertEquals(1L, actualWithCommentResult.columnId());
    assertEquals(1L, actualWithCommentResult.ratingSchemeId());
    assertEquals(1L, actualWithCommentResult.rowId());
    assertEquals(1L, actualWithCommentResult.scenarioId());
    assertTrue(actualWithCommentResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}
   */
  @Test
  @DisplayName("Test withPreviousRating(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withPreviousRating(String)"
  })
  void testWithPreviousRating() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("42")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithPreviousRatingResult =
        immutableChangeScenarioCommand.withPreviousRating("42");

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithPreviousRatingResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}.
   *
   * <ul>
   *   <li>Then return {@code Rating}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}
   */
  @Test
  @DisplayName("Test withPreviousRating(String); then return 'Rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withPreviousRating(String)"
  })
  void testWithPreviousRating_thenReturnRating() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithPreviousRatingResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withPreviousRating("42");

    // Assert
    assertEquals("42", actualWithPreviousRatingResult.previousRating());
    assertEquals("Comment", actualWithPreviousRatingResult.comment());
    assertEquals("Rating", actualWithPreviousRatingResult.rating());
    assertEquals(1L, actualWithPreviousRatingResult.appId());
    assertEquals(1L, actualWithPreviousRatingResult.columnId());
    assertEquals(1L, actualWithPreviousRatingResult.ratingSchemeId());
    assertEquals(1L, actualWithPreviousRatingResult.rowId());
    assertEquals(1L, actualWithPreviousRatingResult.scenarioId());
    assertTrue(actualWithPreviousRatingResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}.
   *
   * <ul>
   *   <li>Then return rating is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withPreviousRating(String)}
   */
  @Test
  @DisplayName("Test withPreviousRating(String); then return rating is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withPreviousRating(String)"
  })
  void testWithPreviousRating_thenReturnRatingIs42() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithPreviousRatingResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("42")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withPreviousRating("42");

    // Assert
    assertEquals("42", actualWithPreviousRatingResult.previousRating());
    assertEquals("42", actualWithPreviousRatingResult.rating());
    assertEquals("Comment", actualWithPreviousRatingResult.comment());
    assertEquals(1L, actualWithPreviousRatingResult.appId());
    assertEquals(1L, actualWithPreviousRatingResult.columnId());
    assertEquals(1L, actualWithPreviousRatingResult.ratingSchemeId());
    assertEquals(1L, actualWithPreviousRatingResult.rowId());
    assertEquals(1L, actualWithPreviousRatingResult.scenarioId());
    assertFalse(actualWithPreviousRatingResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRating(String)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRating(String)"
  })
  void testWithRating() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("42")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithRatingResult =
        immutableChangeScenarioCommand.withRating("42");

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(42L)
            .rowId(1L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithRatingSchemeIdResult =
        immutableChangeScenarioCommand.withRatingSchemeId(42L);

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRatingSchemeId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId_thenReturnComment() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithRatingSchemeIdResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withRatingSchemeId(42L);

    // Assert
    assertEquals("Comment", actualWithRatingSchemeIdResult.comment());
    assertEquals("Previous Rating", actualWithRatingSchemeIdResult.previousRating());
    assertEquals("Rating", actualWithRatingSchemeIdResult.rating());
    assertEquals(1L, actualWithRatingSchemeIdResult.appId());
    assertEquals(1L, actualWithRatingSchemeIdResult.columnId());
    assertEquals(1L, actualWithRatingSchemeIdResult.rowId());
    assertEquals(1L, actualWithRatingSchemeIdResult.scenarioId());
    assertEquals(42L, actualWithRatingSchemeIdResult.ratingSchemeId());
    assertTrue(actualWithRatingSchemeIdResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRating(String)}.
   *
   * <ul>
   *   <li>Then return {@code Previous Rating}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String); then return 'Previous Rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRating(String)"
  })
  void testWithRating_thenReturnPreviousRating() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithRatingResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withRating("42");

    // Assert
    assertEquals("42", actualWithRatingResult.rating());
    assertEquals("Comment", actualWithRatingResult.comment());
    assertEquals("Previous Rating", actualWithRatingResult.previousRating());
    assertEquals(1L, actualWithRatingResult.appId());
    assertEquals(1L, actualWithRatingResult.columnId());
    assertEquals(1L, actualWithRatingResult.ratingSchemeId());
    assertEquals(1L, actualWithRatingResult.rowId());
    assertEquals(1L, actualWithRatingResult.scenarioId());
    assertTrue(actualWithRatingResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRating(String)}.
   *
   * <ul>
   *   <li>Then return previousRating is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String); then return previousRating is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRating(String)"
  })
  void testWithRating_thenReturnPreviousRatingIs42() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithRatingResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("42")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withRating("42");

    // Assert
    assertEquals("42", actualWithRatingResult.previousRating());
    assertEquals("42", actualWithRatingResult.rating());
    assertEquals("Comment", actualWithRatingResult.comment());
    assertEquals(1L, actualWithRatingResult.appId());
    assertEquals(1L, actualWithRatingResult.columnId());
    assertEquals(1L, actualWithRatingResult.ratingSchemeId());
    assertEquals(1L, actualWithRatingResult.rowId());
    assertEquals(1L, actualWithRatingResult.scenarioId());
    assertFalse(actualWithRatingResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRowId(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRowId(long)}
   */
  @Test
  @DisplayName("Test withRowId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRowId(long)"
  })
  void testWithRowId() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(42L)
            .scenarioId(1L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithRowIdResult =
        immutableChangeScenarioCommand.withRowId(42L);

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithRowIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withRowId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withRowId(long)}
   */
  @Test
  @DisplayName("Test withRowId(long); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withRowId(long)"
  })
  void testWithRowId_thenReturnComment() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithRowIdResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withRowId(42L);

    // Assert
    assertEquals("Comment", actualWithRowIdResult.comment());
    assertEquals("Previous Rating", actualWithRowIdResult.previousRating());
    assertEquals("Rating", actualWithRowIdResult.rating());
    assertEquals(1L, actualWithRowIdResult.appId());
    assertEquals(1L, actualWithRowIdResult.columnId());
    assertEquals(1L, actualWithRowIdResult.ratingSchemeId());
    assertEquals(1L, actualWithRowIdResult.scenarioId());
    assertEquals(42L, actualWithRowIdResult.rowId());
    assertTrue(actualWithRowIdResult.hasRatingChanged());
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withScenarioId(long)}.
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withScenarioId(long)"
  })
  void testWithScenarioId() {
    // Arrange
    ImmutableChangeScenarioCommand immutableChangeScenarioCommand =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(42L)
            .build();

    // Act
    ImmutableChangeScenarioCommand actualWithScenarioIdResult =
        immutableChangeScenarioCommand.withScenarioId(42L);

    // Assert
    assertSame(immutableChangeScenarioCommand, actualWithScenarioIdResult);
  }

  /**
   * Test {@link ImmutableChangeScenarioCommand#withScenarioId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Comment}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableChangeScenarioCommand#withScenarioId(long)}
   */
  @Test
  @DisplayName("Test withScenarioId(long); then return 'Comment'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableChangeScenarioCommand ImmutableChangeScenarioCommand.withScenarioId(long)"
  })
  void testWithScenarioId_thenReturnComment() {
    // Arrange and Act
    ImmutableChangeScenarioCommand actualWithScenarioIdResult =
        ImmutableChangeScenarioCommand.builder()
            .appId(1L)
            .columnId(1L)
            .comment("Comment")
            .previousRating("Previous Rating")
            .rating("Rating")
            .ratingSchemeId(1L)
            .rowId(1L)
            .scenarioId(1L)
            .build()
            .withScenarioId(42L);

    // Assert
    assertEquals("Comment", actualWithScenarioIdResult.comment());
    assertEquals("Previous Rating", actualWithScenarioIdResult.previousRating());
    assertEquals("Rating", actualWithScenarioIdResult.rating());
    assertEquals(1L, actualWithScenarioIdResult.appId());
    assertEquals(1L, actualWithScenarioIdResult.columnId());
    assertEquals(1L, actualWithScenarioIdResult.ratingSchemeId());
    assertEquals(1L, actualWithScenarioIdResult.rowId());
    assertEquals(42L, actualWithScenarioIdResult.scenarioId());
    assertTrue(actualWithScenarioIdResult.hasRatingChanged());
  }
}
