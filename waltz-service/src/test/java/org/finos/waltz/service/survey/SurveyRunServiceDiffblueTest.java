package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.common.exception.InsufficientPrivelegeException;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.involvement.InvolvementDao;
import org.finos.waltz.data.involvement_group.InvolvementGroupDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyInstanceOwnerDao;
import org.finos.waltz.data.survey.SurveyInstanceRecipientDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyRunDao;
import org.finos.waltz.data.survey.SurveyTemplateDao;
import org.finos.waltz.model.DateChangeCommand;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.IdCommandResponse;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.ImmutableIdCommandResponse;
import org.finos.waltz.model.SelectionFilters;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.involvement_group.InvolvementGroupCreateCommand;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.ImmutableSurveyRunWithOwnerAndStats;
import org.finos.waltz.model.survey.InstancesAndRecipientsCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceCreateCommand;
import org.finos.waltz.model.survey.SurveyInstanceOwner;
import org.finos.waltz.model.survey.SurveyInstanceOwningRoleSaveCommand;
import org.finos.waltz.model.survey.SurveyInstanceRecipient;
import org.finos.waltz.model.survey.SurveyInstanceRecipientsAndOwners;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRun;
import org.finos.waltz.model.survey.SurveyRunChangeCommand;
import org.finos.waltz.model.survey.SurveyRunCompletionRate;
import org.finos.waltz.model.survey.SurveyRunCreateCommand;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.model.survey.SurveyRunWithOwnerAndStats;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyRunServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyRunService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    SurveyRun actualById = (new SurveyRunService(changeLogService, involvementDao, personDao, surveyInstanceDao,
        surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao, surveyQuestionResponseDao,
        new InvolvementGroupService(mock(InvolvementGroupDao.class)))).getById(1L);

    // Assert
    verify(surveyRunDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link SurveyRunService#findForRecipient(Long)}
   */
  @Test
  void testFindForRecipient() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();
    when(surveyRunDao.findForRecipient(anyLong())).thenReturn(surveyRunList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRun> actualFindForRecipientResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)))).findForRecipient(1L);

    // Assert
    verify(surveyRunDao).findForRecipient(eq(1L));
    assertTrue(actualFindForRecipientResult.isEmpty());
    assertSame(surveyRunList, actualFindForRecipientResult);
  }

  /**
   * Method under test: {@link SurveyRunService#findForRecipient(String)}
   */
  @Test
  void testFindForRecipient2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();
    when(surveyRunDao.findForRecipient(anyLong())).thenReturn(surveyRunList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRun> actualFindForRecipientResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findForRecipient("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).findForRecipient(eq(1L));
    verify(person).id();
    assertTrue(actualFindForRecipientResult.isEmpty());
    assertSame(surveyRunList, actualFindForRecipientResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.create(anyLong(), Mockito.<SurveyRunCreateCommand>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Optional<Long>>any())).thenReturn(1L);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, mock(InvolvementDao.class), personDao,
        mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class),
        surveyRunDao, surveyTemplateDao, mock(SurveyQuestionResponseDao.class),
        new InvolvementGroupService(involvementGroupDao));
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    IdCommandResponse actualCreateSurveyRunResult = surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(involvementGroupDao, atLeast(1)).createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).create(eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(command, atLeast(1)).surveyTemplateId();
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun2() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.create(anyLong(), Mockito.<SurveyRunCreateCommand>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Optional<Long>>any())).thenReturn(1L);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, mock(InvolvementDao.class), personDao,
        mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class),
        surveyRunDao, surveyTemplateDao, mock(SurveyQuestionResponseDao.class),
        new InvolvementGroupService(involvementGroupDao));
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    IdCommandResponse actualCreateSurveyRunResult = surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(involvementGroupDao, atLeast(1)).createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).create(eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(command, atLeast(1)).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun3() throws InsufficientPrivelegeException {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(mock(Person.class));
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(false);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);

    // Act and Assert
    assertThrows(InsufficientPrivelegeException.class, () -> surveyRunService.createSurveyRun("janedoe", command));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(command).surveyTemplateId();
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun4() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.create(anyLong(), Mockito.<SurveyRunCreateCommand>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Optional<Long>>any())).thenReturn(1L);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, mock(InvolvementDao.class), personDao,
        mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class),
        surveyRunDao, surveyTemplateDao, mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    IdCommandResponse actualCreateSurveyRunResult = surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).create(eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(command, atLeast(1)).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementGroupService, atLeast(1)).createGroup(Mockito.<InvolvementGroupCreateCommand>any(),
        eq("janedoe"));
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun5() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.create(anyLong(), Mockito.<SurveyRunCreateCommand>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Optional<Long>>any())).thenReturn(1L);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, mock(InvolvementDao.class), personDao,
        mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class),
        surveyRunDao, surveyTemplateDao, mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    IdCommandResponse actualCreateSurveyRunResult = surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).create(eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(command, atLeast(1)).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementGroupService, atLeast(1)).createGroup(Mockito.<InvolvementGroupCreateCommand>any(),
        eq("janedoe"));
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyRun(String, SurveyRunCreateCommand)}
   */
  @Test
  void testCreateSurveyRun6() throws InsufficientPrivelegeException {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.create(anyLong(), Mockito.<SurveyRunCreateCommand>any(), Mockito.<Optional<Long>>any(),
        Mockito.<Optional<Long>>any())).thenReturn(1L);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.canUserIssueAgainstTemplate(Mockito.<Long>any(), Mockito.<String>any())).thenReturn(true);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, mock(InvolvementDao.class), personDao,
        mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class),
        surveyRunDao, surveyTemplateDao, mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(2L);
    resultLongSet.add(1L);
    SurveyRunCreateCommand command = mock(SurveyRunCreateCommand.class);
    when(command.surveyTemplateId()).thenReturn(1L);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    IdCommandResponse actualCreateSurveyRunResult = surveyRunService.createSurveyRun("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).create(eq(1L), isA(SurveyRunCreateCommand.class), isA(Optional.class), isA(Optional.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyTemplateDao).canUserIssueAgainstTemplate(eq(1L), eq("janedoe"));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(command, atLeast(1)).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    verify(involvementGroupService, atLeast(1)).createGroup(Mockito.<InvolvementGroupCreateCommand>any(),
        eq("janedoe"));
    assertTrue(actualCreateSurveyRunResult instanceof ImmutableIdCommandResponse);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  void testCreateOwnersGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  void testCreateOwnersGroup2() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  void testCreateOwnersGroup3() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createOwnersGroup(long, String, Set, String)}
   */
  @Test
  void testCreateOwnersGroup4() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(2L);
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createOwnersGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup2() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", new HashSet<>(), "janedoe");

    // Assert
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup3() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createRecipientsGroup(long, String, Set, String)}
   */
  @Test
  void testCreateRecipientsGroup4() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), mock(PersonDao.class), mock(SurveyInstanceDao.class),
        mock(SurveyInstanceRecipientDao.class), mock(SurveyInstanceOwnerDao.class), surveyRunDao,
        mock(SurveyTemplateDao.class), mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> involvementKindIds = new HashSet<>();
    involvementKindIds.add(2L);
    involvementKindIds.add(3L);

    // Act
    surveyRunService.createRecipientsGroup(1L, "Doe", involvementKindIds, "janedoe");

    // Assert
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
  }

  /**
   * Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  void testDeleteSurveyRun() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    when(surveyRun.name()).thenReturn("Name");
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);

    // Act
    boolean actualDeleteSurveyRunResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyQuestionResponseDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao).delete(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(person).id();
    verify(surveyRun, atLeast(1)).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).surveyTemplateId();
    assertTrue(actualDeleteSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  void testDeleteSurveyRun2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    when(surveyRun.name()).thenReturn("Name");
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);

    // Act
    boolean actualDeleteSurveyRunResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyQuestionResponseDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao).delete(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(person).id();
    verify(surveyRun, atLeast(1)).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertTrue(actualDeleteSurveyRunResult);
  }

  /**
   * Method under test: {@link SurveyRunService#deleteSurveyRun(String, long)}
   */
  @Test
  void testDeleteSurveyRun3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    when(surveyRun.name()).thenReturn("Name");
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.delete(anyLong())).thenReturn(0);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    when(surveyQuestionResponseDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);

    // Act
    boolean actualDeleteSurveyRunResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .deleteSurveyRun("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyQuestionResponseDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao).delete(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(person).id();
    verify(surveyRun, atLeast(1)).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).surveyTemplateId();
    verify(changeLogService, atLeast(1)).write(Mockito.<ChangeLog>any());
    assertFalse(actualDeleteSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(involvementGroupDao, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(person, atLeast(1)).id();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(involvementGroupDao, atLeast(1)).createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command, atLeast(1)).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command, atLeast(1)).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1)).createGroup(Mockito.<InvolvementGroupCreateCommand>any(),
        eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun5() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun6() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(person, atLeast(1)).id();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun7() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRun(String, long, SurveyRunChangeCommand)}
   */
  @Test
  void testUpdateSurveyRun8() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.update(anyLong(), Mockito.<SurveyRunChangeCommand>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(2L);
    resultLongSet.add(1L);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    int actualUpdateSurveyRunResult = surveyRunService.updateSurveyRun("janedoe", 1L, command);

    // Assert
    verify(personDao, atLeast(1)).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).update(eq(1L), isA(SurveyRunChangeCommand.class));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person, atLeast(1)).id();
    verify(command).name();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
    assertEquals(1, actualUpdateSurveyRunResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(involvementGroupDao, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(person).id();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    doNothing().when(involvementGroupDao).updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any());
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(involvementGroupDao).createInvolvementGroup(isA(InvolvementGroupCreateCommand.class));
    verify(involvementGroupDao).updateInvolvements(eq(1L), isA(Set.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupDao involvementGroupDao = mock(InvolvementGroupDao.class);
    when(involvementGroupDao.createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any())).thenReturn(1L);
    InvolvementGroupService involvementGroupService = new InvolvementGroupService(involvementGroupDao);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(involvementGroupDao, atLeast(1)).createInvolvementGroup(Mockito.<InvolvementGroupCreateCommand>any());
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.updateOwnerInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateOwnerInvolvementGroupId(eq(1L), eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1)).createGroup(Mockito.<InvolvementGroupCreateCommand>any(),
        eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements5() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements6() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.involvementKindIds()).thenReturn(new HashSet<>());
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(person).id();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService, atLeast(1)).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements7() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunInvolvements(long, SurveyRunChangeCommand, String)}
   */
  @Test
  void testUpdateSurveyRunInvolvements8() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateRecipientInvolvementGroupId(anyLong(), Mockito.<Long>any())).thenReturn(1);
    when(surveyRunDao.getOwnerInvolvementGroupId(anyLong())).thenReturn(1L);
    when(surveyRunDao.getRecipientInvolvementGroupId(anyLong())).thenReturn(null);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementGroupService involvementGroupService = mock(InvolvementGroupService.class);
    doNothing().when(involvementGroupService)
        .updateInvolvements(Mockito.<Long>any(), Mockito.<Set<Long>>any(), Mockito.<String>any());
    when(involvementGroupService.createGroup(Mockito.<InvolvementGroupCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);
    SurveyRunService surveyRunService = new SurveyRunService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(InvolvementDao.class), personDao, mock(SurveyInstanceDao.class), mock(SurveyInstanceRecipientDao.class),
        mock(SurveyInstanceOwnerDao.class), surveyRunDao, mock(SurveyTemplateDao.class),
        mock(SurveyQuestionResponseDao.class), involvementGroupService);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(0L);
    resultLongSet.add(1L);
    SurveyRunChangeCommand command = mock(SurveyRunChangeCommand.class);
    when(command.name()).thenReturn("Name");
    when(command.involvementKindIds()).thenReturn(resultLongSet);
    when(command.ownerInvKindIds()).thenReturn(new HashSet<>());

    // Act
    surveyRunService.updateSurveyRunInvolvements(1L, command, "janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).getOwnerInvolvementGroupId(eq(1L));
    verify(surveyRunDao).getRecipientInvolvementGroupId(eq(1L));
    verify(surveyRunDao).updateRecipientInvolvementGroupId(eq(1L), eq(1L));
    verify(person).id();
    verify(command).name();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(command).involvementKindIds();
    verify(command).ownerInvKindIds();
    verify(involvementGroupService).createGroup(isA(InvolvementGroupCreateCommand.class), eq("janedoe"));
    verify(involvementGroupService).updateInvolvements(eq(1L), isA(Set.class), eq("janedoe"));
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}
   */
  @Test
  void testUpdateSurveyRunStatus() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateStatus(anyLong(), Mockito.<SurveyRunStatus>any())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    int actualUpdateSurveyRunStatusResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateStatus(eq(1L), eq(SurveyRunStatus.DRAFT));
    verify(person).id();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}
   */
  @Test
  void testUpdateSurveyRunStatus2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateStatus(anyLong(), Mockito.<SurveyRunStatus>any())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    int actualUpdateSurveyRunStatusResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.DRAFT);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateStatus(eq(1L), eq(SurveyRunStatus.DRAFT));
    verify(person).id();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunStatus(String, long, SurveyRunStatus)}
   */
  @Test
  void testUpdateSurveyRunStatus3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.status()).thenReturn(SurveyRunStatus.DRAFT);
    when(surveyRun.ownerId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.issue(anyLong())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    int actualUpdateSurveyRunStatusResult = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .updateSurveyRunStatus("janedoe", 1L, SurveyRunStatus.ISSUED);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).issue(eq(1L));
    verify(person).id();
    verify(surveyRun).ownerId();
    verify(surveyRun).status();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateSurveyRunStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunDueDate(String, long, DateChangeCommand)}
   */
  @Test
  void testUpdateSurveyRunDueDate() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    DateChangeCommand command = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.newDateVal()).thenReturn(ofResult);

    // Act
    int actualUpdateSurveyRunDueDateResult = surveyRunService.updateSurveyRunDueDate("janedoe", 1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceDao).updateDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateDueDate(eq(1L), isA(LocalDate.class));
    verify(command).newDateVal();
    verify(surveyRun).approvalDueDate();
    assertEquals(2, actualUpdateSurveyRunDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunDueDate(String, long, DateChangeCommand)}
   */
  @Test
  void testUpdateSurveyRunDueDate2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(1);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    DateChangeCommand command = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.newDateVal()).thenReturn(ofResult);

    // Act
    int actualUpdateSurveyRunDueDateResult = surveyRunService.updateSurveyRunDueDate("janedoe", 1L, command);

    // Assert
    verify(surveyInstanceDao).updateDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateDueDate(eq(1L), isA(LocalDate.class));
    verify(command).newDateVal();
    verify(surveyRun).approvalDueDate();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(2, actualUpdateSurveyRunDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)}
   */
  @Test
  void testUpdateSurveyRunApprovalDueDate() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateApprovalDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    DateChangeCommand command = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.newDateVal()).thenReturn(ofResult);

    // Act
    int actualUpdateSurveyRunApprovalDueDateResult = surveyRunService.updateSurveyRunApprovalDueDate("janedoe", 1L,
        command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyInstanceDao).updateApprovalDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(command).newDateVal();
    verify(surveyRun).dueDate();
    assertEquals(84, actualUpdateSurveyRunApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyRunApprovalDueDate(String, long, DateChangeCommand)}
   */
  @Test
  void testUpdateSurveyRunApprovalDueDate2() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateApprovalDueDateForSurveyRun(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.updateApprovalDueDate(anyLong(), Mockito.<LocalDate>any())).thenReturn(42);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    DateChangeCommand command = mock(DateChangeCommand.class);
    Optional<LocalDate> ofResult = Optional.of(LocalDate.of(1970, 1, 1));
    when(command.newDateVal()).thenReturn(ofResult);

    // Act
    int actualUpdateSurveyRunApprovalDueDateResult = surveyRunService.updateSurveyRunApprovalDueDate("janedoe", 1L,
        command);

    // Assert
    verify(surveyInstanceDao).updateApprovalDueDateForSurveyRun(eq(1L), isA(LocalDate.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyRunDao).updateApprovalDueDate(eq(1L), isA(LocalDate.class));
    verify(command).newDateVal();
    verify(surveyRun).dueDate();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(84, actualUpdateSurveyRunApprovalDueDateResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients2() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference2);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference2).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients3() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    EntityReference entityReference2 = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference2, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference3);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference3).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients4() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients5() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients6() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceRecipients7() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceRecipient> actualGenerateSurveyInstanceRecipientsResult = surveyRunService
        .generateSurveyInstanceRecipients(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceRecipientsResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners2() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference2);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference2).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners3() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    EntityReference entityReference2 = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference2, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference3);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference3).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).filters();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners4() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners5() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners6() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).scope();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#generateSurveyInstanceOwners(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testGenerateSurveyInstanceOwners7() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    List<SurveyInstanceOwner> actualGenerateSurveyInstanceOwnersResult = surveyRunService
        .generateSurveyInstanceOwners(command);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference).kind();
    verify(idSelectionOptions).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions).filters();
    verify(idSelectionOptions).scope();
    verify(selectionFilters).omitApplicationKinds();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualGenerateSurveyInstanceOwnersResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients2() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference2 = mock(EntityReference.class);
    when(entityReference2.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference2);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference2, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients3() {
    // Arrange
    HashMap<EntityReference, List<Person>> entityReferenceListMap = new HashMap<>();
    EntityReference entityReference = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference, new ArrayList<>());
    EntityReference entityReference2 = mock(EntityReference.class);
    entityReferenceListMap.put(entityReference2, new ArrayList<>());
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(entityReferenceListMap);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference3 = mock(EntityReference.class);
    when(entityReference3.kind()).thenReturn(EntityKind.ALL);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference3);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference3, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients4() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    HashSet<ApplicationKind> applicationKindSet = new HashSet<>();
    applicationKindSet.add(ApplicationKind.IN_HOUSE);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(applicationKindSet);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients5() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients6() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createSurveyInstancesAndRecipients(InstancesAndRecipientsCreateCommand)}
   */
  @Test
  void testCreateSurveyInstancesAndRecipients7() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    when(surveyInstanceRecipientDao.deleteForSurveyRun(anyLong())).thenReturn(1);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APP_GROUP);
    SelectionFilters selectionFilters = mock(SelectionFilters.class);
    when(selectionFilters.omitApplicationKinds()).thenReturn(new HashSet<>());
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityLifecycleStatuses()).thenReturn(new HashSet<>());
    when(idSelectionOptions.filters()).thenReturn(selectionFilters);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.involvementKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    when(surveyRun.surveyTemplateId()).thenReturn(1L);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.APPLICATION);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    InstancesAndRecipientsCreateCommand command = mock(InstancesAndRecipientsCreateCommand.class);
    when(command.excludedRecipients()).thenReturn(new HashSet<>());
    when(command.surveyRunId()).thenReturn(1L);

    // Act
    boolean actualCreateSurveyInstancesAndRecipientsResult = surveyRunService
        .createSurveyInstancesAndRecipients(command);

    // Assert
    verify(involvementDao, atLeast(1)).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION),
        isA(Select.class), isA(Set.class));
    verify(surveyInstanceDao).deleteForSurveyRun(eq(1L));
    verify(surveyInstanceRecipientDao).deleteForSurveyRun(eq(1L));
    verify(surveyRunDao, atLeast(1)).getById(eq(1L));
    verify(surveyTemplateDao, atLeast(1)).getById(eq(1L));
    verify(entityReference, atLeast(1)).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions, atLeast(1)).entityLifecycleStatuses();
    verify(idSelectionOptions, atLeast(1)).entityReference();
    verify(idSelectionOptions, atLeast(1)).filters();
    verify(idSelectionOptions, atLeast(1)).scope();
    verify(selectionFilters, atLeast(1)).omitApplicationKinds();
    verify(command).excludedRecipients();
    verify(command, atLeast(1)).surveyRunId();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun, atLeast(1)).selectionOptions();
    verify(surveyRun, atLeast(1)).surveyTemplateId();
    verify(surveyTemplate, atLeast(1)).targetEntityKind();
    assertTrue(actualCreateSurveyInstancesAndRecipientsResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#findBySurveyInstanceIdSelector(IdSelectionOptions)}
   */
  @Test
  void testFindBySurveyInstanceIdSelector() {
    // Arrange
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();
    when(surveyRunDao.findBySurveyInstanceIdSelector(Mockito.<Select<Record1<Long>>>any())).thenReturn(surveyRunList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.scope()).thenReturn(HierarchyQueryScope.EXACT);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    // Act
    List<SurveyRun> actualFindBySurveyInstanceIdSelectorResult = surveyRunService
        .findBySurveyInstanceIdSelector(idSelectionOptions);

    // Assert
    verify(surveyRunDao).findBySurveyInstanceIdSelector(isA(Select.class));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(idSelectionOptions).entityReference();
    verify(idSelectionOptions).scope();
    assertTrue(actualFindBySurveyInstanceIdSelectorResult.isEmpty());
    assertSame(surveyRunList, actualFindBySurveyInstanceIdSelectorResult);
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(person).id();
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(person2.id()).thenReturn(ofResult2);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any())).thenReturn(new ArrayList<>());
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(person2).id();
    verify(person).id();
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(person2.id()).thenReturn(ofResult2);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);
    SurveyRunCompletionRate surveyRunCompletionRate = mock(SurveyRunCompletionRate.class);
    when(surveyRunCompletionRate.surveyRunId()).thenReturn(1L);

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(surveyRunCompletionRate);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(person2).id();
    verify(person).id();
    verify(surveyRunCompletionRate).surveyRunId();
    assertTrue(actualFindByTemplateIdResult.isEmpty());
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId5() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(person2.id()).thenReturn(ofResult2);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);
    SurveyRunCompletionRate surveyRunCompletionRate = mock(SurveyRunCompletionRate.class);
    when(surveyRunCompletionRate.surveyRunId()).thenReturn(1L);

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(surveyRunCompletionRate);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerId()).thenReturn(1L);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(surveyRun.id()).thenReturn(ofResult3);

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();
    surveyRunList.add(surveyRun);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(person2).id();
    verify(person).id();
    verify(surveyRun).id();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRunCompletionRate).surveyRunId();
    assertEquals(1, actualFindByTemplateIdResult.size());
    assertTrue(actualFindByTemplateIdResult.get(0) instanceof ImmutableSurveyRunWithOwnerAndStats);
  }

  /**
   * Method under test: {@link SurveyRunService#findByTemplateId(long)}
   */
  @Test
  void testFindByTemplateId6() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    Person person2 = mock(Person.class);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(person2.id()).thenReturn(ofResult2);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(person2);
    personSet.add(person);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);
    SurveyRunCompletionRate surveyRunCompletionRate = mock(SurveyRunCompletionRate.class);
    when(surveyRunCompletionRate.surveyRunId()).thenReturn(1L);

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(surveyRunCompletionRate);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.ownerId()).thenReturn(1L);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(surveyRun.id()).thenReturn(ofResult3);
    SurveyRun surveyRun2 = mock(SurveyRun.class);
    when(surveyRun2.ownerId()).thenReturn(1L);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(surveyRun2.id()).thenReturn(ofResult4);

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();
    surveyRunList.add(surveyRun2);
    surveyRunList.add(surveyRun);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyRunWithOwnerAndStats> actualFindByTemplateIdResult = (new SurveyRunService(changeLogService,
        involvementDao, personDao, surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao,
        surveyTemplateDao, surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))))
            .findByTemplateId(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(person2).id();
    verify(person).id();
    verify(surveyRun2).id();
    verify(surveyRun).id();
    verify(surveyRun2, atLeast(1)).ownerId();
    verify(surveyRun, atLeast(1)).ownerId();
    verify(surveyRunCompletionRate).surveyRunId();
    assertEquals(2, actualFindByTemplateIdResult.size());
    assertTrue(actualFindByTemplateIdResult.get(0) instanceof ImmutableSurveyRunWithOwnerAndStats);
    assertTrue(actualFindByTemplateIdResult.get(1) instanceof ImmutableSurveyRunWithOwnerAndStats);
  }

  /**
   * Method under test: {@link SurveyRunService#getCompletionRate(long)}
   */
  @Test
  void testGetCompletionRate() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.getCompletionRateForSurveyRun(Mockito.<Long>any())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    SurveyRunCompletionRate actualCompletionRate = (new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)))).getCompletionRate(1L);

    // Assert
    verify(surveyInstanceDao).getCompletionRateForSurveyRun(eq(1L));
    assertNull(actualCompletionRate);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createDirectSurveyInstances(long, SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCreateDirectSurveyInstances() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.createInstanceOwners(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.createInstanceRecipients(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyRun.id()).thenReturn(ofResult);
    when(surveyRun.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(surveyRun.involvementKindIds()).thenReturn(resultLongSet);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerId()).thenReturn(1L);
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    SurveyInstanceRecipientsAndOwners recipientsAndOwners = mock(SurveyInstanceRecipientsAndOwners.class);
    when(recipientsAndOwners.owningRole()).thenReturn("Owning Role");
    when(recipientsAndOwners.ownerPersonIds()).thenReturn(new HashSet<>());
    when(recipientsAndOwners.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    boolean actualCreateDirectSurveyInstancesResult = surveyRunService.createDirectSurveyInstances(1L,
        recipientsAndOwners);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).createInstanceOwners(eq(1L), isA(Collection.class));
    verify(surveyInstanceDao).createInstanceRecipients(eq(1L), isA(Collection.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(surveyRun).id();
    verify(idSelectionOptions).entityReference();
    verify(surveyRun).name();
    verify(recipientsAndOwners).ownerPersonIds();
    verify(recipientsAndOwners).owningRole();
    verify(recipientsAndOwners).recipientPersonIds();
    verify(surveyRun).approvalDueDate();
    verify(surveyRun).dueDate();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).issuanceKind();
    verify(surveyRun).ownerId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    assertTrue(actualCreateDirectSurveyInstancesResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createDirectSurveyInstances(long, SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCreateDirectSurveyInstances2() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.createInstanceOwners(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.createInstanceRecipients(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyRun.id()).thenReturn(ofResult);
    when(surveyRun.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.issuanceKind()).thenReturn(SurveyIssuanceKind.INDIVIDUAL);
    when(surveyRun.involvementKindIds()).thenReturn(resultLongSet);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerId()).thenReturn(1L);
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    SurveyInstanceRecipientsAndOwners recipientsAndOwners = mock(SurveyInstanceRecipientsAndOwners.class);
    when(recipientsAndOwners.owningRole()).thenReturn("Owning Role");
    when(recipientsAndOwners.ownerPersonIds()).thenReturn(new HashSet<>());
    when(recipientsAndOwners.recipientPersonIds()).thenReturn(new HashSet<>());

    // Act
    boolean actualCreateDirectSurveyInstancesResult = surveyRunService.createDirectSurveyInstances(1L,
        recipientsAndOwners);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).createInstanceOwners(eq(1L), isA(Collection.class));
    verify(surveyInstanceDao).createInstanceRecipients(eq(1L), isA(Collection.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(surveyRun).id();
    verify(idSelectionOptions).entityReference();
    verify(surveyRun).name();
    verify(recipientsAndOwners).ownerPersonIds();
    verify(recipientsAndOwners).owningRole();
    verify(recipientsAndOwners).recipientPersonIds();
    verify(surveyRun).approvalDueDate();
    verify(surveyRun).dueDate();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).issuanceKind();
    verify(surveyRun).ownerId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    assertTrue(actualCreateDirectSurveyInstancesResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#createDirectSurveyInstances(long, SurveyInstanceRecipientsAndOwners)}
   */
  @Test
  void testCreateDirectSurveyInstances3() {
    // Arrange
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    when(involvementDao.findPeopleByEntitySelectorAndInvolvement(Mockito.<EntityKind>any(),
        Mockito.<Select<Record1<Long>>>any(), Mockito.<Set<Long>>any())).thenReturn(new HashMap<>());
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.createInstanceOwners(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.createInstanceRecipients(Mockito.<Long>any(), Mockito.<Collection<Long>>any()))
        .thenReturn(new int[]{1, -1, 1, -1});
    when(surveyInstanceDao.create(Mockito.<SurveyInstanceCreateCommand>any())).thenReturn(1L);
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.id()).thenReturn(1L);
    when(entityReference.kind()).thenReturn(EntityKind.APPLICATION);
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);
    when(idSelectionOptions.entityReference()).thenReturn(entityReference);

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SurveyRun surveyRun = mock(SurveyRun.class);
    when(surveyRun.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyRun.id()).thenReturn(ofResult);
    when(surveyRun.approvalDueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.dueDate()).thenReturn(LocalDate.of(1970, 1, 1));
    when(surveyRun.issuanceKind()).thenReturn(SurveyIssuanceKind.GROUP);
    when(surveyRun.involvementKindIds()).thenReturn(resultLongSet);
    when(surveyRun.ownerInvKindIds()).thenReturn(new HashSet<>());
    when(surveyRun.ownerId()).thenReturn(1L);
    when(surveyRun.selectionOptions()).thenReturn(idSelectionOptions);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.getById(anyLong())).thenReturn(surveyRun);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    HashSet<Long> resultLongSet2 = new HashSet<>();
    resultLongSet2.add(1L);
    SurveyInstanceRecipientsAndOwners recipientsAndOwners = mock(SurveyInstanceRecipientsAndOwners.class);
    when(recipientsAndOwners.owningRole()).thenReturn("Owning Role");
    when(recipientsAndOwners.ownerPersonIds()).thenReturn(new HashSet<>());
    when(recipientsAndOwners.recipientPersonIds()).thenReturn(resultLongSet2);

    // Act
    boolean actualCreateDirectSurveyInstancesResult = surveyRunService.createDirectSurveyInstances(1L,
        recipientsAndOwners);

    // Assert
    verify(involvementDao).findPeopleByEntitySelectorAndInvolvement(eq(EntityKind.APPLICATION), isA(Select.class),
        isA(Set.class));
    verify(surveyInstanceDao).create(isA(SurveyInstanceCreateCommand.class));
    verify(surveyInstanceDao).createInstanceOwners(eq(1L), isA(Collection.class));
    verify(surveyInstanceDao).createInstanceRecipients(eq(1L), isA(Collection.class));
    verify(surveyRunDao).getById(eq(1L));
    verify(entityReference).id();
    verify(entityReference, atLeast(1)).kind();
    verify(surveyRun).id();
    verify(idSelectionOptions).entityReference();
    verify(surveyRun).name();
    verify(recipientsAndOwners).ownerPersonIds();
    verify(recipientsAndOwners).owningRole();
    verify(recipientsAndOwners).recipientPersonIds();
    verify(surveyRun).approvalDueDate();
    verify(surveyRun).dueDate();
    verify(surveyRun).involvementKindIds();
    verify(surveyRun).issuanceKind();
    verify(surveyRun).ownerId();
    verify(surveyRun).ownerInvKindIds();
    verify(surveyRun).selectionOptions();
    assertTrue(actualCreateDirectSurveyInstancesResult);
  }

  /**
   * Method under test:
   * {@link SurveyRunService#updateSurveyInstanceOwningRoles(String, long, SurveyInstanceOwningRoleSaveCommand)}
   */
  @Test
  void testUpdateSurveyInstanceOwningRoles() {
    // Arrange
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.updateOwningRoleForSurveyRun(anyLong(), Mockito.<String>any())).thenReturn(1);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao = mock(PersonDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));
    SurveyInstanceOwningRoleSaveCommand owningRoleSaveCommand = mock(SurveyInstanceOwningRoleSaveCommand.class);
    when(owningRoleSaveCommand.owningRole()).thenReturn("Owning Role");

    // Act
    int actualUpdateSurveyInstanceOwningRolesResult = surveyRunService.updateSurveyInstanceOwningRoles("janedoe", 1L,
        owningRoleSaveCommand);

    // Assert
    verify(surveyInstanceDao).updateOwningRoleForSurveyRun(eq(1L), eq("Owning Role"));
    verify(owningRoleSaveCommand).owningRole();
    assertEquals(1, actualUpdateSurveyInstanceOwningRolesResult);
  }
}
