package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.data.survey.SurveyInstanceDao;
import org.finos.waltz.data.survey.SurveyQuestionDao;
import org.finos.waltz.data.survey.SurveyQuestionResponseDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceFormDetails;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SurveyInstanceEvaluatorDiffblueTest {
  /**
   * Test {@link SurveyInstanceEvaluator#eval(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceEvaluator#eval(long)}
   */
  @Test
  @DisplayName("Test eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails SurveyInstanceEvaluator.eval(long)"})
  void testEval() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(instanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);

    SurveyInstanceEvaluator surveyInstanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);

    // Act
    ImmutableSurveyInstanceFormDetails actualEvalResult = surveyInstanceEvaluator.eval(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualEvalResult.activeQuestions().isEmpty());
    assertTrue(actualEvalResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceEvaluator#eval(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceEvaluator#eval(long)}
   */
  @Test
  @DisplayName("Test eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails SurveyInstanceEvaluator.eval(long)"})
  void testEval2() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(instanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    ArrayList<SurveyInstanceQuestionResponse> surveyInstanceQuestionResponseList =
        new ArrayList<>();

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse = Optional.of(true);

    Builder dateResponseResult =
        builderResult
            .booleanResponse(booleanResponse)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult = dateResponseResult.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse = Optional.of(immutableEntityReference);

    Builder entityResponseResult = entityListResponseResult.entityResponse(entityResponse);
    surveyInstanceQuestionResponseList.add(
        personIdResult
            .questionResponse(
                entityResponseResult
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    ImmutableSurveyInstanceQuestionResponse.Builder personIdResult2 =
        ImmutableSurveyInstanceQuestionResponse.builder()
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .personId(1L);

    Builder builderResult2 = ImmutableSurveyQuestionResponse.builder();
    Optional<Boolean> booleanResponse2 = Optional.of(true);

    Builder dateResponseResult2 =
        builderResult2
            .booleanResponse(booleanResponse2)
            .comment("Comment")
            .dateResponse(LocalDate.of(1970, 1, 1));

    Builder entityListResponseResult2 = dateResponseResult2.entityListResponse(new ArrayList<>());
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> entityResponse2 = Optional.of(immutableEntityReference2);

    Builder entityResponseResult2 = entityListResponseResult2.entityResponse(entityResponse2);
    surveyInstanceQuestionResponseList.add(
        personIdResult2
            .questionResponse(
                entityResponseResult2
                    .listResponse(new ArrayList<>())
                    .numberResponse(10.0d)
                    .questionId(1L)
                    .stringResponse("String Response")
                    .build())
            .surveyInstanceId(1L)
            .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(surveyInstanceQuestionResponseList);

    SurveyInstanceEvaluator surveyInstanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);

    // Act
    ImmutableSurveyInstanceFormDetails actualEvalResult = surveyInstanceEvaluator.eval(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualEvalResult.activeQuestions().isEmpty());
    assertTrue(actualEvalResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceEvaluator#eval(long)}.
   *
   * <p>Method under test: {@link SurveyInstanceEvaluator#eval(long)}
   */
  @Test
  @DisplayName("Test eval(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails SurveyInstanceEvaluator.eval(long)"})
  void testEval3() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(instanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.APPLICATION)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceEvaluator surveyInstanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);

    // Act
    ImmutableSurveyInstanceFormDetails actualEvalResult = surveyInstanceEvaluator.eval(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualEvalResult.activeQuestions().isEmpty());
    assertTrue(actualEvalResult.missingMandatoryQuestionIds().isEmpty());
  }

  /**
   * Test {@link SurveyInstanceEvaluator#eval(long)}.
   *
   * <ul>
   *   <li>Given {@link DefaultDSLContext#DefaultDSLContext(SQLDialect)} with dialect is {@code
   *       SQL99}.
   *   <li>Then return activeQuestions Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyInstanceEvaluator#eval(long)}
   */
  @Test
  @DisplayName(
      "Test eval(long); given DefaultDSLContext(SQLDialect) with dialect is 'SQL99'; then return activeQuestions Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableSurveyInstanceFormDetails SurveyInstanceEvaluator.eval(long)"})
  void testEval_givenDefaultDSLContextWithDialectIsSql99_thenReturnActiveQuestionsEmpty() {
    // Arrange
    SurveyQuestionDao questionDao = mock(SurveyQuestionDao.class);
    when(questionDao.findForSurveyInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceDao instanceDao = mock(SurveyInstanceDao.class);

    ImmutableSurveyInstance.Builder owningRoleResult =
        ImmutableSurveyInstance.builder()
            .approvalDueDate(LocalDate.of(1970, 1, 1))
            .approvedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .approvedBy("Approved By")
            .dueDate(LocalDate.of(1970, 1, 1))
            .id(1L)
            .issuedOn(LocalDate.of(1970, 1, 1))
            .kind(EntityKind.ALL)
            .name("Name")
            .originalInstanceId(1L)
            .owningRole("Owning Role");

    ImmutableSurveyInstance.Builder submittedByResult =
        owningRoleResult
            .qualifierEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .status(SurveyInstanceStatus.NOT_STARTED)
            .submittedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .submittedBy("Submitted By");
    when(instanceDao.getById(anyLong()))
        .thenReturn(
            submittedByResult
                .surveyEntity(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .surveyEntityExternalId("42")
                .surveyRunId(1L)
                .build());

    SurveyQuestionResponseDao responseDao = mock(SurveyQuestionResponseDao.class);
    when(responseDao.findForInstance(anyLong())).thenReturn(new ArrayList<>());

    SurveyInstanceEvaluator surveyInstanceEvaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);

    // Act
    ImmutableSurveyInstanceFormDetails actualEvalResult = surveyInstanceEvaluator.eval(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualEvalResult.activeQuestions().isEmpty());
    assertTrue(actualEvalResult.missingMandatoryQuestionIds().isEmpty());
  }
}
