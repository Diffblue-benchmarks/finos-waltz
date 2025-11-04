package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableAttestationRunResponseSummaryDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Builder#completeCount(long)}
   */
  @Test
  void testBuilderCompleteCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.completeCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Builder#from(AttestationRunResponseSummary)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Builder builderResult = ImmutableAttestationRunResponseSummary.builder();
    AttestationRunResponseSummary instance = mock(AttestationRunResponseSummary.class);
    when(instance.completeCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.runId()).thenReturn(1L);

    // Act
    ImmutableAttestationRunResponseSummary.Builder actualFromResult = builderResult.from(instance);

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
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Builder#pendingCount(long)}
   */
  @Test
  void testBuilderPendingCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.pendingCount(3L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Builder#runId(long)}
   */
  @Test
  void testBuilderRunId() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Builder builderResult = ImmutableAttestationRunResponseSummary.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.runId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary#copyOf(AttestationRunResponseSummary)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AttestationRunResponseSummary instance = mock(AttestationRunResponseSummary.class);
    when(instance.completeCount()).thenReturn(3L);
    when(instance.pendingCount()).thenReturn(3L);
    when(instance.runId()).thenReturn(1L);

    // Act
    ImmutableAttestationRunResponseSummary actualCopyOfResult = ImmutableAttestationRunResponseSummary.copyOf(instance);

    // Assert
    verify(instance).completeCount();
    verify(instance).pendingCount();
    verify(instance).runId();
    assertEquals(1L, actualCopyOfResult.runId());
    assertEquals(3L, actualCopyOfResult.completeCount());
    assertEquals(3L, actualCopyOfResult.pendingCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#completeCount()}
   */
  @Test
  void testJsonCompleteCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunResponseSummary.Json()).completeCount());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAttestationRunResponseSummary.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAttestationRunResponseSummary.Json actualJson = new ImmutableAttestationRunResponseSummary.Json();

    // Assert
    assertEquals(0L, actualJson.completeCount);
    assertEquals(0L, actualJson.pendingCount);
    assertEquals(0L, actualJson.runId);
    assertFalse(actualJson.completeCountIsSet);
    assertFalse(actualJson.pendingCountIsSet);
    assertFalse(actualJson.runIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#pendingCount()}
   */
  @Test
  void testJsonPendingCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunResponseSummary.Json()).pendingCount());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#runId()}
   */
  @Test
  void testJsonRunId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAttestationRunResponseSummary.Json()).runId());
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#setCompleteCount(long)}
   */
  @Test
  void testJsonSetCompleteCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Json json = new ImmutableAttestationRunResponseSummary.Json();

    // Act
    json.setCompleteCount(3L);

    // Assert
    assertEquals(3L, json.completeCount);
    assertTrue(json.completeCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#setPendingCount(long)}
   */
  @Test
  void testJsonSetPendingCount() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Json json = new ImmutableAttestationRunResponseSummary.Json();

    // Act
    json.setPendingCount(3L);

    // Assert
    assertEquals(3L, json.pendingCount);
    assertTrue(json.pendingCountIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAttestationRunResponseSummary.Json#setRunId(long)}
   */
  @Test
  void testJsonSetRunId() {
    // Arrange
    ImmutableAttestationRunResponseSummary.Json json = new ImmutableAttestationRunResponseSummary.Json();

    // Act
    json.setRunId(1L);

    // Assert
    assertEquals(1L, json.runId);
    assertTrue(json.runIdIsSet);
  }
}
