package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableIdSelectionOptions.Builder;
import org.finos.waltz.model.ImmutableReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.ReleaseLifecycleStatusChangeCommand;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.Person;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.ImmutableSurveyRunCompletionRate;
import org.finos.waltz.model.survey.ImmutableSurveyTemplate;
import org.finos.waltz.model.survey.ImmutableSurveyTemplateChangeCommand;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyRun;
import org.finos.waltz.model.survey.SurveyRunCompletionRate;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.model.survey.SurveyTemplateChangeCommand;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyDropdownEntryModel;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyQuestionModel;
import org.finos.waltz.model.survey_template_exchange.ImmutableSurveyTemplateModel;
import org.finos.waltz.model.survey_template_exchange.SurveyQuestionModel;
import org.finos.waltz.model.survey_template_exchange.SurveyTemplateExchange;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
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
class SurveyTemplateServiceDiffblueTest {
  @Mock private ChangeLogService changeLogService;

  @Mock private PersonDao personDao;

  @Mock private SurveyQuestionDao surveyQuestionDao;

  @Mock private SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao;

  @Mock private SurveyRunService surveyRunService;

  @Mock private SurveyTemplateDao surveyTemplateDao;

  @InjectMocks private SurveyTemplateService surveyTemplateService;

  /**
   * Test {@link SurveyTemplateService#getById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSurveyTemplate}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then return ImmutableSurveyTemplate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateService.getById(long)"})
  void testGetById_thenReturnImmutableSurveyTemplate() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(ofResult.atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    SurveyTemplate actualById = surveyTemplateService.getById(1L);

    // Assert
    verify(surveyTemplateDao).getById(1L);
    assertTrue(actualById instanceof ImmutableSurveyTemplate);
    LocalDateTime createdAtResult = actualById.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualById.issuanceRole());
    assertEquals("Name", actualById.name());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityKind.ALL, actualById.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualById.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SurveyTemplateService#getById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateService.getById(long)"})
  void testGetById_thenThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.getById(1L));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#findForOwner(String)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  @DisplayName(
      "Test findForOwner(String); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateService.findForOwner(String)"})
  void testFindForOwner_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyTemplateService.findForOwner("janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyTemplateService#findForOwner(String)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#findForOwner(Long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  @DisplayName(
      "Test findForOwner(String); given SurveyTemplateDao findForOwner(Long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateService.findForOwner(String)"})
  void testFindForOwner_givenSurveyTemplateDaoFindForOwnerThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findForOwner(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyTemplateService.findForOwner("janedoe"));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).findForOwner(1L);
  }

  /**
   * Test {@link SurveyTemplateService#findForOwner(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#findForOwner(String)}
   */
  @Test
  @DisplayName("Test findForOwner(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyTemplateService.findForOwner(String)"})
  void testFindForOwner_thenReturnEmpty() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findForOwner(Mockito.<Long>any())).thenReturn(new ArrayList<>());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    List<SurveyTemplate> actualFindForOwnerResult = surveyTemplateService.findForOwner("janedoe");

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).findForOwner(1L);
    assertTrue(actualFindForOwnerResult.isEmpty());
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test create(String, SurveyTemplateChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.description()).thenThrow(new IllegalArgumentException());
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.create("", command));
    verify(personDao).getActiveByUserEmail("");
    verify(command).description();
    verify(command).name();
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test create(String, SurveyTemplateChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.externalId()).thenThrow(new IllegalArgumentException());
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.create("", command));
    verify(personDao).getActiveByUserEmail("");
    verify(command).description();
    verify(command).externalId();
    verify(command).name();
    verify(command).targetEntityKind();
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCreateResult =
        surveyTemplateService.create(
            "janedoe",
            ImmutableSurveyTemplateChangeCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .name("Name")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite2() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = surveyTemplateService.create("", command);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(command).description();
    verify(command).externalId();
    verify(command, atLeast(1)).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link SurveyTemplateChangeCommand#issuanceRole()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given ChangeLogService write(ChangeLog) return '19088743'; then calls issuanceRole()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_givenChangeLogServiceWriteReturn19088743_thenCallsIssuanceRole() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.issuanceRole()).thenReturn("Issuance Role");
    Optional<String> ofResult = Optional.of("foo");
    when(command.externalId()).thenReturn(ofResult);
    when(command.description()).thenReturn("The characteristics of someone or something");
    when(command.targetEntityKind()).thenReturn(EntityKind.ALL);
    when(command.name()).thenReturn("Name");

    // Act
    long actualCreateResult = surveyTemplateService.create("", command);

    // Assert
    verify(personDao).getActiveByUserEmail("");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(command).description();
    verify(command).externalId();
    verify(command, atLeast(1)).name();
    verify(command).issuanceRole();
    verify(command).targetEntityKind();
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.create(
                "janedoe",
                ImmutableSurveyTemplateChangeCommand.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link PersonDao} {@link PersonDao#getActiveByUserEmail(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given PersonDao getActiveByUserEmail(String) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_givenPersonDaoGetActiveByUserEmailThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.create(
                "janedoe",
                ImmutableSurveyTemplateChangeCommand.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#create(SurveyTemplate)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); given SurveyTemplateDao create(SurveyTemplate) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_givenSurveyTemplateDaoCreateThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any()))
        .thenThrow(new IllegalArgumentException());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.create(
                "janedoe",
                ImmutableSurveyTemplateChangeCommand.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
  }

  /**
   * Test {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link SurveyTemplateChangeCommand} {@link SurveyTemplateChangeCommand#name()} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#create(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test create(String, SurveyTemplateChangeCommand); when SurveyTemplateChangeCommand name() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.create(String, SurveyTemplateChangeCommand)"})
  void testCreate_whenSurveyTemplateChangeCommandNameThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());
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
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.create("", command));
    verify(personDao).getActiveByUserEmail("");
    verify(command).name();
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName("Test update(String, SurveyTemplateChangeCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    int actualUpdateResult =
        surveyTemplateService.update(
            "janedoe",
            ImmutableSurveyTemplateChangeCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .name("Name")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite() {
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    int actualUpdateResult =
        surveyTemplateService.update(
            "janedoe",
            ImmutableSurveyTemplateChangeCommand.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .name("Name")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_givenChangeLogDaoWriteReturn19088743_thenCallsWrite2() {
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenReturn("Name");
    Optional<Long> ofResult = Optional.of(1L);
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
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.update(
                "janedoe",
                ImmutableSurveyTemplateChangeCommand.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link
   *       SurveyTemplateDao#update(SurveyTemplateChangeCommand)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); given SurveyTemplateDao update(SurveyTemplateChangeCommand) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_givenSurveyTemplateDaoUpdateThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any()))
        .thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.update(
                "janedoe",
                ImmutableSurveyTemplateChangeCommand.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .issuanceRole("Issuance Role")
                    .name("Name")
                    .targetEntityKind(EntityKind.ALL)
                    .build()));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link
   *       SurveyTemplateDao#update(SurveyTemplateChangeCommand)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); given SurveyTemplateDao update(SurveyTemplateChangeCommand) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_givenSurveyTemplateDaoUpdateThrowIllegalArgumentException2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any()))
        .thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyTemplateService.update("janedoe", command));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command).id();
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link SurveyTemplateChangeCommand} {@link SurveyTemplateChangeCommand#id()} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); when SurveyTemplateChangeCommand id() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_whenSurveyTemplateChangeCommandIdThrowIllegalArgumentException() {
    // Arrange
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
    PersonDao personDao = mock(PersonDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.id()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyTemplateService.update("janedoe", command));
    verify(command).id();
  }

  /**
   * Test {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}.
   *
   * <ul>
   *   <li>When {@link SurveyTemplateChangeCommand} {@link SurveyTemplateChangeCommand#name()} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#update(String, SurveyTemplateChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test update(String, SurveyTemplateChangeCommand); when SurveyTemplateChangeCommand name() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyTemplateService.update(String, SurveyTemplateChangeCommand)"})
  void testUpdate_whenSurveyTemplateChangeCommandNameThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.update(Mockito.<SurveyTemplateChangeCommand>any())).thenReturn(1);
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateChangeCommand command = mock(SurveyTemplateChangeCommand.class);
    when(command.name()).thenThrow(new IllegalArgumentException());
    Optional<Long> ofResult = Optional.of(1L);
    when(command.id()).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyTemplateService.update("janedoe", command));
    verify(surveyTemplateDao).update(isA(SurveyTemplateChangeCommand.class));
    verify(command, atLeast(1)).id();
    verify(command).name();
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogDao#write(Optional, ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then calls write(Optional, ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
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

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    int actualUpdateStatusResult =
        surveyTemplateService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(surveyTemplateDao).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogService write(ChangeLog) return '19088743'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogServiceWriteReturn19088743_thenReturnOne() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(1);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    int actualUpdateStatusResult =
        surveyTemplateService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(surveyTemplateDao).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(1);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.DRAFT)
                    .build()));
    verify(surveyTemplateDao).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link ReleaseLifecycleStatusChangeCommand#newStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given IllegalArgumentException(); then calls newStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenIllegalArgumentException_thenCallsNewStatus() {
    // Arrange
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
    PersonDao personDao = mock(PersonDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    ReleaseLifecycleStatusChangeCommand command = mock(ReleaseLifecycleStatusChangeCommand.class);
    when(command.newStatus()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.updateStatus("janedoe", 1L, command));
    verify(command).newStatus();
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#updateStatus(long,
   *       ReleaseLifecycleStatus)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); given SurveyTemplateDao updateStatus(long, ReleaseLifecycleStatus) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_givenSurveyTemplateDaoUpdateStatusThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyTemplateService.updateStatus(
                "janedoe",
                1L,
                ImmutableReleaseLifecycleStatusChangeCommand.builder()
                    .newStatus(ReleaseLifecycleStatus.DRAFT)
                    .build()));
    verify(surveyTemplateDao).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);
  }

  /**
   * Test {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}.
   *
   * <ul>
   *   <li>Then return minus nine.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#updateStatus(String, long,
   * ReleaseLifecycleStatusChangeCommand)}
   */
  @Test
  @DisplayName(
      "Test updateStatus(String, long, ReleaseLifecycleStatusChangeCommand); then return minus nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int SurveyTemplateService.updateStatus(String, long, ReleaseLifecycleStatusChangeCommand)"
  })
  void testUpdateStatus_thenReturnMinusNine() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(-9);
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    int actualUpdateStatusResult =
        surveyTemplateService.updateStatus(
            "janedoe",
            1L,
            ImmutableReleaseLifecycleStatusChangeCommand.builder()
                .newStatus(ReleaseLifecycleStatus.DRAFT)
                .build());

    // Assert
    verify(surveyTemplateDao).updateStatus(1L, ReleaseLifecycleStatus.DRAFT);
    assertEquals(-9, actualUpdateStatusResult);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName("Test clone(String, long) with 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong())).thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName("Test clone(String, long) with 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName("Test clone(String, long) with 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName("Test clone(String, long) with 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong4() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenThrow(new IllegalArgumentException());
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName("Test clone(String, long) with 'String', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong5() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogDao} {@link ChangeLogDao#write(Optional, ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given ChangeLogDao write(Optional, ChangeLog) return '19088743'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenChangeLogDaoWriteReturn19088743_thenReturnOne() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(new ArrayList<>());
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCloneResult = surveyTemplateService.clone("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} return {@code
   *       19088743}.
   *   <li>Then calls {@link ChangeLogService#write(ChangeLog)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given ChangeLogService write(ChangeLog) return '19088743'; then calls write(ChangeLog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenChangeLogServiceWriteReturn19088743_thenCallsWrite() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any())).thenReturn(19088743);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCloneResult = surveyTemplateService.clone("janedoe", 1L);

    // Assert
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link ChangeLogService} {@link ChangeLogService#write(ChangeLog)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given ChangeLogService write(ChangeLog) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenChangeLogServiceWriteThrowIllegalArgumentException() {
    // Arrange
    ChangeLogService changeLogService = mock(ChangeLogService.class);
    when(changeLogService.write(Mockito.<ChangeLog>any()))
        .thenThrow(new IllegalArgumentException());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.clone("janedoe", 1L));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    verify(changeLogService).write(isA(ChangeLog.class));
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#create(SurveyQuestion)} return
   *       one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given SurveyQuestionDao create(SurveyQuestion) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenSurveyQuestionDaoCreateReturnOne_thenReturnOne() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCloneResult = surveyTemplateService.clone("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#create(SurveyQuestion)} return
   *       one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given SurveyQuestionDao create(SurveyQuestion) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenSurveyQuestionDaoCreateReturnOne_thenReturnOne2() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    ImmutableSurveyQuestion.Builder positionResult2 =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity2 = Optional.of(immutableEntityReference2);
    surveyQuestionList.add(
        positionResult2
            .qualifierEntity(qualifierEntity2)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCloneResult = surveyTemplateService.clone("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao, atLeast(1)).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    assertEquals(1L, actualCloneResult);
  }

  /**
   * Test {@link SurveyTemplateService#clone(String, long)} with {@code String}, {@code long}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#create(SurveyTemplate)} return
   *       three.
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#clone(String, long)}
   */
  @Test
  @DisplayName(
      "Test clone(String, long) with 'String', 'long'; given SurveyTemplateDao create(SurveyTemplate) return three; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyTemplateService.clone(String, long)"})
  void testCloneWithStringLong_givenSurveyTemplateDaoCreateReturnThree_thenReturnThree() {
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

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getActiveByUserEmail(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(3L);
    when(surveyTemplateDao.getById(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());

    ArrayList<SurveyQuestion> surveyQuestionList = new ArrayList<>();

    ImmutableSurveyQuestion.Builder positionResult =
        ImmutableSurveyQuestion.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .id(1L)
            .inclusionPredicate("Inclusion Predicate")
            .kind(EntityKind.ALL)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> qualifierEntity = Optional.of(immutableEntityReference);
    surveyQuestionList.add(
        positionResult
            .qualifierEntity(qualifierEntity)
            .questionText("Question Text")
            .sectionName("Section Name")
            .surveyTemplateId(1L)
            .build());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(surveyQuestionList);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    long actualCloneResult = surveyTemplateService.clone("janedoe", 1L);

    // Assert
    verify(changeLogDao).write(isA(Optional.class), isA(ChangeLog.class));
    verify(personDao).getActiveByUserEmail("janedoe");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDao).findForTemplate(1L);
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).getById(1L);
    assertEquals(3L, actualCloneResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            mock(SurveyTemplateDao.class),
            surveyRunService,
            mock(SurveyQuestionDao.class),
            surveyQuestionDropdownEntryDao);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);

    HashSet<Person> personSet = new HashSet<>();
    personSet.add(
        ImmutablePerson.builder()
            .departmentName("Department Name")
            .displayName("Display Name")
            .email("jane.doe@example.org")
            .employeeId("42")
            .id(1L)
            .isRemoved(true)
            .kind(EntityKind.ALL)
            .managerEmployeeId("42")
            .mobilePhone("6625550144")
            .officePhone("6625550144")
            .organisationalUnitId(1L)
            .personKind(PersonKind.EMPLOYEE)
            .title("Dr")
            .userId("42")
            .userPrincipalName("User Principal Name")
            .build());

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(personSet);

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    // Act
    Boolean actualDeleteResult = surveyTemplateService.delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    verify(surveyTemplateDao).delete(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    surveyRunList.add(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            mock(SurveyTemplateDao.class),
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete4() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<SurveyRun> surveyRunList = new ArrayList<>();

    ImmutableSurveyRun.Builder ownerIdResult =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    Builder builderResult = ImmutableIdSelectionOptions.builder();

    Builder filtersResult =
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
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult = filtersResult.joiningEntityKind(joiningEntityKind);
    surveyRunList.add(
        ownerIdResult
            .selectionOptions(
                joiningEntityKindResult
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    ImmutableSurveyRun.Builder ownerIdResult2 =
        ImmutableSurveyRun.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .contactEmail("jane.doe@example.org")
            .description("The characteristics of someone or something")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuanceKind(SurveyIssuanceKind.GROUP)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .name("Name")
            .ownerId(1L);

    Builder builderResult2 = ImmutableIdSelectionOptions.builder();

    Builder filtersResult2 =
        builderResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .filters(ImmutableSelectionFilters.builder().build());
    Optional<? extends EntityKind> joiningEntityKind2 = Optional.of(EntityKind.ALL);

    Builder joiningEntityKindResult2 = filtersResult2.joiningEntityKind(joiningEntityKind2);
    surveyRunList.add(
        ownerIdResult2
            .selectionOptions(
                joiningEntityKindResult2
                    .addAllEntityLifecycleStatuses(new ArrayList<>())
                    .scope(HierarchyQueryScope.EXACT)
                    .build())
            .status(SurveyRunStatus.DRAFT)
            .surveyTemplateId(1L)
            .build());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(surveyRunList);
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            mock(SurveyTemplateDao.class),
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete5() {
    // Arrange
    SurveyRunService surveyRunService = mock(SurveyRunService.class);
    when(surveyRunService.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            mock(PersonDao.class),
            mock(SurveyTemplateDao.class),
            surveyRunService,
            mock(SurveyQuestionDao.class),
            surveyQuestionDropdownEntryDao);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunService).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder surveyRunId one build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given ArrayList() add builder surveyRunId one build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenArrayListAddBuilderSurveyRunIdOneBuild_thenReturnTrue() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    // Act
    Boolean actualDeleteResult = surveyTemplateService.delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    verify(surveyTemplateDao).delete(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add builder surveyRunId one build.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given ArrayList() add builder surveyRunId one build; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenArrayListAddBuilderSurveyRunIdOneBuild_thenReturnTrue2() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    ArrayList<SurveyRunCompletionRate> surveyRunCompletionRateList = new ArrayList<>();
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());
    surveyRunCompletionRateList.add(
        ImmutableSurveyRunCompletionRate.builder().surveyRunId(1L).build());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(surveyRunCompletionRateList);

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    // Act
    Boolean actualDeleteResult = surveyTemplateService.delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    verify(surveyTemplateDao).delete(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#deleteForTemplate(Long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given SurveyQuestionDao deleteForTemplate(Long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenSurveyQuestionDaoDeleteForTemplateThrowIllegalArgumentException() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            mock(SurveyTemplateDao.class),
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#delete(long)} return {@code
   *       false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given SurveyTemplateDao delete(long) return 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenSurveyTemplateDaoDeleteReturnFalse_thenReturnFalse() {
    // Arrange
    when(surveyTemplateDao.delete(anyLong())).thenReturn(false);
    when(surveyRunService.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    // Act
    Boolean actualDeleteResult = surveyTemplateService.delete(1L);

    // Assert
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyTemplateDao).delete(1L);
    verify(surveyRunService).findByTemplateId(1L);
    assertFalse(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#delete(long)} return {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given SurveyTemplateDao delete(long) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenSurveyTemplateDaoDeleteReturnTrue_thenReturnTrue() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.delete(anyLong())).thenReturn(true);

    PersonDao personDao = mock(PersonDao.class);
    when(personDao.findByIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    when(surveyInstanceDao.findCompletionRateForSurveyTemplate(Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    when(surveyRunDao.findByTemplateId(anyLong())).thenReturn(new ArrayList<>());
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService,
            involvementDao,
            personDao,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    when(surveyQuestionDropdownEntryDao.deleteForTemplate(Mockito.<Long>any())).thenReturn(1);
    ChangeLogService changeLogService2 =
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

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService2,
            mock(PersonDao.class),
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    // Act
    Boolean actualDeleteResult = surveyTemplateService.delete(1L);

    // Assert
    verify(personDao).findByIds(isA(Set.class));
    verify(surveyInstanceDao).findCompletionRateForSurveyTemplate(1L);
    verify(surveyQuestionDao).deleteForTemplate(1L);
    verify(surveyQuestionDropdownEntryDao).deleteForTemplate(1L);
    verify(surveyRunDao).findByTemplateId(1L);
    verify(surveyTemplateDao).delete(1L);
    assertTrue(actualDeleteResult);
  }

  /**
   * Test {@link SurveyTemplateService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao}.
   *   <li>Then calls {@link SurveyRunService#findByTemplateId(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long); given SurveyTemplateDao; then calls findByTemplateId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean SurveyTemplateService.delete(long)"})
  void testDelete_givenSurveyTemplateDao_thenCallsFindByTemplateId() {
    // Arrange
    when(surveyRunService.findByTemplateId(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.delete(1L));
    verify(surveyRunService).findByTemplateId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#getByQuestionId(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableSurveyTemplate}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#getByQuestionId(long)}
   */
  @Test
  @DisplayName("Test getByQuestionId(long); then return ImmutableSurveyTemplate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateService.getByQuestionId(long)"})
  void testGetByQuestionId_thenReturnImmutableSurveyTemplate() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(surveyTemplateDao.getByQuestionId(anyLong()))
        .thenReturn(
            ImmutableSurveyTemplate.builder()
                .createdAt(ofResult.atStartOfDay())
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .issuanceRole("Issuance Role")
                .kind(EntityKind.ALL)
                .name("Name")
                .ownerId(1L)
                .status(ReleaseLifecycleStatus.DRAFT)
                .targetEntityKind(EntityKind.ALL)
                .build());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    SurveyTemplate actualByQuestionId = surveyTemplateService.getByQuestionId(1L);

    // Assert
    verify(surveyTemplateDao).getByQuestionId(1L);
    assertTrue(actualByQuestionId instanceof ImmutableSurveyTemplate);
    LocalDateTime createdAtResult = actualByQuestionId.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualByQuestionId.issuanceRole());
    assertEquals("Name", actualByQuestionId.name());
    assertEquals("The characteristics of someone or something", actualByQuestionId.description());
    assertEquals(1L, actualByQuestionId.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualByQuestionId.kind());
    assertEquals(EntityKind.ALL, actualByQuestionId.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualByQuestionId.status());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link SurveyTemplateService#getByQuestionId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#getByQuestionId(long)}
   */
  @Test
  @DisplayName("Test getByQuestionId(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyTemplate SurveyTemplateService.getByQuestionId(long)"})
  void testGetByQuestionId_thenThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.getByQuestionId(anyLong())).thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.getByQuestionId(1L));
    verify(surveyTemplateDao).getByQuestionId(1L);
  }

  /**
   * Test {@link SurveyTemplateService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#findAll()}
   */
  @Test
  @DisplayName(
      "Test findAll(); given SurveyTemplateDao findAll() return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SurveyTemplateService.findAll()"})
  void testFindAll_givenSurveyTemplateDaoFindAllReturnArrayList_thenReturnList() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act
    Collection<SurveyTemplate> actualFindAllResult = surveyTemplateService.findAll();

    // Assert
    verify(surveyTemplateDao).findAll();
    assertTrue(actualFindAllResult instanceof List);
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(surveyTemplateList, actualFindAllResult);
  }

  /**
   * Test {@link SurveyTemplateService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SurveyTemplateService.findAll()"})
  void testFindAll_thenThrowIllegalArgumentException() {
    // Arrange
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenThrow(new IllegalArgumentException());
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
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyTemplateService.findAll());
    verify(surveyTemplateDao).findAll();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON() {
    // Arrange
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
    PersonDao personDao = mock(PersonDao.class);
    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON3() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any()))
        .thenThrow(new IllegalArgumentException());
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON4() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenThrow(new IllegalArgumentException());
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON5() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON6() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    ArrayList<SurveyTemplate> surveyTemplateList = new ArrayList<>();
    surveyTemplateList.add(
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());
    surveyTemplateList.add(
        ImmutableSurveyTemplate.builder()
            .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .issuanceRole("Issuance Role")
            .kind(EntityKind.ALL)
            .name("Name")
            .ownerId(1L)
            .status(ReleaseLifecycleStatus.DRAFT)
            .targetEntityKind(EntityKind.ALL)
            .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(surveyTemplateList);
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON7() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    surveyQuestionModelList.add(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(surveyQuestionModelList);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId("42");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON8() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doNothing()
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.addDropdownEntries(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());

    ImmutableSurveyQuestionModel.Builder positionResult =
        builderResult
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build();

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    surveyQuestionModelList.add(immutableSurveyQuestionModel);

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(surveyQuestionModelList);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName("Test importTemplateFromJSON(String, SurveyTemplateExchange)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON9() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

    SurveyQuestionDropdownEntryDao surveyQuestionDropdownEntryDao =
        mock(SurveyQuestionDropdownEntryDao.class);
    doThrow(new IllegalArgumentException())
        .when(surveyQuestionDropdownEntryDao)
        .saveEntries(anyLong(), Mockito.<Collection<SurveyQuestionDropdownEntry>>any());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            surveyQuestionDropdownEntryDao);

    ImmutableSurveyQuestionModel.Builder builderResult = ImmutableSurveyQuestionModel.builder();
    builderResult.addDropdownEntries(
        ImmutableSurveyDropdownEntryModel.builder().position(1).value("42").build());

    ImmutableSurveyQuestionModel.Builder positionResult =
        builderResult
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    ImmutableSurveyQuestionModel immutableSurveyQuestionModel =
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build();

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();
    surveyQuestionModelList.add(immutableSurveyQuestionModel);

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(surveyQuestionModelList);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange));
    verify(personDao).getByEmployeeId("42");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyQuestionDropdownEntryDao).saveEntries(eq(1L), isA(Collection.class));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName(
      "Test importTemplateFromJSON(String, SurveyTemplateExchange); given ArrayList(); then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON_givenArrayList_thenReturnLongValueIsOne() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            mock(SurveyQuestionDao.class),
            mock(SurveyQuestionDropdownEntryDao.class));

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(new ArrayList<>());
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#create(SurveyQuestion)} return
   *       one.
   *   <li>Then calls {@link SurveyQuestionDao#create(SurveyQuestion)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName(
      "Test importTemplateFromJSON(String, SurveyTemplateExchange); given SurveyQuestionDao create(SurveyQuestion) return one; then calls create(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON_givenSurveyQuestionDaoCreateReturnOne_thenCallsCreate() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    surveyQuestionModelList.add(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(surveyQuestionModelList);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }

  /**
   * Test {@link SurveyTemplateService#importTemplateFromJSON(String, SurveyTemplateExchange)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#create(SurveyQuestion)} return
   *       one.
   *   <li>Then calls {@link SurveyQuestionDao#create(SurveyQuestion)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateService#importTemplateFromJSON(String,
   * SurveyTemplateExchange)}
   */
  @Test
  @DisplayName(
      "Test importTemplateFromJSON(String, SurveyTemplateExchange); given SurveyQuestionDao create(SurveyQuestion) return one; then calls create(SurveyQuestion)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SurveyTemplateService.importTemplateFromJSON(String, SurveyTemplateExchange)"
  })
  void testImportTemplateFromJSON_givenSurveyQuestionDaoCreateReturnOne_thenCallsCreate2() {
    // Arrange
    PersonDao personDao = mock(PersonDao.class);
    when(personDao.getByEmployeeId(Mockito.<String>any()))
        .thenReturn(
            ImmutablePerson.builder()
                .departmentName("Department Name")
                .displayName("Display Name")
                .email("jane.doe@example.org")
                .employeeId("42")
                .id(1L)
                .isRemoved(true)
                .kind(EntityKind.ALL)
                .managerEmployeeId("42")
                .mobilePhone("6625550144")
                .officePhone("6625550144")
                .organisationalUnitId(1L)
                .personKind(PersonKind.EMPLOYEE)
                .title("Dr")
                .userId("42")
                .userPrincipalName("User Principal Name")
                .build());

    SurveyTemplateDao surveyTemplateDao = mock(SurveyTemplateDao.class);
    when(surveyTemplateDao.create(Mockito.<SurveyTemplate>any())).thenReturn(1L);
    when(surveyTemplateDao.findAll()).thenReturn(new ArrayList<>());

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
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
    ChangeLogService changeLogService2 =
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
    InvolvementDao involvementDao = mock(InvolvementDao.class);
    PersonDao personDao2 = mock(PersonDao.class);
    SurveyInstanceDao surveyInstanceDao = mock(SurveyInstanceDao.class);
    SurveyInstanceRecipientDao surveyInstanceRecipientDao = mock(SurveyInstanceRecipientDao.class);
    SurveyInstanceOwnerDao surveyInstanceOwnerDao = mock(SurveyInstanceOwnerDao.class);
    SurveyRunDao surveyRunDao = mock(SurveyRunDao.class);
    SurveyTemplateDao surveyTemplateDao2 = mock(SurveyTemplateDao.class);
    SurveyQuestionResponseDao surveyQuestionResponseDao = mock(SurveyQuestionResponseDao.class);
    InvolvementGroupService involvementGroupService =
        new InvolvementGroupService(mock(InvolvementGroupDao.class));

    SurveyRunService surveyRunService =
        new SurveyRunService(
            changeLogService2,
            involvementDao,
            personDao2,
            surveyInstanceDao,
            surveyInstanceRecipientDao,
            surveyInstanceOwnerDao,
            surveyRunDao,
            surveyTemplateDao2,
            surveyQuestionResponseDao,
            involvementGroupService);

    SurveyTemplateService surveyTemplateService =
        new SurveyTemplateService(
            changeLogService,
            personDao,
            surveyTemplateDao,
            surveyRunService,
            surveyQuestionDao,
            mock(SurveyQuestionDropdownEntryDao.class));

    ArrayList<SurveyQuestionModel> surveyQuestionModelList = new ArrayList<>();

    ImmutableSurveyQuestionModel.Builder positionResult =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    surveyQuestionModelList.add(
        positionResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());

    ImmutableSurveyQuestionModel.Builder positionResult2 =
        ImmutableSurveyQuestionModel.builder()
            .allowComment(true)
            .externalId("42")
            .fieldType(SurveyQuestionFieldType.APPLICATION)
            .helpText("Help Text")
            .inclusionPredicate("Inclusion Predicate")
            .isMandatory(true)
            .label("Label")
            .parentExternalId("42")
            .position(1);
    surveyQuestionModelList.add(
        positionResult2
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .questionText("Question Text")
            .sectionName("Section Name")
            .build());

    SurveyTemplateExchange templateExchange = mock(SurveyTemplateExchange.class);
    when(templateExchange.questions()).thenReturn(surveyQuestionModelList);
    when(templateExchange.template())
        .thenReturn(
            ImmutableSurveyTemplateModel.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .issuanceRole("Issuance Role")
                .name("Name")
                .ownerEmployeeId("42")
                .targetEntityKind(EntityKind.ALL)
                .build());

    // Act
    Long actualImportTemplateFromJSONResult =
        surveyTemplateService.importTemplateFromJSON("janedoe", templateExchange);

    // Assert
    verify(personDao).getByEmployeeId("42");
    verify(surveyQuestionDao, atLeast(1)).create(isA(SurveyQuestion.class));
    verify(surveyTemplateDao).create(isA(SurveyTemplate.class));
    verify(surveyTemplateDao).findAll();
    verify(templateExchange).questions();
    verify(templateExchange).template();
    assertEquals(1L, actualImportTemplateFromJSONResult.longValue());
  }
}
