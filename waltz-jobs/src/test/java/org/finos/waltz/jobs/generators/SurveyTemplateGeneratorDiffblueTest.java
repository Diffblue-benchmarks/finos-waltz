package org.finos.waltz.jobs.generators;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.Map;
import java.util.Optional;
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
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.model.person.ImmutablePerson;
import org.finos.waltz.model.person.PersonKind;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyTemplate;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.involvement_group.InvolvementGroupService;
import org.finos.waltz.service.survey.SurveyInstanceEvaluator;
import org.finos.waltz.service.survey.SurveyQuestionService;
import org.finos.waltz.service.survey.SurveyRunService;
import org.finos.waltz.service.survey.SurveyTemplateService;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

class SurveyTemplateGeneratorDiffblueTest {
  /**
   * Test {@link SurveyTemplateGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#updateStatus(long,
   *       ReleaseLifecycleStatus)} return minus two.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given SurveyTemplateDao updateStatus(long, ReleaseLifecycleStatus) return minus two; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SurveyTemplateGenerator.create(ApplicationContext)"})
  void testCreate_givenSurveyTemplateDaoUpdateStatusReturnMinusTwo_thenReturnNull()
      throws BeansException {
    // Arrange
    SurveyTemplateGenerator surveyTemplateGenerator = new SurveyTemplateGenerator();

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
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(-2);
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

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(SurveyTemplateService.class)).thenReturn(surveyTemplateService);
    when(ctx.getBean(SurveyQuestionService.class)).thenReturn(surveyQuestionService);

    // Act
    Map<String, Integer> actualCreateResult = surveyTemplateGenerator.create(ctx);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(personDao, atLeast(1)).getActiveByUserEmail("admin");
    verify(surveyQuestionDao, atLeast(1)).create(Mockito.<SurveyQuestion>any());
    verify(surveyTemplateDao, atLeast(1)).create(Mockito.<SurveyTemplate>any());
    verify(surveyTemplateDao, atLeast(1)).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE);
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateGenerator#create(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link SurveyTemplateDao} {@link SurveyTemplateDao#updateStatus(long,
   *       ReleaseLifecycleStatus)} return one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateGenerator#create(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test create(ApplicationContext); given SurveyTemplateDao updateStatus(long, ReleaseLifecycleStatus) return one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map SurveyTemplateGenerator.create(ApplicationContext)"})
  void testCreate_givenSurveyTemplateDaoUpdateStatusReturnOne_thenReturnNull()
      throws BeansException {
    // Arrange
    SurveyTemplateGenerator surveyTemplateGenerator = new SurveyTemplateGenerator();

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
    when(surveyTemplateDao.updateStatus(anyLong(), Mockito.<ReleaseLifecycleStatus>any()))
        .thenReturn(1);
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

    SurveyQuestionDao surveyQuestionDao = mock(SurveyQuestionDao.class);
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);
    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99),
            mock(SurveyQuestionDao.class),
            mock(SurveyInstanceDao.class),
            mock(SurveyQuestionResponseDao.class));

    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(surveyQuestionDao, evaluator);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(SurveyTemplateService.class)).thenReturn(surveyTemplateService);
    when(ctx.getBean(SurveyQuestionService.class)).thenReturn(surveyQuestionService);

    // Act
    Map<String, Integer> actualCreateResult = surveyTemplateGenerator.create(ctx);

    // Assert
    verify(changeLogDao, atLeast(1)).write(isA(Optional.class), Mockito.<ChangeLog>any());
    verify(personDao, atLeast(1)).getActiveByUserEmail("admin");
    verify(surveyQuestionDao, atLeast(1)).create(Mockito.<SurveyQuestion>any());
    verify(surveyTemplateDao, atLeast(1)).create(Mockito.<SurveyTemplate>any());
    verify(surveyTemplateDao, atLeast(1)).updateStatus(1L, ReleaseLifecycleStatus.ACTIVE);
    verify(ctx, atLeast(1)).getBean(Mockito.<Class<Object>>any());
    assertNull(actualCreateResult);
  }

  /**
   * Test {@link SurveyTemplateGenerator#remove(ApplicationContext)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#execute()} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyTemplateGenerator#remove(ApplicationContext)}
   */
  @Test
  @DisplayName(
      "Test remove(ApplicationContext); given PreparedStatement execute() return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SurveyTemplateGenerator.remove(ApplicationContext)"})
  void testRemove_givenPreparedStatementExecuteReturnTrue_thenReturnTrue()
      throws SQLException, BeansException {
    // Arrange
    SurveyTemplateGenerator surveyTemplateGenerator = new SurveyTemplateGenerator();

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);

    ApplicationContext ctx = mock(ApplicationContext.class);
    when(ctx.getBean(DSLContext.class))
        .thenReturn(new DefaultDSLContext(connection, SQLDialect.SQL99));

    // Act
    boolean actualRemoveResult = surveyTemplateGenerator.remove(ctx);

    // Assert
    verify(connection, atLeast(1)).prepareStatement(Mockito.<String>any());
    verify(preparedStatement, atLeast(1)).execute();
    verify(preparedStatement, atLeast(1)).close();
    verify(preparedStatement, atLeast(1)).getWarnings();
    verify(ctx).getBean(isA(Class.class));
    assertTrue(actualRemoveResult);
  }
}
