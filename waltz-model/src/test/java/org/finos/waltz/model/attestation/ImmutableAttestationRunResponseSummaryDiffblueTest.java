package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableAttestationRunResponseSummary.Builder;
import org.finos.waltz.model.attestation.ImmutableAttestationRunResponseSummary.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunResponseSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#completeCount(long)}.
   * <p>
   * Method under test: {@link Builder#completeCount(long)}
   */
  @Test
  @DisplayName("Test Builder completeCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.completeCount(long)"})
  void testBuilderCompleteCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completeCount(3L));
  }

  /**
   * Test Builder {@link Builder#from(AttestationRunResponseSummary)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then builder build runId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AttestationRunResponseSummary)}
   */
  @Test
  @DisplayName("Test Builder from(AttestationRunResponseSummary); given three; then builder build runId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AttestationRunResponseSummary)"})
  void testBuilderFrom_givenThree_thenBuilderBuildRunIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();
    AttestationRunResponseSummary instance = mock(AttestationRunResponseSummary.class);
    when(instance.completeCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.runId()).thenReturn(1L);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).completeCount();
    verify(instance).pendingCount();
    verify(instance).runId();
    ImmutableAttestationRunResponseSummary buildResult = builderResult.build();
    assertEquals(1L, buildResult.runId());
    assertEquals(3L, buildResult.completeCount());
    assertEquals(3L, buildResult.pendingCount());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#pendingCount(long)}.
   * <p>
   * Method under test: {@link Builder#pendingCount(long)}
   */
  @Test
  @DisplayName("Test Builder pendingCount(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.pendingCount(long)"})
  void testBuilderPendingCount() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pendingCount(3L));
  }

  /**
   * Test Builder {@link Builder#runId(long)}.
   * <p>
   * Method under test: {@link Builder#runId(long)}
   */
  @Test
  @DisplayName("Test Builder runId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.runId(long)"})
  void testBuilderRunId() {
    // Arrange
    Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.runId(1L));
  }

  /**
   * Test Json {@link Json#completeCount()}.
   * <p>
   * Method under test: {@link Json#completeCount()}
   */
  @Test
  @DisplayName("Test Json completeCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.completeCount()"})
  void testJsonCompleteCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).completeCount());
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
    assertEquals(0L, actualJson.completeCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.runId);
    assertFalse(actualJson.completeCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.runIdIsSet);
  }

  /**
   * Test Json {@link Json#pendingCount()}.
   * <p>
   * Method under test: {@link Json#pendingCount()}
   */
  @Test
  @DisplayName("Test Json pendingCount()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.pendingCount()"})
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).pendingCount());
  }

  /**
   * Test Json {@link Json#runId()}.
   * <p>
   * Method under test: {@link Json#runId()}
   */
  @Test
  @DisplayName("Test Json runId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.runId()"})
  void testJsonRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).runId());
  }

  /**
   * Test Json {@link Json#setCompleteCount(long)}.
   * <p>
   * Method under test: {@link Json#setCompleteCount(long)}
   */
  @Test
  @DisplayName("Test Json setCompleteCount(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setPendingCount(long)}
   */
  @Test
  @DisplayName("Test Json setPendingCount(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setRunId(long)}
   */
  @Test
  @DisplayName("Test Json setRunId(long)")
  @Tag("MaintainedByDiffblue")
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
}
