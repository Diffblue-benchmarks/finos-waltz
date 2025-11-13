package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.finos.waltz.data.physical_specification_definition.PhysicalSpecDefinitionFieldDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUpdateDescriptionCommand;
import org.finos.waltz.model.UpdateDescriptionCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElementChangeCommand.Builder;
import org.finos.waltz.model.logical_data_element.LogicalDataElementChangeCommand;
import org.finos.waltz.model.physical_specification_definition.ImmutablePhysicalSpecDefinitionFieldChangeCommand;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionField;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionFieldChangeCommand;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PhysicalSpecDefinitionFieldServiceDiffblueTest {
  /**
   * Test {@link PhysicalSpecDefinitionFieldService#create(String, long,
   * PhysicalSpecDefinitionFieldChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PhysicalSpecDefinitionFieldDao} {@link
   *       PhysicalSpecDefinitionFieldDao#create(PhysicalSpecDefinitionField)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#create(String, long,
   * PhysicalSpecDefinitionFieldChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, long, PhysicalSpecDefinitionFieldChangeCommand); given PhysicalSpecDefinitionFieldDao create(PhysicalSpecDefinitionField) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long PhysicalSpecDefinitionFieldService.create(String, long, PhysicalSpecDefinitionFieldChangeCommand)"
  })
  void testCreate_givenPhysicalSpecDefinitionFieldDaoCreateReturnOne_thenReturnOne() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.create(Mockito.<PhysicalSpecDefinitionField>any())).thenReturn(1L);
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

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    long actualCreateResult =
        physicalSpecDefinitionFieldService.create(
            "janedoe",
            1L,
            ImmutablePhysicalSpecDefinitionFieldChangeCommand.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .logicalDataElementId(1L)
                .name("Name")
                .position(1)
                .type(FieldDataType.DATE)
                .build());

    // Assert
    verify(dao).create(isA(PhysicalSpecDefinitionField.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#delete(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldService.delete(long)"})
  void testDelete() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.delete(anyLong())).thenReturn(1);
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

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    int actualDeleteResult = physicalSpecDefinitionFieldService.delete(1L);

    // Assert
    verify(dao).delete(1L);
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#deleteForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#deleteForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test deleteForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PhysicalSpecDefinitionFieldService.deleteForSpecDefinition(long)"})
  void testDeleteForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.deleteForSpecDefinition(anyLong())).thenReturn(1);
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

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    int actualDeleteForSpecDefinitionResult =
        physicalSpecDefinitionFieldService.deleteForSpecDefinition(1L);

    // Assert
    verify(dao).deleteForSpecDefinition(1L);
    assertEquals(1, actualDeleteForSpecDefinitionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#findForSpecDefinition(long)}.
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#findForSpecDefinition(long)}
   */
  @Test
  @DisplayName("Test findForSpecDefinition(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhysicalSpecDefinitionFieldService.findForSpecDefinition(long)"})
  void testFindForSpecDefinition() {
    // Arrange
    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.findForSpecDefinition(anyLong())).thenReturn(new ArrayList<>());
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

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult =
        physicalSpecDefinitionFieldService.findForSpecDefinition(1L);

    // Assert
    verify(dao).findForSpecDefinition(1L);
    assertTrue(actualFindForSpecDefinitionResult.isEmpty());
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long,
   * UpdateDescriptionCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long,
   * UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(String, long, UpdateDescriptionCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateDescription(String, long, UpdateDescriptionCommand)"
  })
  void testUpdateDescription_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    int actualUpdateDescriptionResult =
        physicalSpecDefinitionFieldService.updateDescription(
            "janedoe",
            1L,
            ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).updateDescription(1L, "New Description");
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long,
   * UpdateDescriptionCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long,
   * UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(String, long, UpdateDescriptionCommand); given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateDescription(String, long, UpdateDescriptionCommand)"
  })
  void testUpdateDescription_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateDescription(anyLong(), Mockito.<String>any())).thenReturn(1);

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    // Act
    int actualUpdateDescriptionResult =
        physicalSpecDefinitionFieldService.updateDescription(
            "janedoe",
            1L,
            ImmutableUpdateDescriptionCommand.builder().newDescription("New Description").build());

    // Assert
    verify(dao).updateDescription(1L, "New Description");
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateLogicalDataElement(String, long, LogicalDataElementChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)"
  })
  void testUpdateLogicalDataElement_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldService.updateLogicalDataElement(
            "janedoe", 1L, builderResult.newLogicalDataElement(newLogicalDataElement).build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(dao).updateLogicalDataElement(1L, 1L);
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateLogicalDataElement(String, long, LogicalDataElementChangeCommand); then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)"
  })
  void testUpdateLogicalDataElement_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> newLogicalDataElement =
        Optional.of(immutableEntityReference);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldService.updateLogicalDataElement(
            "janedoe", 1L, builderResult.newLogicalDataElement(newLogicalDataElement).build());

    // Assert
    verify(dao).updateLogicalDataElement(1L, 1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}.
   *
   * <ul>
   *   <li>When builder newLogicalDataElement empty build.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateLogicalDataElement(String, long, LogicalDataElementChangeCommand); when builder newLogicalDataElement empty build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)"
  })
  void testUpdateLogicalDataElement_whenBuilderNewLogicalDataElementEmptyBuild() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PhysicalSpecDefinitionFieldDao dao = mock(PhysicalSpecDefinitionFieldDao.class);
    when(dao.updateLogicalDataElement(anyLong(), Mockito.<Long>any())).thenReturn(1);

    PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService =
        new PhysicalSpecDefinitionFieldService(changeLogService, dao);

    Builder builderResult = ImmutableLogicalDataElementChangeCommand.builder();
    Optional<? extends EntityReference> newLogicalDataElement = Optional.empty();

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldService.updateLogicalDataElement(
            "janedoe", 1L, builderResult.newLogicalDataElement(newLogicalDataElement).build());

    // Assert
    verify(dao).updateLogicalDataElement(eq(1L), isNull());
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }
}
