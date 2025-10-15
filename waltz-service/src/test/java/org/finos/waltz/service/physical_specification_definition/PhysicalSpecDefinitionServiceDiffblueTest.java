package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionDao;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionFieldDao;
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionSampleFileDao;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionChangeCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinition;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionChangeCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionType;
import org.finos.waltz.service.changelog.ChangeLogService;
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
class PhysicalSpecDefinitionServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PhysicalSpecDefinitionDao physicalSpecDefinitionDao;

  @Mock private PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao;

  @Mock private PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao;

  @InjectMocks private PhysicalSpecDefinitionService physicalSpecDefinitionService;

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test create(String, long, PhysicalSpecDefinitionChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate() {
    // Arrange
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.create(
                "janedoe",
                1L,
                ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                    .delimiter("Delimiter")
                    .id(1L)
                    .status(ReleaseLifecycleStatus.ACTIVE)
                    .type(PhysicalSpecDefinitionType.DELIMITED)
                    .version("1.0.2")
                    .build()));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName("Test create(String, long, PhysicalSpecDefinitionChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate2() {
    // Arrange
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    when(command.status()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> physicalSpecDefinitionService.create("janedoe", 1L, command));
    verify(command).status();
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@code 1.0.2}.
   *   <li>Then calls {@link PhysicalSpecDefinitionChangeCommand#delimiter()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given '1.0.2'; then calls delimiter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_given102_thenCallsDelimiter() {
    // Arrange
    PhysicalSpecDefinitionChangeCommand command = mock(PhysicalSpecDefinitionChangeCommand.class);
    when(command.delimiter()).thenThrow(new IllegalStateException());
    when(command.version()).thenReturn("1.0.2");
    when(command.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> physicalSpecDefinitionService.create("janedoe", 1L, command));
    verify(command).delimiter();
    verify(command, atLeast(1)).status();
    verify(command).version();
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);

    PhysicalSpecDefinitionService physicalSpecDefinitionService =
        new PhysicalSpecDefinitionService(
            changeLogService,
            physicalSpecDefinitionDao,
            mock(PhysicalSpecDefinitionFieldDao.class),
            mock(PhysicalSpecDefinitionSampleFileDao.class));

    // Act
    long actualCreateResult =
        physicalSpecDefinitionService.create(
            "janedoe",
            1L,
            ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                .delimiter("Delimiter")
                .id(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given ChangeLogService write(ChangeLog) return '19088743'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenReturnOne() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionService.create(
            "janedoe",
            1L,
            ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                .delimiter("Delimiter")
                .id(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Assert
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given ChangeLogService write(ChangeLog) throw IllegalStateException(); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_givenChangeLogServiceWriteThrowIllegalStateException_thenCallsWrite() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new IllegalStateException());
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.create(
                "janedoe",
                1L,
                ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                    .delimiter("Delimiter")
                    .id(1L)
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .type(PhysicalSpecDefinitionType.DELIMITED)
                    .version("1.0.2")
                    .build()));
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao} {@link
   *       PhysicalSpecDefinitionDao#create(PhysicalSpecDefinition)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given PhysicalSpecDefinitionDao create(PhysicalSpecDefinition) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_givenPhysicalSpecDefinitionDaoCreateThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.create(
                "janedoe",
                1L,
                ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                    .delimiter("Delimiter")
                    .id(1L)
                    .status(ReleaseLifecycleStatus.DRAFT)
                    .type(PhysicalSpecDefinitionType.DELIMITED)
                    .version("1.0.2")
                    .build()));
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao} {@link
   *       PhysicalSpecDefinitionDao#markExistingActiveAsDeprecated(long, String)} return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#create(String, long,
   * PhysicalSpecDefinitionChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionChangeCommand); given PhysicalSpecDefinitionDao markExistingActiveAsDeprecated(long, String) return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionService.create(String, long, PhysicalSpecDefinitionChangeCommand)"
  })
  void testCreate_givenPhysicalSpecDefinitionDaoMarkExistingActiveAsDeprecatedReturnOne() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.create(Mockito.<PhysicalSpecDefinition>any())).thenReturn(1L);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionService.create(
            "janedoe",
            1L,
            ImmutablePhysicalSpecDefinitionChangeCommand.builder()
                .delimiter("Delimiter")
                .id(1L)
                .status(ReleaseLifecycleStatus.ACTIVE)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Assert
    verify(physicalSpecDefinitionDao).create(isA(PhysicalSpecDefinition.class));
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName("Test delete(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete() {
    // Arrange
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> physicalSpecDefinitionService.delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName("Test delete(String, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete2() {
    // Arrange
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> physicalSpecDefinitionService.delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code janedoe}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName(
      "Test delete(String, long); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; when 'janedoe'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete_givenChangeLogDaoWriteReturn19088743_whenJanedoe_thenCallsWrite() {
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

    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao =
        mock(PhysicalSpecDefinitionFieldDao.class);
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    PhysicalSpecDefinitionSampleFileDao physicalSpecDefinitionSampleFileDao =
        mock(PhysicalSpecDefinitionSampleFileDao.class);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    PhysicalSpecDefinitionService physicalSpecDefinitionService =
        new PhysicalSpecDefinitionService(
            changeLogService,
            physicalSpecDefinitionDao,
            physicalSpecDefinitionFieldDao,
            physicalSpecDefinitionSampleFileDao);

    // Act
    int actualDeleteResult = physicalSpecDefinitionService.delete("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(1L);
    assertEquals(3, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>When {@code janedoe}.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName(
      "Test delete(String, long); given ChangeLogService write(ChangeLog) return '19088743'; when 'janedoe'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete_givenChangeLogServiceWriteReturn19088743_whenJanedoe_thenReturnThree() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = physicalSpecDefinitionService.delete("janedoe", 1L);

    // Assert
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(3, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName(
      "Test delete(String, long); given ChangeLogService write(ChangeLog) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete_givenChangeLogServiceWriteThrowIllegalStateException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new IllegalStateException());
    when(physicalSpecDefinitionDao.delete(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);
    when(physicalSpecDefinitionSampleFileDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> physicalSpecDefinitionService.delete("userName cannot be null", 1L));
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
    verify(physicalSpecDefinitionSampleFileDao).deleteForSpecDefinition(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao} {@link PhysicalSpecDefinitionDao#delete(long)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName(
      "Test delete(String, long); given PhysicalSpecDefinitionDao delete(long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete_givenPhysicalSpecDefinitionDaoDeleteThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.delete(anyLong())).thenThrow(new IllegalStateException());
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> physicalSpecDefinitionService.delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).delete(1L);
    verify(physicalSpecDefinitionDao).getById(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#delete(String, long)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao} {@link PhysicalSpecDefinitionDao#getById(long)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#delete(String, long)}
   */
  @Test
  @DisplayName(
      "Test delete(String, long); given PhysicalSpecDefinitionDao getById(long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionService.delete(String, long)"})
  void testDelete_givenPhysicalSpecDefinitionDaoGetByIdThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.getById(anyLong())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> physicalSpecDefinitionService.delete("janedoe", 1L));
    verify(physicalSpecDefinitionDao).getById(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#findForSpecification(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#findForSpecification(long)}
   */
  @Test
  @DisplayName("Test findForSpecification(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDefinitionService.findForSpecification(long)"})
  void testFindForSpecification_thenReturnEmpty() {
    // Arrange
    when(physicalSpecDefinitionDao.findForSpecification(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<PhysicalSpecDefinition> actualFindForSpecificationResult =
        physicalSpecDefinitionService.findForSpecification(1L);

    // Assert
    verify(physicalSpecDefinitionDao).findForSpecification(1L);
    assertTrue(actualFindForSpecificationResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#findForSpecification(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#findForSpecification(long)}
   */
  @Test
  @DisplayName("Test findForSpecification(long); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDefinitionService.findForSpecification(long)"})
  void testFindForSpecification_thenThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.findForSpecification(anyLong()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> physicalSpecDefinitionService.findForSpecification(1L));
    verify(physicalSpecDefinitionDao).findForSpecification(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName("Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus() {
    // Arrange
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenThrow(new IllegalStateException());
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.ACTIVE)
                    .build()));
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    PhysicalSpecDefinitionDao physicalSpecDefinitionDao = mock(PhysicalSpecDefinitionDao.class);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    PhysicalSpecDefinitionService physicalSpecDefinitionService =
        new PhysicalSpecDefinitionService(
            changeLogService,
            physicalSpecDefinitionDao,
            mock(PhysicalSpecDefinitionFieldDao.class),
            mock(PhysicalSpecDefinitionSampleFileDao.class));

    // Act
    boolean actualUpdateStatusResult =
        physicalSpecDefinitionService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.ACTIVE)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
    verify(physicalSpecDefinitionDao).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE, "janedoe");
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogService write(ChangeLog) return '19088743'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogServiceWriteReturn19088743_thenReturnTrue() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act
    boolean actualUpdateStatusResult =
        physicalSpecDefinitionService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.ACTIVE)
                .build());

    // Assert
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
    verify(physicalSpecDefinitionDao).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertTrue(actualUpdateStatusResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogService write(ChangeLog) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogServiceWriteThrowIllegalStateException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenThrow(new IllegalStateException());
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.ACTIVE)
                    .build()));
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
    verify(physicalSpecDefinitionDao).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then calls {@link ReleaseLifecycleStatusChangeCommand#newStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given IllegalStateException(); then calls newStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenIllegalStateException_thenCallsNewStatus() {
    // Arrange
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> physicalSpecDefinitionService.updateStatus("janedoe", 1L, command));
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(command).newStatus();
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionDao} {@link PhysicalSpecDefinitionDao#getById(long)}
   *       throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given PhysicalSpecDefinitionDao getById(long) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenPhysicalSpecDefinitionDaoGetByIdThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.getById(anyLong())).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.DRAFT)
                    .build()));
    verify(physicalSpecDefinitionDao).getById(1L);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_thenReturnFalse() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionDao.markExistingActiveAsDeprecated(anyLong(), Mockito.<String>any()))
        .thenReturn(1);
    when(physicalSpecDefinitionDao.updateStatus(
            anyLong(), Mockito.<ReleaseLifecycleStatus>any(), Mockito.<String>any()))
        .thenReturn(15);
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act
    boolean actualUpdateStatusResult =
        physicalSpecDefinitionService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.ACTIVE)
                .build());

    // Assert
    verify(physicalSpecDefinitionDao).getById(1L);
    verify(physicalSpecDefinitionDao).markExistingActiveAsDeprecated(1L, "janedoe");
    verify(physicalSpecDefinitionDao).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE, "janedoe");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertFalse(actualUpdateStatusResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>When builder newStatus {@code DRAFT} build.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); when builder newStatus 'DRAFT' build; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PhysicalSpecDefinitionService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_whenBuilderNewStatusDraftBuild_thenThrowIllegalStateException() {
    // Arrange
    when(physicalSpecDefinitionDao.getById(anyLong()))
        .thenReturn(
            ImmutablePhysicalSpecDefinition.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .createdBy("Jan 1, 2020 8:00am GMT+0100")
                .delimiter("Delimiter")
                .id(1L)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .provenance("Provenance")
                .specificationId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .type(PhysicalSpecDefinitionType.DELIMITED)
                .version("1.0.2")
                .build());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            physicalSpecDefinitionService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.DRAFT)
                    .build()));
    verify(physicalSpecDefinitionDao).getById(1L);
  }
}
