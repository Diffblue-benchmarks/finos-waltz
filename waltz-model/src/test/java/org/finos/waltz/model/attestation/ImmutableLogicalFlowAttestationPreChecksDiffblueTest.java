package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowAttestationPreChecksDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#deprecatedCount(int)}
   */
  @Test
  void testBuilderDeprecatedCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.deprecatedCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#exemptFromDeprecatedCheck(boolean)}
   */
  @Test
  void testBuilderExemptFromDeprecatedCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromDeprecatedCheck(true));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#exemptFromFlowCountCheck(boolean)}
   */
  @Test
  void testBuilderExemptFromFlowCountCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromFlowCountCheck(true));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#exemptFromUnknownCheck(boolean)}
   */
  @Test
  void testBuilderExemptFromUnknownCheck() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromUnknownCheck(true));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#flowCount(int)}
   */
  @Test
  void testBuilderFlowCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#from(LogicalFlowAttestationPreChecks)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();
    LogicalFlowAttestationPreChecks instance = mock(LogicalFlowAttestationPreChecks.class);
    when(instance.exemptFromDeprecatedCheck()).thenReturn(true);
    when(instance.exemptFromFlowCountCheck()).thenReturn(true);
    when(instance.exemptFromUnknownCheck()).thenReturn(true);
    when(instance.deprecatedCount()).thenReturn(3);
    when(instance.flowCount()).thenReturn(3);
    when(instance.unknownCount()).thenReturn(3);

    // Act
    ImmutableLogicalFlowAttestationPreChecks.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).deprecatedCount();
    verify(instance).exemptFromDeprecatedCheck();
    verify(instance).exemptFromFlowCountCheck();
    verify(instance).exemptFromUnknownCheck();
    verify(instance).flowCount();
    verify(instance).unknownCount();
    ImmutableLogicalFlowAttestationPreChecks buildResult = builderResult.build();
    assertEquals(3, buildResult.deprecatedCount());
    assertEquals(3, buildResult.flowCount());
    assertEquals(3, buildResult.unknownCount());
    assertTrue(buildResult.exemptFromDeprecatedCheck());
    assertTrue(buildResult.exemptFromFlowCountCheck());
    assertTrue(buildResult.exemptFromUnknownCheck());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#from(LogicalFlowAttestationPreChecks)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();
    LogicalFlowAttestationPreChecks instance = mock(LogicalFlowAttestationPreChecks.class);
    when(instance.flowCount()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).flowCount();
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks.Builder#unknownCount(int)}
   */
  @Test
  void testBuilderUnknownCount() {
    // Arrange
    ImmutableLogicalFlowAttestationPreChecks.Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknownCount(3));
  }

  /**
   * Method under test:
   * {@link ImmutableLogicalFlowAttestationPreChecks#copyOf(LogicalFlowAttestationPreChecks)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    LogicalFlowAttestationPreChecks instance = mock(LogicalFlowAttestationPreChecks.class);
    when(instance.exemptFromDeprecatedCheck()).thenReturn(true);
    when(instance.exemptFromFlowCountCheck()).thenReturn(true);
    when(instance.exemptFromUnknownCheck()).thenReturn(true);
    when(instance.deprecatedCount()).thenReturn(3);
    when(instance.flowCount()).thenReturn(3);
    when(instance.unknownCount()).thenReturn(3);

    // Act
    ImmutableLogicalFlowAttestationPreChecks actualCopyOfResult = ImmutableLogicalFlowAttestationPreChecks
        .copyOf(instance);

    // Assert
    verify(instance).deprecatedCount();
    verify(instance).exemptFromDeprecatedCheck();
    verify(instance).exemptFromFlowCountCheck();
    verify(instance).exemptFromUnknownCheck();
    verify(instance).flowCount();
    verify(instance).unknownCount();
    assertEquals(3, actualCopyOfResult.deprecatedCount());
    assertEquals(3, actualCopyOfResult.flowCount());
    assertEquals(3, actualCopyOfResult.unknownCount());
    assertTrue(actualCopyOfResult.exemptFromDeprecatedCheck());
    assertTrue(actualCopyOfResult.exemptFromFlowCountCheck());
    assertTrue(actualCopyOfResult.exemptFromUnknownCheck());
  }
}
