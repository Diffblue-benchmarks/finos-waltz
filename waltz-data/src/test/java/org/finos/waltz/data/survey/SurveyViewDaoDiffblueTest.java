package org.finos.waltz.data.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.HierarchyQueryScope;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableIdSelectionOptions;
import org.finos.waltz.model.ImmutableSelectionFilters;
import org.finos.waltz.model.survey.ImmutableSurveyInstance;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceInfo.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyRun;
import org.finos.waltz.model.survey.SurveyInstanceInfo;
import org.finos.waltz.model.survey.SurveyInstanceStatus;
import org.finos.waltz.model.survey.SurveyIssuanceKind;
import org.finos.waltz.model.survey.SurveyRunStatus;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.GroupField;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.RecordMapper;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectField;
import org.jooq.SelectFieldOrAsterisk;
import org.jooq.SelectHavingStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectOnConditionStep;
import org.jooq.SelectOnStep;
import org.jooq.SelectOrderByStep;
import org.jooq.SelectSelectStep;
import org.jooq.TableLike;
import org.jooq.exception.DataAccessException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SurveyViewDaoDiffblueTest {
  @Mock private DSLContext dSLContext;

  @InjectMocks private SurveyViewDao surveyViewDao;

  /**
   * Test {@link SurveyViewDao#getById(long)}.
   *
   * <p>Method under test: {@link SurveyViewDao#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SurveyInstanceInfo SurveyViewDao.getById(long)"})
  void testGetById() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetchMap(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);

    Builder historicalVersionsCountResult =
        ImmutableSurveyInstanceInfo.builder().historicalVersionsCount(3);

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

    Builder surveyInstanceResult =
        historicalVersionsCountResult.surveyInstance(
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

    ImmutableIdSelectionOptions.Builder builderResult = ImmutableIdSelectionOptions.builder();

    ImmutableIdSelectionOptions.Builder filtersResult =
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

    ImmutableIdSelectionOptions.Builder joiningEntityKindResult =
        filtersResult.joiningEntityKind(joiningEntityKind);

    Builder surveyRunResult =
        surveyInstanceResult.surveyRun(
            ownerIdResult
                .selectionOptions(
                    joiningEntityKindResult
                        .addAllEntityLifecycleStatuses(new ArrayList<>())
                        .scope(HierarchyQueryScope.EXACT)
                        .build())
                .status(SurveyRunStatus.DRAFT)
                .surveyTemplateId(1L)
                .build());
    when(selectConditionStep3.fetchOne(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(
            surveyRunResult
                .surveyTemplateRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build());

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    SelectSelectStep<Record> selectSelectStep6 = mock(SelectSelectStep.class);
    when(selectSelectStep6.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep5);

    SelectSelectStep<Record> selectSelectStep7 = mock(SelectSelectStep.class);
    when(selectSelectStep7.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep6);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep7);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    SurveyInstanceInfo actualById = surveyViewDao.getById(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any());
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectHavingStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep3).fetchOne(isA(RecordMapper.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep7).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep6).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualById.surveyTemplateRef() instanceof ImmutableEntityReference);
    assertTrue(actualById.surveyInstance() instanceof ImmutableSurveyInstance);
    assertTrue(actualById instanceof ImmutableSurveyInstanceInfo);
    assertTrue(actualById.surveyRun() instanceof ImmutableSurveyRun);
    assertEquals(3, actualById.historicalVersionsCount().intValue());
  }

  /**
   * Test {@link SurveyViewDao#findForRecipient(long)}.
   *
   * <p>Method under test: {@link SurveyViewDao#findForRecipient(long)}
   */
  @Test
  @DisplayName("Test findForRecipient(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyViewDao.findForRecipient(long)"})
  void testFindForRecipient() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetchMap(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectConditionStep<Record> selectConditionStep5 = mock(SelectConditionStep.class);
    when(selectConditionStep5.and(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectConditionStep<Record> selectConditionStep6 = mock(SelectConditionStep.class);
    when(selectConditionStep6.and(Mockito.<Condition>any())).thenReturn(selectConditionStep5);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep6);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    SelectSelectStep<Record> selectSelectStep6 = mock(SelectSelectStep.class);
    when(selectSelectStep6.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep5);

    SelectSelectStep<Record> selectSelectStep7 = mock(SelectSelectStep.class);
    when(selectSelectStep7.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep6);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep7);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<SurveyInstanceInfo> actualFindForRecipientResult = surveyViewDao.findForRecipient(1L);

    // Assert
    verify(dSLContext).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any());
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectHavingStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep3).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep6).and(isA(Condition.class));
    verify(selectConditionStep5).and(isA(Condition.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep2).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep2).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectOnStep3).on(isA(Condition.class));
    verify(selectOnStep2).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectSelectStep7).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep6).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep5).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForRecipientResult.isEmpty());
  }

  /**
   * Test {@link SurveyViewDao#findForOwner(Long)}.
   *
   * <p>Method under test: {@link SurveyViewDao#findForOwner(Long)}
   */
  @Test
  @DisplayName("Test findForOwner(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyViewDao.findForOwner(Long)"})
  void testFindForOwner() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetchMap(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectConditionStep<Record> selectConditionStep5 = mock(SelectConditionStep.class);
    when(selectConditionStep5.and(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectConditionStep<Record> selectConditionStep6 = mock(SelectConditionStep.class);
    when(selectConditionStep6.and(Mockito.<Condition>any())).thenReturn(selectConditionStep5);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep6);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectConditionStep<Record> selectConditionStep7 = mock(SelectConditionStep.class);
    when(selectConditionStep7.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record> selectConditionStep8 = mock(SelectConditionStep.class);
    when(selectConditionStep8.and(Mockito.<Condition>any())).thenReturn(selectConditionStep7);

    SelectConditionStep<Record> selectConditionStep9 = mock(SelectConditionStep.class);
    when(selectConditionStep9.and(Mockito.<Condition>any())).thenReturn(selectConditionStep8);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep9);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    SelectSelectStep<Record> selectSelectStep6 = mock(SelectSelectStep.class);
    when(selectSelectStep6.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep5);

    SelectSelectStep<Record> selectSelectStep7 = mock(SelectSelectStep.class);
    when(selectSelectStep7.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep6);

    SelectConditionStep<Record1<Object>> selectConditionStep10 = mock(SelectConditionStep.class);
    when(selectConditionStep10.fetchSet(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep4 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.where(Mockito.<Condition>any())).thenReturn(selectConditionStep10);

    SelectOnStep<Record1<Object>> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record1<Object>> selectJoinStep3 = mock(SelectJoinStep.class);
    when(selectJoinStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record1<Object>> selectSelectStep8 = mock(SelectSelectStep.class);
    when(selectSelectStep8.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep3);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep8);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep7);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<SurveyInstanceInfo> actualFindForOwnerResult = surveyViewDao.findForOwner(1L);

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any());
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectHavingStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep10).fetchSet(isA(RecordMapper.class));
    verify(selectOrderByStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep9).and(isA(Condition.class));
    verify(selectConditionStep8).and(isA(Condition.class));
    verify(selectConditionStep7).and(isA(Condition.class));
    verify(selectConditionStep6).and(isA(Condition.class));
    verify(selectConditionStep5).and(isA(Condition.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep8).from(isA(TableLike.class));
    verify(selectSelectStep2, atLeast(1)).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep2, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnConditionStep3, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnStep3, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep2, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectSelectStep7, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep6, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep5, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep3).union(isA(Select.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep4).where(isA(Condition.class));
    verify(selectOnConditionStep2).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForOwnerResult.isEmpty());
  }

  /**
   * Test {@link SurveyViewDao#findForOwner(Long)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link SurveyViewDao#findForOwner(Long)}
   */
  @Test
  @DisplayName("Test findForOwner(Long); given HashSet() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set SurveyViewDao.findForOwner(Long)"})
  void testFindForOwner_givenHashSetAdd42() throws DataAccessException {
    // Arrange
    SelectHavingStep<Record2<Object, Object>> selectHavingStep = mock(SelectHavingStep.class);
    when(selectHavingStep.fetchMap(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());

    SelectConditionStep<Record2<Object, Object>> selectConditionStep =
        mock(SelectConditionStep.class);
    when(selectConditionStep.groupBy((GroupField[]) Mockito.any())).thenReturn(selectHavingStep);

    SelectConditionStep<Record2<Object, Object>> selectConditionStep2 =
        mock(SelectConditionStep.class);
    when(selectConditionStep2.and(Mockito.<Condition>any())).thenReturn(selectConditionStep);

    SelectJoinStep<Record2<Object, Object>> selectJoinStep = mock(SelectJoinStep.class);
    when(selectJoinStep.fetchGroups(
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any(),
            Mockito.<RecordMapper<Record2<Object, Object>, Object>>any()))
        .thenReturn(new HashMap<>());
    when(selectJoinStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep2);

    SelectSelectStep<Record2<Object, Object>> selectSelectStep = mock(SelectSelectStep.class);
    when(selectSelectStep.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep);

    SelectOrderByStep<Record> selectOrderByStep = mock(SelectOrderByStep.class);
    when(selectOrderByStep.fetchSet(Mockito.<RecordMapper<Record, Object>>any()))
        .thenReturn(new HashSet<>());

    SelectConditionStep<Record> selectConditionStep3 = mock(SelectConditionStep.class);
    when(selectConditionStep3.union(Mockito.<Select<Record>>any())).thenReturn(selectOrderByStep);

    SelectConditionStep<Record> selectConditionStep4 = mock(SelectConditionStep.class);
    when(selectConditionStep4.and(Mockito.<Condition>any())).thenReturn(selectConditionStep3);

    SelectConditionStep<Record> selectConditionStep5 = mock(SelectConditionStep.class);
    when(selectConditionStep5.and(Mockito.<Condition>any())).thenReturn(selectConditionStep4);

    SelectConditionStep<Record> selectConditionStep6 = mock(SelectConditionStep.class);
    when(selectConditionStep6.and(Mockito.<Condition>any())).thenReturn(selectConditionStep5);

    SelectOnConditionStep<Record> selectOnConditionStep = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep.where(Mockito.<Condition>any())).thenReturn(selectConditionStep6);

    SelectOnStep<Record> selectOnStep = mock(SelectOnStep.class);
    when(selectOnStep.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep);

    SelectConditionStep<Record> selectConditionStep7 = mock(SelectConditionStep.class);
    when(selectConditionStep7.and(Mockito.<Condition>any()))
        .thenReturn(mock(SelectConditionStep.class));

    SelectConditionStep<Record> selectConditionStep8 = mock(SelectConditionStep.class);
    when(selectConditionStep8.and(Mockito.<Condition>any())).thenReturn(selectConditionStep7);

    SelectConditionStep<Record> selectConditionStep9 = mock(SelectConditionStep.class);
    when(selectConditionStep9.and(Mockito.<Condition>any())).thenReturn(selectConditionStep8);

    SelectOnConditionStep<Record> selectOnConditionStep2 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep2.where(Mockito.<Condition>any())).thenReturn(selectConditionStep9);
    when(selectOnConditionStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep);

    SelectOnStep<Record> selectOnStep2 = mock(SelectOnStep.class);
    when(selectOnStep2.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep2);

    SelectOnConditionStep<Record> selectOnConditionStep3 = mock(SelectOnConditionStep.class);
    when(selectOnConditionStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep2);

    SelectOnStep<Record> selectOnStep3 = mock(SelectOnStep.class);
    when(selectOnStep3.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep3);

    SelectJoinStep<Record> selectJoinStep2 = mock(SelectJoinStep.class);
    when(selectJoinStep2.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep3);

    SelectSelectStep<Record> selectSelectStep2 = mock(SelectSelectStep.class);
    when(selectSelectStep2.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep2);

    SelectSelectStep<Record> selectSelectStep3 = mock(SelectSelectStep.class);
    when(selectSelectStep3.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep2);

    SelectSelectStep<Record> selectSelectStep4 = mock(SelectSelectStep.class);
    when(selectSelectStep4.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep3);

    SelectSelectStep<Record> selectSelectStep5 = mock(SelectSelectStep.class);
    when(selectSelectStep5.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep4);

    SelectSelectStep<Record> selectSelectStep6 = mock(SelectSelectStep.class);
    when(selectSelectStep6.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep5);

    SelectSelectStep<Record> selectSelectStep7 = mock(SelectSelectStep.class);
    when(selectSelectStep7.select((SelectFieldOrAsterisk[]) Mockito.any()))
        .thenReturn(selectSelectStep6);

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    SelectConditionStep<Record1<Object>> selectConditionStep10 = mock(SelectConditionStep.class);
    when(selectConditionStep10.fetchSet(Mockito.<RecordMapper<Record1<Object>, Object>>any()))
        .thenReturn(objectSet);

    SelectOnConditionStep<Record1<Object>> selectOnConditionStep4 =
        mock(SelectOnConditionStep.class);
    when(selectOnConditionStep4.where(Mockito.<Condition>any())).thenReturn(selectConditionStep10);

    SelectOnStep<Record1<Object>> selectOnStep4 = mock(SelectOnStep.class);
    when(selectOnStep4.on(Mockito.<Condition>any())).thenReturn(selectOnConditionStep4);

    SelectJoinStep<Record1<Object>> selectJoinStep3 = mock(SelectJoinStep.class);
    when(selectJoinStep3.innerJoin(Mockito.<TableLike<?>>any())).thenReturn(selectOnStep4);

    SelectSelectStep<Record1<Object>> selectSelectStep8 = mock(SelectSelectStep.class);
    when(selectSelectStep8.from(Mockito.<TableLike<?>>any())).thenReturn(selectJoinStep3);
    when(dSLContext.select(Mockito.<SelectField<Object>>any())).thenReturn(selectSelectStep8);
    when(dSLContext.select((SelectFieldOrAsterisk[]) Mockito.any())).thenReturn(selectSelectStep7);
    when(dSLContext.select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any()))
        .thenReturn(selectSelectStep);

    // Act
    Set<SurveyInstanceInfo> actualFindForOwnerResult = surveyViewDao.findForOwner(1L);

    // Assert
    verify(dSLContext, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(dSLContext).select(isA(SelectField.class));
    verify(dSLContext, atLeast(1))
        .select(Mockito.<SelectField<Object>>any(), Mockito.<SelectField<Object>>any());
    verify(selectJoinStep).fetchGroups(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectHavingStep).fetchMap(isA(RecordMapper.class), isA(RecordMapper.class));
    verify(selectConditionStep10).fetchSet(isA(RecordMapper.class));
    verify(selectOrderByStep).fetchSet(isA(RecordMapper.class));
    verify(selectConditionStep9).and(isA(Condition.class));
    verify(selectConditionStep8).and(isA(Condition.class));
    verify(selectConditionStep7).and(isA(Condition.class));
    verify(selectConditionStep6).and(isA(Condition.class));
    verify(selectConditionStep5).and(isA(Condition.class));
    verify(selectConditionStep4).and(isA(Condition.class));
    verify(selectConditionStep2).and(isA(Condition.class));
    verify(selectSelectStep8).from(isA(TableLike.class));
    verify(selectSelectStep2, atLeast(1)).from(isA(TableLike.class));
    verify(selectSelectStep, atLeast(1)).from(Mockito.<TableLike<?>>any());
    verify(selectConditionStep).groupBy((GroupField[]) Mockito.any());
    verify(selectJoinStep3).innerJoin(isA(TableLike.class));
    verify(selectOnConditionStep2).innerJoin(isA(TableLike.class));
    verify(selectJoinStep2, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnConditionStep3, atLeast(1)).innerJoin(Mockito.<TableLike<?>>any());
    verify(selectOnStep4).on(isA(Condition.class));
    verify(selectOnStep).on(isA(Condition.class));
    verify(selectOnStep3, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectOnStep2, atLeast(1)).on(Mockito.<Condition>any());
    verify(selectSelectStep7, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep6, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep5, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep4, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectSelectStep3, atLeast(1)).select((SelectFieldOrAsterisk[]) Mockito.any());
    verify(selectConditionStep3).union(isA(Select.class));
    verify(selectJoinStep).where(isA(Condition.class));
    verify(selectOnConditionStep4).where(isA(Condition.class));
    verify(selectOnConditionStep2).where(isA(Condition.class));
    verify(selectOnConditionStep).where(isA(Condition.class));
    assertTrue(actualFindForOwnerResult.isEmpty());
  }
}
