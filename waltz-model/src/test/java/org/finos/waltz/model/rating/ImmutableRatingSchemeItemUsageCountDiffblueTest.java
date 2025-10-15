package org.finos.waltz.model.rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItemUsageCount.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItemUsageCount.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemUsageCountDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItemUsageCount Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount actualImmutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals(1L, actualImmutableRatingSchemeItemUsageCount.ratingId());
    assertEquals(1L, actualImmutableRatingSchemeItemUsageCount.schemeId());
    assertEquals(3, actualImmutableRatingSchemeItemUsageCount.count());
    assertEquals(EntityKind.ALL, actualImmutableRatingSchemeItemUsageCount.usageKind());
  }

  /**
   * Test Builder {@link Builder#count(int)}.
   *
   * <p>Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItemUsageCount)}.
   *
   * <p>Method under test: {@link Builder#from(RatingSchemeItemUsageCount)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItemUsageCount)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItemUsageCount)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();
    ImmutableRatingSchemeItemUsageCount instance =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingSchemeItemUsageCount actualImmutableRatingSchemeItemUsageCount =
        builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItemUsageCount);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#ratingId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingId(long)"})
  void testBuilderRatingId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act
    Builder actualRatingIdResult = builderResult.ratingId(1L);

    // Assert
    assertSame(builderResult, actualRatingIdResult);
  }

  /**
   * Test Builder {@link Builder#schemeId(long)}.
   *
   * <p>Method under test: {@link Builder#schemeId(long)}
   */
  @Test
  @DisplayName("Test Builder schemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.schemeId(long)"})
  void testBuilderSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act
    Builder actualSchemeIdResult = builderResult.schemeId(1L);

    // Assert
    assertSame(builderResult, actualSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#usageKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#usageKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder usageKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.usageKind(EntityKind)"})
  void testBuilderUsageKind() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItemUsageCount.builder();

    // Act
    Builder actualUsageKindResult = builderResult.usageKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualUsageKindResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#copyOf(RatingSchemeItemUsageCount)}.
   *
   * <ul>
   *   <li>Then return ratingId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRatingSchemeItemUsageCount#copyOf(RatingSchemeItemUsageCount)}
   */
  @Test
  @DisplayName("Test copyOf(RatingSchemeItemUsageCount); then return ratingId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.copyOf(RatingSchemeItemUsageCount)"
  })
  void testCopyOf_thenReturnRatingIdIsOne() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount instance =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableRatingSchemeItemUsageCount actualCopyOfResult =
        ImmutableRatingSchemeItemUsageCount.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.ratingId());
    assertEquals(1L, actualCopyOfResult.schemeId());
    assertEquals(3, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, actualCopyOfResult.usageKind());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}, and {@link
   * ImmutableRatingSchemeItemUsageCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount2 =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableRatingSchemeItemUsageCount, immutableRatingSchemeItemUsageCount2);
    assertEquals(
        immutableRatingSchemeItemUsageCount.hashCode(),
        immutableRatingSchemeItemUsageCount2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}, and {@link
   * ImmutableRatingSchemeItemUsageCount#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableRatingSchemeItemUsageCount, immutableRatingSchemeItemUsageCount);
    int expectedHashCodeResult = immutableRatingSchemeItemUsageCount.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingSchemeItemUsageCount.hashCode());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(1)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItemUsageCount,
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(2L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItemUsageCount,
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(2L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItemUsageCount,
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItemUsageCount,
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItemUsageCount.equals(Object)",
    "int ImmutableRatingSchemeItemUsageCount.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableRatingSchemeItemUsageCount");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#toString()}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#count()}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#ratingId()}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#schemeId()}
   *   <li>{@link ImmutableRatingSchemeItemUsageCount#usageKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableRatingSchemeItemUsageCount.count()",
    "long ImmutableRatingSchemeItemUsageCount.ratingId()",
    "long ImmutableRatingSchemeItemUsageCount.schemeId()",
    "String ImmutableRatingSchemeItemUsageCount.toString()",
    "EntityKind ImmutableRatingSchemeItemUsageCount.usageKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    String actualToStringResult = immutableRatingSchemeItemUsageCount.toString();
    int actualCountResult = immutableRatingSchemeItemUsageCount.count();
    long actualRatingIdResult = immutableRatingSchemeItemUsageCount.ratingId();
    long actualSchemeIdResult = immutableRatingSchemeItemUsageCount.schemeId();

    // Assert
    assertEquals(
        "RatingSchemeItemUsageCount{schemeId=1, ratingId=1, usageKind=ALL, count=3}",
        actualToStringResult);
    assertEquals(1L, actualRatingIdResult);
    assertEquals(1L, actualSchemeIdResult);
    assertEquals(3, actualCountResult);
    assertEquals(EntityKind.ALL, immutableRatingSchemeItemUsageCount.usageKind());
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
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setUsageKind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setUsageKind(EntityKind)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setUsageKind(EntityKind.ALL);

    // Assert
    assertEquals(0, actualJson.count);
    assertEquals(0L, actualJson.ratingId);
    assertEquals(0L, actualJson.schemeId);
    assertEquals(EntityKind.ALL, actualJson.usageKind);
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.ratingIdIsSet);
    assertFalse(actualJson.schemeIdIsSet);
  }

  /**
   * Test Json {@link Json#ratingId()}.
   *
   * <p>Method under test: {@link Json#ratingId()}
   */
  @Test
  @DisplayName("Test Json ratingId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingId()"})
  void testJsonRatingId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingId());
  }

  /**
   * Test Json {@link Json#schemeId()}.
   *
   * <p>Method under test: {@link Json#schemeId()}
   */
  @Test
  @DisplayName("Test Json schemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.schemeId()"})
  void testJsonSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().schemeId());
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   *
   * <p>Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setRatingId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingId(long)"})
  void testJsonSetRatingId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingId(1L);

    // Assert
    assertEquals(1L, json.ratingId);
    assertTrue(json.ratingIdIsSet);
  }

  /**
   * Test Json {@link Json#setSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setSchemeId(long)"})
  void testJsonSetSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setSchemeId(1L);

    // Assert
    assertEquals(1L, json.schemeId);
    assertTrue(json.schemeIdIsSet);
  }

  /**
   * Test Json {@link Json#usageKind()}.
   *
   * <p>Method under test: {@link Json#usageKind()}
   */
  @Test
  @DisplayName("Test Json usageKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.usageKind()"})
  void testJsonUsageKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().usageKind());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withCount(int)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withCount(int)"
  })
  void testWithCount() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(42)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableRatingSchemeItemUsageCount actualWithCountResult =
        immutableRatingSchemeItemUsageCount.withCount(42);

    // Assert
    assertSame(immutableRatingSchemeItemUsageCount, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withCount(int)}.
   *
   * <ul>
   *   <li>Then return ratingId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int); then return ratingId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withCount(int)"
  })
  void testWithCount_thenReturnRatingIdIsOne() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount actualWithCountResult =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build()
            .withCount(42);

    // Assert
    assertEquals(1L, actualWithCountResult.ratingId());
    assertEquals(1L, actualWithCountResult.schemeId());
    assertEquals(42, actualWithCountResult.count());
    assertEquals(EntityKind.ALL, actualWithCountResult.usageKind());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withRatingId(long)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withRatingId(long)"
  })
  void testWithRatingId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(42L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableRatingSchemeItemUsageCount actualWithRatingIdResult =
        immutableRatingSchemeItemUsageCount.withRatingId(42L);

    // Assert
    assertSame(immutableRatingSchemeItemUsageCount, actualWithRatingIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withRatingId(long)}.
   *
   * <ul>
   *   <li>Then return schemeId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withRatingId(long)}
   */
  @Test
  @DisplayName("Test withRatingId(long); then return schemeId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withRatingId(long)"
  })
  void testWithRatingId_thenReturnSchemeIdIsOne() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount actualWithRatingIdResult =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build()
            .withRatingId(42L);

    // Assert
    assertEquals(1L, actualWithRatingIdResult.schemeId());
    assertEquals(3, actualWithRatingIdResult.count());
    assertEquals(42L, actualWithRatingIdResult.ratingId());
    assertEquals(EntityKind.ALL, actualWithRatingIdResult.usageKind());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withSchemeId(long)}
   */
  @Test
  @DisplayName("Test withSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withSchemeId(long)"
  })
  void testWithSchemeId() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(42L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableRatingSchemeItemUsageCount actualWithSchemeIdResult =
        immutableRatingSchemeItemUsageCount.withSchemeId(42L);

    // Assert
    assertSame(immutableRatingSchemeItemUsageCount, actualWithSchemeIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withSchemeId(long)}.
   *
   * <ul>
   *   <li>Then return ratingId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withSchemeId(long)}
   */
  @Test
  @DisplayName("Test withSchemeId(long); then return ratingId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withSchemeId(long)"
  })
  void testWithSchemeId_thenReturnRatingIdIsOne() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount actualWithSchemeIdResult =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build()
            .withSchemeId(42L);

    // Assert
    assertEquals(1L, actualWithSchemeIdResult.ratingId());
    assertEquals(3, actualWithSchemeIdResult.count());
    assertEquals(42L, actualWithSchemeIdResult.schemeId());
    assertEquals(EntityKind.ALL, actualWithSchemeIdResult.usageKind());
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withUsageKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withUsageKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withUsageKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withUsageKind(EntityKind)"
  })
  void testWithUsageKind() {
    // Arrange
    ImmutableRatingSchemeItemUsageCount immutableRatingSchemeItemUsageCount =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableRatingSchemeItemUsageCount actualWithUsageKindResult =
        immutableRatingSchemeItemUsageCount.withUsageKind(EntityKind.ALL);

    // Assert
    assertSame(immutableRatingSchemeItemUsageCount, actualWithUsageKindResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItemUsageCount#withUsageKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return ratingId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItemUsageCount#withUsageKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withUsageKind(EntityKind); then return ratingId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItemUsageCount ImmutableRatingSchemeItemUsageCount.withUsageKind(EntityKind)"
  })
  void testWithUsageKind_thenReturnRatingIdIsOne() {
    // Arrange and Act
    ImmutableRatingSchemeItemUsageCount actualWithUsageKindResult =
        ImmutableRatingSchemeItemUsageCount.builder()
            .count(3)
            .ratingId(1L)
            .schemeId(1L)
            .usageKind(EntityKind.ACTOR)
            .build()
            .withUsageKind(EntityKind.ALL);

    // Assert
    assertEquals(1L, actualWithUsageKindResult.ratingId());
    assertEquals(1L, actualWithUsageKindResult.schemeId());
    assertEquals(3, actualWithUsageKindResult.count());
    assertEquals(EntityKind.ALL, actualWithUsageKindResult.usageKind());
  }
}
