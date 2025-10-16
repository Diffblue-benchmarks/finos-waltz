package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.physical_specification.search.PhysicalSpecificationSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.command.CommandOutcome;
import org.finos.waltz.model.command.ImmutableCommandResponse;
import org.finos.waltz.model.physical_specification.DataFormatKindValue;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecification.Builder;
import org.finos.waltz.model.physical_specification.ImmutablePhysicalSpecificationDeleteCommand;
import org.finos.waltz.model.physical_specification.PhysicalSpecification;
import org.finos.waltz.model.physical_specification.PhysicalSpecificationDeleteCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.physical_specification.PhysicalSpecificationService;
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
class PhysicalSpecHelperDiffblueTest {
  @InjectMocks private PhysicalSpecHelper physicalSpecHelper;

  @Mock private PhysicalSpecificationService physicalSpecificationService;

  /**
   * Test {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PhysicalSpecificationService#create(ImmutablePhysicalSpecification)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test createPhysicalSpec(EntityReference, String); then calls create(ImmutablePhysicalSpecification)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PhysicalSpecHelper.createPhysicalSpec(EntityReference, String)"})
  void testCreatePhysicalSpec_thenCallsCreate() {
    // Arrange
    when(physicalSpecificationService.create(Mockito.<ImmutablePhysicalSpecification>any()))
        .thenReturn(1L);

    // Act
    Long actualCreatePhysicalSpecResult =
        physicalSpecHelper.createPhysicalSpec(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Name");

    // Assert
    verify(physicalSpecificationService).create(isA(ImmutablePhysicalSpecification.class));
    assertEquals(1L, actualCreatePhysicalSpecResult.longValue());
  }

  /**
   * Test {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PhysicalSpecificationDao#create(PhysicalSpecification)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecHelper#createPhysicalSpec(EntityReference, String)}
   */
  @Test
  @DisplayName(
      "Test createPhysicalSpec(EntityReference, String); then calls create(PhysicalSpecification)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long PhysicalSpecHelper.createPhysicalSpec(EntityReference, String)"})
  void testCreatePhysicalSpec_thenCallsCreate2() {
    // Arrange
    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.create(Mockito.<PhysicalSpecification>any())).thenReturn(1L);
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

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));
    PhysicalSpecHelper physicalSpecHelper = new PhysicalSpecHelper(physicalSpecificationService);

    // Act
    Long actualCreatePhysicalSpecResult =
        physicalSpecHelper.createPhysicalSpec(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build(),
            "Name");

    // Assert
    verify(specificationDao).create(isA(PhysicalSpecification.class));
    assertEquals(1L, actualCreatePhysicalSpecResult.longValue());
  }

  /**
   * Test {@link PhysicalSpecHelper#removeSpec(Long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  @DisplayName(
      "Test removeSpec(Long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalSpecHelper.removeSpec(Long)"})
  void testRemoveSpec_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
    // Arrange
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

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    new PhysicalSpecHelper(physicalSpecificationService).removeSpec(1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
  }

  /**
   * Test {@link PhysicalSpecHelper#removeSpec(Long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  @DisplayName(
      "Test removeSpec(Long); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalSpecHelper.removeSpec(Long)"})
  void testRemoveSpec_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecificationDao specificationDao = mock(PhysicalSpecificationDao.class);
    when(specificationDao.markRemovedIfUnused(anyLong())).thenReturn(1);

    Builder builderResult = ImmutablePhysicalSpecification.builder();
    ImmutableUserTimestamp immutableUserTimestamp =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Optional<? extends UserTimestamp> created = Optional.of(immutableUserTimestamp);

    Builder externalIdResult =
        builderResult
            .created(created)
            .description("The characteristics of someone or something")
            .externalId("42");

    Builder nameResult =
        externalIdResult
            .format(DataFormatKindValue.of("42"))
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name");
    when(specificationDao.getById(anyLong()))
        .thenReturn(
            nameResult
                .owningEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .provenance("Provenance")
                .build());

    PhysicalSpecificationService physicalSpecificationService =
        new PhysicalSpecificationService(
            changeLogService, specificationDao, mock(PhysicalSpecificationSearchDao.class));

    // Act
    new PhysicalSpecHelper(physicalSpecificationService).removeSpec(1L);

    // Assert
    verify(specificationDao).getById(1L);
    verify(specificationDao).markRemovedIfUnused(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link PhysicalSpecHelper#removeSpec(Long)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       PhysicalSpecificationService#markRemovedIfUnused(PhysicalSpecificationDeleteCommand,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecHelper#removeSpec(Long)}
   */
  @Test
  @DisplayName(
      "Test removeSpec(Long); then calls markRemovedIfUnused(PhysicalSpecificationDeleteCommand, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhysicalSpecHelper.removeSpec(Long)"})
  void testRemoveSpec_thenCallsMarkRemovedIfUnused() {
    // Arrange
    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> builderResult =
        ImmutableCommandResponse.builder();

    ImmutableCommandResponse.Builder<PhysicalSpecificationDeleteCommand> messageResult =
        builderResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .message("Not all who wander are lost");
    when(physicalSpecificationService.markRemovedIfUnused(
            Mockito.<PhysicalSpecificationDeleteCommand>any(), Mockito.<String>any()))
        .thenReturn(
            messageResult
                .originalCommand(
                    ImmutablePhysicalSpecificationDeleteCommand.builder()
                        .specificationId(1L)
                        .build())
                .outcome(CommandOutcome.SUCCESS)
                .build());

    // Act
    physicalSpecHelper.removeSpec(1L);

    // Assert
    verify(physicalSpecificationService)
        .markRemovedIfUnused(
            isA(PhysicalSpecificationDeleteCommand.class),
            eq("deletingSpec_3df6c53a-c2ae-429f-afd9-316850e39600"));
  }
}
