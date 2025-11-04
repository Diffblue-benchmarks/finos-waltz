package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionDropdownEntryDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.data.survey.SurveyRunDao;
import org.finos.waltz.data.survey.SurveyTemplateDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyRunWithOwnerAndStats;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.model.survey.SurveyTemplateChangeCommand;
import org.finos.waltz.model.survey_template_exchange.SurveyTemplateExchange;
import org.finos.waltz.model.survey_template_exchange.SurveyTemplateModel;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.jooq.DSLContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SurveyTemplateServiceDiffblueTest {
  /**
   * Method under test: {@link SurveyTemplateService#getById(long)}
   */
  @Test
  void testGetById() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    SurveyTemplate actualById = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).getById(1L);

    // Assert
    verify(surveyTemplateDao).getById(eq(1L));
    assertNull(actualById);
  }

  /**
   * Method under test: {@link SurveyTemplateService#getById(long)}
   */
  @Test
  void testGetById2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).getById(1L));
    verify(surveyTemplateDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  void testFindForOwner() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(null);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    when(surveyTemplateDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = (new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findForOwner("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).findForOwner(isNull());
    assertTrue(actualFindForOwnerResult.isEmpty());
    assertSame(surveyTemplateList, actualFindForOwnerResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  void testFindForOwner2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(null);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findForOwner(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("userName cannot be null"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findForOwner("janedoe"));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).findForOwner(isNull());
  }

  /**
   * Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  void testFindForOwner3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    when(surveyTemplateDao.findForOwner(Mockito.<Long>any())).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = (new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findForOwner("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).findForOwner(eq(1L));
    verify(person).id();
    assertTrue(actualFindForOwnerResult.isEmpty());
    assertSame(surveyTemplateList, actualFindForOwnerResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  void testFindForOwner4() {
    // Arrange
    Person person = mock(Person.class);
    when(person.id()).thenThrow(new IllegalArgumentException("userName cannot be null"));
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findForOwner("janedoe"));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(person).id();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testCreate() {
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = surveyTemplateService.create("janedoe", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(command).description();
    verify(command).externalId();
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testCreate2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.externalId()).thenThrow(new IllegalArgumentException("userName cannot be null"));
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.create("janedoe", command));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(command).description();
    verify(command).externalId();
    verify(person).id();
    verify(command).name();
    verify(command).targetEntityKind();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testCreate3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = surveyTemplateService.create("janedoe", command);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(command).description();
    verify(command).externalId();
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testCreate4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException("userName cannot be null"));
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult2 = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult2);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.create("janedoe", command));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(command).description();
    verify(command).externalId();
    verify(person).id();
    verify(command, atLeast(1)).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = surveyTemplateService.update("janedoe", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).name();
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenThrow(new IllegalArgumentException("userName cannot be null"));
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.update("janedoe", command));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).name();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = surveyTemplateService.update("janedoe", command);

    // Assert
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).name();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  void testUpdate4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException("userName cannot be null"));
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.update("janedoe", command));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).name();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus() {
    // Arrange
    ChangeLogDao changeLogDao = mock(ChangeLogDao.class);
    when(changeLogDao.write(Mockito.<Optional<DSLContext>>any(), Mockito.<ChangeLog>any())).thenReturn(19088743);
    ChangeLogService changeLogService = new ChangeLogService(changeLogDao, mock(ChangeLogSummariesDao.class),
        mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
        mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
        mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class));

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    int actualUpdateStatusResult = surveyTemplateService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyTemplateDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT));
    verify(command, atLeast(1)).newStatus();
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus2() {
    // Arrange
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenThrow(new IllegalArgumentException("command cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.updateStatus("janedoe", 1L, command));
    verify(command).newStatus();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    int actualUpdateStatusResult = surveyTemplateService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(surveyTemplateDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT));
    verify(command, atLeast(1)).newStatus();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus4() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any())).thenReturn(-9);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act
    int actualUpdateStatusResult = surveyTemplateService.updateStatus("janedoe", 1L, command);

    // Assert
    verify(surveyTemplateDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT));
    verify(command).newStatus();
    assertEquals(-9, actualUpdateStatusResult);
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  void testUpdateStatus5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException("command cannot be null"));
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenReturn(ReleaseLifecycleStatus.DRAFT);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.updateStatus("janedoe", 1L, command));
    verify(surveyTemplateDao).updateStatus(eq(1L), eq(ReleaseLifecycleStatus.DRAFT));
    verify(command, atLeast(1)).newStatus();
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  void testClone() {
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
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    long actualCloneResult = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        surveyQuestionDao, mock(SurveyQuestionDropdownEntryDao.class))).clone("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(surveyTemplate).description();
    verify(person).id();
    verify(surveyTemplate).name();
    verify(surveyTemplate).targetEntityKind();
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  void testClone2() {
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
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong()))
        .thenThrow(new IllegalArgumentException("userName cannot be null"));
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            surveyQuestionDao, mock(SurveyQuestionDropdownEntryDao.class))).clone("janedoe", 1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(surveyTemplate).description();
    verify(person).id();
    verify(surveyTemplate).name();
    verify(surveyTemplate).targetEntityKind();
  }

  /**
   * Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  void testClone3() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    long actualCloneResult = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        surveyQuestionDao, mock(SurveyQuestionDropdownEntryDao.class))).clone("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(surveyTemplate).description();
    verify(person).id();
    verify(surveyTemplate).name();
    verify(surveyTemplate).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  void testClone4() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(surveyQuestion.qualifierEntity()).thenReturn(ofResult2);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult4);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult5);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult7);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult8);
    when(surveyQuestion.allowComment()).thenReturn(true);
    Optional<String> ofResult9 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult9);
    when(surveyQuestion.kind()).thenReturn(EntityKind.ALL);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    long actualCloneResult = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        surveyQuestionDao, mock(SurveyQuestionDropdownEntryDao.class))).clone("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(surveyTemplate).description();
    verify(surveyQuestion).externalId();
    verify(person).id();
    verify(surveyQuestion).id();
    verify(surveyTemplate).name();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion, atLeast(1)).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).kind();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(surveyTemplate).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  void testClone5() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplate.name()).thenReturn("Name");
    when(surveyTemplate.targetEntityKind()).thenReturn(EntityKind.ALL);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong())).thenReturn(surveyTemplate);
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.surveyTemplateId()).thenReturn(1L);
    Optional<EntityReference> emptyResult = Optional.empty();
    when(surveyQuestion.qualifierEntity()).thenReturn(emptyResult);
    when(surveyQuestion.isMandatory()).thenReturn(true);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult2);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion.parentExternalId()).thenReturn(ofResult3);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion.sectionName()).thenReturn(ofResult4);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    when(surveyQuestion.position()).thenReturn(1);
    when(surveyQuestion.questionText()).thenReturn("Question Text");
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult5);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult6);
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion.label()).thenReturn(ofResult7);
    when(surveyQuestion.allowComment()).thenReturn(true);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyQuestion.helpText()).thenReturn(ofResult8);
    when(surveyQuestion.kind()).thenReturn(EntityKind.ALL);

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();
    surveyQuestionList.add(surveyQuestion);
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    long actualCloneResult = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        surveyQuestionDao, mock(SurveyQuestionDropdownEntryDao.class))).clone("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail(eq("janedoe"));
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(eq(1L));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(eq(1L));
    verify(surveyTemplate).description();
    verify(surveyQuestion).externalId();
    verify(person).id();
    verify(surveyQuestion).id();
    verify(surveyTemplate).name();
    verify(surveyQuestion).allowComment();
    verify(surveyQuestion, atLeast(1)).fieldType();
    verify(surveyQuestion).helpText();
    verify(surveyQuestion).inclusionPredicate();
    verify(surveyQuestion).isMandatory();
    verify(surveyQuestion).kind();
    verify(surveyQuestion).label();
    verify(surveyQuestion).parentExternalId();
    verify(surveyQuestion).position();
    verify(surveyQuestion).qualifierEntity();
    verify(surveyQuestion).questionText();
    verify(surveyQuestion).sectionName();
    verify(surveyQuestion).surveyTemplateId();
    verify(surveyTemplate).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);
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
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = (new SurveyTemplateService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PersonDao.class), surveyTemplateDao, surveyRunService, surveyQuestionDao, surveyQuestionDropdownEntryDao))
            .delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyQuestionDao).deleteForTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(surveyTemplateDao).delete(eq(1L));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete2() {
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
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException("xs cannot be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PersonDao.class), mock(SurveyTemplateDao.class), surveyRunService, mock(SurveyQuestionDao.class),
            surveyQuestionDropdownEntryDao)).delete(1L));
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete3() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(false);
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
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = (new SurveyTemplateService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PersonDao.class), surveyTemplateDao, surveyRunService, surveyQuestionDao, surveyQuestionDropdownEntryDao))
            .delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyQuestionDao).deleteForTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(surveyTemplateDao).delete(eq(1L));
    assertFalse(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete4() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);
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
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = (new SurveyTemplateService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PersonDao.class), surveyTemplateDao, surveyRunService, surveyQuestionDao, surveyQuestionDropdownEntryDao))
            .delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyQuestionDao).deleteForTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(surveyTemplateDao).delete(eq(1L));
    verify(person).id();
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete5() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);
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
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyRunService surveyRunService = new SurveyRunService(changeLogService, involvementDao, personDao,
        surveyInstanceDao, surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
        surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class)));

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = (new SurveyTemplateService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PersonDao.class), surveyTemplateDao, surveyRunService, surveyQuestionDao, surveyQuestionDropdownEntryDao))
            .delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(eq(1L));
    verify(surveyQuestionDao).deleteForTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyRunDao).findByTemplateId(eq(1L));
    verify(surveyTemplateDao).delete(eq(1L));
    verify(person2).id();
    verify(person).id();
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete6() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    new IllegalArgumentException("xs cannot be null");
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);
    SurveyRunService surveyRunService = mock(SurveyRunService.class);
    when(surveyRunService.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao = mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = (new SurveyTemplateService(
        new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class), mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
        mock(PersonDao.class), surveyTemplateDao, surveyRunService, surveyQuestionDao, surveyQuestionDropdownEntryDao))
            .delete(1L);

    // Assert
    verify(surveyQuestionDao).deleteForTemplate(eq(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(eq(1L));
    verify(surveyTemplateDao).delete(eq(1L));
    verify(surveyRunService).findByTemplateId(eq(1L));
    assertTrue(actualDeleteResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  void testDelete7() {
    // Arrange
    new IllegalArgumentException("xs cannot be null");
    new IllegalArgumentException("xs cannot be null");

    ArrayList<SurveyRunWithOwnerAndStats> surveyRunWithOwnerAndStatsList = new ArrayList<>();
    surveyRunWithOwnerAndStatsList.add(mock(SurveyRunWithOwnerAndStats.class));
    SurveyRunService surveyRunService = mock(SurveyRunService.class);
    when(surveyRunService.findByTemplateId(anyLong())).thenReturn(surveyRunWithOwnerAndStatsList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(
            new ChangeLogService(mock(ChangeLogDao.class), mock(ChangeLogSummariesDao.class),
                mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class), mock(LogicalFlowDao.class),
                mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class), mock(MeasurableRatingDao.class),
                mock(MeasurableRatingPlannedDecommissionDao.class), mock(EntityReferenceNameResolver.class)),
            mock(PersonDao.class), mock(SurveyTemplateDao.class), surveyRunService, mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class))).delete(1L));
    verify(surveyRunService).findByTemplateId(eq(1L));
  }

  /**
   * Method under test: {@link SurveyTemplateService#getByQuestionId(long)}
   */
  @Test
  void testGetByQuestionId() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getByQuestionId(anyLong())).thenReturn(null);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    SurveyTemplate actualByQuestionId = (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).getByQuestionId(1L);

    // Assert
    verify(surveyTemplateDao).getByQuestionId(eq(1L));
    assertNull(actualByQuestionId);
  }

  /**
   * Method under test: {@link SurveyTemplateService#getByQuestionId(long)}
   */
  @Test
  void testGetByQuestionId2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getByQuestionId(anyLong())).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).getByQuestionId(1L));
    verify(surveyTemplateDao).getByQuestionId(eq(1L));
  }

  /**
   * Method under test: {@link SurveyTemplateService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act
    Collection<SurveyTemplate> actualFindAllResult = (new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findAll();

    // Assert
    verify(surveyTemplateDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(surveyTemplateList, actualFindAllResult);
  }

  /**
   * Method under test: {@link SurveyTemplateService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenThrow(new IllegalArgumentException("foo"));
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new SurveyTemplateService(changeLogService, personDao, surveyTemplateDao,
            new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
                surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
                surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
            mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class))).findAll());
    verify(surveyTemplateDao).findAll();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.ownerEmployeeId()).thenThrow(new IllegalArgumentException("foo"));
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON2() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplateModel.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(surveyTemplateModel.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult2);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act
    Long actualImportTemplateFromJSONResult = surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId(eq("42"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplateModel).description();
    verify(surveyTemplateModel).externalId();
    verify(person).id();
    verify(surveyTemplateModel).name();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
    verify(surveyTemplateModel).targetEntityKind();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON3() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplateModel.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(surveyTemplateModel.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult2);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenThrow(new IllegalArgumentException("name"));
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId(eq("42"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplateModel).description();
    verify(surveyTemplateModel).externalId();
    verify(person).id();
    verify(surveyTemplateModel).name();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
    verify(surveyTemplateModel).targetEntityKind();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON4() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(surveyTemplate);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplateModel.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(surveyTemplateModel.name()).thenReturn("Name");
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult3);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act
    Long actualImportTemplateFromJSONResult = surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId(eq("42"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplateModel).description();
    verify(surveyTemplate).externalId();
    verify(surveyTemplateModel).externalId();
    verify(person).id();
    verify(surveyTemplate).name();
    verify(surveyTemplateModel).name();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
    verify(surveyTemplateModel).targetEntityKind();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON5() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    when(surveyTemplate.name()).thenReturn("Name");
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult2);
    SurveyTemplate surveyTemplate2 = mock(SurveyTemplate.class);
    when(surveyTemplate2.name()).thenReturn("Name");
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyTemplate2.externalId()).thenReturn(ofResult3);

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(surveyTemplate2);
    surveyTemplateList.add(surveyTemplate);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.description()).thenReturn("The characteristics of someone or something");
    when(surveyTemplateModel.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(surveyTemplateModel.name()).thenReturn("Name");
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult4);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act
    Long actualImportTemplateFromJSONResult = surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId(eq("42"));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplateModel).description();
    verify(surveyTemplate2).externalId();
    verify(surveyTemplate).externalId();
    verify(surveyTemplateModel).externalId();
    verify(person).id();
    verify(surveyTemplate2).name();
    verify(surveyTemplate).name();
    verify(surveyTemplateModel).name();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
    verify(surveyTemplateModel).targetEntityKind();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON6() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult2);
    SurveyTemplate surveyTemplate2 = mock(SurveyTemplate.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyTemplate2.externalId()).thenReturn(ofResult3);
    SurveyTemplate surveyTemplate3 = mock(SurveyTemplate.class);
    when(surveyTemplate3.externalId()).thenThrow(new IllegalArgumentException("name"));

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(surveyTemplate3);
    surveyTemplateList.add(surveyTemplate2);
    surveyTemplateList.add(surveyTemplate);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult4);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId(eq("42"));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplate3).externalId();
    verify(person).id();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON7() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> emptyResult = Optional.empty();
    when(person.id()).thenReturn(emptyResult);
    Person person2 = mock(Person.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(person2.id()).thenReturn(ofResult);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person2);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);
    SurveyTemplate surveyTemplate = mock(SurveyTemplate.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyTemplate.externalId()).thenReturn(ofResult2);
    SurveyTemplate surveyTemplate2 = mock(SurveyTemplate.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyTemplate2.externalId()).thenReturn(ofResult3);
    SurveyTemplate surveyTemplate3 = mock(SurveyTemplate.class);
    when(surveyTemplate3.externalId()).thenThrow(new IllegalArgumentException("name"));

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(surveyTemplate3);
    surveyTemplateList.add(surveyTemplate2);
    surveyTemplateList.add(surveyTemplate);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyTemplateModel.externalId()).thenReturn(ofResult4);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId(eq("42"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).findAll();
    verify(surveyTemplate3).externalId();
    verify(person2).id();
    verify(person).id();
    verify(templateExchange).template();
    verify(surveyTemplateModel).ownerEmployeeId();
  }

  /**
   * Method under test:
   * {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}
   */
  @Test
  void testImportTemplateFromJSON8() {
    // Arrange
    Person person = mock(Person.class);
    Optional<Long> emptyResult = Optional.empty();
    when(person.id()).thenReturn(emptyResult);
    Person person2 = mock(Person.class);
    Optional<Long> emptyResult2 = Optional.empty();
    when(person2.id()).thenReturn(emptyResult2);
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByUserEmail(Mockito.<String>any())).thenReturn(person2);
    when(personDao.getByEmployeeId(Mockito.<String>any())).thenReturn(person);

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(mock(SurveyTemplate.class));
    surveyTemplateList.add(mock(SurveyTemplate.class));
    surveyTemplateList.add(mock(SurveyTemplate.class));
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    ChangeLogService changeLogService2 = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    SurveyTemplateService surveyTemplateService = new SurveyTemplateService(changeLogService, personDao,
        surveyTemplateDao,
        new SurveyRunService(changeLogService2, involvementDao, personDao2, surveyInstanceDao,
            surveyInstanceRecipientDao, surveyInstanceOwnerDao, surveyRunDao, surveyTemplateDao2,
            surveyQuestionResponseDao, new InvolvementGroupService(mock(InvolvementGroupDao.class))),
        mock(SurveyQuestionDao.class), mock(SurveyQuestionDropdownEntryDao.class));
    SurveyTemplateModel surveyTemplateModel = mock(SurveyTemplateModel.class);
    when(surveyTemplateModel.ownerEmployeeId()).thenReturn("42");
    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template()).thenReturn(surveyTemplateModel);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId(eq("42"));
    verify(personDao).getByUserEmail(eq("janedoe"));
    verify(surveyTemplateDao).findAll();
    verify(person2).id();
    verify(person).id();
    verify(templateExchange).template();
    verify(surveyTemplateModel, atLeast(1)).ownerEmployeeId();
  }
}
