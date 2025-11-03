package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.attestation.ImmutableLogicalFlowAttestationPreChecks.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLogicalFlowAttestationPreChecksDiffblueTest {
  /**
   * Test Builder {@link Builder#deprecatedCount(int)}.
   * <p>
   * Method under test: {@link Builder#deprecatedCount(int)}
   */
  @Test
  @DisplayName("Test Builder deprecatedCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.deprecatedCount(int)"})
  void testBuilderDeprecatedCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.deprecatedCount(3));
  }

  /**
   * Test Builder {@link Builder#exemptFromDeprecatedCheck(boolean)}.
   * <p>
   * Method under test: {@link Builder#exemptFromDeprecatedCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromDeprecatedCheck(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.exemptFromDeprecatedCheck(boolean)"})
  void testBuilderExemptFromDeprecatedCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromDeprecatedCheck(true));
  }

  /**
   * Test Builder {@link Builder#exemptFromFlowCountCheck(boolean)}.
   * <p>
   * Method under test: {@link Builder#exemptFromFlowCountCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromFlowCountCheck(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.exemptFromFlowCountCheck(boolean)"})
  void testBuilderExemptFromFlowCountCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromFlowCountCheck(true));
  }

  /**
   * Test Builder {@link Builder#exemptFromUnknownCheck(boolean)}.
   * <p>
   * Method under test: {@link Builder#exemptFromUnknownCheck(boolean)}
   */
  @Test
  @DisplayName("Test Builder exemptFromUnknownCheck(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.exemptFromUnknownCheck(boolean)"})
  void testBuilderExemptFromUnknownCheck() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.exemptFromUnknownCheck(true));
  }

  /**
   * Test Builder {@link Builder#flowCount(int)}.
   * <p>
   * Method under test: {@link Builder#flowCount(int)}
   */
  @Test
  @DisplayName("Test Builder flowCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.flowCount(int)"})
  void testBuilderFlowCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.flowCount(3));
  }

  /**
   * Test Builder {@link Builder#from(LogicalFlowAttestationPreChecks)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then builder build deprecatedCount is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowAttestationPreChecks)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowAttestationPreChecks); given 'true'; then builder build deprecatedCount is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowAttestationPreChecks)"})
  void testBuilderFrom_givenTrue_thenBuilderBuildDeprecatedCountIsThree() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();
    LogicalFlowAttestationPreChecks instance = mock(LogicalFlowAttestationPreChecks.class);
    when(instance.exemptFromDeprecatedCheck()).thenReturn(true);
    when(instance.exemptFromFlowCountCheck()).thenReturn(true);
    when(instance.exemptFromUnknownCheck()).thenReturn(true);
    when(instance.deprecatedCount()).thenReturn(3);
    when(instance.flowCount()).thenReturn(3);
    when(instance.unknownCount()).thenReturn(3);

    // Act
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(LogicalFlowAttestationPreChecks)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LogicalFlowAttestationPreChecks)}
   */
  @Test
  @DisplayName("Test Builder from(LogicalFlowAttestationPreChecks); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LogicalFlowAttestationPreChecks)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();
    LogicalFlowAttestationPreChecks instance = mock(LogicalFlowAttestationPreChecks.class);
    when(instance.flowCount()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).flowCount();
  }

  /**
   * Test Builder {@link Builder#unknownCount(int)}.
   * <p>
   * Method under test: {@link Builder#unknownCount(int)}
   */
  @Test
  @DisplayName("Test Builder unknownCount(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.unknownCount(int)"})
  void testBuilderUnknownCount() {
    // Arrange
    Builder builderResult = ImmutableLogicalFlowAttestationPreChecks.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknownCount(3));
  }
}
