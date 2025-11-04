package org.finos.waltz.service.attestation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import org.finos.waltz.data.attestation.AttestationPreCheckDao;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.attestation.LogicalFlowAttestationPreChecks;
import org.finos.waltz.service.settings.SettingsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AttestationPreCheckServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures2() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(false);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks, atLeast(1)).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals("Cannot attest as there are deprecated data type usages (3 violation/s)",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures3() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(false);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks, atLeast(1)).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals("Cannot attest as there are unknown data type usages (3 violation/s)",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures4() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(0);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures5() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromFlowCountCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(0);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromFlowCountCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures6() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(0);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertTrue(actualCalcLogicalFlowPreCheckFailuresResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link AttestationPreCheckService#calcLogicalFlowPreCheckFailures(EntityReference)}
   */
  @Test
  void testCalcLogicalFlowPreCheckFailures7() {
    // Arrange
    LogicalFlowAttestationPreChecks logicalFlowAttestationPreChecks = mock(LogicalFlowAttestationPreChecks.class);
    when(logicalFlowAttestationPreChecks.exemptFromDeprecatedCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromUnknownCheck()).thenReturn(true);
    when(logicalFlowAttestationPreChecks.exemptFromFlowCountCheck()).thenReturn(false);
    when(logicalFlowAttestationPreChecks.deprecatedCount()).thenReturn(3);
    when(logicalFlowAttestationPreChecks.flowCount()).thenReturn(0);
    when(logicalFlowAttestationPreChecks.unknownCount()).thenReturn(3);
    AttestationPreCheckDao attestationPreCheckDao = mock(AttestationPreCheckDao.class);
    when(attestationPreCheckDao.calcLogicalFlowAttestationPreChecks(Mockito.<EntityReference>any()))
        .thenReturn(logicalFlowAttestationPreChecks);
    SettingsService settingsService = mock(SettingsService.class);
    when(settingsService.indexByPrefix(Mockito.<String>any())).thenReturn(new HashMap<>());

    // Act
    List<String> actualCalcLogicalFlowPreCheckFailuresResult = (new AttestationPreCheckService(attestationPreCheckDao,
        settingsService)).calcLogicalFlowPreCheckFailures(null);

    // Assert
    verify(attestationPreCheckDao).calcLogicalFlowAttestationPreChecks(isNull());
    verify(logicalFlowAttestationPreChecks).deprecatedCount();
    verify(logicalFlowAttestationPreChecks).exemptFromDeprecatedCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromFlowCountCheck();
    verify(logicalFlowAttestationPreChecks).exemptFromUnknownCheck();
    verify(logicalFlowAttestationPreChecks, atLeast(1)).flowCount();
    verify(logicalFlowAttestationPreChecks).unknownCount();
    verify(settingsService).indexByPrefix(eq("attestation.logical-flow.fail"));
    assertEquals(1, actualCalcLogicalFlowPreCheckFailuresResult.size());
    assertEquals("Cannot attest as there are no recorded relevant flows",
        actualCalcLogicalFlowPreCheckFailuresResult.get(0));
  }
}
