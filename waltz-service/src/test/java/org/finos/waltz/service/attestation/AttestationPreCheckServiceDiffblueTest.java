package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.finos.waltz.data.attestation.AttestationPreCheckDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.ImmutableLogicalFlowAttestationPreChecks;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AttestationPreCheckServiceDiffblueTest {
  @Mock private AttestationPreCheckDao attestationPreCheckDao;

  @InjectMocks private AttestationPreCheckService attestationPreCheckService;

  @Mock private SettingsService settingsService;

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(3)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures2() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(0)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(3)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures3() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(false)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(3)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals(
        "Cannot attest as there are deprecated data type usages (3 violation/s)",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures4() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(false)
                .flowCount(3)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals(
        "Cannot attest as there are unknown data type usages (3 violation/s)",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures5() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(0)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures6() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(3)
                .unknownCount(0)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName("Test calcLogicalFlowPreCheckFailures(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures7() {
    // Arrange
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(false)
                .exemptFromUnknownCheck(true)
                .flowCount(0)
                .unknownCount(3)
                .build());
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsService).indexByPrefix("attestation.logical-flow.fail");
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals(
        "Cannot attest as there are no recorded relevant flows",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }

  /**
   * Test {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}.
   *
   * <ul>
   *   <li>Then calls {@link SettingsDao#indexByPrefix(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test calcLogicalFlowPreCheckFailures(EntityReference); then calls indexByPrefix(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AttestationPreCheckService.calcLogicalFlowPreCheckFailures(EntityReference)"
  })
  void testCalcLogicalFlowPreCheckFailures_thenCallsIndexByPrefix() {
    // Arrange
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(
            ImmutableLogicalFlowAttestationPreChecks.builder()
                .deprecatedCount(3)
                .exemptFromDeprecatedCheck(true)
                .exemptFromFlowCountCheck(true)
                .exemptFromUnknownCheck(true)
                .flowCount(3)
                .unknownCount(3)
                .build());

    SettingsDao settingsDao = mock(SettingsDao.class);
    when(settingsDao.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    AttestationPreCheckService attestationPreCheckService =
        new AttestationPreCheckService(attestationPreCheckDao, settingsService);

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult =
        attestationPreCheckService.calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(settingsDao).indexByPrefix("attestation.logical-flow.fail");
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }
}
