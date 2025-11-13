package org.finos.waltz.model.logical_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.logical_flow.ImmutableFlowRatingCount.Builder;
import org.finos.waltz.model.logical_flow.ImmutableFlowRatingCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowRatingCountDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableFlowRatingCount actualImmutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Assert
    assertEquals(1L, actualImmutableFlowRatingCount.rating().longValue());
    assertEquals(3, actualImmutableFlowRatingCount.flowCount());
  }

  /**
   * Test Builder {@link Builder#flowCount(int)}.
   *
   * <p>Method under test: {@link Builder#flowCount(int)}
   */
  @Test
  @DisplayName("Test Builder flowCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.flowCount(int)"})
  void testBuilderFlowCount() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act
    Builder actualFlowCountResult = builderResult.flowCount(3);

    // Assert
    assertSame(builderResult, actualFlowCountResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowRatingCount)}.
   *
   * <ul>
   *   <li>Then builder build is builder flowCount three rating one build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(FlowRatingCount)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowRatingCount); then builder build is builder flowCount three rating one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowRatingCount)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderFlowCountThreeRatingOneBuild() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();
    ImmutableFlowRatingCount instance =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableFlowRatingCount actualImmutableFlowRatingCount = builderResult.build();
    assertEquals(instance, actualImmutableFlowRatingCount);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(Long)}.
   *
   * <p>Method under test: {@link Builder#rating(Long)}
   */
  @Test
  @DisplayName("Test Builder rating(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(Long)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableFlowRatingCount.builder();

    // Act
    Builder actualRatingResult = builderResult.rating(1L);

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableFlowRatingCount#copyOf(FlowRatingCount)}.
   *
   * <ul>
   *   <li>Then return rating longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#copyOf(FlowRatingCount)}
   */
  @Test
  @DisplayName("Test copyOf(FlowRatingCount); then return rating longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount ImmutableFlowRatingCount.copyOf(FlowRatingCount)"})
  void testCopyOf_thenReturnRatingLongValueIsOne() {
    // Arrange
    ImmutableFlowRatingCount instance =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act
    ImmutableFlowRatingCount actualCopyOfResult = ImmutableFlowRatingCount.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.rating().longValue());
    assertEquals(3, actualCopyOfResult.flowCount());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}, and {@link
   * ImmutableFlowRatingCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRatingCount#equals(Object)}
   *   <li>{@link ImmutableFlowRatingCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();
    ImmutableFlowRatingCount immutableFlowRatingCount2 =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act and Assert
    assertEquals(immutableFlowRatingCount, immutableFlowRatingCount2);
    assertEquals(immutableFlowRatingCount.hashCode(), immutableFlowRatingCount2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}, and {@link
   * ImmutableFlowRatingCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRatingCount#equals(Object)}
   *   <li>{@link ImmutableFlowRatingCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act and Assert
    assertEquals(immutableFlowRatingCount, immutableFlowRatingCount);
    int expectedHashCodeResult = immutableFlowRatingCount.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowRatingCount.hashCode());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(1).rating(1L).build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRatingCount,
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(3L).build();

    // Act and Assert
    assertNotEquals(
        immutableFlowRatingCount,
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build(), null);
  }

  /**
   * Test {@link ImmutableFlowRatingCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowRatingCount.equals(Object)",
    "int ImmutableFlowRatingCount.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build(),
        "Different type to ImmutableFlowRatingCount");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowRatingCount#toString()}
   *   <li>{@link ImmutableFlowRatingCount#flowCount()}
   *   <li>{@link ImmutableFlowRatingCount#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableFlowRatingCount.flowCount()",
    "Long ImmutableFlowRatingCount.rating()",
    "String ImmutableFlowRatingCount.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act
    String actualToStringResult = immutableFlowRatingCount.toString();
    int actualFlowCountResult = immutableFlowRatingCount.flowCount();

    // Assert
    assertEquals("FlowRatingCount{rating=1, flowCount=3}", actualToStringResult);
    assertEquals(1L, immutableFlowRatingCount.rating().longValue());
    assertEquals(3, actualFlowCountResult);
  }

  /**
   * Test Json {@link Json#flowCount()}.
   *
   * <p>Method under test: {@link Json#flowCount()}
   */
  @Test
  @DisplayName("Test Json flowCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.flowCount()"})
  void testJsonFlowCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().flowCount());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setRating(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setRating(Long)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setRating(1L);

    // Assert
    assertEquals(1L, actualJson.rating.longValue());
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
  @MethodsUnderTest({"Long Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#setFlowCount(int)}.
   *
   * <p>Method under test: {@link Json#setFlowCount(int)}
   */
  @Test
  @DisplayName("Test Json setFlowCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setFlowCount(int)"})
  void testJsonSetFlowCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setFlowCount(3);

    // Assert
    assertEquals(3, json.flowCount);
    assertTrue(json.flowCountIsSet);
  }

  /**
   * Test {@link ImmutableFlowRatingCount#withFlowCount(int)}.
   *
   * <ul>
   *   <li>Then return builder flowCount forty-two rating one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#withFlowCount(int)}
   */
  @Test
  @DisplayName("Test withFlowCount(int); then return builder flowCount forty-two rating one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount ImmutableFlowRatingCount.withFlowCount(int)"})
  void testWithFlowCount_thenReturnBuilderFlowCountFortyTwoRatingOneBuild() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(42).rating(1L).build();

    // Act
    ImmutableFlowRatingCount actualWithFlowCountResult = immutableFlowRatingCount.withFlowCount(42);

    // Assert
    assertSame(immutableFlowRatingCount, actualWithFlowCountResult);
  }

  /**
   * Test {@link ImmutableFlowRatingCount#withFlowCount(int)}.
   *
   * <ul>
   *   <li>Then return rating longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#withFlowCount(int)}
   */
  @Test
  @DisplayName("Test withFlowCount(int); then return rating longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount ImmutableFlowRatingCount.withFlowCount(int)"})
  void testWithFlowCount_thenReturnRatingLongValueIsOne() {
    // Arrange and Act
    ImmutableFlowRatingCount actualWithFlowCountResult =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build().withFlowCount(42);

    // Assert
    assertEquals(1L, actualWithFlowCountResult.rating().longValue());
    assertEquals(42, actualWithFlowCountResult.flowCount());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#withRating(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return flowCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#withRating(Long)}
   */
  @Test
  @DisplayName("Test withRating(Long); when forty-two; then return flowCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount ImmutableFlowRatingCount.withRating(Long)"})
  void testWithRating_whenFortyTwo_thenReturnFlowCountIsThree() {
    // Arrange and Act
    ImmutableFlowRatingCount actualWithRatingResult =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build().withRating(42L);

    // Assert
    assertEquals(3, actualWithRatingResult.flowCount());
    assertEquals(42L, actualWithRatingResult.rating().longValue());
  }

  /**
   * Test {@link ImmutableFlowRatingCount#withRating(Long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return builder flowCount three rating one build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowRatingCount#withRating(Long)}
   */
  @Test
  @DisplayName(
      "Test withRating(Long); when one; then return builder flowCount three rating one build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowRatingCount ImmutableFlowRatingCount.withRating(Long)"})
  void testWithRating_whenOne_thenReturnBuilderFlowCountThreeRatingOneBuild() {
    // Arrange
    ImmutableFlowRatingCount immutableFlowRatingCount =
        ImmutableFlowRatingCount.builder().flowCount(3).rating(1L).build();

    // Act
    ImmutableFlowRatingCount actualWithRatingResult = immutableFlowRatingCount.withRating(1L);

    // Assert
    assertSame(immutableFlowRatingCount, actualWithRatingResult);
  }
}
