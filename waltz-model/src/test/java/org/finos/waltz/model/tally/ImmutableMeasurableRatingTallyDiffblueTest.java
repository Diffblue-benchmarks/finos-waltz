package org.finos.waltz.model.tally;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.tally.ImmutableMeasurableRatingTally.Builder;
import org.finos.waltz.model.tally.ImmutableMeasurableRatingTally.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingTallyDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingTally Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableMeasurableRatingTally actualImmutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Assert
    assertEquals('A', actualImmutableMeasurableRatingTally.rating());
    assertEquals(1L, actualImmutableMeasurableRatingTally.id());
    assertEquals(3L, actualImmutableMeasurableRatingTally.count());
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
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act
    Builder actualCountResult = builderResult.count(3L);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingTally)}.
   *
   * <ul>
   *   <li>Then builder build is builder count three id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingTally)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingTally); then builder build is builder count three id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingTally)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderCountThreeIdOneRatingABuild() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingTally.builder();
    ImmutableMeasurableRatingTally instance =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableRatingTally actualImmutableMeasurableRatingTally = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingTally);
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
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

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
    Builder builderResult = ImmutableMeasurableRatingTally.builder();

    // Act
    Builder actualRatingResult = builderResult.rating('A');

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#copyOf(MeasurableRatingTally)}.
   *
   * <ul>
   *   <li>When builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#copyOf(MeasurableRatingTally)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingTally); when builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.copyOf(MeasurableRatingTally)"
  })
  void testCopyOf_whenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange
    ImmutableMeasurableRatingTally instance =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableRatingTally actualCopyOfResult =
        ImmutableMeasurableRatingTally.copyOf(instance);

    // Assert
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, actualCopyOfResult.id());
    assertEquals(3L, actualCopyOfResult.count());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}, and {@link
   * ImmutableMeasurableRatingTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingTally#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally2 =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingTally, immutableMeasurableRatingTally2);
    assertEquals(
        immutableMeasurableRatingTally.hashCode(), immutableMeasurableRatingTally2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}, and {@link
   * ImmutableMeasurableRatingTally#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingTally#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingTally#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act and Assert
    assertEquals(immutableMeasurableRatingTally, immutableMeasurableRatingTally);
    int expectedHashCodeResult = immutableMeasurableRatingTally.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingTally.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(1L).id(1L).rating('A').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingTally,
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(2L).rating('A').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingTally,
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('\u0001').build();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingTally,
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build(), null);
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingTally.equals(Object)",
    "int ImmutableMeasurableRatingTally.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build(),
        "Different type to ImmutableMeasurableRatingTally");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingTally#toString()}
   *   <li>{@link ImmutableMeasurableRatingTally#count()}
   *   <li>{@link ImmutableMeasurableRatingTally#id()}
   *   <li>{@link ImmutableMeasurableRatingTally#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableMeasurableRatingTally.count()",
    "long ImmutableMeasurableRatingTally.id()",
    "char ImmutableMeasurableRatingTally.rating()",
    "String ImmutableMeasurableRatingTally.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    String actualToStringResult = immutableMeasurableRatingTally.toString();
    long actualCountResult = immutableMeasurableRatingTally.count();
    long actualIdResult = immutableMeasurableRatingTally.id();

    // Assert
    assertEquals("MeasurableRatingTally{id=1, rating=A, count=3}", actualToStringResult);
    assertEquals('A', immutableMeasurableRatingTally.rating());
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
   * Test {@link ImmutableMeasurableRatingTally#withCount(long)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withCount(long)}
   */
  @Test
  @DisplayName(
      "Test withCount(long); given builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withCount(long)"
  })
  void testWithCount_givenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableRatingTally actualWithCountResult =
        ImmutableMeasurableRatingTally.builder()
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
   * Test {@link ImmutableMeasurableRatingTally#withCount(long)}.
   *
   * <ul>
   *   <li>Then return builder count forty-two id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withCount(long)}
   */
  @Test
  @DisplayName("Test withCount(long); then return builder count forty-two id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withCount(long)"
  })
  void testWithCount_thenReturnBuilderCountFortyTwoIdOneRatingABuild() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(42L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableRatingTally actualWithCountResult =
        immutableMeasurableRatingTally.withCount(42L);

    // Assert
    assertSame(immutableMeasurableRatingTally, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#withId(long)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating {@code A} build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withId(long)}
   */
  @Test
  @DisplayName(
      "Test withId(long); given builder count three id one rating 'A' build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withId(long)"})
  void testWithId_givenBuilderCountThreeIdOneRatingABuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableRatingTally actualWithIdResult =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build().withId(42L);

    // Assert
    assertEquals('A', actualWithIdResult.rating());
    assertEquals(3L, actualWithIdResult.count());
    assertEquals(42L, actualWithIdResult.id());
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#withId(long)}.
   *
   * <ul>
   *   <li>Then return builder count three id forty-two rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long); then return builder count three id forty-two rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withId(long)"})
  void testWithId_thenReturnBuilderCountThreeIdFortyTwoRatingABuild() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(42L).rating('A').build();

    // Act
    ImmutableMeasurableRatingTally actualWithIdResult = immutableMeasurableRatingTally.withId(42L);

    // Assert
    assertSame(immutableMeasurableRatingTally, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingTally#withRating(char)}.
   *
   * <ul>
   *   <li>Given builder count three id one rating null build.
   *   <li>Then return rating is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withRating(char)}
   */
  @Test
  @DisplayName(
      "Test withRating(char); given builder count three id one rating null build; then return rating is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withRating(char)"
  })
  void testWithRating_givenBuilderCountThreeIdOneRatingNullBuild_thenReturnRatingIsA() {
    // Arrange and Act
    ImmutableMeasurableRatingTally actualWithRatingResult =
        ImmutableMeasurableRatingTally.builder()
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
   * Test {@link ImmutableMeasurableRatingTally#withRating(char)}.
   *
   * <ul>
   *   <li>Then return builder count three id one rating {@code A} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingTally#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char); then return builder count three id one rating 'A' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingTally ImmutableMeasurableRatingTally.withRating(char)"
  })
  void testWithRating_thenReturnBuilderCountThreeIdOneRatingABuild() {
    // Arrange
    ImmutableMeasurableRatingTally immutableMeasurableRatingTally =
        ImmutableMeasurableRatingTally.builder().count(3L).id(1L).rating('A').build();

    // Act
    ImmutableMeasurableRatingTally actualWithRatingResult =
        immutableMeasurableRatingTally.withRating('A');

    // Assert
    assertSame(immutableMeasurableRatingTally, actualWithRatingResult);
  }
}
