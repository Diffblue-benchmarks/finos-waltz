package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityEntry.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableComplexityEntry.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableComplexityEntryDiffblueTest {
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
    Builder builderResult = ImmutableComplexityEntry.builder();

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
   *   <li>{@link Builder#complexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityEntry Builder.build()",
    "Builder Builder.complexityScore(BigDecimal)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualComplexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    BigDecimal complexityScore = new BigDecimal("2.3");
    ImmutableComplexityEntry actualImmutableComplexityEntry =
        actualComplexityKindIdResult.complexityScore(complexityScore).build();

    // Assert
    assertEquals(1L, actualImmutableComplexityEntry.appId());
    assertEquals(1L, actualImmutableComplexityEntry.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    BigDecimal complexityScoreResult = actualImmutableComplexityEntry.complexityScore();
    assertEquals(expectedComplexityScoreResult, complexityScoreResult);
    assertSame(complexityScore, complexityScoreResult);
  }

  /**
   * Test Builder {@link Builder#complexityKindId(long)}.
   *
   * <p>Method under test: {@link Builder#complexityKindId(long)}
   */
  @Test
  @DisplayName("Test Builder complexityKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.complexityKindId(long)"})
  void testBuilderComplexityKindId() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();

    // Act
    Builder actualComplexityKindIdResult = builderResult.complexityKindId(1L);

    // Assert
    assertSame(builderResult, actualComplexityKindIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityEntry)}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityEntry)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();

    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry instance =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act and Assert
    ImmutableComplexityEntry actualImmutableComplexityEntry = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableComplexityEntry);
    ImmutableComplexityEntry actualImmutableComplexityEntry2 = builderResult.build();
    assertEquals(instance, actualImmutableComplexityEntry2);
  }

  /**
   * Test Builder {@link Builder#from(ComplexityEntry)}.
   *
   * <p>Method under test: {@link Builder#from(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test Builder from(ComplexityEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ComplexityEntry)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableComplexityEntry.builder();
    ImmutableComplexityEntry instance =
        ImmutableComplexityEntry.builder()
            .appId(1L)
            .complexityKindId(1L)
            .complexityScore(null)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableComplexityEntry actualImmutableComplexityEntry = builderResult.build();
    assertEquals(instance, actualImmutableComplexityEntry);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableComplexityEntry#copyOf(ComplexityEntry)}.
   *
   * <ul>
   *   <li>Then return appId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#copyOf(ComplexityEntry)}
   */
  @Test
  @DisplayName("Test copyOf(ComplexityEntry); then return appId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityEntry ImmutableComplexityEntry.copyOf(ComplexityEntry)"})
  void testCopyOf_thenReturnAppIdIsOne() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry instance =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityEntry actualCopyOfResult = ImmutableComplexityEntry.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.appId());
    assertEquals(1L, actualCopyOfResult.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    assertEquals(expectedComplexityScoreResult, actualCopyOfResult.complexityScore());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}, and {@link
   * ImmutableComplexityEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityEntry#equals(Object)}
   *   <li>{@link ImmutableComplexityEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry2 =
        complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexityEntry, immutableComplexityEntry2);
    assertEquals(immutableComplexityEntry.hashCode(), immutableComplexityEntry2.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}, and {@link
   * ImmutableComplexityEntry#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityEntry#equals(Object)}
   *   <li>{@link ImmutableComplexityEntry#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act and Assert
    assertEquals(immutableComplexityEntry, immutableComplexityEntry);
    int expectedHashCodeResult = immutableComplexityEntry.hashCode();
    assertEquals(expectedHashCodeResult, immutableComplexityEntry.hashCode());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(2L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableComplexityEntry,
        complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(2L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableComplexityEntry,
        complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("4.5")).build();

    Builder complexityKindIdResult2 =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act and Assert
    assertNotEquals(
        immutableComplexityEntry,
        complexityKindIdResult2.complexityScore(new BigDecimal("2.3")).build());
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act and Assert
    assertNotEquals(complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build(), null);
  }

  /**
   * Test {@link ImmutableComplexityEntry#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableComplexityEntry.equals(Object)",
    "int ImmutableComplexityEntry.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act and Assert
    assertNotEquals(
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build(),
        "Different type to ImmutableComplexityEntry");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableComplexityEntry#toString()}
   *   <li>{@link ImmutableComplexityEntry#appId()}
   *   <li>{@link ImmutableComplexityEntry#complexityKindId()}
   *   <li>{@link ImmutableComplexityEntry#complexityScore()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableComplexityEntry.appId()",
    "long ImmutableComplexityEntry.complexityKindId()",
    "BigDecimal ImmutableComplexityEntry.complexityScore()",
    "String ImmutableComplexityEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    BigDecimal complexityScore = new BigDecimal("2.3");
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(complexityScore).build();

    // Act
    String actualToStringResult = immutableComplexityEntry.toString();
    long actualAppIdResult = immutableComplexityEntry.appId();
    long actualComplexityKindIdResult = immutableComplexityEntry.complexityKindId();
    BigDecimal actualComplexityScoreResult = immutableComplexityEntry.complexityScore();

    // Assert
    assertEquals(
        "ComplexityEntry{appId=1, complexityKindId=1, complexityScore=2.3}", actualToStringResult);
    assertEquals(1L, actualAppIdResult);
    assertEquals(1L, actualComplexityKindIdResult);
    assertEquals(new BigDecimal("2.3"), actualComplexityScoreResult);
    assertSame(complexityScore, actualComplexityScoreResult);
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
   * Test Json {@link Json#complexityKindId()}.
   *
   * <p>Method under test: {@link Json#complexityKindId()}
   */
  @Test
  @DisplayName("Test Json complexityKindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.complexityKindId()"})
  void testJsonComplexityKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexityKindId());
  }

  /**
   * Test Json {@link Json#complexityScore()}.
   *
   * <p>Method under test: {@link Json#complexityScore()}
   */
  @Test
  @DisplayName("Test Json complexityScore()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal Json.complexityScore()"})
  void testJsonComplexityScore() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().complexityScore());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setComplexityScore(BigDecimal)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setComplexityScore(BigDecimal)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setComplexityScore(new BigDecimal("2.3"));

    // Assert
    assertEquals(0L, actualJson.appId);
    assertEquals(0L, actualJson.complexityKindId);
    assertFalse(actualJson.appIdIsSet);
    assertFalse(actualJson.complexityKindIdIsSet);
    assertEquals(new BigDecimal("2.3"), actualJson.complexityScore);
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
   * Test Json {@link Json#setComplexityKindId(long)}.
   *
   * <p>Method under test: {@link Json#setComplexityKindId(long)}
   */
  @Test
  @DisplayName("Test Json setComplexityKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setComplexityKindId(long)"})
  void testJsonSetComplexityKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setComplexityKindId(1L);

    // Assert
    assertEquals(1L, json.complexityKindId);
    assertTrue(json.complexityKindIdIsSet);
  }

  /**
   * Test {@link ImmutableComplexityEntry#withAppId(long)}.
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityEntry ImmutableComplexityEntry.withAppId(long)"})
  void testWithAppId() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(42L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityEntry actualWithAppIdResult = immutableComplexityEntry.withAppId(42L);

    // Assert
    assertSame(immutableComplexityEntry, actualWithAppIdResult);
  }

  /**
   * Test {@link ImmutableComplexityEntry#withAppId(long)}.
   *
   * <ul>
   *   <li>Then return complexityKindId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withAppId(long)}
   */
  @Test
  @DisplayName("Test withAppId(long); then return complexityKindId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableComplexityEntry ImmutableComplexityEntry.withAppId(long)"})
  void testWithAppId_thenReturnComplexityKindIdIsOne() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act
    ImmutableComplexityEntry actualWithAppIdResult =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build().withAppId(42L);

    // Assert
    assertEquals(1L, actualWithAppIdResult.complexityKindId());
    assertEquals(42L, actualWithAppIdResult.appId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    assertEquals(expectedComplexityScoreResult, actualWithAppIdResult.complexityScore());
  }

  /**
   * Test {@link ImmutableComplexityEntry#withComplexityKindId(long)}.
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withComplexityKindId(long)}
   */
  @Test
  @DisplayName("Test withComplexityKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityEntry ImmutableComplexityEntry.withComplexityKindId(long)"
  })
  void testWithComplexityKindId() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(42L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityEntry actualWithComplexityKindIdResult =
        immutableComplexityEntry.withComplexityKindId(42L);

    // Assert
    assertSame(immutableComplexityEntry, actualWithComplexityKindIdResult);
  }

  /**
   * Test {@link ImmutableComplexityEntry#withComplexityKindId(long)}.
   *
   * <ul>
   *   <li>Then return appId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withComplexityKindId(long)}
   */
  @Test
  @DisplayName("Test withComplexityKindId(long); then return appId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityEntry ImmutableComplexityEntry.withComplexityKindId(long)"
  })
  void testWithComplexityKindId_thenReturnAppIdIsOne() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);

    // Act
    ImmutableComplexityEntry actualWithComplexityKindIdResult =
        complexityKindIdResult
            .complexityScore(new BigDecimal("2.3"))
            .build()
            .withComplexityKindId(42L);

    // Assert
    assertEquals(1L, actualWithComplexityKindIdResult.appId());
    assertEquals(42L, actualWithComplexityKindIdResult.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    assertEquals(expectedComplexityScoreResult, actualWithComplexityKindIdResult.complexityScore());
  }

  /**
   * Test {@link ImmutableComplexityEntry#withComplexityScore(BigDecimal)}.
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withComplexityScore(BigDecimal)}
   */
  @Test
  @DisplayName("Test withComplexityScore(BigDecimal)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityEntry ImmutableComplexityEntry.withComplexityScore(BigDecimal)"
  })
  void testWithComplexityScore() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("2.3")).build();

    // Act
    ImmutableComplexityEntry actualWithComplexityScoreResult =
        immutableComplexityEntry.withComplexityScore(new BigDecimal("2.3"));

    // Assert
    assertSame(immutableComplexityEntry, actualWithComplexityScoreResult);
  }

  /**
   * Test {@link ImmutableComplexityEntry#withComplexityScore(BigDecimal)}.
   *
   * <ul>
   *   <li>Then return appId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableComplexityEntry#withComplexityScore(BigDecimal)}
   */
  @Test
  @DisplayName("Test withComplexityScore(BigDecimal); then return appId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableComplexityEntry ImmutableComplexityEntry.withComplexityScore(BigDecimal)"
  })
  void testWithComplexityScore_thenReturnAppIdIsOne() {
    // Arrange
    Builder complexityKindIdResult =
        ImmutableComplexityEntry.builder().appId(1L).complexityKindId(1L);
    ImmutableComplexityEntry immutableComplexityEntry =
        complexityKindIdResult.complexityScore(new BigDecimal("4.5")).build();

    // Act
    ImmutableComplexityEntry actualWithComplexityScoreResult =
        immutableComplexityEntry.withComplexityScore(new BigDecimal("2.3"));

    // Assert
    assertEquals(1L, actualWithComplexityScoreResult.appId());
    assertEquals(1L, actualWithComplexityScoreResult.complexityKindId());
    BigDecimal expectedComplexityScoreResult = new BigDecimal("2.3");
    assertEquals(expectedComplexityScoreResult, actualWithComplexityScoreResult.complexityScore());
  }
}
