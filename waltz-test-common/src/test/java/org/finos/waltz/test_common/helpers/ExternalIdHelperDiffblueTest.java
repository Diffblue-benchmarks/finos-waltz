package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.external_identifier.ExternalIdentifierDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.external_identifier.ExternalIdentifier;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExternalIdHelperDiffblueTest {
  @InjectMocks private ExternalIdHelper externalIdHelper;

  @Mock private ExternalIdentifierService externalIdentifierService;

  /**
   * Test {@link ExternalIdHelper#createExtId(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test createExtId(EntityReference, String, String); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdHelper.createExtId(EntityReference, String, String)"})
  void testCreateExtId_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);

    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any()))
        .thenReturn(19088743);
    ChangeLogService changeLogService =
        new ChangeLogService(
            changeLogDao,
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ExternalIdentifierService externalIdentifierService =
        new ExternalIdentifierService(externalIdentifierDao, changeLogService);
    ExternalIdHelper externalIdHelper = new ExternalIdHelper(externalIdentifierService);

    // Act
    int actualCreateExtIdResult =
        externalIdHelper.createExtId(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "Name");

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(1, actualCreateExtIdResult);
  }

  /**
   * Test {@link ExternalIdHelper#createExtId(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test createExtId(EntityReference, String, String); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdHelper.createExtId(EntityReference, String, String)"})
  void testCreateExtId_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(1);

    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    ExternalIdentifierService externalIdentifierService =
        new ExternalIdentifierService(externalIdentifierDao, changeLogService);
    ExternalIdHelper externalIdHelper = new ExternalIdHelper(externalIdentifierService);

    // Act
    int actualCreateExtIdResult =
        externalIdHelper.createExtId(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "42",
            "Name");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualCreateExtIdResult);
  }

  /**
   * Test {@link ExternalIdHelper#createExtId(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ExternalIdentifierService} {@link
   *       ExternalIdentifierService#create(EntityReference, String, String)} return one.
   *   <li>Then calls {@link ExternalIdentifierService#create(EntityReference, String, String)}.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  @DisplayName(
      "Test createExtId(EntityReference, String, String); given ExternalIdentifierService create(EntityReference, String, String) return one; then calls create(EntityReference, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdHelper.createExtId(EntityReference, String, String)"})
  void testCreateExtId_givenExternalIdentifierServiceCreateReturnOne_thenCallsCreate() {
    // Arrange
    when(externalIdentifierService.create(
            Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);

    // Act
    int actualCreateExtIdResult = externalIdHelper.createExtId(null, "42", "Name");

    // Assert
    verify(externalIdentifierService).create(isNull(), eq("42"), eq("Name"));
    assertEquals(1, actualCreateExtIdResult);
  }

  /**
   * Test {@link ExternalIdHelper#createExtId(EntityReference, String, String)}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  @DisplayName("Test createExtId(EntityReference, String, String); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ExternalIdHelper.createExtId(EntityReference, String, String)"})
  void testCreateExtId_thenReturnMinusOne() {
    // Arrange
    ExternalIdentifierDao externalIdentifierDao = mock(ExternalIdentifierDao.class);
    when(externalIdentifierDao.create(Mockito.<ExternalIdentifier>any())).thenReturn(-1);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));

    ExternalIdentifierService externalIdentifierService =
        new ExternalIdentifierService(externalIdentifierDao, changeLogService);
    ExternalIdHelper externalIdHelper = new ExternalIdHelper(externalIdentifierService);

    // Act
    int actualCreateExtIdResult =
        externalIdHelper.createExtId(
            ImmutableAppGroupEntry.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .provenance("Provenance")
                .build(),
            "42",
            "Name");

    // Assert
    verify(externalIdentifierDao).create(isA(ExternalIdentifier.class));
    assertEquals(-1, actualCreateExtIdResult);
  }
}
