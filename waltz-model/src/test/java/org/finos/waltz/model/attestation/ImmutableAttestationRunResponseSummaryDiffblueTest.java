package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationRunResponseSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRunResponseSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunResponseSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAttestationRunResponseSummary Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableAttestationRunResponseSummary actualImmutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Assert
    assertEquals(1L, actualImmutableAttestationRunResponseSummary.runId());
    assertEquals(3L, actualImmutableAttestationRunResponseSummary.completeCount());
    assertEquals(3L, actualImmutableAttestationRunResponseSummary.pendingCount());
  }

  /**
   * Test Builder {@link Builder#completeCount(long)}.
   *
   * <p>Method under test: {@link Builder#completeCount(long)}
   */
  @Test
  @DisplayName("Test Builder completeCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.completeCount(long)"})
  void testBuilderCompleteCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act
    Builder actualCompleteCountResult = builderResult.completeCount(3L);

    // Assert
    assertSame(builderResult, actualCompleteCountResult);
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunResponseSummary)}.
   *
   * <p>Method under test: {@link Builder#from(AttestationRunResponseSummary)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunResponseSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AttestationRunResponseSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();
    ImmutableAttestationRunResponseSummary instance =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableAttestationRunResponseSummary actualImmutableAttestationRunResponseSummary =
        builderResult.build();
    assertEquals(instance, actualImmutableAttestationRunResponseSummary);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#pendingCount(long)}.
   *
   * <p>Method under test: {@link Builder#pendingCount(long)}
   */
  @Test
  @DisplayName("Test Builder pendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.pendingCount(long)"})
  void testBuilderPendingCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act
    Builder actualPendingCountResult = builderResult.pendingCount(3L);

    // Assert
    assertSame(builderResult, actualPendingCountResult);
  }

  /**
   * Test Builder {@link Builder#runId(long)}.
   *
   * <p>Method under test: {@link Builder#runId(long)}
   */
  @Test
  @DisplayName("Test Builder runId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.runId(long)"})
  void testBuilderRunId() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act
    Builder actualRunIdResult = builderResult.runId(1L);

    // Assert
    assertSame(builderResult, actualRunIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#copyOf(AttestationRunResponseSummary)}.
   *
   * <ul>
   *   <li>Then return runId is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableAttestationRunResponseSummary#copyOf(AttestationRunResponseSummary)}
   */
  @Test
  @DisplayName("Test copyOf(AttestationRunResponseSummary); then return runId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.copyOf(AttestationRunResponseSummary)"
  })
  void testCopyOf_thenReturnRunIdIsOne() {
    // Arrange
    ImmutableAttestationRunResponseSummary instance =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act
    ImmutableAttestationRunResponseSummary actualCopyOfResult =
        ImmutableAttestationRunResponseSummary.copyOf(instance);

    // Assert
    assertEquals(1L, actualCopyOfResult.runId());
    assertEquals(3L, actualCopyOfResult.completeCount());
    assertEquals(3L, actualCopyOfResult.pendingCount());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}, and {@link
   * ImmutableAttestationRunResponseSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunResponseSummary#equals(Object)}
   *   <li>{@link ImmutableAttestationRunResponseSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary2 =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunResponseSummary, immutableAttestationRunResponseSummary2);
    assertEquals(
        immutableAttestationRunResponseSummary.hashCode(),
        immutableAttestationRunResponseSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}, and {@link
   * ImmutableAttestationRunResponseSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunResponseSummary#equals(Object)}
   *   <li>{@link ImmutableAttestationRunResponseSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableAttestationRunResponseSummary, immutableAttestationRunResponseSummary);
    int expectedHashCodeResult = immutableAttestationRunResponseSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableAttestationRunResponseSummary.hashCode());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(1L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunResponseSummary,
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(1L)
            .runId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunResponseSummary,
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableAttestationRunResponseSummary,
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAttestationRunResponseSummary.equals(Object)",
    "int ImmutableAttestationRunResponseSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build(),
        "Different type to ImmutableAttestationRunResponseSummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAttestationRunResponseSummary#toString()}
   *   <li>{@link ImmutableAttestationRunResponseSummary#completeCount()}
   *   <li>{@link ImmutableAttestationRunResponseSummary#pendingCount()}
   *   <li>{@link ImmutableAttestationRunResponseSummary#runId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableAttestationRunResponseSummary.completeCount()",
    "long ImmutableAttestationRunResponseSummary.pendingCount()",
    "long ImmutableAttestationRunResponseSummary.runId()",
    "String ImmutableAttestationRunResponseSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act
    String actualToStringResult = immutableAttestationRunResponseSummary.toString();
    long actualCompleteCountResult = immutableAttestationRunResponseSummary.completeCount();
    long actualPendingCountResult = immutableAttestationRunResponseSummary.pendingCount();

    // Assert
    assertEquals(
        "AttestationRunResponseSummary{runId=1, completeCount=3, pendingCount=3}",
        actualToStringResult);
    assertEquals(1L, immutableAttestationRunResponseSummary.runId());
    assertEquals(3L, actualCompleteCountResult);
    assertEquals(3L, actualPendingCountResult);
  }

  /**
   * Test Json {@link Json#completeCount()}.
   *
   * <p>Method under test: {@link Json#completeCount()}
   */
  @Test
  @DisplayName("Test Json completeCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.completeCount()"})
  void testJsonCompleteCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().completeCount());
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
    assertEquals(0L, actualJson.completeCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.runId);
    assertFalse(actualJson.completeCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.runIdIsSet);
  }

  /**
   * Test Json {@link Json#pendingCount()}.
   *
   * <p>Method under test: {@link Json#pendingCount()}
   */
  @Test
  @DisplayName("Test Json pendingCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.pendingCount()"})
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().pendingCount());
  }

  /**
   * Test Json {@link Json#runId()}.
   *
   * <p>Method under test: {@link Json#runId()}
   */
  @Test
  @DisplayName("Test Json runId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.runId()"})
  void testJsonRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().runId());
  }

  /**
   * Test Json {@link Json#setCompleteCount(long)}.
   *
   * <p>Method under test: {@link Json#setCompleteCount(long)}
   */
  @Test
  @DisplayName("Test Json setCompleteCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCompleteCount(long)"})
  void testJsonSetCompleteCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCompleteCount(3L);

    // Assert
    assertEquals(3L, json.completeCount);
    assertTrue(json.completeCountIsSet);
  }

  /**
   * Test Json {@link Json#setPendingCount(long)}.
   *
   * <p>Method under test: {@link Json#setPendingCount(long)}
   */
  @Test
  @DisplayName("Test Json setPendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPendingCount(long)"})
  void testJsonSetPendingCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPendingCount(3L);

    // Assert
    assertEquals(3L, json.pendingCount);
    assertTrue(json.pendingCountIsSet);
  }

  /**
   * Test Json {@link Json#setRunId(long)}.
   *
   * <p>Method under test: {@link Json#setRunId(long)}
   */
  @Test
  @DisplayName("Test Json setRunId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRunId(long)"})
  void testJsonSetRunId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRunId(1L);

    // Assert
    assertEquals(1L, json.runId);
    assertTrue(json.runIdIsSet);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withCompleteCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withCompleteCount(long)}
   */
  @Test
  @DisplayName("Test withCompleteCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withCompleteCount(long)"
  })
  void testWithCompleteCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(42L)
            .pendingCount(3L)
            .runId(1L)
            .build();

    // Act
    ImmutableAttestationRunResponseSummary actualWithCompleteCountResult =
        immutableAttestationRunResponseSummary.withCompleteCount(42L);

    // Assert
    assertSame(immutableAttestationRunResponseSummary, actualWithCompleteCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withCompleteCount(long)}.
   *
   * <ul>
   *   <li>Then return runId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withCompleteCount(long)}
   */
  @Test
  @DisplayName("Test withCompleteCount(long); then return runId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withCompleteCount(long)"
  })
  void testWithCompleteCount_thenReturnRunIdIsOne() {
    // Arrange and Act
    ImmutableAttestationRunResponseSummary actualWithCompleteCountResult =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build()
            .withCompleteCount(42L);

    // Assert
    assertEquals(1L, actualWithCompleteCountResult.runId());
    assertEquals(3L, actualWithCompleteCountResult.pendingCount());
    assertEquals(42L, actualWithCompleteCountResult.completeCount());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withPendingCount(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withPendingCount(long)}
   */
  @Test
  @DisplayName("Test withPendingCount(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withPendingCount(long)"
  })
  void testWithPendingCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(42L)
            .runId(1L)
            .build();

    // Act
    ImmutableAttestationRunResponseSummary actualWithPendingCountResult =
        immutableAttestationRunResponseSummary.withPendingCount(42L);

    // Assert
    assertSame(immutableAttestationRunResponseSummary, actualWithPendingCountResult);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withPendingCount(long)}.
   *
   * <ul>
   *   <li>Then return runId is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withPendingCount(long)}
   */
  @Test
  @DisplayName("Test withPendingCount(long); then return runId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withPendingCount(long)"
  })
  void testWithPendingCount_thenReturnRunIdIsOne() {
    // Arrange and Act
    ImmutableAttestationRunResponseSummary actualWithPendingCountResult =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build()
            .withPendingCount(42L);

    // Assert
    assertEquals(1L, actualWithPendingCountResult.runId());
    assertEquals(3L, actualWithPendingCountResult.completeCount());
    assertEquals(42L, actualWithPendingCountResult.pendingCount());
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withRunId(long)}.
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withRunId(long)}
   */
  @Test
  @DisplayName("Test withRunId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withRunId(long)"
  })
  void testWithRunId() {
    // Arrange
    ImmutableAttestationRunResponseSummary immutableAttestationRunResponseSummary =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(42L)
            .build();

    // Act
    ImmutableAttestationRunResponseSummary actualWithRunIdResult =
        immutableAttestationRunResponseSummary.withRunId(42L);

    // Assert
    assertSame(immutableAttestationRunResponseSummary, actualWithRunIdResult);
  }

  /**
   * Test {@link ImmutableAttestationRunResponseSummary#withRunId(long)}.
   *
   * <ul>
   *   <li>Then return completeCount is three.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAttestationRunResponseSummary#withRunId(long)}
   */
  @Test
  @DisplayName("Test withRunId(long); then return completeCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAttestationRunResponseSummary ImmutableAttestationRunResponseSummary.withRunId(long)"
  })
  void testWithRunId_thenReturnCompleteCountIsThree() {
    // Arrange and Act
    ImmutableAttestationRunResponseSummary actualWithRunIdResult =
        ImmutableAttestationRunResponseSummary.builder()
            .completeCount(3L)
            .pendingCount(3L)
            .runId(1L)
            .build()
            .withRunId(42L);

    // Assert
    assertEquals(3L, actualWithRunIdResult.completeCount());
    assertEquals(3L, actualWithRunIdResult.pendingCount());
    assertEquals(42L, actualWithRunIdResult.runId());
  }
}
