package org.finos.waltz.service.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.finos.waltz.model.survey.ImmutableSurveyQuestion;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse;
import org.finos.waltz.model.survey.ImmutableSurveyQuestionResponse.Builder;
import org.finos.waltz.model.survey.SurveyInstanceQuestionResponse;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultDSLContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyQuestionServiceDiffblueTest {
  @Mock private SurveyInstanceEvaluator surveyInstanceEvaluator;

  @Mock private SurveyQuestionDao surveyQuestionDao;

  @InjectMocks private SurveyQuestionService surveyQuestionService;

  /**
   * Test {@link SurveyQuestionService#findForSurveyTemplate(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyTemplate(long)}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyTemplate(long)"})
  void testFindForSurveyTemplate_thenReturnEmpty() {
    // Arrange
    when(surveyQuestionDao.findForTemplate(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestion> actualFindForSurveyTemplateResult =
        surveyQuestionService.findForSurveyTemplate(1L);

    // Assert
    verify(surveyQuestionDao).findForTemplate(1L);
    assertTrue(actualFindForSurveyTemplateResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyTemplate(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyTemplate(long)}
   */
  @Test
  @DisplayName("Test findForSurveyTemplate(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyTemplate(long)"})
  void testFindForSurveyTemplate_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.findForTemplate(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyQuestionService.findForSurveyTemplate(1L));
    verify(surveyQuestionDao).findForTemplate(1L);
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyRun(long)"})
  void testFindForSurveyRun_thenReturnEmpty() {
    // Arrange
    when(surveyQuestionDao.findForSurveyRun(anyLong())).thenReturn(new ArrayList<>());

    // Act
    List<SurveyQuestion> actualFindForSurveyRunResult = surveyQuestionService.findForSurveyRun(1L);

    // Assert
    verify(surveyQuestionDao).findForSurveyRun(1L);
    assertTrue(actualFindForSurveyRunResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyRun(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyRun(long)}
   */
  @Test
  @DisplayName("Test findForSurveyRun(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyRun(long)"})
  void testFindForSurveyRun_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.findForSurveyRun(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyQuestionService.findForSurveyRun(1L));
    verify(surveyQuestionDao).findForSurveyRun(1L);
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance() {
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

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);

    // Act
    List<SurveyQuestion> actualFindForSurveyInstanceResult =
        surveyQuestionService.findForSurveyInstance(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyInstance(long)}.
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance2() {
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

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);

    // Act
    List<SurveyQuestion> actualFindForSurveyInstanceResult =
        surveyQuestionService.findForSurveyInstance(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyInstance(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyInstanceEvaluator} {@link SurveyInstanceEvaluator#eval(long)} return
   *       builder build.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName(
      "Test findForSurveyInstance(long); given SurveyInstanceEvaluator eval(long) return builder build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance_givenSurveyInstanceEvaluatorEvalReturnBuilderBuild() {
    // Arrange
    when(surveyInstanceEvaluator.eval(anyLong()))
        .thenReturn(ImmutableSurveyInstanceFormDetails.builder().build());

    // Act
    List<SurveyQuestion> actualFindForSurveyInstanceResult =
        surveyQuestionService.findForSurveyInstance(1L);

    // Assert
    verify(surveyInstanceEvaluator).eval(1L);
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyInstance(long)}.
   *
   * <ul>
   *   <li>Then calls {@link SurveyInstanceDao#getById(long)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long); then calls getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance_thenCallsGetById() {
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

    SurveyInstanceEvaluator evaluator =
        new SurveyInstanceEvaluator(
            new DefaultDSLContext(SQLDialect.SQL99), questionDao, instanceDao, responseDao);
    SurveyQuestionService surveyQuestionService =
        new SurveyQuestionService(mock(SurveyQuestionDao.class), evaluator);

    // Act
    List<SurveyQuestion> actualFindForSurveyInstanceResult =
        surveyQuestionService.findForSurveyInstance(1L);

    // Assert
    verify(instanceDao).getById(1L);
    verify(questionDao).findForSurveyInstance(1L);
    verify(responseDao).findForInstance(1L);
    assertTrue(actualFindForSurveyInstanceResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForSurveyInstance(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForSurveyInstance(long)}
   */
  @Test
  @DisplayName("Test findForSurveyInstance(long); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List SurveyQuestionService.findForSurveyInstance(long)"})
  void testFindForSurveyInstance_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyInstanceEvaluator.eval(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyQuestionService.findForSurveyInstance(1L));
    verify(surveyInstanceEvaluator).eval(1L);
  }

  /**
   * Test {@link SurveyQuestionService#create(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#create(SurveyQuestion)} return
   *       one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#create(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test create(SurveyQuestion); given SurveyQuestionDao create(SurveyQuestion) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionService.create(SurveyQuestion)"})
  void testCreate_givenSurveyQuestionDaoCreateReturnOne_thenReturnOne() {
    // Arrange
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any())).thenReturn(1L);

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

    // Act
    long actualCreateResult =
        surveyQuestionService.create(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
    assertEquals(1L, actualCreateResult);
  }

  /**
   * Test {@link SurveyQuestionService#create(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#create(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test create(SurveyQuestion); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long SurveyQuestionService.create(SurveyQuestion)"})
  void testCreate_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.create(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyQuestionService.create(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build()));
    verify(surveyQuestionDao).create(isA(SurveyQuestion.class));
  }

  /**
   * Test {@link SurveyQuestionService#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link SurveyQuestion} {@link SurveyQuestion#id()} return of one.
   *   <li>Then calls {@link SurveyQuestion#id()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#update(SurveyQuestion)}
   */
  @Test
  @DisplayName(
      "Test update(SurveyQuestion); given of one; when SurveyQuestion id() return of one; then calls id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.update(SurveyQuestion)"})
  void testUpdate_givenOfOne_whenSurveyQuestionIdReturnOfOne_thenCallsId() {
    // Arrange
    when(surveyQuestionDao.update(Mockito.<SurveyQuestion>any())).thenReturn(1);

    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);

    // Act
    int actualUpdateResult = surveyQuestionService.update(surveyQuestion);

    // Assert
    verify(surveyQuestionDao).update(isA(SurveyQuestion.class));
    verify(surveyQuestion).id();
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionService#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#update(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test update(SurveyQuestion); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.update(SurveyQuestion)"})
  void testUpdate_thenReturnOne() {
    // Arrange
    when(surveyQuestionDao.update(Mockito.<SurveyQuestion>any())).thenReturn(1);

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

    // Act
    int actualUpdateResult =
        surveyQuestionService.update(
            positionResult
                .qualifierEntity(qualifierEntity)
                .questionText("Question Text")
                .sectionName("Section Name")
                .surveyTemplateId(1L)
                .build());

    // Assert
    verify(surveyQuestionDao).update(isA(SurveyQuestion.class));
    assertEquals(1, actualUpdateResult);
  }

  /**
   * Test {@link SurveyQuestionService#update(SurveyQuestion)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#update(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test update(SurveyQuestion); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.update(SurveyQuestion)"})
  void testUpdate_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.update(Mockito.<SurveyQuestion>any()))
        .thenThrow(new IllegalArgumentException());

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

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            surveyQuestionService.update(
                positionResult
                    .qualifierEntity(qualifierEntity)
                    .questionText("Question Text")
                    .sectionName("Section Name")
                    .surveyTemplateId(1L)
                    .build()));
    verify(surveyQuestionDao).update(isA(SurveyQuestion.class));
  }

  /**
   * Test {@link SurveyQuestionService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#hasResponses(long)} return
   *       {@code false}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given SurveyQuestionDao hasResponses(long) return 'false'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.delete(long)"})
  void testDelete_givenSurveyQuestionDaoHasResponsesReturnFalse_thenReturnOne() {
    // Arrange
    when(surveyQuestionDao.hasResponses(anyLong())).thenReturn(false);
    when(surveyQuestionDao.delete(anyLong())).thenReturn(1);

    // Act
    int actualDeleteResult = surveyQuestionService.delete(1L);

    // Assert
    verify(surveyQuestionDao).delete(1L);
    verify(surveyQuestionDao).hasResponses(1L);
    assertEquals(1, actualDeleteResult);
  }

  /**
   * Test {@link SurveyQuestionService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#hasResponses(long)} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  @DisplayName("Test delete(long); given SurveyQuestionDao hasResponses(long) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.delete(long)"})
  void testDelete_givenSurveyQuestionDaoHasResponsesReturnTrue() {
    // Arrange
    when(surveyQuestionDao.hasResponses(anyLong())).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyQuestionService.delete(1L));
    verify(surveyQuestionDao).hasResponses(1L);
  }

  /**
   * Test {@link SurveyQuestionService#delete(long)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#hasResponses(long)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#delete(long)}
   */
  @Test
  @DisplayName(
      "Test delete(long); given SurveyQuestionDao hasResponses(long) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int SurveyQuestionService.delete(long)"})
  void testDelete_givenSurveyQuestionDaoHasResponsesThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.hasResponses(anyLong())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> surveyQuestionService.delete(1L));
    verify(surveyQuestionDao).hasResponses(1L);
  }

  /**
   * Test {@link SurveyQuestionService#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao} {@link SurveyQuestionDao#findForIds(Set)} return {@link
   *       HashSet#HashSet()}.
   *   <li>Then calls {@link SurveyQuestionDao#findForIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findForIds(Set); given SurveyQuestionDao findForIds(Set) return HashSet(); then calls findForIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionService.findForIds(Set)"})
  void testFindForIds_givenSurveyQuestionDaoFindForIdsReturnHashSet_thenCallsFindForIds() {
    // Arrange
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult =
        surveyQuestionService.findForIds(surveyQuestionsIds);

    // Assert
    verify(surveyQuestionDao).findForIds(isA(Set.class));
    assertTrue(actualFindForIdsResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao}.
   *   <li>When {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); given SurveyQuestionDao; when HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionService.findForIds(Set)"})
  void testFindForIds_givenSurveyQuestionDao_whenHashSet_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(surveyQuestionService.findForIds(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given {@link SurveyQuestionDao}.
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); given SurveyQuestionDao; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionService.findForIds(Set)"})
  void testFindForIds_givenSurveyQuestionDao_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(surveyQuestionService.findForIds(null).isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForIds(Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then calls {@link SurveyQuestionDao#findForIds(Set)}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  @DisplayName(
      "Test findForIds(Set); given zero; when HashSet() add zero; then calls findForIds(Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionService.findForIds(Set)"})
  void testFindForIds_givenZero_whenHashSetAddZero_thenCallsFindForIds() {
    // Arrange
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any())).thenReturn(new HashSet<>());

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(0L);
    surveyQuestionsIds.add(1L);

    // Act
    Set<SurveyQuestion> actualFindForIdsResult =
        surveyQuestionService.findForIds(surveyQuestionsIds);

    // Assert
    verify(surveyQuestionDao).findForIds(isA(Set.class));
    assertTrue(actualFindForIdsResult.isEmpty());
  }

  /**
   * Test {@link SurveyQuestionService#findForIds(Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyQuestionService#findForIds(Set)}
   */
  @Test
  @DisplayName("Test findForIds(Set); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyQuestionService.findForIds(Set)"})
  void testFindForIds_thenThrowIllegalArgumentException() {
    // Arrange
    when(surveyQuestionDao.findForIds(Mockito.<Set<Long>>any()))
        .thenThrow(new IllegalArgumentException());

    HashSet<Long> surveyQuestionsIds = new HashSet<>();
    surveyQuestionsIds.add(1L);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> surveyQuestionService.findForIds(surveyQuestionsIds));
    verify(surveyQuestionDao).findForIds(isA(Set.class));
  }
}
