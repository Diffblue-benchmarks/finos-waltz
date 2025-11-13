package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.tally.ImmutableMeasurableFlowDiagramTally.Builder;
import org.finos.waltz.model.tally.ImmutableMeasurableFlowDiagramTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableFlowDiagramTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableFlowDiagramTally Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableFlowDiagramTally actualImmutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Assert
    assertEquals('A', actualImmutableMeasurableFlowDiagramTally.rating());
    assertEquals(1L, actualImmutableMeasurableFlowDiagramTally.id());
    assertEquals(3L, actualImmutableMeasurableFlowDiagramTally.count());
  }

  /**
   * Test Builder {@link Builder#count(long)}.
   *
   * <p>Method under test: {@link Builder#count(long)}
   */
  @Test
  @DisplayName("Test Builder count(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(long)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act
    Builder actualCountResult = builderResult.count(3L);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableFlowDiagramTally)}.
   *
   * <ul>
   *   <li>Then builder build is builder count three id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableFlowDiagramTally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableFlowDiagramTally); then builder build is builder count three id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableFlowDiagramTally)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCountThreeIdOneRatingABuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();
    ImmutableMeasurableFlowDiagramTally instance =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableFlowDiagramTally actualImmutableMeasurableFlowDiagramTally =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableFlowDiagramTally);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderId() {
    // Arrange
    Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#rating(char)}.
   *
   * <p>Method under test: {@link Builder#rating(char)}
   */
  @Test
  @DisplayName("Test Builder rating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(char)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableMeasurableFlowDiagramTally.builder();

    // Act
    Builder actualRatingResult = builderResult.rating('A');

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#copyOf(MeasurableFlowDiagramTally)}.
   *
   * <ul>
   *   <li>When builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableFlowDiagramTally#copyOf(MeasurableFlowDiagramTally)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableFlowDiagramTally); when builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.copyOf(MeasurableFlowDiagramTally)"
  })
  void testCopyOf_whenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally instance =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableFlowDiagramTally actualCopyOfResult =
        ImmutableMeasurableFlowDiagramTally.copyOf(instance);

    // Assert
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(3L, actualCopyOfResult.count());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}, and {@link
   * ImmutableMeasurableFlowDiagramTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally2 =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act and Assert
    assertEquals(immutableMeasurableFlowDiagramTally, immutableMeasurableFlowDiagramTally2);
    assertEquals(
        immutableMeasurableFlowDiagramTally.hashCode(),
        immutableMeasurableFlowDiagramTally2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}, and {@link
   * ImmutableMeasurableFlowDiagramTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act and Assert
    assertEquals(immutableMeasurableFlowDiagramTally, immutableMeasurableFlowDiagramTally);
    int expectedHashCodeResult = immutableMeasurableFlowDiagramTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableFlowDiagramTally.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(1L).id(1L).rating('A').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableFlowDiagramTally,
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(2L).rating('A').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableFlowDiagramTally,
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('\u0001').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableFlowDiagramTally,
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableFlowDiagramTally.equals(Object)",
    "int ImmutableMeasurableFlowDiagramTally.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build(),
        "Different type to ImmutableMeasurableFlowDiagramTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#toString()}
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#count()}
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#id()}
   *   <li>{@link ImmutableMeasurableFlowDiagramTally#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableMeasurableFlowDiagramTally.count()",
    "long ImmutableMeasurableFlowDiagramTally.id()",
    "char ImmutableMeasurableFlowDiagramTally.rating()",
    "String ImmutableMeasurableFlowDiagramTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    String actualToStringResult = immutableMeasurableFlowDiagramTally.toString();
    long actualCountResult = immutableMeasurableFlowDiagramTally.count();
    long actualIdResult = immutableMeasurableFlowDiagramTally.id();

    // Assert
    assertEquals("MeasurableFlowDiagramTally{id=1, rating=A, count=3}", actualToStringResult);
    assertEquals('A', immutableMeasurableFlowDiagramTally.rating());
    assertEquals(1L, actualIdResult);
    assertEquals(3L, actualCountResult);
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
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
  @MethodsUnderTest({"long Json.id()"})
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
    assertEquals('\u0000', actualJson.rating);
    assertEquals(0L, actualJson.count);
    assertEquals(0L, actualJson.id);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.idIsSet);
    assertFalse(actualJson.ratingIsSet);
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
  @MethodsUnderTest({"char Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#setCount(long)}.
   *
   * <p>Method under test: {@link Json#setCount(long)}
   */
  @Test
  @DisplayName("Test Json setCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(long)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3L);

    // Assert
    assertEquals(3L, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setId(long)}.
   *
   * <p>Method under test: {@link Json#setId(long)}
   */
  @Test
  @DisplayName("Test Json setId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setId(long)"})
  void testJsonSetId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setId(1L);

    // Assert
    assertEquals(1L, json.id);
    assertTrue(json.idIsSet);
  }

  /**
   * Test Json {@link Json#setRating(char)}.
   *
   * <p>Method under test: {@link Json#setRating(char)}
   */
  @Test
  @DisplayName("Test Json setRating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRating(char)"})
  void testJsonSetRating() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withCount(long)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withCount(long)}
   */
  @Test
  @DisplayName(
      "Test withCount(long); given builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withCount(long)"
  })
  void testWithCount_givenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableFlowDiagramTally actualWithCountResult =
        ImmutableMeasurableFlowDiagramTally.builder()
            .count(3L)
            .id(1L)
            .rating('A')
            .build()
            .withCount(42L);

    // Assert
    assertEquals('A', actualWithCountResult.rating());
    assertEquals(1L, actualWithCountResult.id());
    assertEquals(42L, actualWithCountResult.count());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withCount(long)}.
   *
   * <ul>
   *   <li>Then return builder count forty-two id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withCount(long)}
   */
  @Test
  @DisplayName("Test withCount(long); then return builder count forty-two id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withCount(long)"
  })
  void testWithCount_thenReturnBuilderCountFortyTwoIdOneRatingABuild() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(42L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableFlowDiagramTally actualWithCountResult =
        immutableMeasurableFlowDiagramTally.withCount(42L);

    // Assert
    assertSame(immutableMeasurableFlowDiagramTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withId(long)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long); given builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withId(long)"
  })
  void testWithId_givenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableFlowDiagramTally actualWithIdResult =
        ImmutableMeasurableFlowDiagramTally.builder()
            .count(3L)
            .id(1L)
            .rating('A')
            .build()
            .withId(42L);

    // Assert
    assertEquals('A', actualWithIdResult.rating());
    assertEquals(3L, actualWithIdResult.count());
    assertEquals(42L, actualWithIdResult.id());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withId(long)}.
   *
   * <ul>
   *   <li>Then return builder count three id forty-two rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long); then return builder count three id forty-two rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withId(long)"
  })
  void testWithId_thenReturnBuilderCountThreeIdFortyTwoRatingABuild() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(42L).rating('A').build();

    // Act
    ImmutableMeasurableFlowDiagramTally actualWithIdResult =
        immutableMeasurableFlowDiagramTally.withId(42L);

    // Assert
    assertSame(immutableMeasurableFlowDiagramTally, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withRating(char)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating null build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withRating(char)}
   */
  @Test
  @DisplayName(
      "Test withRating(char); given builder count three id one rating null build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withRating(char)"
  })
  void testWithRating_givenBuilderCountThreeIdOneRatingNullBuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableFlowDiagramTally actualWithRatingResult =
        ImmutableMeasurableFlowDiagramTally.builder()
            .count(3L)
            .id(1L)
            .rating('\u0000')
            .build()
            .withRating('A');

    // Assert
    assertEquals('A', actualWithRatingResult.rating());
    assertEquals(1L, actualWithRatingResult.id());
    assertEquals(3L, actualWithRatingResult.count());
  }

  /**
   * Test {@link ImmutableMeasurableFlowDiagramTally#withRating(char)}.
   *
   * <ul>
   *   <li>Then return builder count three id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableFlowDiagramTally#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char); then return builder count three id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableFlowDiagramTally ImmutableMeasurableFlowDiagramTally.withRating(char)"
  })
  void testWithRating_thenReturnBuilderCountThreeIdOneRatingABuild() {
    // Arrange
    ImmutableMeasurableFlowDiagramTally immutableMeasurableFlowDiagramTally =
        ImmutableMeasurableFlowDiagramTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableFlowDiagramTally actualWithRatingResult =
        immutableMeasurableFlowDiagramTally.withRating('A');

    // Assert
    assertSame(immutableMeasurableFlowDiagramTally, actualWithRatingResult);
  }
}
