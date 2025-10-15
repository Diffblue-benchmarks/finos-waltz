package org.finos.waltz.service.physical_specification_definition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
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
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionField;
import org.finos.waltz.model.physical_specification_definition.PhysicalSpecDefinitionFieldChangeCommand;
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
class PhysicalSpecDefinitionFieldServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PhysicalSpecDefinitionFieldDao physicalSpecDefinitionFieldDao;

  @InjectMocks private PhysicalSpecDefinitionFieldService physicalSpecDefinitionFieldService;

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
    when(physicalSpecDefinitionFieldDao.create(Mockito.<PhysicalSpecDefinitionField>any()))
        .thenReturn(1L);

    PhysicalSpecDefinitionFieldChangeCommand command =
        mock(PhysicalSpecDefinitionFieldChangeCommand.class);
    when(command.description()).thenReturn("The characteristics of someone or something");
    Optional<Long> ofResult = Optional.of(1L);
    when(command.logicalDataElementId()).thenReturn(ofResult);
    when(command.position()).thenReturn(1);
    when(command.type()).thenReturn(FieldDataType.DATE);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = physicalSpecDefinitionFieldService.create("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionFieldDao).create(isA(PhysicalSpecDefinitionField.class));
    verify(command).description();
    verify(command).name();
    verify(command).logicalDataElementId();
    verify(command).position();
    verify(command).type();
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
    when(physicalSpecDefinitionFieldDao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = physicalSpecDefinitionFieldService.delete(1L);

    // Assert
    verify(physicalSpecDefinitionFieldDao).delete(1L);
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
    when(physicalSpecDefinitionFieldDao.deleteForSpecDefinition(anyLong())).thenReturn(1);

    // Act
    int actualDeleteForSpecDefinitionResult =
        physicalSpecDefinitionFieldService.deleteForSpecDefinition(1L);

    // Assert
    verify(physicalSpecDefinitionFieldDao).deleteForSpecDefinition(1L);
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
    when(physicalSpecDefinitionFieldDao.findForSpecDefinition(anyLong()))
        .thenReturn(new ArrayList<>());

    // Act
    List<PhysicalSpecDefinitionField> actualFindForSpecDefinitionResult =
        physicalSpecDefinitionFieldService.findForSpecDefinition(1L);

    // Assert
    verify(physicalSpecDefinitionFieldDao).findForSpecDefinition(1L);
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
   *   <li>Given {@code New Description}.
   *   <li>Then calls {@link UpdateDescriptionCommand#newDescription()}.
   * </ul>
   *
   * <p>Method under test: {@link PhysicalSpecDefinitionFieldService#updateDescription(String, long,
   * UpdateDescriptionCommand)}
   */
  @Test
  @DisplayName(
      "Test updateDescription(String, long, UpdateDescriptionCommand); given 'New Description'; then calls newDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateDescription(String, long, UpdateDescriptionCommand)"
  })
  void testUpdateDescription_givenNewDescription_thenCallsNewDescription() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionFieldDao.updateDescription(anyLong(), Mockito.<String>any()))
        .thenReturn(1);

    UpdateDescriptionCommand command = mock(UpdateDescriptionCommand.class);
    when(command.newDescription()).thenReturn("New Description");

    // Act
    int actualUpdateDescriptionResult =
        physicalSpecDefinitionFieldService.updateDescription("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionFieldDao).updateDescription(1L, "New Description");
    verify(command).newDescription();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateDescriptionResult);
  }

  /**
   * Test {@link PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}.
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName("Test updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)"
  })
  void testUpdateLogicalDataElement() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionFieldDao.updateLogicalDataElement(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    LogicalDataElementChangeCommand command = mock(LogicalDataElementChangeCommand.class);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> ofResult = Optional.of(immutableEntityReference);
    when(command.newLogicalDataElement()).thenReturn(ofResult);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldService.updateLogicalDataElement("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionFieldDao).updateLogicalDataElement(1L, 1L);
    verify(command, atLeast(1)).newLogicalDataElement();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
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
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * PhysicalSpecDefinitionFieldService#updateLogicalDataElement(String, long,
   * LogicalDataElementChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateLogicalDataElement(String, long, LogicalDataElementChangeCommand); given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int PhysicalSpecDefinitionFieldService.updateLogicalDataElement(String, long, LogicalDataElementChangeCommand)"
  })
  void testUpdateLogicalDataElement_givenEmpty() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    when(physicalSpecDefinitionFieldDao.updateLogicalDataElement(anyLong(), Mockito.<Long>any()))
        .thenReturn(1);

    LogicalDataElementChangeCommand command = mock(LogicalDataElementChangeCommand.class);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(command.newLogicalDataElement()).thenReturn(emptyResult);

    // Act
    int actualUpdateLogicalDataElementResult =
        physicalSpecDefinitionFieldService.updateLogicalDataElement("janedoe", 1L, command);

    // Assert
    verify(physicalSpecDefinitionFieldDao).updateLogicalDataElement(eq(1L), isNull());
    verify(command, atLeast(1)).newLogicalDataElement();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateLogicalDataElementResult);
  }
}
